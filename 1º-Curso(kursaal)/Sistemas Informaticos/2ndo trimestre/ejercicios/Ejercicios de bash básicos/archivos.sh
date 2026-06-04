#!/bin/bash

ruta=$1
if [[ -e "$ruta" ]]
	then
    	echo "La ruta '$ruta' existe." [cite: 244]

 if [[ -d "$ruta" ]]
	then
        echo "- Es un directorio."
    elif [[ -f "$ruta" ]]
	then
        echo "- Es un archivo regular"
    elif [[ -L "$ruta" ]]
	then
        echo "- Es un enlace simbólico." 
    fi
    if [[ -r "$ruta" ]]
	 then
        echo "- Es legible (lectura)." 
    fi

    if [[ -w "$ruta" ]]
	 then
        echo "- Es escribible (escritura)." 
    fi

    if [[ -x "$ruta" ]]
	 then
        echo "- Es ejecutable." 
    fi

else
    echo "La ruta '$ruta' NO existe."
fi
