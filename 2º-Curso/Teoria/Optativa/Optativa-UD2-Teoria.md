# Optativa · UD2 — El Panel de Administración de WordPress (Teoría Completa)

> 🏠 [[📚 Indice General]] ▸ [[Optativa|Optativa · Gestores de Contenido]] │ 📄 Fuente: `UD2. El panel de administración.pdf` (Daniel Ocaña Aguilera) │ ⬅️ [[Optativa-UD1-Teoria]]

## Índice
- [2.1. ¿Qué vamos a aprender?](#21-qué-vamos-a-aprender)
- [2.2. Estructura del Panel de Administración (`wp-admin`)](#22-estructura-del-panel-de-administración-wp-admin)
- [2.3. El Escritorio — Centro de control principal](#23-el-escritorio--centro-de-control-principal)
- [2.4. Personalización del Escritorio y atajos de teclado](#24-personalización-del-escritorio-y-atajos-de-teclado)
- [2.5. Ajustes Generales](#25-ajustes-generales)
- [2.6. Ajustes de Escritura](#26-ajustes-de-escritura)
- [2.7. Ajustes de Lectura (Comportamiento Frontend)](#27-ajustes-de-lectura-comportamiento-frontend)
- [2.8. Sistema de Usuarios en WordPress](#28-sistema-de-usuarios-en-wordpress)
- [2.9. Roles de Usuario — Jerarquía de Permisos](#29-roles-de-usuario--jerarquía-de-permisos)
- [2.10. Matriz detallada de permisos por rol](#210-matriz-detallada-de-permisos-por-rol)
- [2.11. Gestión de Usuarios y Perfil individual](#211-gestión-de-usuarios-y-perfil-individual)
- [2.13. Seguridad, Casos de Uso y Resolución de Problemas](#213-seguridad-casos-de-uso-y-resolución-de-problemas)

---

## 2.1. ¿Qué vamos a aprender?

- **Navegación y configuración:** identificar todas las secciones del escritorio, configurar ajustes generales/escritura/lectura y personalizar el espacio de trabajo.
- **Gestión de usuarios:** crear usuarios con distintos roles, comprender la matriz de permisos y aplicar políticas de seguridad (principio de menor privilegio).
- **Flujos de trabajo:** establecer procesos de publicación colaborativa entre redactores y editores.

---

## 2.2. Estructura del Panel de Administración (`wp-admin`)

Se accede desde `tudominio.com/wp-admin` mediante usuario y contraseña. El menú lateral izquierdo agrupa todas las herramientas en **9 bloques**:

| Sección del menú | Submenús principales | Función |
|---|---|---|
| **1. Escritorio** | *Inicio*, *Actualizaciones* | Resumen del estado del sitio y actualizaciones de núcleo, temas y plugins. |
| **2. Entradas** | *Todas las entradas*, *Añadir nueva*, *Categorías*, *Etiquetas* | Contenido dinámico o cronológico (artículos del blog/noticias) clasificado por taxonomías. |
| **3. Medios** | *Biblioteca*, *Añadir nuevo* | Gestión de imágenes, documentos, audios y vídeos subidos al servidor. |
| **4. Páginas** | *Todas las páginas*, *Añadir nueva* | Contenido estático y atemporal (*Inicio*, *Quiénes somos*, *Contacto*, *Aviso legal*). |
| **5. Comentarios** | — | Bandeja de moderación (aprobar, responder, marcar como spam, enviar a papelera). |
| **6. Apariencia** | *Temas*, *Personalizar*, *Widgets*, *Menús* | Control del diseño visual y la estructura de navegación del sitio. |
| **7. Plugins** | *Plugins instalados*, *Añadir nuevo* | Ampliación de funcionalidades técnicas. |
| **8. Usuarios** | *Todos los usuarios*, *Añadir nuevo*, *Perfil* | Altas, bajas, asignación de roles y preferencias personales. |
| **9. Ajustes** | *Generales*, *Escritura*, *Lectura*, *Comentarios*, *Medios*, *Enlaces permanentes* | Configuración global del comportamiento de WordPress. |

---

## 2.3. El Escritorio — Centro de control principal

Al entrar en `wp-admin` se muestran por defecto **4 widgets informativos**:
1. **Bienvenida:** accesos rápidos a funciones comunes y enlaces para personalizar el sitio.
2. **Actividad reciente:** últimas entradas publicadas y comentarios recientes con botones rápidos de moderación.
3. **Borrador rápido:** formulario ligero para anotar y guardar ideas de entradas sin salir del escritorio.
4. **Noticias y eventos de WordPress:** novedades oficiales de la comunidad y *meetups* cercanos.

---

## 2.4. Personalización del Escritorio y atajos de teclado

- **Opciones de pantalla** (pestaña superior derecha):
  - Mostrar u ocultar widgets específicos mediante casillas de verificación.
  - Reordenar widgets arrastrando y soltando (*drag & drop*).
- **Ajustes del perfil de usuario (`Usuarios → Tu perfil`):**
  - Cambiar el **esquema de color del administrador** (*Por defecto, Claro, Azul, Café, Ectoplasma, Medianoche, Océano, Amanecer*).
  - Mostrar u ocultar la barra superior de herramientas al ver el sitio público.

### Atajos de teclado del panel
| Atajo | Acción |
|---|---|
| `Shift + Alt + C` | Ir a Comentarios / Añadir o moderar comentarios |
| `Shift + Alt + M` | Añadir nuevo medio (Biblioteca multimedia) |
| `Shift + Alt + P` | Añadir nueva entrada (*Post*) / página |

---

## 2.5. Ajustes Generales

Ubicados en **Ajustes → Generales**:
1. **Información básica del sitio:**
   - **Título del sitio:** visible en la pestaña del navegador y clave para el SEO.
   - **Descripción breve:** actúa como *meta description* por defecto (máx. recomendado ~150 caracteres).
2. **Configuración de URLs:**
   - **Dirección de WordPress (URL):** ruta donde están alojados los ficheros del núcleo de WordPress (ej. si se instala en una subcarpeta `/wordpress`).
   - **Dirección del sitio (URL):** dirección pública de acceso de los visitantes (la raíz del dominio).
3. **Configuración regional:**
   - **Zona horaria** (`Europa/Madrid`), **idioma del sitio** y formato de fecha/hora.
4. **Opciones de membresía:**
   - **Cualquiera puede registrarse:** debe mantenerse **desmarcado** por seguridad salvo que el sitio requiera registro abierto, evitando cuentas spam o ataques automatizados.
   - **Perfil predeterminado para nuevos usuarios:** siempre el de menor privilegio (*Suscriptor*).

---

## 2.6. Ajustes de Escritura

Ubicados en **Ajustes → Escritura**:
- **Categoría predeterminada para las entradas** (por si el autor olvida asignar una categoría).
- **Formato de entrada por defecto.**
- **Publicar por correo electrónico** (en desuso actualmente).
- **Servicios de actualización (*Pingbacks*):** lista de directorios a los que WordPress avisa automáticamente cada vez que se publica nuevo contenido para acelerar su indexación (por defecto `http://rpc.pingomatic.com/`).

---

## 2.7. Ajustes de Lectura (Comportamiento Frontend)

Ubicados en **Ajustes → Lectura**:
1. **Tu página de inicio muestra:**
   - *Tus últimas entradas:* comportamiento de blog clásico.
   - *Una página estática:* comportamiento de web corporativa o medio digital, separando la **Portada** (ej. página *Inicio*) de la **Página de entradas** (ej. página *Blog*).
2. **Número de entradas en el blog y en el feed RSS**, y si en el feed se muestra el *texto completo* o solo el *resumen*.
3. **Visibilidad en los motores de búsqueda:**
   - Casilla *«Disuadir a los motores de búsqueda de que indexen este sitio»*.
   - **Crítico:** debe estar **DESMARCADA en sitios en producción** (si se marca, inyecta `noindex` y oculta la web en Google).

---

## 2.8. Sistema de Usuarios en WordPress

Cada persona registrada se identifica por un **nombre de usuario único** (que **no se puede cambiar** tras su creación) y un **correo electrónico único**.
- Es fundamental diferenciar el **Nombre de usuario (login)** del **Nombre público para mostrar**: los artículos publicados deben firmarse siempre con el *Nombre para mostrar* para no revelar públicamente el identificador de login.

---

## 2.9. Roles de Usuario — Jerarquía de Permisos

WordPress incluye **6 roles predefinidos** ordenados de mayor a menor privilegio:

1. **Super Administrador** *(solo en instalaciones WordPress Multisite)*: control total sobre toda la red de sitios.
2. **Administrador:** acceso total a todas las funciones de un sitio individual (usuarios, plugins, temas, ajustes, código y contenidos).
3. **Editor:** responsable de contenidos. Puede crear, editar, publicar y borrar **cualquier entrada o página (propia o de otros usuarios)**, gestionar categorías/etiquetas y moderar comentarios, pero **no tiene acceso a Ajustes, Plugins, Temas ni Usuarios**.
4. **Autor:** puede escribir, editar, **publicar** y borrar **únicamente sus propias entradas**, así como subir archivos a la biblioteca de medios.
5. **Colaborador:** puede escribir y editar sus propias entradas, pero **NO puede publicarlas** (el botón *Publicar* se sustituye por *«Enviar para revisión»* para que un Editor o Administrador la valide) y **no puede subir archivos multimedia**.
6. **Suscriptor:** solo puede gestionar su propio perfil de usuario y escribir comentarios en las entradas.

---

## 2.10. Matriz detallada de permisos por rol

| Capacidad / Permiso | Admin | Editor | Autor | Colaborador | Suscriptor |
|---|:---:|:---:|:---:|:---:|:---:|
| Gestionar ajustes, plugins, temas y usuarios | ✅ | ❌ | ❌ | ❌ | ❌ |
| Crear y editar **páginas** y entradas de **otros** | ✅ | ✅ | ❌ | ❌ | ❌ |
| Moderar comentarios y gestionar categorías | ✅ | ✅ | ❌ | ❌ | ❌ |
| **Publicar** entradas propias y subir medios | ✅ | ✅ | ✅ | ❌ | ❌ |
| Redactar entradas propias y **enviar a revisión** | ✅ | ✅ | ✅ | ✅ | ❌ |
| Editar su propio perfil y comentar | ✅ | ✅ | ✅ | ✅ | ✅ |

---

## 2.11. Gestión de Usuarios y Perfil individual

- **Crear usuario (`Usuarios → Añadir nuevo`):** definir nombre de usuario único, email, nombre/apellidos, web, contraseña robusta y rol.
- **Perfil individual (`Usuarios → Tu perfil`):** permite rellenar la **información biográfica** (que se muestra públicamente en la caja de autor de las entradas), cambiar el **Nombre para mostrar públicamente**, regenerar contraseña y elegir preferencias del editor y esquema de color.

---

## 2.13. Seguridad, Casos de Uso y Resolución de Problemas

### Buenas prácticas de seguridad en la gestión de usuarios
1. **Política de nombres de usuario:** **nunca usar `admin`**; emplear patrones estructurados (`rol.nombre` o `nombre.apellido`) y ocultar el login usando un *Nombre para mostrar* distinto.
2. **Gestión de contraseñas:** mínimo **12 caracteres** combinando mayúsculas, minúsculas, números y símbolos, con rotación periódica cada 3–6 meses y **autenticación de dos factores (2FA)**.
3. **Principio de menor privilegio:** asignar a cada persona únicamente el rol mínimo que necesita para su tarea, auditar trimestralmente las cuentas activas y eliminar cuentas en desuso.

### Casos de uso reales de reparto de roles
- **Caso 1 — Blog personal:** 1 Administrador (dueño) + Colaboradores (autores invitados puntuales) + Suscriptores (lectores que comentan).
- **Caso 2 — Sitio corporativo pequeño:** 1 Administrador (TI) + 1 Editor (comunicación) + varios Autores (departamentos).
- **Caso 3 — Medio de comunicación online:** 1-2 Administradores + varios Editores (jefes de sección) + múltiples Autores (redactores en plantilla) + Colaboradores (*freelancers* externos sujetos a revisión).

### Resolución de problemas frecuentes (*Troubleshooting*)
- **El usuario no puede acceder:** verificar email de activación, comprobar que la cuenta existe y revisar bloqueos de plugins de seguridad o del cortafuegos del hosting (como la doble autenticación de CDMON).
- **Permisos incorrectos o el usuario ve opciones que no debería:** limpiar caché del navegador, comprobar el rol asignado y verificar que ningún plugin de membresía haya alterado las capacidades (*capabilities*) del rol.

---

## 🔗 Relacionado
- [[Optativa|Optativa · Gestores de Contenido (Índice)]]
- [[Optativa-UD1-Teoria|UD1 · Introducción al CMS y CDMON (Teoría)]]

🏷️ #optativa #ud2 #wordpress #usuarios #roles #seguridad #cms #2daw
