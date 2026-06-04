#imprimimos
echo "hola mundo"
#variables
a="okeeey lets go"
#imprimimos variables
echo "$a" 
#leemos y asiganmos variables
read -p"¿Nombre?" nombre
#utilizamos esa variable que hemos leido del usuario
echo "hola $nombre, ¿Cómo estas?"
array=("valor 1" "2" "tres")
echo ${array[1]}
echo ${array[@]}
echo ${array[-1]}
[[ -b ${libreta.txt} ]]
