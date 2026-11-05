---
tags: [Sistemas_Informaticos, teoria]
---

# RESUMEN DE L TEMA SISTEMAS INFORMÁTICOS EN RED

Ventajas Inconvenientes
Compartir información, servicios y recursos Menor seguridad
Reducción de costes Necesidad de configuración correcta
Mejora la comunicación Dependencia de la red
Trabajo a distancia
RESUMEN DE L TEMA, SISTEMAS
INFORMÁTICOS EN RED
Introducción
Hoy en día es difícil encontrar un equipo trabajando aislado. Las redes permiten compartir recursos, acceder a
internet, trabajar a distancia, etc. También suponen un peligro para la seguridad, por lo que es importante
saber proteger el sistema.
Redes informáticas
Una red informática es un conjunto de sistemas y dispositivos conectados para comunicarse y compartir
recursos.
Ventajas e inconvenientes
Componentes de una red
Dispositivos finales (hosts)
Son los equipos que se conectan a la red mediante una tarjeta de red y tienen una dirección IP válida.
**Ejemplos:** ordenadores, impresoras con tarjeta de red, smartphones, tablets, smartTVs.
Dispositivos intermedios
Conectan los dispositivos finales entre sí o una red con otra.
Switch (conmutador): conecta equipos de una red mediante cable RJ45. Mejora el rendimiento frente
al antiguo hub.
Router (enrutador): conecta diferentes redes. Trabaja con direcciones IP (nivel 3). Establece la mejor
ruta.
**Módem:** permite la conexión a internet. En entornos domésticos suele ir integrado en el router
(módem-router). Para fibra óptica se llama ONT.
Firewall (cortafuegos): filtra el tráfico que entra o sale. Puede ser hardware o software. La DMZ es una
subred aislada donde se colocan servidores accesibles desde internet.
**Repetidor:** regenera la señal para extender la longitud de la red.
Transceptor (transceiver): cambia el tipo de medio de transmisión (ej. fibra óptica a par trenzado).
Medios de transmisión
Medios guiados (por cable)
Par trenzado (cobre): UTP (sin apantallar), STP (cada par apantallado), FTP (pantalla global). Conectores
RJ45. Categorías: Cat5 (100 Mbps), Cat5e (1 Gbps), Cat6 (1 Gbps), Cat6a (10 Gbps), Cat7 (10 Gbps), Cat8
(40 Gbps).
Estándares EIA/TIA: T568A y T568B. El cable directo (mismo estándar en ambos extremos)
conecta dispositivos diferentes; el cruzado (T568A en un extremo, T568B en el otro) conecta
dispositivos iguales. Muchos puertos soportan auto-MDIX.
**Cable coaxial:** núcleo de cobre, aislante y malla trenzada. Antiguamente usado en redes LAN en bus y
FTTB.
Fibra óptica: núcleo de vidrio o plástico, mayor distancia, ancho de banda y menor atenuación. Tipos:
monomodo (un haz de luz) y multimodo (varios haces).
Medios inalámbricos
WiFi (IEEE 802.11): redes WLAN.
WiMAX (IEEE 802.16): microondas para zonas rurales.
Bluetooth (IEEE 802.15.1): corto alcance (10-15 m, hasta 200 m en v5). Redes PAN.
NFC (ISO/IEC 14443): muy corto alcance, usado en pagos e identificación.
Zigbee, Z-Wave, Thread: para domótica (IEEE 802.15.4).
Ancho de banda, velocidad y latencia
**Ancho de banda:** capacidad de transmisión (cantidad de datos a la vez).
Throughput (rendimiento): velocidad real de transferencia (bps, Mbps, Gbps).
**Latencia:** tiempo que tarda la información en ir de un punto a otro.
Control de acceso al medio
CSMA/CD (Ethernet): detecta colisiones.
CSMA/CA (WiFi): evita colisiones.
Token ring (paso de testigo): en desuso.
Protocolos y estándares
Un protocolo es un conjunto de reglas. Un estándar es un protocolo formalizado.
**Organismos:** IEEE, ISO, EIA, TIA, ETSI, ANSI.
**Estándares importantes:** 
IEEE 802.3: Ethernet (CSMA/CD).
IEEE 802.11: WiFi (CSMA/CA).
Topología Descripción
Bus Todos los nodos conectados a un único cable.
Estrella Todos los nodos conectados a un dispositivo central (switch). Es la más usada en LAN.
IEEE 802.15: WPAN (Bluetooth, Zigbee).
EIA/TIA T568A y T568B: cableado LAN.
Tipos de redes
Según dirección de los datos
**Simplex:** unidireccional.
Half-duplex: bidireccional pero no simultánea.
Full-duplex: bidireccional y simultánea.
Según destinatarios
**Unicast:** un emisor a un receptor.
**Multicast:** un emisor a varios.
**Broadcast:** un emisor a todos (solo IPv4).
Según medio físico
Cableadas, inalámbricas, híbridas.
Según relación equipos
Peer-to-peer (P2P): todos iguales.
Cliente-servidor: servidores atienden peticiones de clientes.
Según dimensión y alcance
PAN (Personal Area Network): muy corto alcance (Bluetooth). WPAN (inalámbrica).
LAN (Local Area Network): alcance hasta cientos de metros. WLAN (inalámbrica), HAN (doméstica), VLAN
(virtual).
MAN (Metropolitan Area Network): escala de ciudad.
WAN (Wide Area Network): grandes distancias (países, continentes).
Según privacidad
Públicas (ej. internet).
**Privadas:** solo propietarios.
VPN (Virtual Private Network): red virtual sobre otra red (generalmente internet). Tipos: acceso remoto,
VPN interna (LAN), punto a punto (túnel). Usa autenticación, hash (MD5, SHA), cifrado y firma digital.
Topologías de red
Topología Descripción
Anillo Cada nodo conectado a otros dos formando un anillo.
Malla Cada nodo conectado a varios o todos.
Árbol Combinación de bus y estrella.
Capa Función

### 7. Aplicación Acceso de aplicaciones a la red.

### 6. Presentación Cifrado, compresión.

### 5. Sesión Gestión de sesiones.

### 4. Transporte Confirmación de entrega de datos.

### 3. Red Encaminamiento óptimo (direcciones IP).

### 2. Enlace Agrupación en tramas, control de errores.

### 1. Física Señales eléctricas, conectores, voltajes.
Capa Función
Aplicación Datos del usuario (HTTP, FTP, DNS, etc.).
Transporte Segmentación (TCP, UDP).
Internet Encaminamiento (IP, ARP, ICMP).
Acceso a red Envío físico (Ethernet, WiFi).
Mapas físicos y lógicos
**Mapa lógico:** esquema con hosts, servidores, dispositivos de conexión, subredes, direccionamiento.
Mapa físico: representa la red en el espacio real (edificios, distancias). Herramientas: SmartDraw, Visio,
LibreOffice Draw. Simuladores: Cisco Packet Tracer, GNS3.
Modelos de referencia
Modelo OSI (7 capas)
Modelo TCP/IP (4 capas)
Equivalencia: La capa de Aplicación TCP/IP engloba las capas 5,6,7 de OSI; Transporte e Internet equivalen a
Transporte y Red; Acceso a red engloba Enlace y Física.
Protocolos más utilizados
Capa de Aplicación
DNS (puerto 53): traduce nombres de dominio a IP.
DHCP (puertos 67/68): asignación dinámica de IP.
HTTP (80), HTTPS (443): web.
FTP (21), TFTP (69): transferencia de archivos.
SMTP (25/587), POP3 (110), IMAP (143): correo.
Telnet (23), SSH (22): acceso remoto.
SMB/CIFS (445): compartir archivos e impresoras.
NFS (2049): acceso remoto a archivos en Linux.
SNMP (161/162): gestión de red.
Capa de Transporte
**TCP:** orientado a conexión, fiable.
**UDP:** no orientado a conexión, más rápido.
**SCTP:** combina características.
TLS/SSL: seguridad entre aplicación y transporte.
Capa de Internet
IPv4, IPv6: direccionamiento y encaminamiento.
**ARP:** resolución IP → MAC.
**RARP:** MAC → IP.
**ICMP:** mensajes de control (ping).
**IGMP:** gestión de grupos multicast.
**IPSec:** seguridad en IP (cifrado, autenticación).
Capa de Acceso a red
Ethernet, WiFi, PPP, PPPoE.
Puertos de red
Los puertos son números enteros de 16 bits (0-65535). Los puertos bien conocidos (0-1023) están reservados
para servicios estándar. Los puertos registrados (1024-49151) y puertos dinámicos/privados (49152-65535)
se asignan temporalmente.
Clase Rango Máscara por defecto
A 0.0.0.0 – 127.255.255.255 255.0.0.0 (/8)
Direccionamiento
Direcciones IPv4

### 32 bits → 4 números decimales de 0 a 255 (notación decimal punteada).
**Ejemplo:** 192.168.0.1
Parte de red + parte de host (determinado por la máscara de subred).
Direcciones IPv6

### 128 bits → 8 grupos de 16 bits en hexadecimal, separados por dos puntos :.
**Ejemplo:** 2001:0db8:85a3:0000:0000:8a2e:0370:7334
**Se pueden omitir ceros iniciales y usar :** : para una cadena continua de ceros (solo una vez).
**Dirección de loopback IPv6:** ::1
Direcciones especiales
**Loopback:** 127.0.0.1 (IPv4), ::1 (IPv6). También localhost.
Broadcast (IPv4): todos los bits de host a 1. Ejemplo en red 192.168.0.0/24 → 192.168.0.255.
IPv6 no tiene broadcast; usa multicast y anycast.
Direcciones públicas y privadas
Privadas (no son enrutables en internet):
**Clase A:** 10.0.0.0 – 10.255.255.255
**Clase B:** 172.16.0.0 – 172.31.255.255
**Clase C:** 192.168.0.0 – 192.168.255.255
**Públicas:** asignadas por ISP. El NAT (Network Address Translation) permite que múltiples equipos con
IP privada compartan una IP pública.
Máscara de subred
Separa bits de red y bits de host.
**Notación decimal:** 255.255.255.0 → Notación CIDR: /24 (24 bits para red).
La dirección de red se obtiene haciendo AND entre IP y máscara.
**Ejemplo:** 
IP 192.168.0.32, máscara 255.255.255.0
AND → 192.168.0.0 (dirección de red).
Clases de redes IPv4 (obsoletas por CIDR)
Clase Rango Máscara por defecto
B 128.0.0.0 – 191.255.255.255 255.255.0.0 (/16)
C 192.0.0.0 – 223.255.255.255 255.255.255.0 (/24)
D 224.0.0.0 – 239.255.255.255 Multicast
E 240.0.0.0 – 255.255.255.255 Experimental
Puerta de enlace (gateway)
Es la dirección IP del dispositivo que conecta nuestra red con otras redes (normalmente el router hacia
internet). En redes domésticas suele ser 192.168.0.1 o 192.168.1.1.
Subnetting (división en subredes)
Consiste en tomar bits prestados de la parte de host para crear más redes.
**Ejemplo:** Red 192.168.10.0/24 -> dividir en 4 subredes.
**Tomamos 2 bits prestados:** máscara /26 (255.255.255.192).
**Subredes:** 

### 192.168.10.0/26 (hosts 1-62, broadcast 63)

### 192.168.10.64/26 (hosts 65-126, broadcast 127)

### 192.168.10.128/26 (hosts 129-190, broadcast 191)

### 192.168.10.192/26 (hosts 193-254, broadcast 255)
Servidores DHCP y DNS
**DHCP:** asigna automáticamente IP, máscara, gateway, DNS a los hosts.
**DNS:** traduce nombres de dominio a direcciones IP.
Conexión
Redes cableadas
Uso de cables de par trenzado (conector RJ45) o fibra óptica.
**Estándares Ethernet:** 100Base-T, 1000Base-T, 10GBase-T, etc.
Construcción de un cable RJ45 (T568B):

### 1. Pelar la cubierta unos 2 cm.

### 2. Ordenar los pares según T568B: naranja/blanco, naranja, verde/blanco, azul, azul/blanco, verde,
marrón/blanco, marrón.

### 3. Recortar los hilos alineados.

### 4. Insertar en el conector RJ45 y crimpar.

### 5. Comprobar con un comprobador de cables.
Comando Función
ip address (o ip a) Muestra las direcciones IP.
ip link set <interfaz> up/down Activar/desactivar interfaz.
Redes inalámbricas (WiFi)
Estándares IEEE 802.11: a, b, g, n (WiFi 4), ac (WiFi 5), ax (WiFi 6/6E).
**Bandas:** 2.4 GHz (mayor alcance, menor velocidad) y 5 GHz (menor alcance, mayor velocidad).
**Seguridad WiFi:** 
**WEP:** obsoleto, inseguro.
**WPA:** TKIP, mejor que WEP.
**WPA2:** AES, más seguro.
**WPA3:** cifrado individual, más robusto.
**Medidas adicionales:** filtrado MAC, desactivar difusión SSID, cambiar SSID y contraseña por
defecto.
WPS (Wi-Fi Protected Setup): facilita la conexión pero es inseguro. Se recomienda desactivarlo.
Redes WAN
Abarcan grandes distancias. Protocolos: X.25, Frame Relay, ATM, MPLS, Ethernet sobre fibra. Ejemplo: internet.
Conexión a internet
ADSL (en desuso), fibra óptica (FTTH), WiMAX, redes móviles (4G, 5G).
**Proxy:** intermediario que mejora privacidad y seguridad. Puede ser anónimo, caché, inverso,
transparente.
Configuración de red
VirtualBox
**Modos de adaptador:** 
**NAT:** salida a internet desde la máquina anfitriona, pero las máquinas virtuales no se ven entre
sí.
**Adaptador puente:** la MV tiene su propia IP en la red física.
**Red interna:** solo entre MVs.
Solo-anfitrión: comunicación solo con el anfitrión.
**Red NAT:** MVs entre sí y con salida a internet.
Configuración en Linux (Ubuntu)
**Desde interfaz gráfica:** Configuración → Red.
**Comandos principales:** 
Comando Función
ping <destino> Prueba conectividad.
hostnamectl set-hostname <nombre> Cambia nombre del equipo.
host <nombre> Resolución DNS.
nslookup <dominio> Consulta DNS.
traceroute <destino> Muestra la ruta de los paquetes.
netstat o ss Conexiones de red, tablas de enrutamiento.
systemctl status NetworkManager Estado del gestor de red.
Comando Función
ipconfig Muestra configuración IP.
ipconfig /all Información detallada.
ipconfig /release y /renew Liberar/renovar IP.
ping Prueba conectividad (4 paquetes por defecto).
tracert Ruta de paquetes.
nslookup Consulta DNS.
netstat Conexiones y tablas.
getmac Muestra direcciones MAC.
hostname Muestra el nombre del equipo.
Los ficheros de configuración están en /etc/netplan/ (formato YAML). Aplicar cambios con sudo
netplan apply.
Configuración en Windows
Desde Panel de control o Configuración → Red e Internet → Centro de redes.
**Comandos:** 
**PowerShell:** Get-NetIPAddress, Test-NetConnection.
Monitorización y simulación
Herramientas de monitorización
IPTraf-ng (Linux): monitor de tráfico en terminal. sudo iptraf-ng
Nmon (Linux): monitor de recursos y red. sudo apt install nmon → ejecutar nmon y pulsar n.
**Wireshark:** analizador de protocolos (gráfico). Captura y analiza paquetes.
**Kismet:** analizador de redes inalámbricas.
**Advanced IP Scanner:** escanea la LAN y muestra hosts, IP, MAC, recursos compartidos.
Nmap (también Zenmap gráfico): escaneo de puertos, detección de SO y servicios.
**Ejemplos:** 
nmap 192.168.0.32 (escanea un equipo)
nmap -sL 192.168.0.0/24 (lista equipos)
nmap -A 127.0.0.1 (detección agresiva)
Simuladores de red
Cisco Packet Tracer, GNS3, Dynamips: permiten diseñar y probar redes antes del montaje físico.
