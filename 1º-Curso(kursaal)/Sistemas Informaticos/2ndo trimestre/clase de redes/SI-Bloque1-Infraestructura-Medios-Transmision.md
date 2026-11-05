# SI · Bloque 1 — Infraestructura y Medios de Transmisión (Nivel Inicial)

> 🏠 [[📚 Indice General]] ▸ [[Sistemas Informaticos|Sistemas Informáticos]] │ 📄 Fuente: `Bloque 1 Infraestructura y Medios de Transmisión (Nivel Inicial).pdf` │ ➡️ [[SI-Tema3|Tema 3 · Redes]] · [[SI-Conexion-Gestion-Recursos-Red|Conexión y gestión de recursos en red]]

## 📝 Tarea Moodle: «El esqueleto de la red: Hardware y Conectividad»

**Objetivo:** identificar y explicar los componentes físicos de una red y cómo se conectan entre sí.

**Entregable extra:** presentación visual o vídeo-tutorial con un esquema de una red local (LAN) en el que se etiquete cada componente y el medio utilizado.

---

## 1. Dispositivos finales e intermedios

| Tipo | Función | Ejemplos |
|---|---|---|
| **Dispositivos finales (hosts)** | Origen o destino de los datos. | PC, portátil, servidor, impresora, móvil |
| **Dispositivos intermedios** | Conectan, dirigen o filtran el tráfico. | Switch, router, punto de acceso, firewall |

### Qué hace cada intermedio

- **Switch:** conecta equipos dentro de la misma LAN y reenvía tramas según la dirección MAC.
- **Router:** une redes distintas y decide por dónde enviar los paquetes (encaminamiento).
- **Punto de acceso (AP):** da acceso inalámbrico a la red cableada.
- **Firewall:** filtra el tráfico entrante y saliente según reglas de seguridad.

---

## 2. Medios guiados

### Par trenzado

| Tipo | Descripción |
|---|---|
| **UTP** (*Unshielded Twisted Pair*) | Sin apantallamiento. El más habitual y económico. |
| **STP** (*Shielded Twisted Pair*) | Apantallado individual o global; mejor protección frente a interferencias. |
| **FTP** (*Foiled Twisted Pair*) | Lámina metálica global; intermedio entre UTP y STP. |

### Estándares de crimpado

- **T568A** y **T568B**: orden de los hilos en el conector RJ45.
- Un cable **directo** usa el mismo estándar en ambos extremos.
- Un cable **cruzado** usa T568A en un extremo y T568B en el otro.

### Fibra óptica

| Tipo | Característica |
|---|---|
| **Monomodo** | Un solo haz de luz, larga distancia y mayor ancho de banda. |
| **Multimodo** | Varios haces, distancias más cortas y menor coste. |

---

## 3. Topologías físicas

| Topología | Ventajas | Inconvenientes |
|---|---|---|
| **Estrella** | Fácil de gestionar; un fallo de un equipo no tumba la red. | Depende del nodo central (switch). |
| **Malla** | Alta redundancia y tolerancia a fallos. | Mucho cableado y coste. |
| **Árbol** | Jerárquica y escalable por niveles. | Si falla un nivel superior, afecta a los inferiores. |
| **Bus** | Sencilla y económica. | Un fallo en el bus afecta a toda la red; colisiones. |

---

## 4. Esquema para el entregable

Incluye al menos:

1. **Hosts:** PC de aula, servidor, impresora.
2. **Intermedios:** switch, router, punto de acceso y firewall.
3. **Medios:** cable UTP cat. 6 con conectores RJ45 y, si procede, fibra óptica.
4. **Etiquetas:** nombre del dispositivo, medio y topología empleada.

---

## 🔗 Relacionado
- [[Sistemas Informaticos|Sistemas Informáticos (Índice)]]
- [[SI-Tema3|Tema 3 · Redes]]
- [[SI-Conexion-Gestion-Recursos-Red|Conexión y gestión de recursos en red]]
- [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web]]

🏷️ #si #redes #infraestructura #hardware #1daw
