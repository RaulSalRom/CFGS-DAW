# ED-Tema1: Fases de Liberación

> Versiones y estados del software

## Ciclo de Liberación

| Fase | Descripción |
|------|-------------|
| **Pre-alpha** | Versiones de desarrollo iniciales, nightly builds |
| **Alpha** | Fase interna de pruebas (pre beta) |
| **Beta** | PMV (Producto Mínimo Viable), usuarios finales prueban |
| **RC** (Release Candidate) | Gamma, Delta - Versión candidato a definitiva |
| **RTM** | Release to Manufacturing/Marketing |
| **GA** | General Availability (disponibilidad general) |
| **Production/Gold** | Lanzamiento final en producción |

---

## Tipos de Versiones

### Por función
- **Major** (X.0.0): Cambios grandes, no compatible hacia atrás
- **Minor** (1.X.0): Nuevas funcionalidades compatibles
- **Patch** (1.0.X): Corrección de bugs

### Por entorno
- **Desarrollo**: Testing interno
- **Staging**: Pre-producción (similar a producción)
- **Producción**: Usuario final

---

## Gestión de Versiones

### Semantic Versioning (SemVer)
```
MAJOR.MINOR.PATCH
1.2.3
  └─ Patch: Bug fixes compatibles
    └─ Minor: Nuevas funcionalidades compatibles
      └─ Major: Cambios incompatibles
```

### Versiones prerelease
```
1.0.0-alpha.1
1.0.0-beta.2
1.0.0-rc.1
```

---

## 🔗 Relacionado
- [[ED-Tema3|Testing]]

---

🏷️ #entorno #tema1 #versiones #releases