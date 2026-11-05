---
tags: [Sistemas_Informaticos, teoria]
---

# Tema 4 Adaptación- V-02

ADMINISTRACIÓN Y CONFIGURACIÓN DEL SISTEMA OPERATIVO LINUXINTRODUCCIÓN AL SISTEMA OPERATIVO LINUX
El sistema operativo Linux es uno de los más extendidos en el panorama tecnológico actual, con una presencia dominante en servidores y una creciente popularidad enordenadores personales. Su origen se remonta a principios de los años 90 como una versión del sistema operativo Unix, pero su desarrollo se ha regido por un modelo de softwarelibre y código abierto. Este modelo está fundamentado en la licencia GPL (General Public License) y el acrónimo GNU (un acrónimo recursivo que significa GNU Not Unix), quegarantizan las libertades de los usuarios para usar, estudiar, modificar y distribuir el software.
La función de Linux como sistema operativo es gestionar los recursos del hardware y proporcionar una plataforma para la ejecución de aplicaciones. Su robustez, flexibilidad yseguridad lo han convertido en la opción preferida para infraestructuras críticas en internet, supercomputación y dispositivos embebidos.
En esta unidad, exploraremos los fundamentos de la administración del sistema operativo Linux, comenzando por la interacción básica con sus entornos gráfico y de comandos,hasta llegar a la configuración avanzada de usuarios, permisos, procesos y la automatización de tareas mediante scripts.

### 1.0 PRIMEROS PASOS: USO DEL SISTEMA OPERATIVO LINUX
Para administrar eficazmente un sistema Linux, es fundamental dominar tanto su interfaz gráfica de usuario (GUI) como su interfaz de línea de comandos (CLI), comúnmenteconocida como la terminal. Lejos de ser excluyentes, ambos entornos son complementarios: la GUI ofrece una experiencia visual e intuitiva para las tareas cotidianas, mientras quela terminal proporciona un control potente, rápido y automatizable para la configuración y administración avanzada del sistema.

### 1.1 LA INTERFAZ GRÁFICA (GUI)
La interfaz gráfica de Linux se compone de un entorno de escritorio, que es un conjunto completo de software que ofrece una experiencia de usuario coherente con aplicaciones,iconos y menús, y un gestor de ventanas, que se encarga específicamente del aspecto y la posición de las ventanas. Existen múltiples opciones, como GNOME (elpredeterminado en Ubuntu), KDE, XFCE, LXDE y Cinnamon, cada uno con sus propias características y requisitos de sistema.
En la instalación por defecto de Ubuntu, la interfaz gráfica presenta los siguientes componentes principales:
Desde el menú del sistema, se pueden gestionar las opciones de la sesión de usuario:
La opción de Configuración abre un panel centralizado desde donde se pueden ajustar diversos aspectos del sistema, organizados en categorías como:

### 1.2 LA TERMINAL (CLI)
La terminal es la herramienta fundamental para cualquier administrador de sistemas Linux. Proporciona una interfaz de línea de comandos (CLI) para ejecutar órdenesdirectamente. Se puede acceder a ella de varias formas:
Al abrir una terminal, se muestra el prompt o indicador del sistema, que informa sobre el usuario conectado y la ruta actual. Un símbolo de dólar ($) indica que se ha iniciadosesión como un usuario estándar, mientras que una almohadilla (#) indica que se está operando como el superusuario o root. Es crucial recordar que Linux es case-sensitive, esdecir, distingue entre mayúsculas y minúsculas en nombres de ficheros, directorios y comandos.
La sintaxis general de un comando en la terminal sigue esta estructura: comando [-opción...] [argumento...]
Una característica muy útil de la terminal es el autocompletado. Al pulsar la tecla de tabulación (Tab), el sistema intentará completar automáticamente el nombre de un comando,fichero o directorio que se esté escribiendo.

### 1.3 COMANDOS ESENCIALES DE INTERACCIÓN
A continuación, se presentan algunos de los comandos básicos más importantes para empezar a interactuar con el sistema a través de la terminal.
history
Escritorio: Es el área de trabajo principal, donde se encuentra el fondo de pantalla y se pueden colocar carpetas y ficheros.Botón Aplicaciones: Ubicado en la esquina inferior izquierda, permite buscar y acceder a todas las aplicaciones instaladas en el sistema.Dock: Una barra lateral (por defecto a la izquierda) que muestra las aplicaciones abiertas y las ancladas como favoritas para un acceso rápido.Menú del sistema: Situado en la esquina superior derecha, desde aquí se puede acceder a la configuración de red, audio, energía, y a las opciones de sesión como apagar,reiniciar o suspender.Selector de ventanas – Actividades: Permite gestionar las ventanas y escritorios virtuales que están abiertos.Menú Aplicaciones: Sirve para gestionar la aplicación que está activa en primer plano.Calendario y notificaciones: Permite consultar la fecha, los eventos del calendario y ver las notificaciones del sistema.
Apagar/cerrar sesión: Permite apagar el equipo, reiniciar, suspender, bloquear la pantalla o cerrar la sesión del usuario actual.Suspender: Pone el equipo en un estado de bajo consumo, manteniendo la sesión activa en la memoria para una reanudación rápida.Reiniciar: Apaga y vuelve a encender el sistema.
Red, Bluetooth, Fondo de escritorio, Notificaciones: Para gestionar la conectividad, la apariencia visual y las alertas.Buscar, Multitarea, Aplicaciones: Configuran el comportamiento del escritorio y las aplicaciones.Privacidad, Compartir, Sonido, Energía: Ajustan la seguridad, los recursos compartidos y la gestión de hardware.Monitores, Ratón y panel táctil, Teclado, Impresoras: Permiten configurar los periféricos.Soportes extraíbles, Color, Región e idioma, Accesibilidad: Opciones adicionales para la gestión de dispositivos, perfiles de color y adaptaciones para el usuario.Usuarios, Aplicaciones predeterminadas, Fecha y hora, Acerca de: Para la gestión de cuentas, aplicaciones por defecto, la hora del sistema y la visualización deinformación del equipo.
Desde el menú de Aplicaciones, buscando "Terminal".Mediante el atajo de teclado Ctrl+Alt+T.A través de las consolas virtuales, usando las combinaciones desde Ctrl+Alt+F1 hasta Ctrl+Alt+F7 (la F7 suele ser la que corresponde al entorno gráfico).
Comando: La instrucción que se desea ejecutar.Opción: Modifica el comportamiento del comando. Pueden ser cortas (un guion y una letra, ej. -l) o largas (dos guiones y una palabra, ej. --list).Argumento: El objeto sobre el que actúa el comando (ej. un nombre de fichero o directorio).
Propósito: Muestra los últimos comandos utilizados.Sintaxis: history [opciones]Opciones Principales: -c (Borra el historial de comandos).
clear
date
ModificadorDescripción%d Día del mes (ej. 01)%m Mes (01..12)%Y Año%D La fecha; igual que %m/%d/%y%F Fecha completa; igual que %Y-%m-%d%H La hora en formato de 24 horas%I Hora (01..12)%M Minutos (00..59)%S Segundos (00..60)%T Hora; igual que %H:%M:%S%j Día del año (001..366)
whoami
who
sudo
uname
lsb_release
lshw
passwd
exit
**Ejemplo:** history -c borra el historial de la sesión actual.
Propósito: Limpia la pantalla de la terminal.Sintaxis: clearOpciones Principales: Ninguna.Ejemplo: clear
Propósito: Muestra o cambia la fecha y hora del sistema.Sintaxis: date [opciones]... [+formato]Opciones Principales: -s, --set=STRING (Establece la hora indicada).Ejemplo: date '+%d/%m/%Y' muestra la fecha en formato día/mes/año.
Propósito: Muestra el nombre del usuario actual.Sintaxis: whoamiOpciones Principales: Ninguna.Ejemplo: whoami
Propósito: Muestra quién está conectado al sistema.Sintaxis: who [opciones]Opciones Principales: -a, --all (Muestra toda la información).Ejemplo: who --all muestra la fecha de arranque, usuarios, terminales y nivel de arranque.
Propósito: Ejecuta un comando con privilegios de superusuario (super user do).Sintaxis: sudo [comando]Opciones Principales: Dependen del comando a ejecutar.Ejemplo: sudo apt update
Propósito: Muestra información sobre el sistema operativo y el equipo.Sintaxis: uname [opciones]Opciones Principales: -s (kernel-name), -n (nodename), -r (kernel-release), -v (kernel-version), -p (processor), -i (hardware-platform), -o (operating-system), -a(all).Ejemplo: uname -a muestra toda la información disponible.
Propósito: Muestra información sobre la distribución de Linux.Sintaxis: lsb_release [opciones]Opciones Principales: -i (distributor id), -d (description), -r (release), -c (codename).Ejemplos: lsb_release --description o lsb_release -d
Propósito: Muestra una lista completa del hardware del sistema. Requiere privilegios de superusuario.Sintaxis: lshw [opciones]Opciones Principales: -html (formato HTML), -xml (formato XML), -json (formato JSON), -short (formato corto).Ejemplo: sudo lshw -html
Propósito: Cambia la contraseña de un usuario.Sintaxis: passwd [opciones] [usuario]Opciones Principales: -d, --delete (Elimina la contraseña), -l, --lock (Bloquea la cuenta), -u, --unlock (Desbloquea la cuenta).Ejemplo: sudo passwd -d usuario2
logout
reboot
shutdown
Para obtener ayuda detallada sobre cualquier comando, se pueden utilizar las siguientes herramientas:
Una vez familiarizados con los comandos básicos de interacción, el siguiente paso es comprender cómo Linux organiza la información. Esto nos lleva al sistema de archivos ydirectorios, la columna vertebral de cualquier sistema operativo.

### 2.0 GESTIÓN DE ARCHIVOS Y DIRECTORIOS
En Linux, la estructura del sistema de archivos es fundamental. Sigue una filosofía donde "todo es un archivo", lo que significa que no solo los documentos y programas serepresentan como archivos, sino también los dispositivos de hardware (como discos duros y teclados), los directorios e incluso las conexiones de red. Esta aproximación unifica lamanera en que el sistema operativo interactúa con todos sus componentes, haciendo su gestión más consistente y potente a través de una estructura jerárquica de directorios queparte de un único directorio raíz.

### 2.1 SISTEMAS Y ESTRUCTURA DE ARCHIVOS
Un sistema de archivos es la estructura que utiliza el sistema operativo para organizar y gestionar la información en los dispositivos de almacenamiento. Los tipos más comunes enLinux son:
ext4 (Fourth Extended Filesystem): Es el sistema de archivos predominante en la mayoría de las distribuciones de Linux. Es una evolución de sus predecesores (ext2, ext3) y ofrecemejoras en rendimiento, tamaño y fiabilidad. Una de sus características clave es el journaling, un registro que anota las operaciones de escritura antes de realizarlas, lo que permiteuna recuperación rápida y segura del sistema en caso de un apagado inesperado o un fallo.
btrfs (B-tree Filesystem): Es un sistema de archivos moderno diseñado para ofrecer funciones avanzadas de gestión y administración del almacenamiento. Entre sus característicasdestacan las instantáneas (snapshots), la compresión de datos, la verificación de integridad y la capacidad de gestionar volúmenes de gran tamaño de forma flexible. Estáespecialmente orientado a entornos donde se requiere alta fiabilidad y facilidad para realizar copias de seguridad y restauraciones.
xfs: Es un sistema de archivos de alto rendimiento, optimizado para trabajar con grandes volúmenes de datos y archivos de gran tamaño. Destaca por su escalabilidad y eficienciaen operaciones de entrada/salida, por lo que es ampliamente utilizado en servidores y sistemas empresariales. Al igual que ext4, incorpora journaling para garantizar la consistenciade los datos.
swap: No es un sistema de archivos para datos de usuario, sino un espacio especial en el disco duro utilizado como memoria virtual. Cuando la memoria RAM se llena, el sistemaoperativo mueve los datos menos utilizados de la RAM al área swap para liberar espacio, mejorando así la estabilidad y el rendimiento del sistema.
La organización de los directorios en Linux sigue el estándar FHS (Filesystem Hierarchy Standard), que define un árbol de directorios jerárquico que comienza en el directorioraíz, representado por una barra (/).
NombreContenido/binProgramas ejecutables necesarios para el arranque y funcionamiento del sistema./sbinProgramas ejecutables del superusuario necesarios para el arranque y funcionamiento del sistema./bootArchivos necesarios para el arranque del sistema./devArchivos de los dispositivos del sistema./etcConfiguración del sistema./homeContiene los directorios personales de los usuarios normales./lib Bibliotecas necesarias para que se puedan ejecutar los programas ejecutables./mediaDirectorios de almacenamiento montadas, como pendrives, DVD, carpetas compartidas, etcétera./mntAquí se montan sistemas de archivos de forma temporal. Se usa de forma similar al anterior./optAplicaciones instaladas sin utilizar los repositorios./procDirectorio temporal con archivos que envían información al kernel o núcleo que son los archivos de los procesos que se están en ejecución./runDirectorio temporal con archivos necesarios para almacenar en la RAM en tiempo de ejecución ciertos datos de procesos en ejecución./snapDirectorios con las aplicaciones instaladas con snap./rootDirectorio personal del usuario root./tmpArchivos temporales./varArchivos de variables y logs./srvDirectorios de los servidores que se instalen en el sistema.swapfileFichero de intercambio para la memoria virtual del sistema.
Preste especial atención a /etc, /home, y /var, ya que son los directorios con los que interactuará con mayor frecuencia en sus tareas diarias de configuración, gestión deusuarios y revisión de registros.
**Propósito:** Termina la sesión de un usuario o sale de la terminal.Sintaxis: exit
Propósito: Sale de la sesión en una terminal virtual o de entrada (una terminal donde se ha iniciado sesión, no en el modo gráfico).Sintaxis: logout
**Propósito:** Reinicia el sistema.Sintaxis: reboot
Propósito: Apaga, pausa o reinicia el sistema.Sintaxis: shutdown [opciones]... [tiempo]Opciones Principales: -H, --halt (Detiene el sistema), -P, --poweroff (Apaga el sistema), -r, --reboot (Reinicia el sistema), -c (Cancela un apagado programado).Ejemplo: shutdown -r now reinicia el sistema inmediatamente. shutdown -h +5 apaga el sistema en 5 minutos.
- man [comando]**: Muestra el manual de referencia del comando.**info [comando]**: Proporciona información más detallada, a menudo en un formato hipertexto.**[comando] --help**: Muestra una ayuda rápida con las opciones más comunes del comando.

### 2.2 CONCEPTOS CLAVE: FICHEROS, RUTAS Y DIRECTORIOS
Ficheros en Linux Los nombres de los ficheros pueden tener hasta 255 caracteres, y aunque el carácter . se usa comúnmente para indicar la extensión (ej. .txt, .pdf), no esobligatorio. Internamente, cada fichero está asociado a una estructura de datos llamada inodo, que contiene metadatos esenciales sobre el mismo:
Directorios Especiales En cualquier directorio, existen dos entradas especiales:
Ruta Absoluta y Ruta Relativa Una ruta es la dirección para localizar un fichero o directorio en el sistema de archivos.
Además, el carácter ~ (virgulilla) es un atajo que representa el directorio personal del usuario que ha iniciado la sesión.

### 2.3 OPERACIONES CON ARCHIVOS Y DIRECTORIOSMODO GRÁFICO
En entornos como GNOME, el gestor de archivos predeterminado es Archivos (Nautilus). Permite realizar todas las operaciones comunes de forma visual:
MODO TERMINAL
La terminal ofrece un conjunto de comandos potente para gestionar archivos y directorios.
ls
pwd
mkdir
cd
rmdir
rm
cp
mv
Número de inodo: Identificador único del fichero.Nombre del fichero.Permisos: Quién puede leer, escribir o ejecutar el fichero.Tipo de archivo: Si es regular, directorio, enlace, etc.Tamaño en bytes.Propietario y grupo: UID y GID del dueño.Fechas: De creación, acceso y modificación.Bloques: Ubicación de los datos del fichero en el disco.
. (punto): Hace referencia al directorio actual... (doble punto): Hace referencia al directorio superior o padre.
Ruta absoluta: Es la ruta completa desde el directorio raíz (/). Siempre es única y no depende de la ubicación actual. Ejemplo: /home/usuario/fichero.txt.Ruta relativa: Es la ruta desde el directorio actual donde nos encontramos. Puede variar dependiendo de nuestra ubicación. Ejemplo: si estamos en /home/usuario, la rutarelativa a fichero.txt sería simplemente fichero.txt o ./fichero.txt.
Crear carpetas (botón secundario → Nueva carpeta).Mostrar archivos ocultos (cuyos nombres empiezan por .) con el atajo Ctrl+H o desde el menú de opciones.El menú contextual (botón secundario) sobre un fichero o directorio ofrece opciones como Abrir, Cortar, Copiar, Mover a la papelera, Renombrar y ver sus Propiedades.
Propósito: Muestra el contenido de un directorio.Sintaxis: ls [opciones]... [fichero]...Opciones clave: -d (muestra información sobre el directorio), -a (muestra todos los ficheros, incluidos los ocultos), -l (formato largo), -h (tamaño legible por humanos).Ejemplos: ls -la muestra todos los ficheros en formato largo.
Propósito: Muestra la ruta absoluta del directorio de trabajo actual (print working directory).Sintaxis: pwd
Propósito: Crea directorios.Sintaxis: mkdir [opciones]... directorio...Opciones clave: -p, --parents (crea los directorios padres si no existen).Ejemplo: mkdir -p dir1/dir2/dir3 crea toda la estructura de directorios.
Propósito: Cambia de directorio (change directory).Sintaxis: cd [opciones]... [directorio]Ejemplos: cd .. sube al directorio superior. cd sin argumentos lleva al directorio personal del usuario.
Propósito: Elimina directorios vacíos.Sintaxis: rmdir [opciones]... directorio...Opciones clave: -p, --parents (borra los directorios padres si quedan vacíos).
Propósito: Elimina ficheros y directorios.Sintaxis: rm [opciones]... [fichero o directorio]...Opciones clave: -i (pregunta antes de cada eliminación), -r, -R, --recursive (elimina directorios y su contenido de forma recursiva).Ejemplo: rm -ri directorio1 elimina de forma recursiva e interactiva el directorio.
Propósito: Copia ficheros.Sintaxis: cp [opciones]... origen... destinoOpciones clave: -r, -R, --recursive (copia directorios de forma recursiva).Ejemplo: cp fichero1.txt fichero2.txt crea una copia de fichero1.txt.
touch
stat
du
df
ln
whereis
locate
find

### 2.4 CARACTERES ESPECIALES Y PROCESAMIENTO DE FLUJOS DE TEXTO
La terminal utiliza una serie de caracteres especiales para realizar operaciones avanzadas.
Metacaracteres (Comodines) Permiten sustituir a un carácter o a un conjunto de ellos.
CarácterSignificado* Cero o varios caracteres.? Un carácter exactamente.[] Un carácter que se indicará dentro del corchete. Se pueden utilizar rangos.{} Varios caracteres o cadenas de caracteres, separadas por comas.
Sustitución de comandos Permite usar la salida de un comando como argumento de otro. Se consigue con $(comando) o con comillas invertidas `comando`.
Separación y ejecución condicional de comandos
Redireccionamientos y tuberías (pipes) En Linux, los procesos tienen tres flujos de datos estándar: entrada estándar (stdin), salida estándar (stdout) y salida de error estándar(stderr). Los redireccionamientos y las tuberías permiten manipular estos flujos.
Tipo Función< Redirecciona la entrada estándar de un comando.> Redirecciona la salida estándar a un fichero, sobrescribiendo su contenido.>> Redirecciona la salida estándar a un fichero, añadiendo el contenido al final.2> Redirecciona la salida de errores a un fichero, sobrescribiendo su contenido.
Propósito: Mueve o renombra uno o varios ficheros.Sintaxis: mv [opciones]... fuente destinoOpciones clave: -i, --interactive (pregunta antes de sobrescribir), -f, --force (fuerza la sobrescritura).Ejemplo: mv fichero2.txt fichero3.txt renombra el fichero. mv fichero3.txt carpeta/ lo mueve a la carpeta.
Propósito: Modifica la fecha de un fichero y, si no existe, lo crea vacío.Sintaxis: touch ficheros...
Propósito: Muestra información sobre el fichero (inodo).Sintaxis: stat [opciones]... fichero...Opciones clave: -f, --file-system (muestra información del sistema de archivos).
Propósito: Muestra el espacio usado en el disco por un fichero o directorio (disk usage).Sintaxis: du [opciones]... [fichero]...Opciones clave: -h, --human-readable (muestra el tamaño en unidades legibles).
Propósito: Muestra el espacio disponible en dispositivos de almacenamiento (display free).Sintaxis: df [opciones]... [fichero]...Opciones clave: -h, --human-readable (muestra el tamaño en unidades legibles).
Propósito: Crea un enlace simbólico o duro a un fichero.Sintaxis: ln [opciones]... fichero_o_directorio enlaceDiferencia: Un enlace duro es otro nombre para el mismo inodo; no puede apuntar a directorios y solo funciona dentro del mismo sistema de archivos. Un enlace simbólico (-s, --symbolic) es un fichero especial que apunta a la ruta de otro fichero, similar a un acceso directo en Windows; puede apuntar a directorios y a través de sistemas dearchivos.Ejemplo: ln -s /bin ~/Escritorio/enlace_a_bin
Propósito: Muestra la ruta de los ficheros fuentes, los ejecutables y las páginas del manual de un comando.Sintaxis: whereis fichero...
Propósito: Busca ficheros rápidamente por el nombre en una base de datos del sistema.Sintaxis: locate [opciones]... [patrón]...Nota: La base de datos debe ser actualizada periódicamente con el comando updatedb.
Propósito: Busca ficheros que coincidan con un patrón en un árbol de directorios. Es más lento pero mucho más potente que locate.Sintaxis: find [opciones]... [directorios] [criterios] [acción]Criterios de búsqueda: -type [b,c,d,p,f,l,s] (tipo de fichero), -name "patrón" (nombre).Acciones: -delete (borra los ficheros encontrados), -exec comando \; (ejecuta un comando sobre cada fichero encontrado).
;: Separa comandos que se ejecutan secuencialmente, sin importar el resultado del anterior.&&: Ejecuta el segundo comando solo si el primero tuvo éxito (código de salida 0).||: Ejecuta el segundo comando solo si el primero falló.
&> Redirecciona tanto la salida estándar como la de errores a un fichero.\| (Tubería/Pipe)Envía la salida de un comando a la entrada del siguiente.
El dispositivo especial /dev/null es un "agujero negro" al que se puede redirigir cualquier salida que no se desee conservar.
Comandos para visualizar y procesar ficheros
grep es una de las herramientas más potentes de la línea de comandos. Su dominio, combinado con el uso de expresiones regulares y tuberías, permite filtrar y analizar gigabytesde datos en segundos, una habilidad indispensable para la depuración de logs y la automatización de scripts. Las expresiones regulares son patrones que describen un conjuntode cadenas de caracteres. Son extremadamente potentes para la búsqueda y manipulación de texto.
CaracteresSignificado^ Inicio de línea.$ Final de línea.* Indica que lo anterior se puede repetir cero o más veces.+ Indica que lo anterior se puede repetir una o más veces.? Indica que lo anterior es opcional, es decir, ninguna o una aparición.. Cualquier carácter.{n} Indica que lo anterior se debe repetir exactamente n veces.{n,} Indica que lo anterior se puede repetir desde n veces o hasta n veces, respectivamente.{n,m} Indica que lo anterior se puede repetir desde n hasta m veces.[a-z] Cualquiera de los caracteres del contenido. Se pueden utilizar rangos.[^abc] Negación del contenido.

### 2.5 FICHEROS ESPECIALES
Como parte de la filosofía "todo es un archivo", los dispositivos de hardware se representan mediante ficheros especiales en el directorio /dev.
Una vez comprendida la gestión de archivos y directorios, es esencial saber cómo controlar quién puede acceder a ellos. Esto nos lleva a la administración de usuarios y grupos.

### 3.0 GESTIÓN DE USUARIOS Y GRUPOS
Linux es un sistema operativo inherentemente multiusuario, diseñado para que varias personas puedan trabajar en el mismo sistema simultáneamente. La gestión de usuarios ygrupos es, por tanto, una tarea administrativa crucial para garantizar la seguridad, organizar el acceso a los recursos y asignar responsabilidades dentro del sistema.

### 3.1 TIPOS DE USUARIOS Y CONCEPTOS FUNDAMENTALES
En Linux, los usuarios se pueden clasificar en tres tipos principales:
**El sistema identifica a cada usuario y grupo mediante un número único:** 

### 3.2 GESTIÓN DE USUARIOS EN ENTORNO GRÁFICO
Desde la interfaz gráfica, se pueden realizar tareas básicas de gestión de usuarios:

### 3.3 COMANDOS PARA LA GESTIÓN DE USUARIOS Y GRUPOS
La terminal ofrece un conjunto de comandos para una administración más potente y flexible.
- addgroup: Añade un nuevo grupo al sistema.
cat: Concatena y muestra ficheros.head: Muestra las primeras líneas de un fichero (-n NUM para especificar el número).tail: Muestra las últimas líneas de un fichero (-n NUM para el número, -f para seguir mostrando mientras crece).wc: Cuenta líneas, palabras y bytes de un fichero (-l para líneas, -w para palabras, -c para bytes).more: Muestra el contenido de un fichero página por página.less: Similar a more, pero más completo y con más funciones.cut: Elimina secciones de cada línea de un fichero (-d delimitador, -f campos).sort: Ordena las líneas de un fichero (-r para orden inverso).grep: Busca patrones en un fichero utilizando expresiones regulares.
Ficheros de tipo bloque (**b**): Representan dispositivos que mandan bloques de información, como discos duros (ej. /dev/sda).Ficheros de tipo carácter (**c**): Representan dispositivos que mandan información carácter a carácter, como una terminal (ej. /dev/tty) o el dispositivo nulo(/dev/null).
Usuario root: También conocido como superusuario o administrador. Tiene acceso ilimitado a todos los ficheros y comandos del sistema. Su poder es absoluto, por lo que suuso debe ser cuidadoso y reservado para tareas administrativas.Usuarios del sistema o especiales: Son cuentas que no están destinadas a ser utilizadas por personas. Se crean para que los procesos y servicios del sistema se ejecutencon sus propios privilegios, limitando el daño potencial en caso de una vulnerabilidad.Usuarios estándar o normales: Son las cuentas creadas para las personas que trabajan en el sistema. Tienen privilegios limitados a su propio directorio personal y a losrecursos que se les hayan concedido explícitamente.
UID (User ID): Identificador numérico único para cada usuario. El root siempre tiene UID 0.GID (Group ID): Identificador numérico único para cada grupo.
A través de Configuración → Usuarios, se pueden añadir, modificar o eliminar cuentas. Para realizar cambios, es necesario desbloquear el panel con la contraseña de unusuario administrador. Al añadir un usuario, se puede elegir entre un tipo "Estándar" o "Administrador".Para una gestión más completa, se puede instalar el paquete gnome-system-tools (sudo apt install gnome-system-tools). Esto añade la aplicación Usuarios y grupos,que ofrece un control más detallado sobre las propiedades de los usuarios (información de contacto, privilegios de usuario, configuración avanzada del shell) y la gestión degrupos.
adduser: Añade un nuevo usuario al sistema de forma interactiva, creando su directorio personal y pidiendo información adicional.
- chsh: Cambia el shell de inicio de sesión de un usuario.

### 3.4 SEGURIDAD: CONTRASEÑAS Y FICHEROS DE CONFIGURACIÓN
La autenticación en Linux se gestiona a través de PAM (Pluggable Authentication Modules), un sistema flexible que permite establecer políticas de seguridad, como los requisitosde complejidad de las contraseñas.
La política de contraseñas se puede configurar en el fichero /etc/pam.d/common-password. Utilizando el módulo pam_pwquality, se pueden definir restricciones como:
**La información sobre usuarios y grupos se almacena en varios ficheros de configuración clave:** 

### 3.5 CAMBIO DE USUARIO Y ELEVACIÓN DE PRIVILEGIOS
Para realizar tareas administrativas, a menudo es necesario actuar como otro usuario o como root.
deluser: Elimina un usuario. Con la opción --remove-home, elimina también su directorio personal.delgroup: Elimina un grupo.usermod: Modifica una cuenta de usuario existente (ej. cambiar el nombre de usuario, el directorio personal, añadirlo a grupos, bloquear la cuenta).groupmod: Modifica un grupo existente (ej. cambiar su nombre o GID).
id: Muestra el UID, GID y los grupos a los que pertenece un usuario.groups: Muestra los grupos a los que pertenece un usuario.chown: Cambia el propietario (usuario) y/o grupo de un fichero o directorio.chgrp: Cambia el grupo de un fichero o directorio.
difok: Número de caracteres que deben ser diferentes a la contraseña anterior.minlen: Longitud mínima de la contraseña.ucredit: Número mínimo de caracteres en mayúscula.lcredit: Número mínimo de caracteres en minúscula.dcredit: Número mínimo de dígitos.
/etc/passwd: Contiene la información básica de los usuarios (nombre, UID, GID, directorio personal, shell). Es legible por todos los usuarios./etc/shadow: Contiene la contraseña cifrada del usuario y las políticas de expiración. Solo es legible por el root./etc/group: Define los grupos y qué usuarios pertenecen a cada uno./etc/gshadow: Almacena las contraseñas de los grupos (si las tienen)./etc/deluser.conf: Fichero de configuración para el comando deluser./etc/adduser.conf: Fichero de configuración para el comando adduser./etc/shells: Lista los shells de inicio de sesión válidos en el sistema./etc/skel: Directorio "esqueleto". Su contenido se copia al directorio personal de cada nuevo usuario que se crea en el sistema.
su (substitute user): Permite cambiar de usuario. Si se ejecuta sin argumentos (su), intenta iniciar sesión como root.
