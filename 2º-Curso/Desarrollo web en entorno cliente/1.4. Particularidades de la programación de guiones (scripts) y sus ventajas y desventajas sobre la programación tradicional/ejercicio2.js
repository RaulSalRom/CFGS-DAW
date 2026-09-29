/*Implementa una función llamada calcularDiasDiferencia(fechaInicio, fechaFin) que reciba 
dos cadenas de texto en formato YYYY-MM-DD y devuelva el número entero de días 
transcurridos entre ambas fechas.
Utiliza el cálculo de diferencias en milisegundos mediante .getTime(). 
Redondea con Math.round() o trunca con Math.floor() para evitar inconsistencias con 
cambios horarios (horario de verano/invierno)*/

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Introduce la fecha de inicio (YYYY-MM-DD): ', (respuestaInicio) => {
    const fechaInicio = respuestaInicio.trim();

    rl.question('Introduce la fecha de fin (YYYY-MM-DD): ', (respuestaFin) => {
        const fechaFin = respuestaFin.trim();
        rl.close();
    });
});

function calcularDiasDiferencia(fechaInicio, fechaFin) {
    
    const inicio = new Date(fechaInicio);
    const fin = new Date(fechaFin);
    
    const diferenciaMilisegundos = fin - inicio;
    
    const diferenciaDias = Math.floor(diferenciaMilisegundos / (1000 * 60 * 60 * 24));
    
    return diferenciaDias;
}