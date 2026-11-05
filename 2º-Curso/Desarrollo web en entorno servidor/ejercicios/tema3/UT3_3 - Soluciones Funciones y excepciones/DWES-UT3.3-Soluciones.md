# UT3.3 - Funciones y excepciones

Soluciones de los ejercicios de la relación **UT3_3** de *Desarrollo Web en Entorno Servidor*.

## Cómo abrir el proyecto

Desde esta carpeta, con PHP instalado:

```bash
php -S localhost:8000
```

Después se abre <http://localhost:8000/index.php>. También se puede copiar la carpeta
dentro de `htdocs` de XAMPP y entrar por el navegador.

La página `index.php` reúne todos los ejercicios en pestañas (Bootstrap 5). Cada pestaña
carga su ejercicio en un `iframe`, igual que en la relación UT3_2.

> [!note]
> El HTML, el CSS y las pestañas se mantienen porque los pide el enunciado. En cambio, el
> código PHP utiliza únicamente recursos explicados en la teoría de
> `DesarrolloWebEnEntornoServidor.md`: variables, operadores, estructuras de control,
> arrays, funciones propias, `include`/`require`, excepciones (`try`/`catch`) y funciones
> nativas de los anexos (`rand`, `round`, `is_numeric`, `htmlspecialchars`, `strval`,
> `str_replace`, `filter_input`).

## Estructura

```text
UT3_3 - Soluciones Funciones y excepciones/
├── index.php                 # Pestañas con todos los ejercicios
├── functions.php             # Todas las funciones comentadas
├── ejercicio1.php            # Suma, división aleatoria y volumen del cilindro
├── ejercicio2.php            # inicializar_array() + imprimir_array()
├── ejercicio3.php            # calcular_media()
├── ejercicio4.php            # calcular_maximo()
├── ejercicio5.php            # calcular_minimo()
├── ejercicio6.php            # imprimir_array() en tabla
├── ejercicio7.php            # Uso de functions.php + ejercicio de UT3_2
├── ejercicio9.php            # sumar(), dividir() y calcularAreaTriangulo()
├── Ejercicio8_Tema3_3/
│   ├── public_html/
│   │   ├── index.php         # Página que cambia de tema
│   │   ├── css/
│   │   │   ├── temaClaro.css
│   │   │   └── temaOscuro.css
│   │   └── img/
│   └── resources/
│       ├── library/
│       │   └── temas.php     # Validación del tema recibido por URL
│       └── templates/
│           ├── cabeceraTemaClaro.php
│           ├── cabeceraTemaOscuro.php
│           └── footer.php
└── DWES-UT3.3-Soluciones.md
```

## Qué hace cada ejercicio

- **Ejercicio 1**
  - `sumar_cinco_numeros()` recibe cinco enteros y muestra la suma (no devuelve nada).
  - `dividir_dos_de_cinco()` recibe cinco enteros aleatorios entre 0 y 9 y divide el
    primero entre el segundo. Si el divisor es 0 lanza una `Exception`, que se
    captura con `try/catch` y se guarda el resultado en `$tmp`.
  - `volumen_cilindro()` aplica `3.1416 * radio² * altura`.
- **Ejercicios 2 a 6**: `inicializar_array()`, `calcular_media()`,
  `calcular_maximo()`, `calcular_minimo()` e `imprimir_array()`. Esta última pinta una
  tabla HTML con la posición y el valor de cada elemento.
- **Ejercicio 7**: `functions.php` contiene todas las funciones anteriores.
  `ejercicio7.php` lo incluye y resuelve otra vez el ejercicio de UT3_2:
  10 valores aleatorios entre 1 y 30, media y los tres valores mayores y menores.
  Para los extremos se añadieron `obtener_n_mayores()` y `obtener_n_menores()`, que
  trabajan sobre una copia del array para no modificarlo.
- **Ejercicio 8**: tema claro por defecto. Los enlaces
  `index.php?estilo=temaClaro` e `index.php?estilo=temaOscuro` incluyen la cabecera
  correspondiente desde `resources/templates`. El footer es común. El tema recibido se
  valida con una función propia; si no es válido se usa el tema claro. Los archivos se
  incluyen con `require_once`/`require` y rutas relativas, como explica el tema.
- **Ejercicio 9**: `sumar()`, `dividir()` y `calcularAreaTriangulo()` validan sus
  parámetros con `is_numeric()` y lanzan una `Exception` con el mensaje correspondiente.
  Cada llamada va dentro de un `try/catch`, y se muestran tanto los casos correctos como
  los incorrectos.

## Comprobaciones realizadas

- Todos los archivos PHP pasan `php -l` sin errores de sintaxis.
- Las 11 páginas se sirven con `php -S` con HTTP 200 y sin warnings, notices ni
  deprecations de PHP.
- Las 11 páginas generadas se han comprobado con el validador HTML del W3C
  (<https://validator.w3.org/nu/>) y no devuelven ningún error ni warning.
- Los dos temas del ejercicio 8 y sus hojas de estilos se cargan correctamente; un
  `?estilo=` inválido vuelve al tema claro.

## Nota sobre la entrega

El enunciado pide además una memoria en Word/PDF con capturas de la validación. Esta nota
recoge la explicación y las comprobaciones; si hace falta, se puede pasar a PDF y añadir
las capturas del validador.
