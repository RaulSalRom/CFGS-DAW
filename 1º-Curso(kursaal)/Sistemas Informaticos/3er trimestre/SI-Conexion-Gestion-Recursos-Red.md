# SI · Conexión y Gestión de Recursos en Red

> 🏠 [[📚 Indice General]] ▸ [[Sistemas Informaticos|Sistemas Informáticos]] │ 📄 Fuente: `Conexión y gestión de recursos en red.pdf` (31 págs.) │ ➡️ [[SI-Tema3|Tema 3 · Redes]]

## Índice
- [1. Seguridad en redes](#1-seguridad-en-redes)
- [2. Cortafuegos](#2-cortafuegos)
- [3. Detección de intrusos](#3-detección-de-intrusos)
- [4. Cifrado y certificados](#4-cifrado-y-certificados)
- [5. Configuración del router](#5-configuración-del-router)
- [6. Recursos compartidos](#6-recursos-compartidos)
- [7. Listas de control de acceso (ACL)](#7-listas-de-control-de-acceso-acl)
- [8. Acceso remoto](#8-acceso-remoto)
- [9. Servidores](#9-servidores)

---

## 1. Seguridad en redes

Hay que preservar tres propiedades básicas:

- **Integridad:** que la información no se pierda ni se altere.
- **Disponibilidad:** que se pueda acceder cuando sea necesario.
- **Privacidad/confidencialidad:** que solo acceda quien está autorizado.

### Medidas de seguridad

| Tipo | Cuándo actúa | Ejemplos |
|---|---|---|
| **Activas** | Detectan la amenaza y actúan contra ella. | Control de acceso, antivirus, firewall, IDS |
| **Pasivas** | Reducen el impacto una vez producido el ataque. | Copias de seguridad, planes de recuperación |

También pueden implantarse por **hardware** o por **software**.

### Control de acceso

Limita qué usuarios acceden a qué equipos, qué equipos entran en la red o qué comandos se pueden ejecutar. Incluye el **control de acceso físico** al CPD (identificación electrónica, vigilancia, cámaras, protección contra humedad, temperatura, incendios y SAI).

---

## 2. Cortafuegos

El **firewall** protege los sistemas o redes de las amenazas que llegan por la red: impide el acceso no autorizado y permite el tráfico autorizado, tanto entrante como saliente.

- **Hardware:** se coloca entre la red y el acceso a internet o a otra red; puede estar integrado en el router.
- **Software:** incluido en el sistema operativo o de terceros (a veces dentro del antivirus).

### DMZ (zona desmilitarizada)

Zona aislada de la red interna donde se colocan los servidores accesibles desde internet (web, correo).

| Origen → Destino | ¿Permitido? |
|---|---|
| Internet → DMZ | Sí |
| Internet → LAN interna | No |
| DMZ → Internet | Sí |
| DMZ → LAN interna | No |
| LAN → DMZ e Internet | Sí |

También existe el modelo de **doble firewall** para reforzar la protección de la LAN.

### Cortafuegos en Linux: `ufw`

```bash
sudo ufw enable            # activa y habilita al arranque
sudo ufw disable           # desactiva
sudo ufw reload            # recarga
sudo ufw reset             # resetea
sudo ufw status verbose    # estado detallado
sudo ufw status numbered   # reglas numeradas
sudo ufw allow 3389        # permite el puerto
sudo ufw deny 3389         # deniega el puerto
sudo ufw default deny      # política por defecto
```

`ufw` es una forma sencilla de manejar `iptables` y su sucesor `nftables`.

### Cortafuegos en Windows

- **Firewall de Windows Defender:** panel de control o búsqueda de Inicio.
- **Seguridad avanzada:** `wf.msc` o `Win + R`.
- **Perfiles:** dominio, privada y pública/invitada.
- **Reglas:** entrada y salida; permitir, bloquear o permitir solo si la conexión es segura.

```powershell
Get-NetFirewallProfile                       # estado de los perfiles
netsh advfirewall show allprofiles state     # estado por perfiles
```

---

## 3. Detección de intrusos

| Sistema | Comportamiento |
|---|---|
| **IDS** | Pasivo: detecta la intrusión y emite una alarma. |
| **IPS** | Activo: monitoriza y detiene la amenaza. |
| **SIEM** | Centraliza y analiza eventos de seguridad; descarta falsos positivos. |

Otras buenas prácticas: revisar logs, filtrar direcciones MAC, ocultar el SSID y mantener los equipos actualizados.

---

## 4. Cifrado y certificados

- **OpenSSL:** herramientas de seguridad para TLS/SSL y utilidades criptográficas.
- **LibreSSL:** bifurcación de OpenSSL (`libcrypto`, `libssl`, `libtls`).
- **Let's Encrypt:** autoridad de certificación que emite certificados gratuitos válidos para HTTPS.

```bash
openssl req -out certificado.csr   # genera una petición de certificado
```

El certificado incluye un par de claves: la **privada** se queda en el servidor y la **pública** se envía al cliente para verificar la identidad del servidor.

Formatos habituales: `.CSR`, `.KEY`, `.DER`, `.CRT`, `.CERT`, `.CER`, `.PEM`.

### Comprobar certificados

```powershell
certmgr.msc   # certificados del usuario actual (Windows)
certlm.msc    # certificados del equipo local (Windows)
```

En Linux están en `/etc/ssl/certs`, junto a `ca-certificates.crt`.

---

## 5. Configuración del router

Para entrar en el router se necesita su IP, usuario y contraseña. Suele ser la puerta de enlace (`192.168.1.1` o `192.168.0.1`) y aplica **NAT** para traducir direcciones privadas a públicas.

Medidas recomendadas:

1. Cambiar la contraseña por defecto.
2. Ocultar el SSID.
3. Cambiar la contraseña del Wi-Fi.
4. Usar el cifrado más seguro posible.
5. Activar el filtrado MAC.
6. Desactivar WPS si no se usa.
7. Actualizar el firmware.
8. Abrir solo los puertos necesarios.

```bash
tracert google.es      # Windows: ruta hasta el destino
traceroute google.es   # Linux: ruta hasta el destino
```

---

## 6. Recursos compartidos

### Identificación de equipos

- Cada equipo necesita una **IP única** y un **nombre único** (máximo 15 caracteres).
- Caracteres no permitidos en el nombre: `; : " < > * + = \ / | ? ,`
- **Grupo de trabajo:** administración descentralizada, útil en redes pequeñas.
- **Dominio:** existe un controlador de dominio (Active Directory o LDAP) y cuentas centralizadas.
- **FQDN:** nombre completo, por ejemplo `equipolinux.dominio.edu`.

### Comprobar conectividad

```bash
ping -c 4 192.168.1.10     # Linux: 4 paquetes
ping -n 4 192.168.1.10     # Windows: 4 paquetes
```

```powershell
Test-NetConnection -ComputerName <nombre> -TraceRoute
Test-NetConnection -ComputerName <nombre> -Port <puerto>
```

### Compartir en Windows

- Activar **detección de redes** y **uso compartido de archivos e impresoras**.
- Propiedades de la carpeta → **Compartir** → elegir usuarios y permisos.
- **Uso compartido avanzado** → nombre del recurso y permisos.
- Opciones de seguridad: protección por contraseña y cifrado de conexiones de 128 bits.

```cmd
net share
```

### Compartir en Linux: Samba

Samba implementa SMB/CIFS para compartir archivos e impresoras e integrarse con Active Directory.

```bash
sudo apt install samba samba-common smbclient
sudo systemctl status smbd
sudo systemctl status nmbd
sudo smbpasswd -a usuario      # añade usuario de Samba
sudo smbpasswd -x usuario      # lo elimina
sudo pdbedit --list            # lista usuarios de Samba
```

Configuración en `/etc/samba/smb.conf`:

| Sección | Contenido |
|---|---|
| `[global]` | Configuración global |
| `[profiles]` | Perfiles móviles |
| `[homes]` | Directorios personales |
| `[printers]` | Impresoras compartidas |
| `[print$]` | Controladores de impresoras |

---

## 7. Listas de control de acceso (ACL)

Las **ACL** amplían el control de permisos sobre recursos locales y de red.

| Tipo | Función |
|---|---|
| **DACL** | Indica qué usuarios y grupos pueden usar un objeto y con qué permisos. |
| **SACL** | Indica qué accesos se auditan y se registran. |

Una ACL contiene **ACE** (*Access Control Entry*), que indican los permisos de cada usuario o grupo. Los permisos pueden ser explícitos o heredados.

### Linux

```bash
grep ACL /boot/config-*              # comprobar soporte ACL en el kernel
sudo tune2fs -l /dev/sda3            # ver opciones de montaje
sudo mount -o remount,defaults,acl /home
dpkg -s acl                          # comprobar si está instalado
sudo apt install acl
```

```bash
getfacl archivo                      # obtiene la ACL
setfacl -m u:usuario:rw archivo      # modifica permisos
setfacl -x u:usuario archivo         # elimina permisos
setfacl -b archivo                   # elimina toda la ACL
setfacl -R -m g:grupo:r directorio   # aplica recursivamente
```

En `/etc/fstab` hay que añadir la opción `acl`:

```
UUID=xxxx /home ext4 defaults,acl 0 0
```

### Windows

Requiere **NTFS** (no funciona en FAT). Se gestiona desde **Propiedades → Seguridad → Opciones avanzadas** o con `icacls`.

```cmd
icacls archivo /grant usuario:F
icacls archivo /deny usuario:W
icacls archivo /remove usuario
icacls /?
```

Permisos básicos: `N` (sin acceso), `F` (total), `M` (modificar), `RX` (lectura y ejecución), `R` (solo lectura), `W` (solo escritura), `D` (borrar).

También existen `Get-Acl` y `Set-Acl` en PowerShell.

---

## 8. Acceso remoto

| Método | Protocolo | Puerto | Uso |
|---|---|---|---|
| Escritorio remoto Windows | RDP | 3389 | Entorno gráfico |
| Escritorio remoto Linux | VNC | — | Entorno gráfico |
| Terminal remota | Telnet | 23 | Texto, **sin cifrar** |
| Terminal remota segura | SSH | 22 | Texto cifrado |

### RDP / xrdp

```bash
sudo ufw allow 3389
sudo apt install xrdp -y
sudo systemctl status xrdp
```

En Linux se puede conectar con **Remmina**:

```bash
sudo apt install remmina
```

### SSH

```bash
sudo apt update && sudo apt upgrade
sudo apt install openssh-server
sudo systemctl status sshd
sudo apt install openssh-client

ssh usuario@direccionIP -p puerto
ssh usuario@nombreequipo -p puerto
```

Aplicaciones cliente: **PuTTY**, Remmina, KITTY, Bitwise SSH Client.

### Copias remotas

```bash
scp archivo.txt usuario@servidor:/ruta/destino
```

También existe `rsync`.

---

## 9. Servidores

### DHCP

Asigna automáticamente IP, máscara, puerta de enlace y DNS. Gestiona concesiones y evita duplicados.

- **IP-MAC binding:** reserva una IP para una MAC concreta.
- **APIPA:** si no hay DHCP, el equipo se asigna una dirección `169.254.0.0/16`.

```bash
sudo apt update
sudo apt install isc-dhcp-server -y
sudo nano /etc/dhcp/dhcpd.conf
sudo systemctl enable isc-dhcp-server
sudo systemctl status isc-dhcp-server
```

Ejemplo de configuración:

```conf
option domain-name "dominio.edu";
option domain-name-servers ns1.dominio.edu, ns2.dominio.edu;
default-lease-time 600;
max-lease-time 7200;

subnet 192.168.2.0 netmask 255.255.255.0 {
  range 192.168.2.10 192.168.2.20;
  host equipoll {
    hardware ethernet 00:00:0f:ff:00:00;
    fixed-address 192.168.2.100;
  }
}
```

Cliente:

```cmd
ipconfig /all
ipconfig /renew
ipconfig /release
```

```bash
ip address show
sudo dhclient -r     # libera
sudo dhclient        # renueva
sudo dhclient -v     # información
```

### DNS

Traduce nombres de dominio a direcciones IP y viceversa. Organiza los nombres en una jerarquía de dominios.

- **TLD:** `.com`, `.net`, `.org`, `.edu`, `.es`…
- **Zonas:** directa (nombre → IP) e inversa (IP → nombre).
- **Reenviador DNS:** consulta a otro servidor para dominios externos.

Registros DNS:

| Registro | Función |
|---|---|
| `A` | Nombre → IPv4 |
| `AAAA` | Nombre → IPv6 |
| `CNAME` | Alias de un dominio |
| `MX` | Servidor de correo |
| `NS` | Servidor DNS autoritativo |
| `TXT` | Información de texto |
| `SOA` | Autoridad de la zona |
| `PTR` | Traducción inversa |
| `SRV` | Servicios ofrecidos |

```bash
dig localhost
dig paraninfo.es
```

### FTP

Transfiere archivos entre equipos. Usa TCP y los puertos **20 y 21**. TFTP usa UDP.

```bash
sudo apt update
sudo apt install vsftpd
sudo systemctl enable vsftpd
sudo systemctl start vsftpd
sudo systemctl status vsftpd
```

Configuración en `/etc/vsftpd.conf`:

```conf
anonymous_enable=NO
local_enable=YES
chroot_local_user=YES
```

Cliente:

```bash
ftp host
# help, ls, cd, get, put, pwd, rename, quit
```

### NFS

Comparte sistemas de archivos por red.

```bash
sudo apt install nfs-kernel-server
sudo mkdir /home/compartida
sudo chown nobody:nogroup /home/compartida
sudo chmod 777 /home/compartida
```

```conf
# /etc/exports
/home/compartida <IP>(rw,sync)
```

```bash
sudo exportfs -a
sudo systemctl restart nfs-kernel-server
showmount -e <IP_servidor>
sudo mount -o rw <IP_servidor>:/home/compartida /home/compartida
```

### Impresión: CUPS

```bash
systemctl status cups
```

### Servidor web

- **Apache en Linux:** configuración en `/etc/apache2/apache2.conf`; sitio por defecto en `/var/www/html`; página inicial `index.html`.
- **IIS en Windows:** sitio por defecto en `C:\inetpub\wwwroot`.

```bash
sudo apt install apache2 -y
sudo systemctl status apache2
sudo systemctl stop|start|restart|enable|disable apache2
```

> En un mismo equipo no puede haber dos servidores web escuchando el mismo puerto.

### Servidor de aplicaciones

Centraliza la ejecución de aplicaciones: **Zope** (Python), **IIS** (ASP.NET), **WildFly** (Java EE).

### Docker

Requisitos: 64 bits, 4 GB de RAM y virtualización activada. En Windows 10/11 Pro se usa Hyper-V; en Home, WSL2.

```bash
docker run hello-world
docker run -d -p 80:80 docker/getting-started
docker run httpd
```

---

## 🔗 Relacionado
- [[Sistemas Informaticos|Sistemas Informáticos (Índice)]]
- [[SI-Tema3|Tema 3 · Redes]]
- [[SI-Tema4|Tema 4 · Scripts Bash]]
- [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web]]
- [[Docker para Base de Datos|Docker para Base de Datos]]

🏷️ #si #redes #seguridad #servidores #dhcp #dns #ssh #1daw
