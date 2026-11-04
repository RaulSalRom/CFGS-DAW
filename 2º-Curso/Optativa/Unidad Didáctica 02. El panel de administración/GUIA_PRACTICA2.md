# Guía Práctica UD2: Configuración del Panel de Administración y Gestión de Usuarios en WordPress

## Acceso
- **URL WP Admin:** http://www.raulsalromeo.com.mialias.net/wp-admin
- **Usuario WP:** `6a8e00cb0655`
- **Contraseña WP:** `uwPfyIzv`
- **Credenciales CDOM (hosting):** `rsalrom1405@g.educaand.es` / `Raulalejandrosalromeo2007!`

> *Nota:* Si aparece un cuadro de autenticación HTTP Basic ("Restricted Content"), prueba ambas credenciales. En caso de dar error, intenta sin relleno o pregunta al profesor. Las credenciales WP son las que van en el formulario de WordPress.

## Temática elegida
**Elige UNA y anótala aquí:** _____________________________
*(Ejemplos: Blog de videojuegos, Portfolio de fotografía, Revista tecnológica, Sitio corporativo...)*

---

## Tarea 1. Configuración general (Ajustes → Generales)

Captura: `Tarea1_Generales.png`

- [ ] **Título del sitio:** `_________________________` (coherente con temática)
- [ ] **Descripción corta / lema del sitio:** `_________________________` (máx. 150 caracteres, actúa como meta description)
- [ ] **Zona horaria:** Madrid / `Europa/Madrid` (UTC+1)
- [ ] **Formato de fecha:** `j F, Y` o similar español
- [ ] **Formato de hora:** `H:i`
- [ ] **Idioma del sitio:** `Español`
- [ ] **Miembros → Cualquiera puede registrarse:** **DESMARCADO**

**Explicación para el PDF:**
> *"He deshabilitado el registro libre de usuarios porque solo deben poder acceder personas autorizadas por el administrador. Esto evita registros masivos, spam y posibles intentos de acceso no deseados, aplicando el principio de menor exposición."*

**Pregunta teórica:**
> *Diferencia entre Dirección de WordPress (URL) y Dirección del sitio (URL):* La **Dirección de WordPress (URL)** es donde están los archivos del core de WordPress. La **Dirección del sitio (URL)** es la URL que verán los visitantes. Pueden ser distintas si, por ejemplo, instalamos WordPress en una subcarpeta (`/wordpress/`) pero queremos que el sitio se vea desde la raíz del dominio, o en entornos de desarrollo/migración.

---

## Tarea 2. Configuración de escritura y lectura

### Ajustes → Escritura
Captura: `Tarea2_Escritura.png`

- [ ] **Categoría predeterminada para las entradas:** `_________________________` (ej. General, Noticias, Artículos)
- [ ] **Servicio de actualización:** `rpc.pingomatic.com` (dejar por defecto)

**Explicación:**
> *"Ping-O-Matic avisa a distintos servicios de agregadores y motores de búsqueda cuando publicamos nuevo contenido, ayudando a que nuestras actualizaciones se descubran más rápidamente."*

### Ajustes → Lectura
Captura: `Tarea2_Lectura.png`

**Crear páginas primero (Páginas → Añadir nueva):**
- [ ] `Inicio` - con un texto de bienvenida breve
- [ ] `Blog` - vacía (solo para alojar las entradas)
- [ ] `Quiénes somos` - contenido genérico
- [ ] `Contacto` - contenido genérico

**Configuración:**
- [ ] **La página de inicio muestra:** `Una página estática` → Portada: `Inicio` | Página de entradas: `Blog`
- [ ] **Páginas del blog que se muestran como máximo:** `5`
- [ ] **Para cada artículo en un feed, mostrar:** `Resumen`
- [ ] **Elementos del feed RSS que se mostrarán:** `10`
- [ ] **Visibilidad para los motores de búsqueda → "Disuadir a los motores de búsqueda de indexar este sitio":** **DESMARCADO**

**Explicación:**
> *"Debo tener esta casilla desmarcada porque el sitio está en producción y quiero que sea visible e indexable por motores de búsqueda (Google, etc.). Si estuviera marcada, se añadiría una directiva `noindex` que impediría su indexación."*

---

## Tarea 3. Personalización del escritorio

Capturas: `Tarea3_Pantalla.png`, `Tarea3_Perfil.png`, `Tarea3_Atajos.png`

- [ ] **Opciones de pantalla (arriba derecha):** Ocultar al menos un widget (ej. "Eventos y noticias de WordPress" o "Borrador rápido"). Capturar antes/después o el resultado.
- [ ] **Usuarios → Tu perfil:** Cambiar el **Esquema de color** a uno distinto al predeterminado
- [ ] **Escritorio:** Organizar los widgets restantes en **2 columnas** (arrastrando)

**Atajos de teclado del Escritorio:**
| Atajo | ¿Qué hace? |
|---|---|
| `Shift + Alt + C` | _____________________________ |
| `Shift + Alt + M` | _____________________________ |
| `Shift + Alt + P` | _____________________________ |

*(Anótalos tal como los compruebes en clase/práctica)*

---

## Tarea 4. Gestión de usuarios y roles

**Usuarios → Añadir nuevo**. Usar patrón coherente. Generar contraseñas seguras (mín. 12 caracteres, mayúsculas, minúsculas, números y símbolos).

| Rol | Nombre de usuario | Nombre para mostrar | Correo electrónico | Biografía | Justificación |
|---|---|---|---|---|---|
| Administrador | `admin.tunombre` | *(tu nombre)* | `admin.tunombre@tudominio.local` | *(opcional)* | Responsable TI / dirección |
| Editor | `editor.nombre` | *(nombre real)* | `editor.nombre@tudominio.local` | **OBLIGATORIA** | Responsable de contenidos |
| Autor | `autor.nombre` | *(nombre real)* | `autor.nombre@tudominio.local` | **OBLIGATORIA** | Redactor de sección |
| Colaborador | `colaborador.nombre` | *(nombre real)* | `colaborador.nombre@tudominio.local` | *(opcional)* | Colaborador esporádico |
| Suscriptor | `suscriptor.nombre` | *(nombre real)* | `suscriptor.nombre@tudominio.local` | *(opcional)* | Lector registrado para comentar |

Capturas: `Tarea4_Usuarios.png` (listado completo), `Tarea4_Editor_Perfil.png`, `Tarea4_Autor_Perfil.png`

> **Importante:** NO usar "admin" a secas. El nombre público debe ser el "Nombre para mostrar", no el login.

---

## Tarea 5. Verificación de permisos (experimento práctico)

Hacer logout/login con cada usuario. Capturar cada paso.

### 5.1 Colaborador
- [ ] Iniciar sesión como **colaborador.nombre**
- [ ] **Entradas → Añadir nueva:** Crear entrada de prueba
- [ ] Intentar **Publicar** → Observar que solo aparece **"Enviar a revisión"**
- [ ] **Captura:** `Tarea5_Colaborador.png`

### 5.2 Autor
- [ ] Iniciar sesión como **autor.nombre**
- [ ] Crear entrada de prueba
- [ ] Publicarla directamente
- [ ] Comprobar que aparece publicada
- [ ] **Captura:** `Tarea5_Autor.png`

### 5.3 Editor
- [ ] Iniciar sesión como **editor.nombre**
- [ ] Intentar editar una entrada creada por otro usuario
- [ ] Intentar moderar comentarios (**Comentarios**)
- [ ] Intentar acceder a **Ajustes** → Debe NO tener acceso / menú ausente
- [ ] Intentar acceder a **Usuarios** → Debe NO tener acceso / menú ausente
- [ ] **Captura:** `Tarea5_Editor.png`

### Tabla resumen para el PDF

| Acción | Administrador | Editor | Autor | Colaborador | Suscriptor | Observado (sí/no) |
|---|---|---|---|---|---|---|
| Publicar entradas propias | Sí | Sí | Sí | No | No | Colab:____ / Autor:____ |
| Editar entradas ajenas | Sí | Sí | No | No | No | Editor:____ |
| Enviar a revisión | Sí | Sí | Sí | Sí | No | Colaborador:____ |
| Moderar comentarios | Sí | Sí | No | No | No | Editor:____ |
| Acceso a Ajustes | Sí | No | No | No | No | Editor:____ |
| Acceso a Usuarios | Sí | No | No | No | No | Editor:____ |
| Comentar | Sí | Sí | Sí | Sí | Sí | Suscriptor:____ |
| Gestionar perfil propio | Sí | Sí | Sí | Sí | Sí | Todos:____ |

**Conclusión Tarea 5:** Comparar lo observado con la matriz teórica. Coincide con el principio de **mínimo privilegio** (cada rol tiene solo los permisos necesarios para su función).

---

## Tarea 6. Simulación de flujo de trabajo editorial

Capturar CADA paso con usuario distinto.

- [ ] **Paso 1 - Colaborador:** `colaborador.nombre` crea entrada con título acorde a tu temática. Pulsa **"Enviar a revisión"**. *Captura:* `Tarea6_1_Colaborador_Revision.png`
- [ ] **Paso 2 - Editor:** `editor.nombre` entra en **Entradas → Todas las entradas** (verá "Pendiente de revisión"), abre la entrada, añade **Categoría** y **Etiqueta**, pulsa **Publicar**. *Captura:* `Tarea6_2_Editor_Publica.png`
- [ ] **Paso 3 - Activar comentarios (si necesario):** Como Editor/Administrador, ir a **Ajustes → Debate** o directamente en la entrada. Asegurar que se permiten comentarios.
- [ ] **Paso 4 - Suscriptor:** `suscriptor.nombre` accede al sitio (frente público), abre la entrada publicada y deja un **comentario**. *Captura:* `Tarea6_3_Suscriptor_Comentario.png`
- [ ] **Paso 5 - Editor modera:** `editor.nombre` va a **Comentarios**, encuentra el comentario del suscriptor, lo **Aprueba**. *Captura:* `Tarea6_4_Editor_Aprueba.png`

**Explicación del flujo:**
> *"Se ha simulado un flujo editorial real: el colaborador redacta pero no puede publicar (requiere revisión), el editor valida, categoriza, etiqueta y publica, y se gestiona la participación de lectores mediante moderación de comentarios. Esto garantiza control de calidad y separación de responsabilidades."*

---

## Estructura del PDF de entrega

**Nombre del archivo:** `UD2_Practica_ApellidoNombre.pdf`

**Orden:**
1. **Portada** - Nombre y apellidos, Curso (2º DAW), Fecha, Temática elegida
2. **Tarea 1** - Capturas + explicaciones
3. **Tarea 2** - Capturas + explicaciones  
4. **Tarea 3** - Capturas + tabla atajos + explicaciones
5. **Tarea 4** - Captura listado usuarios + perfiles Editor/Autor + tabla + explicaciones
6. **Tarea 5** - Capturas por usuario + tabla comparativa rellenada + explicación
7. **Tarea 6** - Capturas de los 4 pasos + explicación del flujo
8. **Conclusiones personales** - ¿Qué he aprendido? ¿Qué dificultades he encontrado? ¿Cómo las he resuelto?

**Trucos para las capturas:**
- Recorta solo la zona relevante (no pantalla completa)
- Asegúrate que se vean nombres de usuario, roles, URLs, menús
- Usa capturas claras y legibles
- Para el listado de usuarios (**Usuarios → Todos los usuarios**) captura toda la tabla con los 5 usuarios visibles
- Para las pruebas de permisos, captura el menú lateral o las opciones que sí/no aparecen
