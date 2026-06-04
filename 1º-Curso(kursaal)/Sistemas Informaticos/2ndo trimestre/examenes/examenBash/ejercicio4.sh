#!/bin/bash

read -p "¿Cuál es tu nombre? " nombre

if [ -z "$nombre" ]; then
    echo "¡Por favor, ingresa tu nombre!"
else
    echo "Hola $nombre"
fi