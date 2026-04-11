#!/bin/bash

ls /noexiste

if [[ $? -gt 0 ]]; then
    echo "Hubo errores" 
else
    echo "Comando OK" 
fi