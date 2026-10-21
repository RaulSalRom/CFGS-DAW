# AGENTS.md — CFGS-DAW

> Instrucciones para agentes (OpenClaw, opencode…) que trabajen en este repositorio.
> Se carga como **contexto de proyecto** cuando la sesión se ejecuta con este repo como
> carpeta de trabajo. El idioma de trabajo es **español**.

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
| DWEC | Desarrollo Web Entorno Cliente | Carvajal | JavaScript, DOM, eventos, `fetch` (actividades 1.1–1.6) |
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
📚 Indice General.md   # Índice maestro (en la raíz)
1º-Curso(kursaal)/     # 8 asignaturas
2º-Curso/              # 8 asignaturas, en curso
```

- `📚 Indice General.md` (en la raíz del repo) es el **índice maestro** y cubre 1º y 2º.
- Los `README.md` de raíz documentan estructura, notas y horario.

## 4. Cómo tienes que trabajar (bucles)

Toda tarea se resuelve en un **ciclo iterativo**, nunca de un tirón:

1. **Entender** — lee el enunciado y el material ya existente antes de tocar nada.
2. **Planificar** — decide los pasos y dilo en una línea.
3. **Implementar** — haz el cambio mínimo que toca.
4. **Verificar** — comprueba de verdad: Java compila, SQL ejecuta, HTML/PHP se abre, JS corre con `node`.
5. **Cerrar** — commit y `push` a `main` (ver §6).

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

## 7. DWEC tiene dos capas (no las rompas)

`Desarrollo web en entorno cliente` = monolito de teoría (`DesarrolloWebEnEntornoCliente.md`) +
notas por criterio (`DWEC-1.1.md`…`DWEC-1.6.md`).

- **No es duplicado, es material complementario. No borres el monolito.**
- Solo el monolito tiene `## 1. Teoría`; solo las per-unit tienen `Para el examen`, `Vocabulario`
  y las actividades resueltas.
- Están enlazadas en ambos sentidos: si tocas una, mantén los enlaces.

## 8. Límites

- No inventes contenido que no salga del material del repo o del enunciado: si falta, pregunta.
- No reescribas la teoría existente ni «mejores» el estilo de notas que no son tuyas.
- No toques ficheros fuera de este repositorio.
- Nunca escribas secretos, tokens ni claves en el repositorio.
