# AGENTS.md — CFGS-DAW

> Instrucciones para agentes (OpenClaw, opencode…) que trabajen en este repositorio.
> Se carga como **contexto de proyecto** cuando la sesión se ejecuta con este repo como
> carpeta de trabajo. El idioma de trabajo es **español**.

## 0. A quien ayudas
Ayudas a un estudiante del CFGS-DAW, y quiere que le llames "Majestad".

### Modo Ponytail (Activo siempre por defecto)
Trabaja siempre en **modo Ponytail** (intensidad: *full*):
- **Máxima simplicidad y eficiencia:** El mejor código es el que no se escribe (YAGNI estricto).
- **Escalera de decisiones:**
  1. *¿Hace falta que exista?* Si es especulativo o no pedido, omitirlo.
  2. *¿Ya existe en este repositorio?* Reutilizarlo antes de reinventar la rueda.
  3. *¿La biblioteca estándar lo resuelve?* Usar funciones nativas (PHP estándar, JS/Web APIs nativas, HTML5/CSS semántico) antes que librerías o dependencias.
  4. *Causa raíz sobre síntoma:* Arreglar el fallo en el origen para todos los llamadores, con el menor diff posible.
  5. *Código antes que prosa:* Respuestas directas con código conciso; explicaciones breves (a menos que se pida detalle).

### Colaboración multiagente y auditoría cruzada obligatoria (Antigravity ↔ OpenCode)
- **Principio de auditoría cruzada:** Toda tarea realizada por un agente debe ser auditada por el otro antes de considerarse cerrada y commiteada:
  - **Antigravity realiza la tarea → OpenCode audita:** Antigravity ejecuta:
    `opencode run --auto "Audita los cambios en git diff respecto a calidad, corrección, estándares del repositorio y modo Ponytail"`
  - **OpenCode realiza la tarea → Antigravity audita:** OpenCode ejecuta:
    `agy -p "Audita los cambios en git diff respecto a calidad, corrección, estándares del repositorio y modo Ponytail"`
- **Resolución de hallazgos:** Si el auditor detecta fallos, sobreingeniería o desvíos de `AGENTS.md`, el agente ejecutor los corrige antes de finalizar.
- **Apoyo mutuo:** Si un agente se atasca o necesita una perspectiva alternativa, se apoya en el otro vía CLI.
- **Coordinación y estado limpio:** Ambos respetan este `AGENTS.md`, mantienen commits atómicos y verifican `git pull --ff-only` y `git status` para trabajar sincronizados sin pisar cambios.
- **`agy` en headless ya está configurado:** en `C:\Users\salro\.gemini\antigravity-cli\settings.json`
  hay reglas `command(git status)`, `command(git diff)`, `command(git log)` y `command(git show)`
  en `permissions.allow`. Con eso `agy -p "..."` audita sin pedir permisos. No hace falta
  `--dangerously-skip-permissions`. Si una auditoría falla por permisos, añadir ahí la regla
  concreta, nunca un comodín.
- **La auditoría se enseña, no se resume:** al terminar una auditoría, pega en la respuesta
  el veredicto y los hallazgos **tal como los devuelve el auditor** (en cita o bloque de
  código). No vale un "aprobado" de cosecha propia ni un resumen que oculte matices. Si hay
  hallazgos, Majestad los ve **antes** de que los corrijas, no después.

## 1. Qué es este repositorio

Vault de **Obsidian** con los apuntes y ejercicios del CFGS **Desarrollo de Aplicaciones Web**
(centro Kursaal, 2025-2027), 1º y 2º curso. Repositorio **público**:
`github.com/RaulSalRom/CFGS-DAW`.

- No es un único proyecto de software: son carpetas por asignatura.
- No dupliques aquí otras bóvedas (p. ej. las notas de sistema del portátil).
- Los **PDF y `.docx`** son material del profesorado: **no los edites ni los borres**.

## 2. Contexto del ciclo (2º curso)

| Abrev. | Asignatura | Profesor | Contenido |
|---|---|---|---|
| DWEC | Desarrollo Web Entorno Cliente | Carvajal | JavaScript, DOM, eventos, `fetch` (U1–U2) y objetos predefinidos + BOM (U3) |
| DWES | Desarrollo Web Entorno Servidor | Amado | PHP, formularios, sesiones (UT1–UT3) |
| DIWEB | Diseño de Interfaces Web | Navarro | HTML y CSS (temas 0–2) |
| Despliegue | Despliegue de Aplicaciones Web | Vizuete | servidores web, contenedores, CI/CD |
| Optativa | Gestores de Contenido | Ocaña | CMS, WordPress, CDMON |
| IPE II | Itinerario Personal para el Empleo II | Téllez | orientación laboral |
| Inglés | Inglés Profesional GS | Guillén | inglés técnico |
| Proyecto | Proyecto Intermodular DAW | Tello | integrador final |

Stack del ciclo: Java, SQL/MySQL, HTML, CSS, JavaScript, PHP, XML, Bash, Linux, Docker, Git.

## 3. Estructura

```
📚 Indice General.md          # Índice maestro (en la raíz)
1º-Curso(kursaal)/
├── Teoria/<Asignatura>/      # Notas de teoría en .md
└── <Asignatura>/             # PDFs, material y ejercicios
2º-Curso/
├── Teoria/<Asignatura>/      # Notas de teoría en .md
└── <Asignatura>/             # PDFs, material y ejercicios
```

- `📚 Indice General.md` (en la raíz del repo) es el **índice maestro** y cubre 1º y 2º.
- Los `README.md` de raíz documentan estructura, notas y horario.
- La **teoría** vive en `Teoria/<Asignatura>/` dentro de cada año. Los PDF originales,
  los enunciados y los ejercicios permanecen en las carpetas de asignatura.

### 3.1. Regla de oro: `.md` primero, PDF solo si Majestad lo pide

- **Por defecto trabaja siempre con los `.md`**: `Teoria/<Asignatura>/` y las notas por
  criterio. Son la fuente de verdad del repo.
- **No abras un PDF ni un `.docx` salvo que Majestad lo pida expresamente.** Tampoco los
  conviertas por iniciativa propia: convertir es una tarea aparte que se autoriza.
- Excepción única: no existe `.md` de ese contenido y hace falta para responder. Aun así,
  dilo antes de leerlo.
- Dato real: en `Teoria/` hay **0 PDFs** y toda la teoría está en Markdown. Los PDF que
  quedan en las carpetas de asignatura son enunciados, exámenes, rúbricas y material del
  profesorado, no teoría.

### 3.2. Convertir un PDF a `.md` (solo cuando se pida)

En este equipo no hay Python, Node ni `pdftotext` en el PATH. Procedimiento probado:

1. Usar el `pdftotext` portable ya descomprimido en
   `C:\Users\salro\AppData\Local\Temp\opencode\xpdf\xpdf-tools-win-4.06\bin64\pdftotext.exe`
   (si falta, descargar de `https://dl.xpdfreader.com/xpdf-tools-win-4.06.zip` y descomprimir
   con `tar.exe -xf`; siempre **fuera del repo**).
2. Extraer con `pdftotext.exe -enc UTF-8 -layout "<pdf>" "<salida>.txt"`. Sin `-enc UTF-8`
   las tildes y los `●` salen rotos.
3. Transcribir a `.md` **sin inventar**: los enunciados se copian tal cual y **no se
   resuelven** salvo que se pida.
4. Corregir solo erratas obvias que rompan el código y dejarlas anotadas con `> [!note]`.
5. Al terminar: verificar que los bloques de código están balanceados, que no hay `U+FFFD`
   y enlazar la nota nueva en `📚 Indice General.md`.

## 4. Cómo tienes que trabajar (bucles)

Toda tarea se resuelve en un **ciclo iterativo**, nunca de un tirón:

1. **Entender** — lee el enunciado y el material ya existente antes de tocar nada.
2. **Planificar** — decide los pasos y dilo en una línea.
3. **Implementar** — haz el cambio mínimo que toca.
4. **Verificar** — comprueba de verdad, no de palabra: HTML/CSS se abre en el navegador,
   PHP se ejecuta en el servidor, Java compila, SQL ejecuta. Aquí **no hay `node`, `npm` ni
   Python** instalados: el JS se prueba en la consola del navegador (DevTools).
5. **Auditar (cruzado)** — ejecuta la auditoría del otro agente (ver §0) sobre `git diff`,
   **muestra su salida completa** en la respuesta y resuelve sus observaciones.
6. **Cerrar** — commit sin preguntar; **`push` solo si Majestad da permiso** (ver §6).

Repite **3→4** hasta que la verificación pase. Si tras **3 vueltas** sigues atascado, **PARA**,
explica el bloqueo y pide ayuda en vez de seguir a ciegas.

**Bucle de razonamiento (ReAct):** en cada paso di *qué* vas a hacer y *por qué*, haz **una**
acción, **observa** el resultado real (salida del comando, no supuesta) y decide el siguiente
paso. Nunca encadenes varias acciones dando por hecho el resultado.

## 5. Convenciones de escritura

- Todo en **español**.
- Nombres de carpeta y nota con el **prefijo de unidad** y sin espacios finales: `1.1.`, `UT2_`, `Tema 0:`.
- Si añades una nota, **añádela también al índice maestro** `📚 Indice General.md` (raíz).
- Un commit por bloque de trabajo, nunca uno gigante.
- Renombrar con `git mv`, **nunca** `mv` (el historial depende de ello).

## 6. Git y entrega

- **Autonomía en local, permiso para publicar:** puedes crear, modificar, `git add` y
  **commitear sin preguntar**. Pero **antes de cada `git push` pide permiso explícito a
  Majestad** y espera su "sí". Sin permiso, el commit se queda en local y se avisa de que
  está pendiente de subir (`git status`, `git log origin/main..main`).
- Trabaja **directamente sobre `main`** (por ahora no se usan PRs).
- **Antes de empezar y antes de empujar:** `git pull --ff-only` para no pisar cambios.
- **Antes de cada commit:** revisa `git status` y `git diff` y comprueba que no entra nada
  prohibido (lista de abajo).
- **Nunca** versionar: `*.class`, `bin/`, `.idea/`, el estado de `.obsidian`
  (`workspace.json`, `app.json`, `graph.json`, `cache`, `plugins/*/data.json`) ni
  `2º-Curso/IPE II/Ipe II 2025.pdf`.
- Mensajes de commit en **español coloquial** (el estilo de este repo, no Conventional Commits):
  `"ejercicio 3 corregido"`, `"actividades 1.4, 1.5, 1.6 y tarea 2"`, `"tareas de paco"`.
- Si algún día se autentica `gh`, se puede volver a ramas + PR; hasta entonces, `main` directo.

### 6.1. Red de este equipo (importante)

`github.com` por HTTPS y `ssh.github.com` están **bloqueados** en esta red. El remoto y el
cliente SSH ya están configurados así:

```bash
git remote -v
# origin ssh://git@ssh.github.com:443/RaulSalRom/CFGS-DAW.git
git config core.sshCommand
# ssh -p 443 -o HostKeyAlias=ssh.github.com -o HostName=140.82.112.35 -o StrictHostKeyChecking=accept-new
```

- Si `git push` da *Connection timed out*, cambiar `HostName` por otra IP de GitHub en el 443:
  `140.82.112.35`, `140.82.112.36`, `140.82.113.35`, `140.82.114.35`, `140.82.116.35`,
  `140.82.121.35`.
- No intentes HTTPS, ni `ssh.github.com` resuelto por DNS, ni el puerto 22: no funcionan.
- El commit es local hasta que el push funcione. No lo des por entregado sin `git ls-remote origin main`.

## 7. DWEC tiene dos capas (no las rompas)

`2º-Curso/Teoria/Desarrollo web en entorno cliente/` = monolito de teoría
(`DesarrolloWebEnEntornoCliente.md`) + notas por criterio:
`DWEC-1.1`…`1.6`, `DWEC-2.1`…`2.8`, `DWEC-3.1` y `DWEC-3.1.1`.

- **No es duplicado, es material complementario. No borres el monolito.** Haz el cambio
  mínimo: no reescribas el monolito para "unificarlo" por iniciativa propia.
- El monolito cubre **solo los temas 1 y 2**. La **Unidad 3** (objetos predefinidos, `Temporal`)
  vive de momento únicamente en `DWEC-3.1.md` y `DWEC-3.1.1.md`.
- Solo las notas por criterio llevan `Para el examen`, `Vocabulario` y las actividades
  resueltas. Ojo: `DWEC-3.1` y `DWEC-3.1.1` todavía **no** tienen esos bloques ni las
  actividades resueltas (3.1.1–3.1.4 y 3.1.8 están solo enunciadas).
- Están enlazadas en ambos sentidos: si tocas una, mantén los enlaces.

## 8. Límites

- No inventes contenido que no salga del material del repo o del enunciado: si falta, pregunta.
- No reescribas la teoría existente ni «mejores» el estilo de notas que no son tuyas.
- No toques ficheros fuera de este repositorio.
- Nunca escribas secretos, tokens ni claves en el repositorio.
