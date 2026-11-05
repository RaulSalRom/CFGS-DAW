# Unidad 1. Hito 1 — Proyecto Intermodular DAW

> **Alumno:** Raúl Sal Romeo
> **Ciclo:** Desarrollo de Aplicaciones Web (DAW) — I.E.S. Kursaal
> **Curso:** 2026/27
> **Tarea:** Conocer y analizar un entorno empresarial real
> **Entrega:** `sal_romeo_raul_Tareav1.zip`

---

# PARTE I — PROPUESTA DE PROYECTO

## 1. Nombre del proyecto

**TarifaTransparente** — Plataforma de transparencia de precios y valoraciones de alojamientos turísticos en Tarifa.

## 2. Autor

Raúl Sal Romeo

## 3. Ciclo formativo

CFGS Desarrollo de Aplicaciones Web (DAW) — I.E.S. Kursaal

## 4. Tipo de desarrollo

**Aplicación web** (basada en web, arquitectura cliente-servidor, responsive). No se plantea
app móvil nativa ni aplicación de escritorio en esta primera fase.

## 5. Introducción

**Proyecto propio.** La persona que ejecuta el proyecto lleva la dirección y ejecución.

Tarifa es uno de los destinos turísticos con mayor presión estacional de la provincia de
Cádiz. En los últimos años el municipio ha pasado de una oferta hotelera concentrada a un
modelo disperso de viviendas de uso turístico (VUT), con cientos de alojamientos registrados
en plataformas globales. El problema aparece cuando el usuario quiere decidir:

- Los precios que muestra una plataforma no son comparables con los de otra (distintas
  políticas de limpieza, tasas, mínimos de estancia y comisiones ya incluidas o no).
- Las valoraciones están fragmentadas entre plataformas y no son trasladables.
- El turista no sabe cuánto paga realmente por noche ni qué parte del precio se queda la
  intermediación.

La comunicación con el cliente es directa (proyecto propio), lo que permite iterar rápido:
la propuesta aquí recogida actúa como documento de especificaciones inicial.

## 6. Planteamiento

### 6.1. El problema

El usuario final no dispone de una fuente única, neutral y comparable para evaluar opciones
de alojamiento en Tarifa. La información existe pero está **dispersa, formateada de forma
incompatible y sesgada por los intereses comerciales de cada plataforma**.

### 6.2. Modelo de negocio y necesidad del consumidor

| Elemento | Análisis |
|---|---|
| **Usuario objetivo** | Turista nacional (principalmente Madrid, Sevilla, Málaga) y extranjero (alemán, británico, francés) que busca alojamiento en Tarifa; estancias de 3 a 14 días. |
| **Necesidad** | Comparar precio real por noche y calidad percibida en una sola vista, sin scraping manual. |
| **Propuesta de valor** | Normalización del precio total (incluyendo limpieza, tasas y comisiones) y agregación de valoraciones con un índice propio de fiabilidad. |
| **Modelo de ingresos** | Freemium para propietarios (ficha destacada y analítica de su posicionamiento) + afiliación con plataformas de reserva. |
| **Competencia** | Booking, Airbnb, Vrbo, Trivago (metabuscador). Ninguna ofrece normalización de precio final en destinos concretos ni índice de fiabilidad de reseñas. |

### 6.3. Funcionamiento de la aplicación

1. El usuario introduce fechas, número de huéspedes y zona de Tarifa.
2. La aplicación consulta las fuentes disponibles (APIs de afiliación y carga manual de datos
   por propietarios).
3. Se calcula el **precio real por noche**: `(precio base × noches + limpieza + tasas) / noches`.
4. Se muestran resultados ordenables por precio real, valoración agregada y fiabilidad.
5. El usuario puede guardar favoritos y comparar hasta tres alojamientos en paralelo.

### 6.4. Actividades que realiza la aplicación

- Registro e inicio de sesión de usuarios (turistas y propietarios).
- Búsqueda y filtrado de alojamientos por zona, fechas, precio y servicios.
- Normalización y cálculo del precio final por noche.
- Agregación de valoraciones con índice de fiabilidad.
- Comparador de hasta tres alojamientos.
- Panel de propietario con estadísticas de visitas y posición en el listado.
- Gestión de favoritos y listas.

### 6.5. Modelo de navegación y diseño de interfaz

Estructura de tres niveles:

```
Home (buscador)
 ├── Resultados (lista + filtros laterales)
 │    ├── Detalle del alojamiento
 │    └── Comparador (hasta 3)
 ├── Área de usuario
 │    ├── Favoritos
 │    └── Mis reservas (registro)
 └── Área de propietario
      ├── Mi ficha
      └── Estadísticas
```

Diseño **mobile-first**, con paleta basada en tonos marinos (coherente con Tarifa),
tipografía de alta legibilidad y navegación inferior fija en móvil. Se aplicarán criterios
WCAG 2.2 AA desde el inicio.

## 7. Finalidad

### 7.1. Cómo soluciona el problema

La aplicación convierte información dispersa en una **métrica única y comparable**: el precio
real por noche. El turista deja de comparar cifras que no significan lo mismo y pasa a
comparar el coste efectivo, haciendo la decisión de compra racional en lugar de intuitiva.

### 7.2. Por qué se realiza

Porque la opacidad de precios en destinos turísticos saturados es un problema real y
verificable, y porque existe un nicho no cubierto por los grandes metabuscadores, que
comptien en volumen global y no en normalización local.

### 7.3. Justificación frente a alternativas

| Alternativa | Por qué es menos efectiva |
|---|---|
| Usar Trivago u otro metabuscador | Compara precios tal y como los da cada plataforma, sin normalizar limpieza, tasas ni comisiones. |
| Comparar manualmente en varias pestañas | No escala, no persiste y el usuario no puede agregar valoraciones. |
| Foro o grupo de Telegram local | Sin estructura de datos, sin filtros y sin garantía de actualización. |

### 7.4. Impacto y beneficio

- **Corto plazo (3-6 meses):** producto funcional con datos de las principales zonas de Tarifa.
- **Medio plazo (12 meses):** red de propietarios que mantienen sus datos actualizados y
  primeras conversiones por afiliación.
- **Beneficio:** para el turista, ahorro medio estimado del 8-12 % al detectar cargos
  ocultos; para el propietario, visibilidad en un canal neutral.

## 8. Objetivos

### 8.1. Objetivos generales

1. **Desarrollar** una plataforma web que centralice la oferta de alojamiento turístico de
   Tarifa y permita comparar precios reales por noche.
2. **Normalizar** los precios de distintas fuentes aplicando una fórmula de coste total
   transparente y auditable.
3. **Agregar** valoraciones dispersas en un índice de fiabilidad propio.
4. **Validar** el modelo de negocio mediante un piloto con al menos 50 alojamientos reales.

**Criterios de éxito medibles:**
- Al menos 50 alojamientos cargados y verificados en el primer mes.
- Tiempo medio de comparación inferior a 90 segundos (frente a 8-12 min manuales).
- Tasa de retorno de usuarios superior al 20 % en el primer trimestre.

**Dónde se utilizará:** entorno web (navegador de escritorio y móvil), desplegado en servidor
propio con posibilidad de escalar a cloud.

**Coste, programación y calidad:** desarrollo individual, 9 meses lectivos, priorizando
calidad de código y accesibilidad sobre número de funcionalidades.

### 8.2. Objetivos específicos

1. **Implementar** un buscador con filtros por zona, fechas, precio real y servicios.
2. **Calcular** automáticamente el precio real por noche incorporando limpieza, tasas y
   comisiones.
3. **Diseñar** un índice de fiabilidad que penalice reseñas anómalas o concentradas en el
   tiempo.
4. **Permitir** la comparación simultánea de hasta tres alojamientos.
5. **Ofrecer** a los propietarios un panel donde actualizar su ficha sin intermediarios.
6. **Garantizar** cumplimiento RGPD y de la LSSI en el tratamiento de datos personales.

**Recursos y limitaciones:** desarrollo en solitario dentro del horario lectivo del ciclo;
sin presupuesto de marketing; datos iniciales obtenidos de APIs públicas de afiliación y
carga manual consentida por propietarios.

## 9. Recursos y tecnologías a utilizar

### 9.1. Personal

Desarrollo individual (Raúl Sal Romeo). Tutor del módulo como supervisor.

### 9.2. Herramientas y lenguajes

| Capa | Tecnología | Uso |
|---|---|---|
| **Frontend** | HTML5 semántico, CSS3 (Grid/Flexbox), JavaScript ES6+ | Interfaz y lógica de cliente |
| **Framework cliente** | React (con Vite) | Componentes, estado y enrutado |
| **Backend** | PHP 8 con Laravel | API REST, autenticación y lógica de negocio |
| **Base de datos** | MySQL 8 / MariaDB | Persistencia relacional |
| **Control de versiones** | Git + GitHub | Historial, ramas y despliegue |
| **Entorno** | Docker + Docker Compose | Reproducibilidad (Apache, MySQL, PHP) |
| **Testing** | PHPUnit, Jest, Playwright | Pruebas unitarias y end-to-end |
| **Diseño** | Figma | Prototipado de interfaz |

### 9.3. Utilidades adicionales

- **Uptime Kuma** para monitorización de disponibilidad.
- **GitHub Actions** para integración continua.
- **Lighthouse y axe DevTools** para auditoría de rendimiento y accesibilidad.

## 10. Metodología

Modelo **iterativo incremental** con sprints de dos semanas:

1. **Análisis** — requisitos, casos de uso y modelo de datos.
2. **Diseño** — prototipo Figma y esquema de base de datos.
3. **Desarrollo** — implementación por capas (API → frontend → integración).
4. **Pruebas** — unitarias, de integración y E2E.
5. **Entrega y revisión** — demo al tutor y ajuste de requisitos.

Cada sprint termina con código funcionando y desplegado en entorno de pruebas.

## 11. Evaluación

| Entregable | Momento | Criterio de logro |
|---|---|---|
| Documento de especificaciones | Sprint 1 | Aprobado por el tutor |
| Prototipo de interfaz (Figma) | Sprint 2 | Navegable y validado |
| API funcional con autenticación | Sprint 4 | Endpoints documentados y probados |
| Frontend integrado | Sprint 6 | Búsqueda y comparador operativos |
| Sistema completo desplegado | Sprint 8 | Accesible en URL pública |
| Memoria y defensa | Final | Rúbrica del módulo |

## 12. Financiación

Proyecto **autofinanciado** con recursos propios. Necesidades estimadas:

| Concepto | Importe |
|---|---|
| Dominio (.com) | 12 €/año |
| Hosting VPS básico (2 vCPU, 4 GB RAM) | 60 €/año |
| Certificado SSL | 0 € (Let's Encrypt) |
| APIs de afiliación | 0 € (modelo de comisión) |
| **Total primer año** | **72 €** |

**Ayudas consideradas:** programas de emprendimiento del IEDT (Diputación de Cádiz) y
líneas de subvención de la Junta de Andalucía para digitalización de pymes turísticas.

## 13. Presupuesto y riesgos

### 13.1. Presupuesto

El proyecto **no busca generar ingresos durante el desarrollo**. El objetivo es validar el
producto; la monetización se plantea a partir del piloto.

**Coste total aproximado del desarrollo (valorado a precio de mercado):**

| Concepto | Horas | €/hora | Total |
|---|---|---|---|
| Análisis y diseño | 60 | 25 | 1.500 € |
| Desarrollo backend | 180 | 25 | 4.500 € |
| Desarrollo frontend | 200 | 25 | 5.000 € |
| Pruebas y despliegue | 60 | 25 | 1.500 € |
| **Total** | **500** | | **12.500 €** |

Coste real en el contexto del ciclo: **0 €** (trabajo propio).

### 13.2. Riesgos

| Riesgo | Probabilidad | Impacto | Mitigación |
|---|---|---|---|
| Las plataformas bloquean la obtención de datos | Alta | Alto | Uso de APIs de afiliación oficiales y datos cedidos por propietarios |
| Datos desactualizados | Media | Medio | Panel de propietario y marcado de fecha de verificación |
| No alcanzar usuarios en el piloto | Media | Medio | Difusión en foros locales y colaboración con hostelería |
| Incumplimiento RGPD | Baja | Alto | Asesoramiento y diseño con privacidad desde el origen |
| Falta de tiempo por carga lectiva | Alta | Medio | Alcance mínimo viable cerrado al inicio |

## 14. Resumen y conclusiones

TarifaTransparente propone convertir la confusión del mercado de alojamiento turístico local
en una decisión informada. Frente a los metabuscadores globales, la propuesta no compite en
volumen sino en **normalización y transparencia**: un precio comparable y una valoración
agregada fiable. El desarrollo es viable con los recursos del ciclo, el coste de operación es
mínimo y el impacto para el usuario es directo y medible. Se solicita la aprobación de esta
propuesta para iniciar la fase de análisis y diseño.

---

# PARTE II — INFORME DE ENTORNO EMPRESARIAL

## Índice

1. [Clasificación de las empresas del sector](#1-clasificación-de-las-empresas-del-sector)
2. [Empresas tipo: estructura y departamentos](#2-empresas-tipo-estructura-y-departamentos)
3. [Necesidades más demandadas](#3-necesidades-más-demandadas)
4. [Oportunidades de negocio](#4-oportunidades-de-negocio)
5. [Características y funcionalidades más demandadas](#5-características-y-funcionalidades-más-demandadas)
6. [Obligaciones legales, fiscales y laborales](#6-obligaciones-legales-fiscales-y-laborales)
7. [Ayudas y subvenciones](#7-ayudas-y-subvenciones)
8. [Conclusiones](#8-conclusiones)

---

## 1. Clasificación de las empresas del sector

El sector de referencia es el **turismo digital / alojamiento turístico en la provincia de
Cádiz**, con foco en Tarifa.

### 1.1. Por características organizativas

| Tipo | Descripción | Ejemplos |
|---|---|---|
| **Grandes plataformas globales** | Multinacionales cotizadas, estructura matricial, miles de empleados, modelo de marketplace | Booking Holdings, Airbnb, Expedia |
| **Metabuscadores** | Intermediarios que agregan oferta de terceros; no poseen inventario | Trivago, Kayak |
| **Pymes tecnológicas locales** | Empresas andaluzas de desarrollo web y marketing turístico, 5-50 empleados | Agencias de Cádiz y Málaga |
| **Gestores de alquiler turístico** | Empresas que gestionan VUT por cuenta de propietarios | Gestoras locales de Tarifa |
| **Establecimientos hoteleros** | Empresas tradicionales con plantilla estacional | Hoteles y hostales de Tarifa |
| **Autónomos / micropymes** | Propietarios individuales que alquilan 1-3 viviendas | Mayoría del inventario de VUT |

### 1.2. Por tipo de producto o servicio

| Categoría | Producto o servicio |
|---|---|
| **Intermediación de reservas** | Comisión por transacción (15-25 %) |
| **Publicidad y posicionamiento** | Ficha destacada, subasta de anuncios |
| **SaaS de gestión** | Channel manager, PMS, revenue management |
| **Servicios de marketing** | Fotografía, redacción, reputación online |
| **Alojamiento directo** | Venta de noches de hotel o vivienda |

---

## 2. Empresas tipo: estructura y departamentos

### 2.1. Estructura de una plataforma global (modelo Booking/Airbnb)

```
Dirección General
├── Producto y Tecnología
│    ├── Ingeniería (backend, frontend, móvil, datos)
│    ├── Product Management
│    └── Diseño (UX/UI)
├── Operaciones
│    ├── Atención al cliente
│    └── Gestión de inventario y calidad
├── Comercial
│    ├── Ventas a establecimientos
│    ├── Marketing y adquisición
│    └── Alianzas
├── Datos y Analítica
├── Finanzas y Legal
└── Personas (RRHH)
```

**Funciones por departamento:**

- **Tecnología:** desarrollo y mantenimiento de la plataforma, escalabilidad, seguridad.
- **Producto:** definición de funcionalidades, priorización por impacto en negocio.
- **Operaciones:** soporte 24/7, resolución de incidencias, control de calidad de anuncios.
- **Comercial:** captación de establecimientos y campañas de adquisición de usuarios.
- **Datos:** modelos de pricing, detección de fraude en reseñas, personalización.
- **Finanzas:** facturación, cobros, cumplimiento fiscal internacional.
- **Legal:** contratos, protección de datos, normativa turística por país.

### 2.2. Estructura de una pyme tecnológica local

Mucho más plana, con perfiles polivalentes:

```
Socio-director
├── Desarrollo (1-4 personas)
├── Diseño / Marketing (1-2 personas)
└── Administración (1 persona, a tiempo parcial)
```

En este modelo **una misma persona asume varias funciones**, lo que es relevante para el
proyecto propio: el desarrollo, el diseño y la relación con el cliente recaen en la misma
persona.

### 2.3. Estructura de un gestor de alquiler turístico

```
Gerente
├── Comercial (captación de propietarios)
├── Operaciones (limpieza, mantenimiento, check-in)
├── Atención al huésped
└── Administración y facturación
```

---

## 3. Necesidades más demandadas

A partir del análisis de oferta y de foros de propietarios y viajeros:

### 3.1. Necesidades del turista

1. **Comparabilidad de precios** — saber cuánto paga realmente por noche.
2. **Confianza en la reseña** — detectar reseñas falsas o incentivadas.
3. **Información local fiable** — viento, accesibilidad a playas, transporte.
4. **Reserva rápida en móvil** — proceso inferior a 3 pasos.
5. **Atención en su idioma** — especialmente inglés y alemán.

### 3.2. Necesidades del propietario

1. **Visibilidad sin depender de una sola plataforma.**
2. **Control del precio y de las comisiones.**
3. **Herramientas de gestión unificadas** (calendario, mensajería, facturación).
4. **Datos sobre su posicionamiento** frente a la competencia.
5. **Cumplimiento normativo** (registro de VUT, RGPD).

### 3.3. Necesidades de las gestoras

1. Sincronización automática de calendarios (channel manager).
2. Informes de rentabilidad por inmueble.
3. Automatización de la comunicación con huéspedes.

---

## 4. Oportunidades de negocio

| Oportunidad | Justificación |
|---|---|
| **Nicho de transparencia local** | Los grandes jugadores no normalizan precios por destino; hay hueco real. |
| **B2B para propietarios** | Miles de VUT en Tarifa necesitan herramientas que las plataformas no dan. |
| **Datos como servicio** | Informes de mercado para gestoras e inversores. |
| **Crecimiento del turismo activo** | Tarifa es referente de kitesurf y deportes de viento; público recurrente y fiel. |
| **Desestacionalización** | Herramientas que ayuden a llenar temporada baja (packs, ofertas). |
| **Afiliación** | Comisión por reserva derivada sin asumir riesgo de inventario. |

**Oportunidades previsibles a 2-3 años:** consolidación de la regulación de VUT, lo que
favorecerá a plataformas que ya trabajan con datos verificados; y demanda creciente de
transparencia por parte del consumidor europeo.

---

## 5. Características y funcionalidades más demandadas

Análisis de las funcionalidades que más se repiten en plataformas del sector y en las
reseñas de usuarios:

| Funcionalidad | Demanda | Presencia en competencia |
|---|---|---|
| Buscador con filtros por fecha, precio y zona | Muy alta | Universal |
| Mapa interactivo de resultados | Alta | Alta (Booking sí, gestoras locales no) |
| Precio final desglosado | Alta | **Baja** — hueco de mercado |
| Comparador de alojamientos | Media | Baja |
| Valoraciones verificadas | Muy alta | Alta, pero no agregadas entre plataformas |
| Cancelación gratuita visible | Muy alta | Universal |
| Reserva sin registro previo | Alta | Media |
| Chat directo con propietario | Alta | Media |
| Versión móvil optimizada | Muy alta | Universal |
| Multiidioma | Alta | Alta |

**Conclusión del análisis:** las funcionalidades básicas están universalmente cubiertas; el
espacio diferencial está en **el desglose del precio final** y en la **agregación de
valoraciones**, precisamente los dos pilares de la propuesta.

---

## 6. Obligaciones legales, fiscales y laborales

### 6.1. Obligaciones fiscales

| Obligación | Descripción |
|---|---|
| **Alta en el censo (modelo 036/037)** | Comunicación de inicio de actividad a la AEAT |
| **IVA** | Tipo general 21 % sobre servicios digitales; inversión del sujeto pasivo en servicios B2B intracomunitarios |
| **IRPF** | Estimación directa simplificada como autónomo |
| **Modelo 303** | Declaración trimestral de IVA |
| **Modelo 130** | Pago fraccionado de IRPF |
| **Modelo 349** | Operaciones intracomunitarias (si hay clientes UE) |
| **Modelo 390** | Resumen anual de IVA |
| **Facturación electrónica** | Obligatoria en relación con empresas (Ley Crea y Crece) |

### 6.2. Obligaciones laborales

| Obligación | Descripción |
|---|---|
| **Alta en RETA** | Régimen Especial de Trabajadores Autónomos |
| **Cotización** | Cuota mensual por tramos de ingresos reales |
| **Convenio aplicable** | En su caso, convenio de empresas de consultoría y desarrollo de software |
| **Prevención de riesgos laborales** | Evaluación de riesgos del puesto (trabajo con pantallas), formación |
| **Registro horario** | Obligatorio si hay personal contratado |

### 6.3. Protección de datos (RGPD / LOPDGDD)

- **Base jurídica** para el tratamiento: ejecución de contrato y consentimiento.
- **Registro de actividades de tratamiento** obligatorio.
- **Política de privacidad** accesible y en lenguaje claro.
- **Derechos del interesado** (acceso, rectificación, supresión, portabilidad).
- **Encargados de tratamiento:** contrato con el proveedor de hosting.
- **Medidas de seguridad:** cifrado en tránsito (TLS), control de acceso, copias de respaldo.

### 6.4. Ley de cookies y LSSI

- **Banner de consentimiento** previo, con opción de rechazo tan accesible como de aceptación.
- **Política de cookies** detallada por finalidad (técnicas, analíticas, publicitarias).
- **No cargar cookies no esenciales** antes del consentimiento.
- **Datos identificativos del prestador** en el aviso legal (LSSI art. 10).

### 6.5. Normativa turística específica

- **Registro de Viviendas de Uso Turístico de Andalucía** (Decreto 28/2016): obligación de
  inscripción y exhibición del número de registro.
- **Normativa municipal de Tarifa** sobre usos turísticos y ocupación de vía pública.

---

## 7. Ayudas y subvenciones

| Organismo | Línea | Finalidad |
|---|---|---|
| **Junta de Andalucía (TRADE)** | Programa de digitalización de pymes | Financiación de soluciones digitales |
| **Junta de Andalucía** | Kit Digital | Ayudas para implantación de soluciones digitales |
| **Diputación de Cádiz (IEDT)** | Emprendimiento turístico | Apoyo a proyectos de innovación en turismo |
| **CDTI** | Ayudas Neotec | Financiación de proyectos empresariales innovadores |
| **ENISA** | Préstamos participativos | Capital para startups en fase temprana |
| **Cámara de Comercio de Cádiz** | Programas de internacionalización | Apoyo a la salida al exterior |
| **Fondos Next Generation EU** | Componente 14 (turismo sostenible) | Modernización del sector turístico |

**Aplicabilidad al proyecto:** las líneas de digitalización (TRADE, Kit Digital) son las más
accesibles para una micropyme; las de CDTI/ENISA requieren una estructura societaria que el
proyecto aún no tiene.

---

## 8. Conclusiones

1. **El sector está dominado por plataformas globales**, pero su escala les impide atender
   necesidades hiperlocales como la normalización de precios en un destino concreto. Ese es
   el hueco real.
2. **La mayoría del inventario de Tarifa son micropymes y autónomos**, lo que reduce la
   barrera de entrada: no hay que negociar con grandes cadenas.
3. **Las funcionalidades básicas están cubiertas**, por lo que la diferenciación debe venir
   del desglose de precio y de la agregación de valoraciones, no de añadir más filtros.
4. **La carga normativa es asumible para un autónomo**, pero exige rigor desde el primer día
   en RGPD y en la ley de cookies, ya que se tratan datos de usuarios y de reservas.
5. **El coste de operación es mínimo** (72 €/año), lo que permite iterar sin presión
   financiera mientras se valida el producto.

**Veredicto:** el proyecto es viable técnicamente con los recursos del ciclo, tiene un mercado
identificable y una propuesta diferencial concreta. Se recomienda su aprobación para iniciar
la fase de análisis y diseño.

---

*Documento elaborado para la Unidad 1, Hito 1 del módulo Proyecto Intermodular de Desarrollo
de Aplicaciones Web — I.E.S. Kursaal.*
