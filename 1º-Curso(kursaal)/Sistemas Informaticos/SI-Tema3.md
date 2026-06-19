# SI-Tema3: Redes

> Conectividad y configuración

## 1. Comandos Básicos

```bash
ping host                    # Comprobar conectividad
ping -c 4 google.com        # 4 paquetes

ifconfig                    # Ver interfaces (deprecated)
ip a                        # Ver interfaces (nuevo)
ip link show                # Ver interfaces de red

hostname -I                 # Ver IP actual
```

---

## 2. Conexión Remota

```bash
ssh usuario@host            # Conectar por SSH
ssh -p 2222 usuario@host    # Puerto personalizado
scp archivo usuario@host:/ruta  # Copiar por SSH
rsync -av origen/ destino/  # Sincronizar
```

---

## 3. Descargas

```bash
curl url                    # Ver contenido
curl -O url                # Descargar archivo
wget url                   # Descargar
wget -r url                # Recursivo
```

---

## 4. DNS

```bash
nslookup dominio           # Consultar DNS
dig dominio                # Consulta detallada
host dominio               # Consulta simple
cat /etc/resolv.conf       # Ver DNS del sistema
```

---

## 5. Puertos y Conexiones

```bash
netstat -tulpn             # Ver puertos listening
ss -tulpn                  # Nuevo netstat
lsof -i                    # Ver archivos abiertos
nmap localhost             # Escanear puertos
```

---

## 6. Firewall (iptables)

```bash
iptables -L                # Ver reglas
iptables -A INPUT -p tcp --dport 22 -j ACCEPT  # Abrir puerto
iptables -A INPUT -j DROP  # Drop por defecto
```

---

## 🔗 Relacionado
- [[SI-Tema2|Estructura Sistema]]
- [[SI-Tema4|Scripts Bash]]

---

🏷️ #sistemas #tema3 #redes #conectividad