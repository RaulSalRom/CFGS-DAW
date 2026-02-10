#!/bin/bash
read -p "Introduce tu fruta (Manzana/Banana/Limon/Naranja): " fruta
case $fruta in
    Manzana)
        echo "La ${fruta} es roja o verde."
        ;;
    Banana|Limon)
        echo "La ${fruta} es amarilla."
        ;;
    Naranja)
        echo "La ${fruta} es naranja."
        ;;
    *)
        echo "${fruta} es una fruta desconocida."
        ;;
esac

