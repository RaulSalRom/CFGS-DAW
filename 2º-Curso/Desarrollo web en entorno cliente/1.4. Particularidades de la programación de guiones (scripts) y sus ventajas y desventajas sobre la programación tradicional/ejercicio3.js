/*Gracias al comportamiento de desbordamiento, pasar el día 0 al constructor permite obtener 
el último día del mes inmediatamente anterior. 
Crea una función obtenerUltimoDiaMes(año, mes) donde: 
mes se pase en formato humano (1 para enero, 2 para febrero, etc.). 
La función retorne el número entero de días que tiene dicho mes (p. ej., 31, 30, 28 o 
29). */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function obtenerUltimoDiaMes(año, mes) {
    const fecha = new Date(año, mes, 0);
    return fecha.getDate();
}

rl.question('Introduce el año: ', (respuestaAño) => {
    const año = parseInt(respuestaAño, 10);

    rl.question('Introduce el mes (1-12): ', (respuestaMes) => {
        const mes = parseInt(respuestaMes, 10);

        const ultimoDia = obtenerUltimoDiaMes(año, mes);

        console.log(`El último día del mes ${mes} del año ${año} es: ${ultimoDia}`);
        rl.close();
    });
});
