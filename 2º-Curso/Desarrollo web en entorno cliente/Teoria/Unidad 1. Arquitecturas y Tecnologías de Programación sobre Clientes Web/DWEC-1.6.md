# DWEC 1.6 — Herramientas de programación y prueba sobre clientes Web

> **Teoría completa de este criterio:** [[DesarrolloWebEnEntornoCliente#1.6. Reconocimiento y evaluación de las herramientas de programación y prueba sobre clientes Web|1.6]]
> dentro de `DesarrolloWebEnEntornoCliente.md` (el TEMA 1 entero, los seis criterios).
> Esta nota es la capa de examen: actividades resueltas, errores detectados y "para el examen".

## Índice

- [1. Teoría](#1-teoría)
  - [1.6.A Herramientas locales: de editores básicos a IDEs](#16a-herramientas-locales-de-editores-básicos-a-ides-avanzados)
  - [1.6.B Control de versiones: Git y GitHub](#16b-integración-con-sistemas-de-control-de-versiones-git-y-github)
  - [1.6.C Entornos de programación y prueba online](#16c-entornos-de-programación-y-prueba-online)
  - [1.6.D Herramientas de prueba del navegador (DevTools)](#16d-herramientas-de-prueba-y-depuración-del-navegador-devtools)
  - [1.6.E Criterios de evaluación y selección](#16e-criterios-de-evaluación-y-selección-de-herramientas)
- [2. Actividad oficial: configuración de entorno](#2-actividad-oficial-configuración-de-entorno)
- [3. Archivos de la carpeta](#3-archivos-de-la-carpeta)
- [4. Errores e inconsistencias detectadas](#4-errores-e-inconsistencias-detectadas)
- [5. Para el examen](#5-para-el-examen)
- [6. Vocabulario](#6-vocabulario)

---

## 1. Teoría

El desarrollo profesional en JavaScript exige superar el uso de editores de texto elementales y
adoptar entornos de trabajo que integren **asistentes de código, depuradores interactivos,
gestores de dependencias y sistemas de control de versiones**. El técnico debe evaluar y
seleccionar las herramientas adecuadas en función de la **envergadura del proyecto**, la
**infraestructura disponible** y el **flujo de trabajo en equipo**.

### 1.6.A Herramientas locales: de editores básicos a IDEs avanzados

Para escribir JavaScript es técnicamente suficiente un **editor de texto plano** (Notepad en
Windows, *gedit* en Linux). Sin embargo, en un entorno de desarrollo empresarial esa práctica es
**inviable** por la falta de herramientas que automaticen la verificación de la sintaxis y la
gestión de proyectos.

#### Ranking de editores top para JavaScript / TypeScript

Datos de la encuesta global **Stack Overflow Developer Survey**.

##### 1. Visual Studio Code (75,9% de uso global)

**Su rol en JS/TS:** es el **estándar absoluto** de la industria; más del 80% de los
desarrolladores *frontend* lo tienen como herramienta principal. Cuenta con **soporte nativo de
fábrica para TypeScript** (el propio editor está programado en TS) y extensiones obligatorias del
ecosistema como **ESLint**, **Prettier** y los **React/Vue Snippets**.

##### 2. Notepad++ (27,4% de uso global)

**Su rol en JS/TS:** aunque **no** es un entorno para armar una aplicación moderna compleja (como
una app de Next.js), sigue apareciendo muy alto en las métricas globales porque miles de
desarrolladores lo usan en Windows para la **edición rápida de scripts sueltos**, la manipulación
veloz de archivos `.json` gigantescos o tareas ligeras de automatización sin consumir recursos.

##### 3. Vim / Neovim (38,3% de uso combinado)

- Vim: 24,3% | Neovim: 14%

**Su rol en JS/TS:** es el entorno favorito de los **desarrolladores avanzados y administradores
de servidores**, que obtienen con Neovim el mismo autocompletado y tipado inteligente de
TypeScript que ofrece VS Code, pero **corriendo directo en la terminal** a máxima velocidad.

##### 4. Cursor (17,9% de uso global y subiendo)

**Su rol en JS/TS:** la herramienta de **Inteligencia Artificial** que más rápido ha escalado en
los rankings. Al ser un **clon exacto de VS Code**, se ha vuelto popular entre desarrolladores de
JavaScript porque permite usar la **IA nativa** para generar componentes interactivos completos o
**refactorizar** archivos TypeScript complejos con instrucciones en lenguaje natural.

##### 5. Los IDEs de JetBrains (15,1% combinados en web)

- WebStorm: 7,6%

**Su rol en JS/TS:** WebStorm es considerado el **Rolls-Royce de los IDEs** para JavaScript. Su
porcentaje global parece menor porque es una herramienta tradicionalmente **comercial de pago**,
pero en entornos profesionales y corporativos es muy cotizada: su **motor de refactorización** y
**detección de rutas rotas** en JS/TS es el más inteligente y seguro del mercado.

> [!NOTE] JetBrains y WebStorm
> JetBrains recientemente liberó una **versión totalmente gratuita de WebStorm para uso no
> comercial**, lo que está impulsar su adopción.

**Tabla resumen del ranking:**

| # | Herramienta | % global | Tipo | Rol principal en JS/TS |
|---|---|---|---|---|
| 1 | **Visual Studio Code** | 75,9% | Editor | Estándar de la industria; soporte nativo de TS |
| 3 | **Vim / Neovim** | 38,3% | Editor de terminal | Autocompletado de TS a máxima velocidad |
| 2 | **Notepad++** | 27,4% | Editor ligero | Scripts sueltos y `.json` en Windows |
| 4 | **Cursor** | 17,9% | Editor con IA | Generar y refactorizar con lenguaje natural |
| 5 | **WebStorm** (JetBrains) | 7,6% | IDE | Mejor motor de refactorización del mercado |

> [!NOTE] Los porcentajes no suman 100
> La encuesta admite **múltiples respuestas** (un mismo desarrollador usa VS Code y Vim a la vez),
> y además **no todos los consultados** trabajan con JavaScript/TypeScript. Por eso la
> tabla del PDF oficial presenta los datos como "más utilizados", no como reparto de mercado.

#### Características técnicas fundamentales para elegir un entorno profesional

| Característica | Qué aporta |
|---|---|
| **Código abierto y gratuidad** | La comunidad audita el código, reporta fallos y publica mejoras de forma continua, **solucionando incidencias con más rapidez** que en aplicaciones propietarias cerradas. |
| **Arquitectura modular** | Permite **activar, desactivar o reemplazar** componentes internos del editor según las necesidades. |
| **Gestor de paquetes integrado** | Mecanismo (CLI o interfaz visual) para **registrar, instalar, actualizar y eliminar** librerías, extensiones y temas de forma desatendida. |
| **Autocompletado predictivo** | Analiza variables, funciones y métodos del lenguaje **mientras se escribe**, minimizando fallos tipográficos. |
| **Sistema de paneles múltiples** | Organización del espacio de trabajo en **paneles divididos** para comparar y editar varios archivos (HTML, CSS y JS) simultáneamente. |
| **Soporte y canales comunitarios** | Apoyo técnico distribuido en foros y plataformas colaborativas. |

### 1.6.B Integración con sistemas de control de versiones (Git y GitHub)

El desarrollo en equipo exige registrar el historial de cambios, gestionar ramas de
características y coordinar modificaciones concurrentes:

- **Git:** sistema de **control de versiones distribuido** que rastrea cada modificación realizada
  en los archivos del proyecto a lo largo del tiempo.
- **GitHub:** plataforma **en la nube** para alojar repositorios Git, facilitando la **revisión de
  código por pares** (*pull requests*), el **seguimiento de incidencias** (*issues*) y la
  **integración continua**.
- **Integración en el IDE:** editores como VS Code **integran paneles nativos de Git** que permiten
  confirmar cambios (*commits*), alternar entre ramas y **resolver conflictos** sin salir del
  entorno de edición.

### 1.6.C Entornos de programación y prueba online

Cuando hay que probar fragmentos de código de forma inmediata sin configurar un entorno local, o
cuando se trabaja desde dispositivos con restricciones de instalación, los **IDEs en la nube**
ofrecen una alternativa funcional:

- **Coding Ground (Tutorialspoint):**
  - Plataforma accesible vía navegador web (`https://www.tutorialspoint.com/online_javascript_editor.php`).
  - Editor con **resaltado de sintaxis**, visualización previa (*Preview*) y **consola de
    ejecución simultánea**.
  - Permite **gestionar múltiples ficheros** en un mismo proyecto y **descargar** el código
    generado al equipo local o importar archivos externos.
- **Otras plataformas en la nube:** **CodeSandbox**, **StackBlitz** o **JSFiddle** permiten
  evaluar librerías y componentes sin instalación previa, y **arrancar proyectos de React, Angular
  o Vue directamente desde el navegador** en un par de segundos.

### 1.6.D Herramientas de prueba y depuración del navegador (DevTools)

El navegador integra su propio conjunto de herramientas de diagnóstico técnico, accesibles de
forma universal con la tecla **F12** o con **Ctrl + Shift + I**:

| Panel | Para qué sirve |
|---|---|
| **Consola** (*Console*) | Permite **interactuar directamente con el motor de JavaScript en tiempo real**. Muestra las salidas emitidas por `console.log()` y **resalta en color rojo las excepciones y errores no capturados** durante la ejecución. |
| **Fuentes** (*Sources* / *Debugger*) | Permite **examinar los ficheros `.js` descargados** y establecer **puntos de interrupción** (*breakpoints*) en líneas concretas. Al alcanzarlos, el navegador **congela la ejecución** del script, permitiendo **inspeccionar el valor de las variables paso a paso** y analizar la **pila de llamadas** (*Call Stack*). |
| **Red** (*Network*) | **Supervisa todas las peticiones HTTP** de la página (HTML, CSS, `.js`, imágenes o peticiones asíncronas de datos). Permite comprobar el **código de respuesta del servidor** (`200 OK`, `404 Not Found`, `500 Server Error`), el **tiempo exacto de transferencia** y el **tamaño** de los recursos descargados. |

> [!NOTE] Paneles adicionales que conviene conocer
> **Elements** (árbol del DOM y estilos calculados, útil para el criterio 1.2), **Performance**
> (mide *reflow* y *repaint*, conectando con el apartado 1.2.I) y **Application** (muestra
> `localStorage`, `sessionStorage`, cookies e `IndexedDB`, conectando con el apartado 1.2.D).

### 1.6.E Criterios de evaluación y selección de herramientas

| Parámetro de decisión | Editor ligero / online | IDE completo / avanzado |
|---|---|---|
| **Escenario de uso idóneo** | Pruebas de concepto rápidas, corrección puntual de errores, equipos con hardware limitado. | Proyectos profesionales medianos y grandes, aplicaciones basadas en *frameworks* (React, Angular). |
| **Consumo de recursos** | **Mínimo**; funciona en cualquier navegador web. | **Medio-alto**; requiere RAM y almacenamiento local para indexar el proyecto. |
| **Control de versiones** | **Limitado** a exportar o descargar archivos sueltos. | **Integración profunda** con Git, ramas, diferencias visuales y GitHub. |
| **Personalización** | **Escasa o nula**; depende de la plataforma web. | **Elevada**; personalizable mediante gestores de paquetes y extensiones de la comunidad. |

---

## 2. Actividad oficial: configuración de entorno

> **Instala un editor modular avanzado** (como Visual Studio Code o Cursor). Para que tu
> experiencia programando solo con JavaScript sea excelente, instala estas **3 extensiones
> específicas** y configura una **herramienta clave**.

### 2.1 Live Server — imprescindible para front-end

**Qué hace:** crea un **servidor web local** en el ordenador con un solo clic. Cada vez que
cambies tu código JavaScript u HTML y **guardes**, la página del navegador **se recargará
automáticamente**. Ya no tendrás que abrir el archivo desde tu carpeta ni pulsar F5
constantemente.

**Por qué es imprescindible en JavaScript puro:** los navegadores aplican la **política de mismo
origen** y, por seguridad, **bloquean la ejecución de JavaScript** cargado desde el sistema de
archivos con el protocolo `file://`. Con Live Server la página se sirve por `http://localhost`, y
los scripts externos **sí se ejecutan**. Esta es exactamente la solución al problema del
apartado 1.5.D.

### 2.2 Quokka.js — tu bloc de notas interactivo

**Qué hace:** **ejecuta tu código JavaScript en tiempo real mientras lo escribes**, directamente
dentro del propio editor. Si creas una función o una operación matemática, Quokka te muestra el
**resultado flotando justo al lado de la línea de código**, sin necesidad de abrir el navegador ni
la terminal. Es ideal para **probar lógica rápido**.

**Archivo de demostración:** [`quokka.js`](./quokka.js)

```javascript
// Quokka.js — evalúa el código mientras escribes
const precio = 15
const iva = precio * 0.21
precio + iva                    // → 18.15 (resultado flotante en la línea)
[1, 2, 3, 4].map(n => n * n)     // → [1, 4, 9, 16]
`Total: ${precio + iva} euros`   // → "Total: 18.15 euros"
Math.max(...[3, 9, 4])           // → 9
new Date().getFullYear()         // → año actual
```

Los cinco enunciados corresponden a las cinco funciones integradas más útiles para este módulo:
aritmética con `const`, métodos de array (`map` de ES5), **plantillas literales** con
backticks, **operador de propagación** (`...`) y el objeto `Date` (que es el objeto del criterio
1.4).

### 2.3 Error Lens — detección visual inmediata

**Qué hace:** normalmente, cuando te equivocas en JavaScript (falta un paréntesis, escribes mal
el nombre de una variable), el editor pone una **línea ondulada roja muy pequeña debajo** del
error. Error Lens toma ese mensaje y **lo escribe en texto completo con fondo rojo directamente al
final de la línea**, para que veas instantáneamente qué está fallando **sin tener que pasar el
cursor por encima**.

**Archivo de demostración:** [`errores.js`](./errores.js) — ver la nota de §4, el archivo está
**incompleto**.

---

## 3. Archivos de la carpeta

| Archivo | Tipo | Función |
|---|---|---|
| `1.6. ... .pdf` | PDF | Teoría del criterio (apartados A a E) y **apartado F. Actividades prácticas y ejercicios**, con la configuración de las tres extensiones. |
| `1.6. ... hecha.pdf` | PDF | Versión resuelta. **Escaneo de 2 páginas** sin capa de texto (`pdftotext` extrae 2 caracteres). |
| `quokka.js` | JavaScript | Demostración de **Quokka.js**: 5 expresiones que muestran su resultado flotante junto a la línea. |
| `errores.js` | JavaScript | Demostración de **Error Lens**. **Está incompleto** (ver §4). |

### 3.1 Qué demonstrates los dos archivos

**`quokka.js`** — se abre en VS Code/Cursor con la extensión instalada y **cada expresión muestra
su resultado a la derecha**, sin necesidad de ejecutar nada:

| Línea | Qué demuestra | Resultado esperado |
|---|---|---|
| `precio + iva` | Aritmética con `const` (ES6) | `18.15` |
| `[1, 2, 3, 4].map(n => n * n)` | Método funcional de array de **ES5** + flecha de ES6 | `[1, 4, 9, 16]` |
| `` `Total: ${precio + iva} euros` `` | **Plantillas literales** con *backticks* | `"Total: 18.15 euros"` |
| `Math.max(...[3, 9, 4])` | **Operador de propagación** (`...`) | `9` |
| `new Date().getFullYear()` | Objeto `Date` nativo (criterio 1.4) | Año actual |

**`errores.js`** — debería contener un error de sintaxis o de referencia para que **Error Lens** lo
muestre en texto completo. El archivo actual está truncado (ver §4).

---

## 4. Errores e inconsistencias detectadas

> [!WARNING] `errores.js` está incompleto y no demuestra nada
> ```javascript
> const numero = 42;
> console.log
> ```
> La última línea está **cortada**: falta el paréntesis `console.log()`. Tal como está:
> - **No hay ningún error de sintaxis**, así que **Error Lens no muestra nada**: para lo que
>   sirve la extensión habría que escribir, por ejemplo, `console.log(numero)` (sin cerrar
>   paréntesis) o referenciar una variable inexistente.
> - `console.log` **a secas es JavaScript válido**: es una referencia a la *función* `log` del
>   objeto `console`, que se evalúa y se descarta. **No imprime nada** y **no lanza ningún error**.
>
> Para que el archivo cumpla su función, lo razonable sería:
> ```javascript
> const numero = 42;
> console.log(numero;          // falta el paréntesis de cierre -> SyntaxError
> console.log(numeroInexistente // ReferenceError
> ```

> [!NOTE] Error Lens solo detecta errores **de análisis**, no de ejecución
> La extensión brilla con los errores que el editor detecta **mientras escribes** (sintaxis,
> variables no declaradas, imports rotos). Un `ReferenceError` que solo aparece **al ejecutar** (por
> ejemplo una variable declarada dentro de un bloque) no lo verá hasta que se ejecute el código.
> Conviene tenerlo claro para no esperar de Error Lens más de lo que ofrece.

> [!NOTE] Los porcentajes del ranking son de la edición anterior de la encuesta
> Las cifras del PDF (**VS Code 75,9%**, Notepad++ 27,4%, Vim/Neovim 38,3%, Cursor 17,9%,
> JetBrains 15,1%) proceden de la encuesta de Stack Overflow del año de publicación del material.
> Stack Overflow publica estos datos **anualmente**, así que si se cita el ranking en un
> ejercicio conviene **indicar la edición** concreta de la encuesta en lugar de presentarlo como
> un dato actual.

> [!NOTE] El PDF "hecha" no tiene capa de texto
> `1.6. ... hecha.pdf` es un **escaneo de 2 páginas** sin texto extraíble, así que la solución
> oficial solo se puede consultar abriéndolo visualmente. Ocurre igual con los PDFs resueltos de
> los criterios 1.3 y 1.5.

---

## 5. Para el examen

1. **¿Por qué no basta un editor de texto plano para el desarrollo profesional en JavaScript?**
   Porque en un entorno empresarial es inviable por la **falta de herramientas que automaticen la
   verificación de la sintaxis y la gestión de proyectos**: sin autocompletado, sin gestor de
   paquetes, sin integración con Git y sin paneles múltiples.

2. **Enumera las seis características técnicas que debe tener un entorno profesional.**
   1) Código abierto y gratuidad. 2) Arquitectura modular. 3) Gestor de paquetes integrado.
   4) Autocompletado predictivo. 5) Sistema de paneles múltiples. 6) Soporte y canales
   comunitarios.

3. **¿Qué aporta ser software libre frente a una aplicación propietaria cerrada?**
   Que la **comunidad audita el código, reporta fallos y publica mejoras de forma continua**,
   lo que permite **solucionar las incidencias con mayor rapidez**.

4. **¿Por qué VS Code es el estándar de la industria y qué extensión obligatorias necesita para
   JavaScript/TypeScript?**
   Porque lo usan más del 80% de los desarrolladores *frontend* y tiene **soporte nativo de
   fábrica para TypeScript** (el propio editor está escrito en TS). Sus extensiones de ecosistema
   son **ESLint**, **Prettier** y los **React/Vue Snippets**.

5. **Compara VS Code con WebStorm.**
   **VS Code:** editor, gratuito, **ligero** y con soporte nativo de TS. **WebStorm:** IDE
   **comercial** (con versión gratuita para uso no comercial), cuyo **motor de refactorización y
   detección de rutas rotas** en JS/TS es el más seguro e inteligente del mercado. El porcentaje
   global de WebStorm es menor porque es de pago, pero en el entorno corporativo es muy cotizado.

6. **¿Qué diferencia hay entre un editor y un IDE?**
   Un **editor** ligero (Notepad++, VS Code) sirve para escribir y editar archivos. Un **IDE**
   (WebStorm, los IDEs de JetBrains) **indexa el proyecto entero**, por lo que necesita más RAM y
   almacenamiento y a cambio ofrece **refactorización, navegación por símbolos y análisis estático
   de todo el código**.

7. **¿Por qué siguen siendo populares Notepad++ y Vim/Neovim si existe VS Code?**
   **Notepad++** se usa en Windows para la **edición rápida de scripts sueltos**, manipular
   archivos `.json` gigantescos y tareas ligeras sin consumir recursos. **Vim/Neovim** es el
   favorito de desarrolladores avanzados y administradores de servidores, que obtienen el mismo
   autocompletado de TypeScript **corriendo en la terminal a máxima velocidad**.

8. **¿Qué es Git y qué es GitHub?**
   **Git** es un sistema de **control de versiones distribuido** que rastrea cada modificación de
   los archivos a lo largo del tiempo. **GitHub** es una **plataforma en la nube** que aloja
   repositorios Git y facilita la **revisión por pares** (*pull requests*), el **seguimiento de
   incidencias** (*issues*) y la **integración continua**.

9. **¿Qué ventajas aporta la integración de Git en el IDE?**
   Permite **confirmar cambios** (*commits*), **alternar entre ramas** y **resolver conflictos**
   **sin salir del entorno de edición**. En un editor online, en cambio, el control de versiones
   se limita a **exportar o descargar archivos sueltos**.

10. **¿Cuándo conviene una plataforma online como CodeSandbox o StackBlitz?**
    Para **probar fragmentos de código de forma inmediata sin configurar un entorno local**, o
    para trabajar desde **dispositivos con restricciones de instalación**. Permiten arrancar
    proyectos de React, Angular o Vue **directamente desde el navegador en un par de segundos**.

11. **Enumera y explica los tres paneles de DevTools que exige el temario.**
    **Consola:** interactuar con el motor de JS en tiempo real y ver las salidas de `console.log()`,
    con las excepciones resaltadas en rojo. **Fuentes:** examinar los `.js` descargados, poner
    **puntos de interrupción**, inspeccionar variables paso a paso y analizar la **pila de
    llamadas**. **Red:** supervisar todas las peticiones HTTP, comprobando **códigos de
    respuesta** (`200`, `404`, `500`), **tiempos** y **tamaños** de los recursos.

12. **¿Cómo se abren las herramientas de desarrollo del navegador?**
    Con la tecla **F12** o con la combinación **Ctrl + Shift + I**. También con clic derecho sobre
    la página → *Inspeccionar*.

13. **Compara un editor ligero online con un IDE completo según el escenario, consumo de
    recursos, control de versiones y personalización.**
    Tabla 1.6.E. El ligero gana en escenario (pruebas rápidas, hardware limitado) y consumo
    (mínimo, cualquier navegador); el IDE completo gana en control de versiones (integración
    profunda con Git y GitHub) y personalización (gestores de paquetes y extensiones).

14. **¿Qué hace la extensión Live Server y por qué es imprescindible al trabajar JavaScript
    puro?**
    Crea un **servidor web local** con un clic y **recarga la página automáticamente** al guardar,
    evitando abrir el archivo desde la carpeta o pulsar F5. Es imprescindible porque los
    navegadores, por la **política de mismo origen**, **bloquean el JavaScript cargado con el
    protocolo `file://`**; con Live Server la página se sirve por `http://localhost` y los scripts
    externos sí se ejecutan.

15. **¿Qué hace Quokka.js y para qué tipo de trabajo está pensado?**
    **Ejecuta el JavaScript en tiempo real mientras se escribe**, mostrando el resultado **flotando
    al lado de la línea de código**, sin abrir el navegador ni la terminal. Es ideal para
    **probar lógica rápidamente** y para aprender.

16. **¿Qué hace Error Lens y cómo se diferencia del comportamiento por defecto del editor?**
    Normalmente el editor marca los errores con una **línea ondulada roja muy pequeña debajo**.
    Error Lens **escribe el mensaje completo con fondo rojo al final de la línea**, permitiendo ver
    **instantáneamente** qué falla **sin pasar el cursor por encima**.

---

## 6. Vocabulario

- **Editor de texto:** aplicación mínima para escribir código sin verificación ni gestión de
  proyectos.
- **IDE (*Integrated Development Environment*):** entorno que **indexa todo el proyecto** y ofrece
  refactorización, navegación por símbolos y análisis estático.
- **Editor modular:** editor cuyos componentes internos se pueden activar, desactivar o reemplazar.
- **Gestor de paquetes (*Package Manager*):** mecanismo para registrar, instalar, actualizar y
  eliminar librerías, extensiones y temas de forma desatendida.
- **Autocompletado predictivo:** asistente que analiza variables, funciones y métodos del lenguaje
  mientras se escribe.
- **Control de versiones:** sistema que rastrea las modificaciones de los archivos a lo largo del
  tiempo.
- **Repositorio:** almacenamiento versionado de un proyecto de código.
- **Commit:** confirmación que registra un conjunto de cambios en el historial de Git.
- **Rama (*branch*):** línea de desarrollo paralela que permite trabajar sin afectar a la principal.
- **Pull request:** mecanismo de revisión de código por pares en GitHub.
- **Punto de interrupción (*breakpoint*):** marca en una línea de código donde el depurador **congela
  la ejecución** para inspeccionar el estado.
- **Pila de llamadas (*Call Stack*):** lista de funciones que están en ejecución en un momento
  dado.
- **Política de mismo origen:** restricción de seguridad que impide ejecutar el JavaScript de un
  archivo abierto con `file://`.
- **`localhost`:** dirección que apunta al propio equipo, usada por los servidores locales como
  Live Server.

---

> **Ver también:**
> [`DWEC-1.2.md`](../1.2.%20Capacidades%20y%20mecanismos%20de%20ejecuci%C3%B3n%20de%20c%C3%B3digo%20de%20los%20navegadores%20Web/DWEC-1.2.md)
> (los paneles **Elements**, **Performance** y **Application** que se mencionan en §1.6.D), y
> [`DWEC-1.5.md`](../1.5.%20Verificaci%C3%B3n%20de%20los%20mecanismos%20de%20integraci%C3%B3n%20de%20los%20lenguajes%20de%20marcas%20con%20los%20lenguajes%20de%20programaci%C3%B3n%20de%20clientes%20Web/DWEC-1.5.md)
> (la estructura de carpetas en la que trabaja Live Server).
>
> **Nota:** la actividad de los apartados 1.2 y 1.4 se puede comprobar con estas herramientas:
> `node` para los scripts de consola, **Quokka.js** para la evaluación en caliente y **Error Lens**
> para la detección de fallos mientras se escribe.