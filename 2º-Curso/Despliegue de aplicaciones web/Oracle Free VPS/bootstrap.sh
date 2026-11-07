#!/usr/bin/env bash
# ============================================================================
# bootstrap.sh — Aprovisionamiento Oracle Cloud Always Free (Ubuntu 24.04 ARM)
# ----------------------------------------------------------------------------
# Instala y configura: hardening, firewall, JDK 21, Minecraft (Paper), Nginx.
# Es IDEMPOTENTE: se puede relanzar sin romper lo ya hecho.
#
# Uso:  sudo bash bootstrap.sh
# ============================================================================
set -euo pipefail

MC_USER="minecraft"
MC_HOME="/opt/minecraft"
MC_RAM="4G"
MC_VERSION="1.21.3"
PAPER_BUILD="latest"
JAVA_PKG="temurin-21-jdk"

GRN='\033[0;32m'; YEL='\033[0;33m'; RED='\033[0;31m'; CYA='\033[0;36m'; NC='\033[0m'
log()  { printf "${CYA}→${NC} %s\n" "$1"; }
ok()   { printf "${GRN}✓${NC} %s\n" "$1"; }
warn() { printf "${YEL}⚠${NC} %s\n" "$1"; }
die()  { printf "${RED}✗${NC} %s\n" "$1" >&2; exit 1; }

[ "$(id -u)" -eq 0 ] || die "Ejecutar con sudo: sudo bash $0"
[ "$(uname -m)" = "aarch64" ] || warn "Arquitectura $(uname -m): se asume ARM64, revisa los paquetes"

# ---------------------------------------------------------------------------
log "1/9 · Actualizando paquetes base"
export DEBIAN_FRONTEND=noninteractive
apt-get update -qq
apt-get upgrade -y -qq
apt-get install -y -qq curl wget unzip screen jq htop ncdu \
    ufw fail2ban unattended-upgrades apt-listchanges ca-certificates gnupg
ok "Paquetes base instalados"

# ---------------------------------------------------------------------------
log "2/9 · Corrigiendo el firewall interno de Oracle (iptables)"
if iptables -L INPUT -n 2>/dev/null | grep -q "REJECT.*icmp-host-prohibited"; then
    iptables -D INPUT -j REJECT --reject-with icmp-host-prohibited && ok "Regla REJECT eliminada"
else
    ok "No había regla REJECT (ya corregido antes)"
fi
apt-get install -y -qq iptables-persistent
netfilter-persistent save >/dev/null 2>&1
ok "Reglas de iptables persistidas"

# ---------------------------------------------------------------------------
log "3/9 · Configurando UFW"
ufw --force reset >/dev/null 2>&1 || true
ufw default deny incoming >/dev/null
ufw default allow outgoing >/dev/null
ufw allow 22/tcp    comment 'SSH'
ufw allow 80/tcp    comment 'HTTP'
ufw allow 443/tcp   comment 'HTTPS'
ufw allow 25565/tcp comment 'Minecraft Java'
ufw allow 19132/udp comment 'Minecraft Bedrock'
ufw --force enable >/dev/null
ok "UFW activo: 22, 80, 443, 25565/tcp, 19132/udp"

# ---------------------------------------------------------------------------
log "4/9 · Instalando JDK 21 (Eclipse Temurin ARM64)"
if command -v java >/dev/null 2>&1 && java -version 2>&1 | grep -q '"21'; then
    ok "Java 21 ya presente: $(java -version 2>&1 | head -1)"
else
    install -d -m 0755 /etc/apt/keyrings
    if [ ! -f /etc/apt/keyrings/adoptium.gpg ]; then
        wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public \
            | gpg --dearmor -o /etc/apt/keyrings/adoptium.gpg
    fi
    echo "deb [signed-by=/etc/apt/keyrings/adoptium.gpg] https://packages.adoptium.net/artifactory/deb $(. /etc/os-release && echo "$VERSION_CODENAME") main" \
        > /etc/apt/sources.list.d/adoptium.list
    apt-get update -qq
    apt-get install -y -qq "$JAVA_PKG"
    ok "Java instalado: $(java -version 2>&1 | head -1)"
fi

# ---------------------------------------------------------------------------
log "5/9 · Creando usuario de servicio y estructura de Minecraft"
if ! id "$MC_USER" >/dev/null 2>&1; then
    useradd -r -m -d "$MC_HOME" -s /usr/sbin/nologin "$MC_USER"
    ok "Usuario $MC_USER creado"
else
    ok "Usuario $MC_USER ya existe"
fi
install -d -o "$MC_USER" -g "$MC_USER" -m 0755 "$MC_HOME" "$MC_HOME/backups"

if [ ! -f "$MC_HOME/paper.jar" ]; then
    log "   Descargando Paper $MC_VERSION (build $PAPER_BUILD)"
    API="https://api.papermc.io/v2/projects/paper/versions/${MC_VERSION}"
    BUILD=$(curl -fsSL "$API/builds" | jq -r '.builds[-1].build')
    JAR=$(curl -fsSL "$API/builds/${BUILD}" | jq -r '.downloads.application.name')
    curl -fsSL "$API/builds/${BUILD}/downloads/${JAR}" -o "$MC_HOME/paper.jar"
    chown "$MC_USER:$MC_USER" "$MC_HOME/paper.jar"
    ok "Paper build $BUILD descargado"
else
    ok "paper.jar ya presente"
fi

# EULA y configuración inicial
if [ ! -f "$MC_HOME/eula.txt" ]; then
    echo "eula=true" > "$MC_HOME/eula.txt"
    chown "$MC_USER:$MC_USER" "$MC_HOME/eula.txt"
fi

if [ ! -f "$MC_HOME/server.properties" ]; then
    log "   Generando server.properties (6 jugadores, whitelist)"
    cat > "$MC_HOME/server.properties" <<'PROPS'
# --- Red ---
server-port=25565
enable-status=true
# --- Jugadores ---
max-players=10
white-list=true
enforce-whitelist=true
online-mode=true
# --- Rendimiento (calibrado para 2 vCPU ARM) ---
view-distance=6
simulation-distance=4
entity-broadcast-range-percentage=75
# --- Varios ---
motd=\u00a76Minecraft \u00a7f| \u00a7bKursaal
enable-command-block=false
spawn-protection=16
max-tick-time=60000
sync-chunk-writes=false
PROPS
    chown "$MC_USER:$MC_USER" "$MC_HOME/server.properties"
    ok "server.properties creado"
fi

# ---------------------------------------------------------------------------
log "6/9 · Servicio systemd de Minecraft"
cat > /etc/systemd/system/minecraft.service <<UNIT
[Unit]
Description=Minecraft Paper Server
After=network-online.target
Wants=network-online.target

[Service]
Type=simple
User=${MC_USER}
Group=${MC_USER}
WorkingDirectory=${MC_HOME}
ExecStart=/usr/bin/java -Xms${MC_RAM} -Xmx${MC_RAM} \\
  -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 \\
  -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC \\
  -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 \\
  -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 \\
  -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 \\
  -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 \\
  -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 \\
  -jar paper.jar --nogui
# Fijar al núcleo 0: Hermes y el resto comparten el núcleo 1
CPUAffinity=0
Restart=on-failure
RestartSec=10
StandardInput=null

[Install]
WantedBy=multi-user.target
UNIT

systemctl daemon-reload
systemctl enable minecraft >/dev/null 2>&1
if systemctl is-active --quiet minecraft; then
    systemctl restart minecraft
else
    systemctl start minecraft
fi
ok "Servicio minecraft activo y habilitado"

# ---------------------------------------------------------------------------
log "7/9 · Backups automáticos"
cat > /usr/local/bin/minecraft-backup.sh <<'BK'
#!/bin/bash
set -euo pipefail
MC=/opt/minecraft
DEST="$MC/backups"
DATE=$(date +%Y%m%d-%H%M)
[ -d "$DEST" ] || mkdir -p "$DEST"
# Avisar al servidor para que vacíe el mundo a disco antes de copiar
if systemctl is-active --quiet minecraft; then
    echo "save-off" > /proc/$(systemctl show -p MainPID --value minecraft)/fd/0 2>/dev/null || true
    echo "save-all flush" > /proc/$(systemctl show -p MainPID --value minecraft)/fd/0 2>/dev/null || true
    sleep 5
fi
tar -czf "$DEST/world-$DATE.tar.gz" -C "$MC" world world_nether world_the_end *.properties 2>/dev/null || true
if systemctl is-active --quiet minecraft; then
    echo "save-on" > /proc/$(systemctl show -p MainPID --value minecraft)/fd/0 2>/dev/null || true
fi
# Rotación: conservar 7 días
find "$DEST" -name 'world-*.tar.gz' -mtime +7 -delete
BK
chmod +x /usr/local/bin/minecraft-backup.sh

cat > /etc/systemd/system/minecraft-backup.service <<'BS'
[Unit]
Description=Backup del mundo de Minecraft
[Service]
Type=oneshot
ExecStart=/usr/local/bin/minecraft-backup.sh
BS

cat > /etc/systemd/system/minecraft-backup.timer <<'BT'
[Unit]
Description=Backup diario de Minecraft (04:30)
[Timer]
OnCalendar=*-*-* 04:30:00
Persistent=true
[Install]
WantedBy=timers.target
BT

systemctl daemon-reload
systemctl enable --now minecraft-backup.timer >/dev/null 2>&1
ok "Timer de backups activo (diario 04:30, rotación 7 días)"

# ---------------------------------------------------------------------------
log "8/9 · Nginx"
apt-get install -y -qq nginx
cat > /etc/nginx/sites-available/hermes <<'NGX'
# Panel de Hermes Agent — protegido con autenticación básica.
# Cambia el puerto si Hermes usa otro.
server {
    listen 80 default_server;
    listen [::]:80 default_server;
    server_name _;

    # El panel de Hermes
    location / {
        auth_basic           "Hermes Agent";
        auth_basic_user_file /etc/nginx/.htpasswd;

        proxy_pass         http://127.0.0.1:8080;
        proxy_http_version 1.1;
        proxy_set_header   Upgrade $http_upgrade;
        proxy_set_header   Connection "upgrade";
        proxy_set_header   Host $host;
        proxy_set_header   X-Real-IP $remote_addr;
        proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header   X-Forwarded-Proto $scheme;
        proxy_read_timeout 300s;
    }
}
NGX
ln -sf /etc/nginx/sites-available/hermes /etc/nginx/sites-enabled/hermes
rm -f /etc/nginx/sites-enabled/default
nginx -t >/dev/null 2>&1 && systemctl reload nginx
ok "Nginx configurado (proxy a Hermes con auth_basic)"

if [ ! -f /etc/nginx/.htpasswd ]; then
    warn "Falta /etc/nginx/.htpasswd — créalo con:"
    warn "  sudo apt install -y apache2-utils"
    warn "  sudo htpasswd -c /etc/nginx/.htpasswd TU_USUARIO"
fi

# ---------------------------------------------------------------------------
log "9/9 · fail2ban y actualizaciones automáticas"
systemctl enable --now fail2ban >/dev/null 2>&1
systemctl enable --now unattended-upgrades >/dev/null 2>&1
ok "fail2ban y unattended-upgrades activos"

# ---------------------------------------------------------------------------
IP=$(curl -fsS --max-time 5 https://api.ipify.org 2>/dev/null || echo "IP_DESCONOCIDA")

cat <<RES

============================================================================
  APROVISIONAMIENTO COMPLETADO
============================================================================

  IP pública:       $IP

  Minecraft:        $IP:25565
  Nginx / Hermes:   http://$IP

  Estado de servicios
  -------------------
RES
systemctl is-active minecraft | sed 's/^/  minecraft      : /'
systemctl is-active nginx     | sed 's/^/  nginx          : /'
systemctl is-active fail2ban  | sed 's/^/  fail2ban       : /'

cat <<RES

  Comandos útiles
  ---------------
  Logs de Minecraft    journalctl -u minecraft -f
  Reiniciar servidor   sudo systemctl restart minecraft
  Consola interactiva  sudo -u minecraft screen -r   (si arrancas con screen)
  Backup manual        sudo /usr/local/bin/minecraft-backup.sh
  Ver backups          sudo systemctl list-timers

  PENDIENTE
  ---------
  1. Añadir jugadores a la whitelist:
       sudo -u minecraft vi /opt/minecraft/whitelist.json
       # o desde consola: whitelist add NOMBRE
  2. Instalar Hermes:
       curl -fsSL https://hermes-agent.nousresearch.com/install.sh -o ~/hermes.sh
       less ~/hermes.sh && bash ~/hermes.sh
  3. Crear la contraseña del panel:
       sudo apt install -y apache2-utils
       sudo htpasswd -c /etc/nginx/.htpasswd admin
  4. HTTPS con certbot (necesita dominio apuntando a la IP)

============================================================================
RES
