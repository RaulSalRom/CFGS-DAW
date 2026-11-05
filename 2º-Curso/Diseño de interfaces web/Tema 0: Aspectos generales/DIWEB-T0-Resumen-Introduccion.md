# DIWEB · Tema 0 — Conceptos Arquitectónicos del Computador y Sistemas Operativos

> 🏠 [[📚 Indice General]] ▸ [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web]] │ 📄 Fuente: `resumen_introduccion.pdf` │ ➡️ [[DIWEB-T0-Digital-Blueprint]]

## Índice
- [1. Estructura y funcionamiento del computador](#1-estructura-y-funcionamiento-del-computador)
  - [1.1. Componentes básicos (Arquitectura Von Neumann)](#11-componentes-básicos-arquitectura-von-neumann)
  - [1.2. Modos de ejecución y secuencia del procesador](#12-modos-de-ejecución-y-secuencia-del-procesador)
  - [1.3. Registros de control y estado](#13-registros-de-control-y-estado)
- [2. Interrupciones](#2-interrupciones)
- [3. El Reloj (CLK y RTC)](#3-el-reloj-clk-y-rtc)
- [4. Jerarquía de Memoria](#4-jerarquía-de-memoria)
  - [4.1. Memoria caché y memoria virtual (MMU y TLB)](#41-memoria-caché-y-memoria-virtual-mmu-y-tlb)
- [5. Gestión del Sistema Operativo](#5-gestión-del-sistema-operativo)
  - [5.1. Gestión de procesos](#51-gestión-de-procesos)
  - [5.2. Gestión de memoria](#52-gestión-de-memoria)
  - [5.3. Comunicación y sincronización entre procesos](#53-comunicación-y-sincronización-entre-procesos)

---

## 1. Estructura y funcionamiento del computador

El computador es una máquina destinada a procesar datos. Este procesamiento involucra **dos flujos de información**:
1. **Flujo de datos:** los datos que han de ser procesados.
2. **Flujo de instrucciones:** instrucciones máquina generadas por la ejecución de un programa, que producen el flujo de datos resultado.

> [!info] Programa máquina (o código)
> Conjunto de instrucciones máquina que tiene por objeto que el computador realice una determinada función. Los programas escritos en cualquier lenguaje de programación han de convertirse en programas máquina para poder ser ejecutados por el computador.

### 1.1. Componentes básicos (Arquitectura Von Neumann)

Un computador con arquitectura **Von Neumann** está compuesto por cuatro elementos básicos:

| Componente | Descripción y funciones |
|---|---|
| **Memoria principal (RAM / ROM)** | Conjunto de celdas idénticas donde residen los datos a procesar, el programa máquina a ejecutar y los resultados. Se direcciona a nivel de byte, aunque el acceso suele realizarse por **palabra** (4 u 8 bytes). |
| **Unidad Aritmético-Lógica (ALU)** | Realiza operaciones aritméticas y lógicas sobre uno o dos operandos (almacenados en el **banco de registros** o en memoria principal). Genera además bits en el **registro de estado**: **Cero** (`Z`), **Signo** (`N`), **Acarreo** (`C`) y **Desbordamiento** (`V`), esenciales para los saltos condicionales. |
| **Unidad de Control (UC)** | Gobierna el funcionamiento cíclico del conjunto: 1) Lee de memoria la siguiente instrucción máquina; 2) Interpreta la instrucción; 3) Lee los datos referenciados; 4) Ejecuta la instrucción; 5) Almacena el resultado. |
| **Unidad de Entrada/Salida (E/S)** | Transfiere información entre la memoria principal (o registros) y los periféricos, ya sea mediante **E/S programada** (bajo gobierno de la UC) o mediante **acceso directo a memoria (DMA)**. |

> Se denomina **procesador o Unidad Central de Proceso (UCP / CPU)** al conjunto de la **ALU** y la **Unidad de Control** (más la unidad de gestión de memoria **MMU**). Hoy en día un único circuito integrado puede incluir varios núcleos (*cores*).

### 1.2. Modos de ejecución y secuencia del procesador

Para proteger al sistema, el procesador cuenta con dos modos de ejecución:
- **Modo usuario:** no permite operaciones de E/S directas, ni modificar gran parte del registro de estado ni los registros de soporte de memoria. Usa el puntero de pila de usuario (`SP`).
- **Modo privilegiado o núcleo (Kernel):** tiene acceso completo al mapa de memoria, mapa de E/S y juego completo de instrucciones. Usa el puntero de pila del sistema (`SP'`).

**Secuencia de ejecución del procesador (bucle continuo):**
1. **a) Lectura** de la instrucción apuntada por el contador de programa (`PC`).
2. **b) Incremento del `PC`** para apuntar a la siguiente instrucción máquina.
3. **c) Interpretación y ejecución** de la instrucción.

Para romper esta secuencia lineal existen tres mecanismos básicos:
1. **Instrucciones máquina de salto o bifurcación** (dentro del mismo programa).
2. **Interrupciones externas o internas** (modifican el `PC` para saltar al Sistema Operativo).
3. **Llamadas al sistema** (`TRAP`, `INT` o `SC`), que producen un efecto similar a una interrupción síncrona para solicitar un servicio al SO.

### 1.3. Registros de control y estado

- **Contador de programa (`PC`, *Program Counter*):** dirección de la siguiente instrucción máquina.
- **Puntero de pila (`SP`, *Stack Pointer*):** dirección de la cima de la pila (`SP` usuario y `SP'` sistema).
- **Registro de instrucción (`RI`):** contiene la instrucción en curso de ejecución.
- **Registro de estado (`RE`):** contiene los bits de estado aritméticos (`Z`, `N`, `C`, `V`), bits de modo de ejecución (usuario/núcleo) y bits de control/máscara de interrupciones.
- **Registros de gestión de memoria:** registros de protección o espacio de direccionamiento.

> **Estado del procesador:** contenido de todos los registros del procesador en un instante determinado. El subconjunto visible en modo usuario se denomina **estado visible del procesador**.

---

## 2. Interrupciones

Una interrupción se solicita activando una señal hacia la unidad de control. Al terminar la instrucción en curso, la UC realiza el **ciclo de aceptación de interrupción**:
1. **Salva registros clave** (`RE` y `PC`) en la pila del sistema (`SP'`).
2. **Eleva el modo de ejecución** del procesador pasándolo a **modo núcleo**.
3. **Carga un nuevo valor en el `PC`** usando el **vector de interrupción** como índice en la **Tabla de Descriptores de Interrupción (IDT)** para saltar a la rutina de tratamiento del SO.
4. **Inhibe interrupciones** según la prioridad/máscara (`BGII`, registro de nivel y registro de máscara).

La instrucción máquina `RETI` realiza el proceso inverso al finalizar la rutina: restaura `RE` y `PC` desde la pila del sistema y devuelve el procesador al modo que tenía (p. ej. modo usuario).

### Clasificación de las interrupciones

| Tipo | Naturaleza | Causas y ejemplos |
|---|---|---|
| **Excepciones hardware síncronas** (o excepciones software) | **Síncronas** (consecuencia directa de la instrucción en ejecución) | - **Problemas de ejecución:** división por cero, operación inválida, desbordamiento, violación de límites de memoria, instrucción privilegiada en modo usuario.<br>- **Depuración:** punto de ruptura (*breakpoint*).<br>- **Fallo de página** (memoria virtual). |
| **Excepciones hardware asíncronas** | **Asíncronas** (error físico en el hardware) | Error de paridad en bus o memoria, fallo de alimentación, límite de temperatura excedido. |
| **Interrupciones externas** | **Asíncronas** (elementos externos al procesador) | Reloj (temporizador), controladores de dispositivos de E/S, otros procesadores. |
| **Llamadas al sistema** (`TRAP`, `INT`, `SYSENTER`, `SC`) | **Síncronas** (solicitadas por el programa) | El programa de usuario pide explícitamente un servicio al Sistema Operativo. |

---

## 3. El Reloj (CLK y RTC)

El término **reloj** tiene tres acepciones en el computador:
1. **Señal de reloj (`CLK`):** onda cuadrada generada por un oscilador que gobierna el ritmo de ejecución de las instrucciones máquina (p. ej., 5 GHz).
2. **Temporizador / Generador de interrupciones periódicas:** mediante un divisor de frecuencia genera **interrupciones de reloj o *tics*** (cada 1 a 100 ms) para que el SO tome el control periódicamente y ningún programa monopolice la CPU.
3. **Reloj de tiempo real (`RTC`, *Real Time Clock*):** circuito contador alimentado por batería que mantiene la fecha y hora reales.
   - En **UNIX** se cuenta en segundos desde la época **00:00:00 del 1 de enero de 1970** (un entero de 32 bits con signo desborda el 19 de enero de 2038 a las 03:14:07, problema Y2K38).
   - Para medidas de alta resolución, los procesadores incluyen el registro **`TSC`** (*Time-Stamp Counter*) de 64 bits que cuenta ciclos de reloj.

---

## 4. Jerarquía de Memoria

Dado que la memoria más rápida es más cara y de menor capacidad, se organiza en forma piramidal:

| Nivel | Tipo de memoria | Capacidad típica | Tiempo de acceso | Tipo de acceso | Gestión |
|---|---|---|---|---|---|
| **Nivel 0** | Registros de la CPU | 64 a 1024 bytes | 0,25 a 0,5 ns | Palabra | Lenguaje / Compilador |
| **Nivel 1** | Memoria Caché (L1/L2/L3) | 8 KiB a 8 MiB | 0,5 a 20 ns | Palabra (Líneas de 32-128 B) | Hardware |
| **Nivel 2** | Memoria Principal (RAM) | 128 MiB a 64 GiB | 60 a 200 ns | Palabra | Sistema Operativo + MMU |
| **Nivel 3** | Disco SSD / Magnético | 128 GiB a 4 TiB | 50 µs (SSD) / 5-30 ms (HDD) | Sector / Bloque | Sistema Operativo |

### 4.1. Memoria caché y memoria virtual (MMU y TLB)

- **Memoria caché:** memoria oculta de alta velocidad interpuesta entre el procesador y la RAM que almacena **líneas** (32 a 128 bytes) recientemente utilizadas por localidad espacial y temporal. Su gestión es 100% por hardware.
- **Memoria virtual:** mecanismo gestionado por el Sistema Operativo y la **MMU** (*Memory Management Unit*) que soporta el mapa de memoria de los procesos usando **RAM + zona de intercambio (*swap*) en disco**.
  - El espacio virtual se divide en **páginas virtuales**, la RAM en **marcos de página (*frames*)** y el swap en **páginas de intercambio**.
  - La **tabla de páginas** traduce cada página virtual a su marco físico. Si la página solicitada no está en RAM, la MMU dispara una excepción de **fallo de página (*page fault*)** para que el SO la cargue desde el disco.
  - Para acelerar la traducción sin consultar la RAM en cada acceso, la MMU incluye una caché asociativa ultrarrápida llamada **TLB** (*Translation Look-aside Buffer*).

---

## 5. Gestión del Sistema Operativo

### 5.1. Gestión de procesos
- **Programa vs. Proceso:** un **programa** es un fichero ejecutable estático en disco; un **proceso** es un programa en ejecución (entidad activa con su **imagen de memoria** —código, datos, pila— y su estado en el **Bloque de Control de Proceso, BCP / PCB**).
- **Servicios básicos de procesos:**
  1. **Crear un proceso:** por clonación de la imagen del padre (`fork` en UNIX) o a partir de un fichero ejecutable (`CreateProcess` en Windows).
  2. **Ejecutar un proceso:** en modo *batch* (lotes), interactivo o en segundo plano (*background*).
  3. **Terminar un proceso:** fin normal, error de ejecución (división por cero, acceso inválido) o señal externa (`kill`).
  4. **Cambiar el ejecutable:** sustituir la imagen manteniendo el mismo proceso (`exec` en UNIX).

### 5.2. Gestión de memoria
El gestor de memoria del SO se encarga de:
- Asignar y liberar memoria a los procesos (**solicitar memoria** y **liberar memoria**).
- Proteger el acceso para que un proceso no interfiera en la memoria de otro.
- Permitir regiones de **memoria compartida** entre procesos.
- Gestionar la jerarquía de memoria virtual y resolver los fallos de página.

### 5.3. Comunicación y sincronización entre procesos (IPC)
Los procesos son aislados por defecto, pero cooperan mediante mecanismos de comunicación locales o en red (**tuberías / *pipes***, **memoria compartida**, **sockets**).
- **Operaciones básicas:** *Crear* (`pipe` / `CreatePipe`), *Enviar/Escribir* (`write` / `WriteFile`), *Recibir/Leer* (`read` / `ReadFile`) y *Destruir* (`close` / `CloseHandle`).
- **Comunicación síncrona vs. asíncrona:** en la síncrona emisor y receptor deben coincidir en el tiempo (uno espera al otro); en la asíncrona no se bloquea al emisor.

---

## 🔗 Relacionado
- [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web (Índice)]]
- [[DIWEB-T0-Digital-Blueprint|Tema 0 · The Digital Blueprint (Infografías de Arquitectura y Procesos)]]
- [[DIWEB-T1-Planificacion-Interfaces|Tema 1 · Planificación de Interfaces Gráficas]]
- [[SI-Tema2|Estructura del Sistema y Procesos (1º Sistemas Informáticos)]]

🏷️ #diweb #tema0 #arquitectura #hardware #memoria #procesos #2daw
