# Chuletilla con comandos basicos para linux.
- **Aviso:** Esta chuletilla es muy basica, pero con el tiempo iré subiendo los comandos que más utilice.
- **Disclaimer:** Actualmente uso la distribución de Fedora, pero en el futuro me gustaria ir moviendome. Cuando cambie de distro señalaré cuales son los comandos especificos de la distro

-----
-pwd: muestra la ruta completa desde el directorio raíz hasta el directorio de trabajo actual.

-ls: lista los archivos en el directorio actual. Con ls -a se muestran los archivos ocultos.

-cd: permite cambiar de directorio. cd .. retrocede al directorio anterior.

-mkdir y rmdir: crean y eliminan directorios. rmdir solo funciona con directorios vacíos.

-rm: elimina archivos y carpetas. Con rm -r se eliminan directorios y su contenido.

-touch: crea archivos vacíos. Ejemplo: touch nuevo.txt.

-cp: copia archivos. Acepta dos argumentos: origen y destino.

-mv: mueve o renombra archivos.

-locate: busca archivos en el sistema, ignorando mayúsculas y minúsculas con -i.

-echo: añade texto en un archivo. Ejemplo: echo Hola >> nuevo.txt.

-cat: muestra el contenido de un archivo.

-nano, vi, jed: editores de texto en terminal. nano es fácil de usar, vi más simple, y jed recomendado para HTML.

-df: muestra el espacio en disco. Con df -m en megabytes.

-du: muestra el tamaño ocupado por archivos o directorios.

-zip y unzip: comprimen y descomprimen archivos ZIP.

-uname: muestra información del sistema. Con uname -a se obtiene información completa.

-chmod: cambia permisos y hace ejecutables los archivos. Ejemplo: chmod +x script.py.

-hostname: muestra el nombre de host y dirección IP. Con hostname -I se muestra la IP.

-ping: comprueba la conexión con un servidor. Ejemplo: ping google.com