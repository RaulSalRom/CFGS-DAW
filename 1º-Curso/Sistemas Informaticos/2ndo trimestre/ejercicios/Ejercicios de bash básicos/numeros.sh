#!/bin/bash
read -p "Escribe un número " numero
if [[ $numero -lt 0 ]]
then
echo "El numero es negativo"
elif [[ $numero -eq 0 ]]
then 
echo "El numero es neutro"
elif [[ $numero -gt 0 ]]
then
echo "El número es positivo"
fi
