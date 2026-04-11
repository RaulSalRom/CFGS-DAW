#!/bin/bash
read -p "¿Cuantos años tienes?" edad
if [[  $edad -le 0 ]]
then
echo "Edad no valida"
elif [[ $edad -lt 18 ]]
then
echo "Eres menor de edad"
elif [[ $edad -lt 65 ]]
then
echo "Eres un adulto"
else
echo "mayor de 65"
fi
