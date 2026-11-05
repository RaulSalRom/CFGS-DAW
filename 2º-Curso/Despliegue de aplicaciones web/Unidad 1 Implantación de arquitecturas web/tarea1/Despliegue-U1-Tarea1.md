
## 1. Servidor web frente a servidor de aplicaciones

El servidor web (como Apache) atiende peticiones HTTP y entrega ficheros estáticos. El servidor de aplicaciones (como Tomcat) ejecuta la lógica dinámica en Java (Servlets/JSP). Servir estáticos desde Tomcat sobrecarga la JVM y reduce el rendimiento.

## 2. Renderizado y ejecución en ausencia de servidor HTTP

Es posible abrir webs directamente sin servidor web, pero el navegador aplica restricciones estrictas de seguridad: bloquea peticiones asíncronas por política CORS (origen nulo) e impide cargar módulos ECMAScript por falta de cabeceras HTTP.

## 3. Transición y obsolescencia tecnológica

Se abandonó CGI (creaba un proceso pesado por petición), Applets y ActiveX/VBScript (problemas de seguridad, plugins y falta de portabilidad). Hoy se usan estándares abiertos: HTML5, JavaScript y WebAssembly en el cliente, y arquitecturas persistentes (Servlets, Node.js, FastCGI) en el servidor.

## 4. Comparativa LAMP vs. WISA y su virtualización

Se basa en software libre (Linux, Apache, MySQL, PHP), mientras que WISA es una suite propietaria de Microsoft (Windows, IIS, SQL Server, ASP.NET). La contenedorización con Docker soluciona los conflictos de dependencias y la falta de reproducibilidad del aprovisionamiento manual en el sistema operativo.

## 5. Alojamientos múltiples y Virtual Hosts

Apache permite alojar varios sitios en una única IP pública utilizando la cabecera HTTP Host. El servidor lee esta cabecera y la contrasta con las directivas ServerName de sus archivos de configuración (000-default), entregando el contenido desde el DocumentRoot correspondiente.

## 6. Escalabilidad vertical vs. horizontal

| Criterio | Vertical (scale-up) | Horizontal (scale-out) |
|---|---|---|
| Definición | Añade CPU/RAM a un nodo | Añade más nodos en granja |
| Ventajas | Es sencillo | Alta disponibilidad y coste progresivo |
| Limitaciones | Tiene un límite físico | Exige balanceadores y gestionar el estado |

## 7. Persistencia de sesiones en entornos distribuidos

Tradicional: Sticky sessions (fija el cliente a un servidor) o replicación en clúster (satura la red). Moderno (Stateless): Guardar sesiones en memoria compartida (Redis/Memcached) o usar tokens JWT en el cliente.

## 8. Algoritmos de reparto de carga

- **Round Robin:** Turno rotatorio secuencial.
- **LRU:** Asigna al nodo menos usado recientemente.
- **Least Connections:** Deriva al servidor con menos conexiones activas.
- **Ponderado (Weighted):** Reparte según la capacidad de cómputo de cada máquina.

## 9. Proxy Inverso y protocolo AJP

Situar Apache delante de Tomcat protege la red interna (oculta el puerto 8080), asume la descarga SSL/TLS y optimiza el tráfico mediante el protocolo binario AJP (puerto 8009).

## 10. Administración de servicios en GNU/Linux

Se sustituyeron los scripts SysV (`/etc/init.d/`) por systemd. Control con `systemctl [start | stop | restart | status | enable] apache2`.
