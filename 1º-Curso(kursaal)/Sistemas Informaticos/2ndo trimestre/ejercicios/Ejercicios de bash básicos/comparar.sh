#!/bin/bash
read -p "Introduce tu primer número" numero1
read -p "Introduce tu segundo numero" numero2
if [[ $numero1 -lt $numero2 ]]
then 
echo "El numero $numero2 es mayor que $numero1"
elif [[ $numero1 -gt $numero2 ]]
then 
echo "El número $numero2 es menor que $numero1"
elif [[ $numero1 -eq $numero2 ]]
then
echo "Son iguales"
fi
