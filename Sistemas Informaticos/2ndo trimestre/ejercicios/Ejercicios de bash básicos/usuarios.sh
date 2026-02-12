#!/bin/bash

admin="usuario_admin"

read -p "Ingresa tu usuario: " usuario

if [[ "$usuario" == "$admin" ]]
then
    echo "¡Eres el usuario administrador!" 
elif [[ "$usuario" != "$admin" ]] && [[ $EUID != 0 ]]
then 
    echo "No eres admin ni root, ¡ten cuidado!" 
else
    echo "Eres el usuario admin o root." 
fi
