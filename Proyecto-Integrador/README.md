# DAWConnect 🎯

**Proyecto Integrador de 1º DAW** — Sistema de Gestión Académica

## 📋 Descripción

DAWConnect es una plataforma web integral que gestiona el ciclo formativo de Desarrollo de Aplicaciones Web. Combina todos los conocimientos adquiridos en el primer curso del CFGS DAW:

- **Programación**: Lógica backend en Java con POO, colecciones, excepciones, serialización
- **Bases de Datos**: Modelo relacional, SQL, joins, restricciones
- **Lenguajes de Marcas**: HTML5 semántico, CSS3 moderno (Flexbox/Grid), XML, XSLT
- **Entornos de Desarrollo**: Git, control de versiones, testing, documentación técnica
- **Sistemas Informáticos**: Estructura cliente-servidor, manejo de ficheros
- **IPE**: Módulo de empresa, departamentos, roles
- **Digitalización**: Herramientas digitales, automatización
- **Sostenibilidad**: Módulo de impacto ambiental y buenas prácticas

## 🏗️ Arquitectura

```
DAWConnect/
├── backend/              # Lógica Java (POO, colecciones, excepciones)
│   └── src/main/java/
│       └── com/dawconnect/
│           ├── model/    # Clases del dominio
│           ├── dao/      # Acceso a datos (JDBC + SQL)
│           ├── service/  # Lógica de negocio
│           ├── exception/# Excepciones personalizadas
│           └── util/     # Validadores, helpers
├── frontend/             # HTML5 + CSS3 + JS (LMSGI)
│   ├── index.html        # Página principal
│   ├── css/              # Estilos (Flexbox, Grid, responsive)
│   ├── js/               # Lógica frontend
│   └── pages/            # Páginas secundarias
├── bbdd/                 # Esquema SQL + scripts
│   └── schema.sql        # Creación de BBDD
├── docs/                 # Documentación y memorias
│   ├── MEMORIA.md        # Memoria técnica completa
│   ├── UML.md            # Diagramas UML
│   └── manual-usuario.md # Guía de uso
└── testing/              # Pruebas unitarias (JUnit)
```

## 🚀 Cómo ejecutar

### Requisitos
- Java 21+
- Navegador web moderno

### Compilar y ejecutar backend
```bash
cd backend
./build.sh        # Compila todo
./run.sh          # Ejecuta la aplicación
```

### Ver frontend
Abrir `frontend/index.html` en un navegador.

## 📚 Asignaturas aplicadas

| Asignatura | Implementación |
|------------|---------------|
| **Programación** | Clases Java, herencia, interfaces, colecciones, excepciones, serialización |
| **BBDD** | Modelo ER, SQL DDL/DML, joins, scripts |
| **LMSGI** | HTML5, CSS3 (Flexbox/Grid), XML, XSLT, responsive design |
| **ENDES** | Git, JUnit testing, diagramas UML, control de versiones |
| **Sistemas** | Sistema de ficheros, streams, estructura cliente-servidor |
| **IPE** | Módulo empresarial: departamentos, roles, gestión |
| **Digitalización** | Automatización, herramientas digitales |
| **Sostenibilidad** | Buenas prácticas, eficiencia, documentación |

## 👤 Autor
Raúl Sal — 1º DAW, IES ...
