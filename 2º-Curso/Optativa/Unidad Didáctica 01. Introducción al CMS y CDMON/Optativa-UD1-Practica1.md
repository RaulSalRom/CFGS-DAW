# Optativa · UD1 — Práctica 1: Creación de Plataforma en CDMON, WordPress, Astra y Elementor

> 🏠 [[📚 Indice General]] ▸ [[Optativa|Optativa · Gestores de Contenido]] │ 📄 Fuentes: `Práctica_1-CDMON con Wordpress.pdf` y `Raul_Sal_Romeo_Practica1.pdf` │ ⬅️ [[Optativa-UD1-Teoria]] · [[Optativa-UD2-Teoria]] ➡️

## Índice
- [1. Guía paso a paso del procedimiento en CDMON](#1-guía-paso-a-paso-del-procedimiento-en-cdmon)
- [2. Configuración inicial: Tema Astra y Plugins (Elementor, WPForms, Blogmentor)](#2-configuración-inicial-tema-astra-y-plugins-elementor-wpforms-blogmentor)
- [3. Resolución documentada en la entrega (`Raul_Sal_Romeo_Practica1.pdf`)](#3-resolución-documentada-en-la-entrega-raul_sal_romeo_practica1pdf)

---

## 1. Guía paso a paso del procedimiento en CDMON

### Paso 1: Registro en CDMON y gestión de credenciales
1. Registrarse en **CDMON** (permite hasta 5 plataformas de prueba gratuitas sin pagar hosting) utilizando el correo corporativo educativo (`@g.educaand.es`).
2. Guardar en un documento de referencia las **dos capas de credenciales**:
   - **Credenciales de CDMON / Hosting** (para desbloquear la visualización del sitio de pruebas).
   - **Credenciales del administrador de WordPress** y la URL de administración (`http://tudominio.mialias.net/wp-admin`).

### Paso 2: Crear plataforma de prueba e instalar WordPress
1. En el panel de CDMON, crear una **nueva plataforma de prueba** indicando el dominio (sin `www.`), por ejemplo `raulsalromeo.com`, y aceptando las condiciones.
2. Entrar en la **configuración del hosting**, desplazarse hasta la sección **Aplicaciones → WordPress** y lanzar el instalador automático.
3. Copiar el usuario, contraseña y URL `/wp-admin` generados tras la instalación.

### Paso 3: Orden obligatorio de acceso en sesiones posteriores
> [!warning] Secuencia obligatoria para evitar el bloqueo de IP en CDMON
> Siempre que se quiera volver a entrar a trabajar en el WordPress alojado en la plataforma de pruebas de CDMON, hay que seguir este orden exacto:
> 1. **Iniciar sesión en el panel de CDMON** con el usuario de CDMON.
> 2. Ir a **Listado de Hostings**, seleccionar la plataforma de prueba y pulsar en **«Acceder a la página»** (esto autentica la sesión HTTP del navegador frente al cortafuegos del hosting de pruebas).
> 3. Una vez cargada la portada pública, abrir la URL **`/wp-admin`** e introducir el usuario y contraseña de **WordPress**.

---

## 2. Configuración inicial: Tema Astra y Plugins (Elementor, WPForms, Blogmentor)

1. **Instalación del tema base (`Astra`):**
   - Ir a **Apariencia → Temas → Añadir nuevo tema**.
   - Buscar **`Astra`**, pulsar **Instalar** y **Activar**.
2. **Instalación del maquetador visual (`Elementor`):**
   - Ir a **Plugins → Añadir nuevo plugin**.
   - Buscar **`Elementor`**, instalar y activar.
3. **Creación de formularios de contacto (`WPForms`):**
   - Instalar y activar el plugin **`WPForms`**.
   - Crear un formulario de contacto, guardarlo e insertarlo en la página o en el *footer* mediante el widget de WPForms dentro de **Elementor**, personalizando sus estilos en las pestañas *Contenido*, *Estilo* y *Avanzado*.
4. **Creación del apartado de Blog (`Blogmentor`):**
   - Instalar y activar el plugin **`Blogmentor`** para maquetar el listado de entradas en Elementor.

---

## 3. Resolución documentada en la entrega (`Raul_Sal_Romeo_Practica1.pdf`)

- **Dominio de prueba desplegado:** `http://www.raulsalromeo.com.mialias.net/wp-admin`
- **Hitos verificados con capturas en la entrega:**
  1. Alta correcta de la cuenta y creación de la primera plataforma de prueba en CDMON.
  2. Instalación automática de WordPress verificada desde el panel de aplicaciones.
  3. Acceso al escritorio de WordPress (`/wp-admin`).
  4. Instalación y activación de la plantilla **Astra**.
  5. Instalación del constructor visual **Elementor** y creación/inserción del primer formulario con **WPForms** en la página.
  6. Instalación y activación del plugin **Blogmentor**.

---

## 🔗 Relacionado
- [[Optativa|Optativa · Gestores de Contenido (Índice)]]
- [[Optativa-UD1-Teoria|UD1 · Introducción al CMS y CDMON (Teoría)]]
- [[Optativa-UD2-Teoria|UD2 · El Panel de Administración de WordPress (Teoría)]]
- [[Optativa-UD2-Practica2|UD2 · Práctica 2: Configuración del Panel y Roles en TechRevista]]

🏷️ #optativa #ud1 #practica #wordpress #cdmon #elementor #astra #2daw
