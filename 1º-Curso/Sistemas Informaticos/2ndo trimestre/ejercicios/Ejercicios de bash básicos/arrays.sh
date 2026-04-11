#!/bin/bash
mi_array=("1" "dos" "3" "cuatro")
echo ${mi_array[@]:1:3}
echo ${mi_array[@]:2}
