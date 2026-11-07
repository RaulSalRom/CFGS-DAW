# Oracle Cloud Free Tier — VPS para Minecraft + Hermes Agent

> Guía revisada y corregida del repositorio [maaper/oracle-free-serve](https://github.com/maaper/oracle-free-serve).
> Documento de trabajo de **Raúl Sal Romeo** — 2º DAW, I.E.S. Kursaal.
> Fecha: 7 de noviembre de 2026.

---

## Qué vamos a montar

| Recurso | Valor |
|---|---|
| Máquina | Oracle Cloud Always Free — VM.Standard.A1.Flex |
| Arquitectura | ARM (Ampere Altra) aarch64 |
| CPU / RAM | 2 OCPU · 12 GB RAM |
| Disco | 200 GB SSD (boot volume) |
| SO | Ubuntu 24.04 LTS aarch64 |
| Servicios | Minecraft (Paper) + Hermes Agent + Nginx |
| Jugadores previstos | ~6 |

### Reparto de recursos

```
Núcleo 0  →  Minecraft (Paper)   4 GB RAM   · fijado con taskset
Núcleo 1  →  Hermes + Nginx + SO  resto      · compartido
```

Minecraft es monohilo y sensible a la latencia del tick. Si Hermes le roba CPU,
los jugadores notan tirones. Por eso el servidor de juego va clavado a un núcleo.

---

## ⚠️ Avisos que la guía original omite

**1. "Gratis" con upgrade a Pay-As-You-Go.** El "truco" del README es pasar a
cuenta de pago por uso para esquivar `Out of capacity`. Funciona, pero tu tarjeta
queda registrada y hacen una **retención de ~100 USD** que se devuelve en días.

**2. El plan gratuito básico también sirve.** La diferencia es que el hardware ARM
se agota con frecuencia. Si te da el error, reintenta más tarde o usa el script de
reintento automático (§2.3). No necesitas pagar nada.

**3. Tarjeta física obligatoria.** Oracle rechaza tarjetas virtuales y de prepago.
Datos del registro (nombre, dirección, teléfono, correo) deben coincidir
**exactamente** con los del titular de la tarjeta.

**4. La región es irreversible.** Los recursos Always Free solo se crean en la
región de origen. Para España: **Spain Central (Madrid)**.

**5. Hay dos firewalls.** La *Security List* del panel de Oracle **y** el `iptables`
interno de la imagen de Ubuntu. Si abres solo uno, la página no carga y pierdes
media hora buscando el fallo.

**6. Las reglas de iptables no persisten solas.** Hay que instalar
`iptables-persistent` y guardar, o al reiniciar se pierde todo.

---

## Fase 1 — Registro

1. Entra en <https://www.oracle.com/cloud/free/> → **Comience ya gratuitamente**.
2. Rellena con **datos exactos del titular de la tarjeta**.
3. Elige región **Spain Central (Madrid)**.
4. Verificación: preautorización temporal de ~1 USD, se devuelve.

> Si el registro se rechaza, es automático e irrevocable. No reintentes con otra
> tarjeta ni otros datos: suele empeorar. Contacta con soporte.

---

## Fase 2 — Capacidad disponible

### 2.1. Si funciona a la primera
Perfecto: ve a la Fase 3.

### 2.2. Si sale `Out of capacity`
Opciones, en orden de preferencia:

**a) Reintentar sin tocar nada.** La capacidad se libera a lo largo del día. Prueba
en distintas franjas (madrugada suele ir mejor).

**b) Cambiar de dominio de fallos.** En la creación de la instancia, marca
*Create instance without specifying a fault domain*. Oracle coloca la VM donde
haya hueco.

**c) Cambiar la forma temporalmente.** Crea con `VM.Standard.A1.Flex` de 1 OCPU /
6 GB y luego edita la instancia para subir a 2 / 12 cuando haya hueco.

### 2.3. Script de reintento (opcional)
Solo si las opciones anteriores fallan varias veces. Requiere configurar la CLI
de OCI y una clave API. Se lanza en bucle hasta que consigue instancia.

---

## Fase 3 — Crear la instancia

En el panel de OCI: **Compute → Instances → Create Instance**.

| Campo | Valor |
|---|---|
| Name | `oracle-free-01` |
| Compartment | el de por defecto |
| Advanced options | **On-demand capacity** |
| Fault domain | *Create instance without specifying a fault domain* ✅ |
| Image | **Canonical Ubuntu 24.04** (arquitectura **aarch64**) |
| Shape | **Ampere** → `VM.Standard.A1.Flex` |
| OCPUs | **2** |
| Memory | **12 GB** |
| Networking | Create new VCN + public subnet ✅ |
| Public IP | **Assign a public IPv4 address** ✅ |
| SSH keys | **Generate a key pair for me** |
| Boot volume | Personalizado → **200 GB** |

### Claves SSH — importante
Descarga **los dos** archivos y guárdalos ya:

- `ssh-key-*.key` → clave privada. **Nunca se comparte.**
- `ssh-key-*.key.pub` → clave pública.

Si pierdes la privada, pierdes el acceso. No hay contraseña de rescate.

---

## Fase 4 — Red (los dos firewalls)

### 4.1. IP pública fija

Detalles de la instancia → **Resources → Attached VNICs** → VNIC principal →
**IPv4 Addresses** → menú de la IP → **Edit** → tipo **Ephemeral public IP**.

Es gratuita y se mantiene fija mientras no borres la instancia.

### 4.2. Security List (firewall de nube)

Instancia → enlace de la **Subnet** → **Security List** → **Add Ingress Rules**.

Reglas a crear (Source CIDR `0.0.0.0/0`, IP Protocol según cada una):

| Puerto | Protocolo | Servicio |
|---|---|---|
| 22 | TCP | SSH |
| 80 | TCP | HTTP (Nginx) |
| 443 | TCP | HTTPS |
| 25565 | TCP | Minecraft Java Edition |
| 19132 | UDP | Minecraft Bedrock (opcional) |

### 4.3. iptables interno (el que nadie ve)

La imagen de Ubuntu de Oracle trae una regla `REJECT` que bloquea todo el tráfico
entrante salvo SSH. Prevalece sobre UFW. Se elimina así:

```bash
# Ver dónde está la regla
sudo iptables -L INPUT -n -v --line-numbers

# Borrarla por su coincidencia sintáctica (no depende del número de línea)
sudo iptables -D INPUT -j REJECT --reject-with icmp-host-prohibited

# Hacerla persistente
sudo apt install -y iptables-persistent
sudo netfilter-persistent save
```

Sin el último bloque, al reiniciar vuelve la regla y el servidor queda inaccesible
desde fuera.

---

## Fase 5 — Conexión y aprovisionamiento

```bash
chmod 400 ~/ruta/ssh-key-XXXX.key
ssh -i ~/ruta/ssh-key-XXXX.key ubuntu@IP_PUBLICA
```

Una vez dentro, todo el resto lo hace `bootstrap.sh`:

```bash
# Copiar el script al servidor
scp -i ~/ruta/ssh-key-XXXX.key bootstrap.sh ubuntu@IP_PUBLICA:~/

# Ejecutarlo
ssh -i ~/ruta/ssh-key-XXXX.key ubuntu@IP_PUBLICA
sudo bash bootstrap.sh
```

### Qué hace `bootstrap.sh`

1. `apt update && apt upgrade`
2. UFW: 22, 80, 443, 25565/tcp, 19132/udp
3. Arreglo de `iptables` + `netfilter-persistent`
4. `fail2ban` y `unattended-upgrades`
5. JDK 21 (Eclipse Temurin ARM64)
6. Usuario `minecraft` sin privilegios
7. Paper descargado e instalado
8. Servicios `systemd` de Minecraft y de backups
9. Nginx con proxy al panel de Hermes (cuando se instale)
10. Resumen final con IPs y comandos

Es **idempotente**: si falla a medias, se puede volver a lanzar.

---

## Fase 6 — Hermes Agent

### 6.1. Instalación

```bash
# Nunca con curl | bash: descargar, revisar y ejecutar
curl -fsSL https://hermes-agent.nousresearch.com/install.sh -o ~/hermes-install.sh
less ~/hermes-install.sh     # leer antes de ejecutar
bash ~/hermes-install.sh
```

El instalador es serio: clona `NousResearch/hermes-agent`, descarga `uv` con
verificación SHA256, y usa `sudo` solo para `libatomic1`.

### 6.2. Exposición pública

Hermes tiene acceso a shell. **Nunca debe quedar expuesto sin autenticación.**

Configuración mínima recomendada en Nginx:

- HTTPS con Let's Encrypt
- `auth_basic` con contraseña fuerte
- `fail2ban` vigilando el log de acceso

---

## Fase 7 — Verificación

```bash
# Servicios activos
systemctl status minecraft hermes --no-pager
systemctl status nginx --no-pager

# Puertos a la escucha
ss -tlnp | grep -E ':(80|443|25565|22)'

# Firewall
sudo ufw status verbose
sudo iptables -L INPUT -n --line-numbers | head

# Minecraft respondiendo
nc -zv IP_PUBLICA 25565

# Nginx
curl -I http://IP_PUBLICA
```

---

## Ajustes de Paper para 6 jugadores

En `server.properties`:

```properties
max-players=10
view-distance=6
simulation-distance=4
white-list=true
online-mode=true
enable-command-block=false
```

En `config/paper-global.yml`, dejar los valores por defecto salvo que haya lag. El
ajuste importante son los flags de la JVM en el servicio systemd:

```
-Xms4G -Xmx4G -XX:+UseG1GC -XX:+ParallelRefProcEnabled
-XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions
```

Y fijar el núcleo:

```
CPUAffinity=0
```

---

## Checklist final

- [ ] Registro completado en Oracle (tarjeta física)
- [ ] Región: Spain Central (Madrid)
- [ ] Instancia creada: A1.Flex, 2 OCPU, 12 GB, 200 GB, Ubuntu 24.04 ARM
- [ ] Claves SSH descargadas y guardadas
- [ ] IP efímera asignada
- [ ] Security List: 22, 80, 443, 25565/tcp, 19132/udp
- [ ] iptables interno arreglado y persistente
- [ ] `bootstrap.sh` ejecutado sin errores
- [ ] Minecraft arranca y responde en el 25565
- [ ] Whitelist activada con los 6 jugadores
- [ ] Hermes instalado tras leer el script
- [ ] Nginx con HTTPS y auth_basic delante de Hermes
- [ ] Backups diarios funcionando (`systemctl list-timers`)
