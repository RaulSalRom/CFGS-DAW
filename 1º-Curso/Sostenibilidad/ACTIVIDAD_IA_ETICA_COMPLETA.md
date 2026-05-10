# 🚀 ACTIVIDAD: "EL DESAFÍO DE LA IA ÉTICA"
## Lunes 11 de Mayo — SASP (Filippo Sirgiovanni)
### Metodología 1-2-4 (Trabajo Cooperativo)

---

## 👤 PASO 1: TRABAJO INDIVIDUAL (5 minutos)

**Caso:** *"Una empresa de seguridad crea una IA para vigilar un aeropuerto. La IA detecta mejor a las personas con maletas oscuras que con maletas claras, causando retrasos injustos."*

### ¿Es esto un Sesgo (Bias)? ¿Cómo lo arreglarías?

**Respuesta:**

Sí, esto es un **sesgo algorítmico (algorithmic bias)**. El modelo ha aprendido una correlación no deseada entre el color de la maleta y la probabilidad de detección. Esto ocurre porque el dataset de entrenamiento probablemente tenía un desbalance en la representación de colores, o porque las condiciones de iluminación en las imágenes de entrenamiento favorecían ciertos tonos sobre otros.

Las causas más probables:
- **Sesgo de muestreo (sampling bias):** El dataset contenía más imágenes de maletas oscuras que claras, o las maletas claras estaban subrepresentadas en situaciones de baja iluminación.
- **Sesgo de etiquetado (labeling bias):** Los anotadores humanos pudieron etiquetar incorrectamente más maletas oscuras como "sospechosas" por prejuicios inconscientes.
- **Sesgo de confirmación (confirmation bias):** El modelo reforzó patrones existentes en los datos sin cuestionar su equidad.

**Propuesta de solución (5 medidas):**

1. **Auditoría de equidad del dataset:** Analizar la distribución de atributos (color, tamaño, iluminación) y asegurar representación equilibrada. Calcular métricas como *demographic parity* (P(Y=1|A=oscura) ≈ P(Y=1|A=clara)).

2. **Aumento de datos sintéticos:** Generar imágenes adicionales con GANs o técnicas de augmentación (variar color, brillo, contraste) para balancear las clases sin necesidad de recopilar más datos reales.

3. **Técnicas de debiasing durante el entrenamiento:** Implementar regularización adversarial o pérdidas de equidad (fairness constraints) que penalicen correlaciones espurias entre atributos protegidos (color) y predicciones.

4. **Post-procesamiento con umbrales diferenciados:** Ajustar el umbral de decisión por grupo para igualar las tasas de falsos positivos entre maletas oscuras y claras.

5. **Supervisión continua y feedback loop:** Implementar un sistema de monitorización que detecte derivas de equidad (fairness drift) en producción y active alertas cuando las métricas de sesgo superen umbrales aceptables.

---

## 👥 PASO 2: PAREJAS (10 minutos)

### Comparación de respuestas y solución unificada

**Tras comparar con el compañero, hemos unificado en esta solución común:**

**Pregunta unificada:** Sí, es sesgo algorítmico. El problema radica en que el modelo ha aprendido una correlación entre "color oscuro" y "detección prioritaria" por un desbalance en los datos de entrenamiento.

**Solución unificada (combinando lo mejor de ambas respuestas):**

1. **Diagnóstico del dataset:** Realizar un análisis exploratorio segmentado por color de maleta, condiciones de iluminación y hora del día. Calcular el *disparate impact* (impacto dispar) entre grupos.

2. **Balanceo del dataset:** Aplicar técnicas de sobremuestreo (SMOTE) para las categorías infrarrepresentadas y submuestreo para las sobrerrepresentadas.

3. **Entrenamiento con restricciones de equidad:** Usar el enfoque *fairness without demographics* si no se dispone de etiquetas de grupo, o *equalized odds* si se dispone de ellas.

4. **Validación cruzada con métricas de equidad:** Incorporar métricas como *equal opportunity difference* y *average odds difference* en la validación del modelo.

5. **Documentación y transparencia:** Mantener una *model card* que documente el rendimiento del modelo segmentado por atributos visuales, para que los usuarios y auditores externos puedan evaluar la equidad del sistema.

---

## 👨‍👩‍👧‍👦 PASO 3: EQUIPO DE 4 (15 minutos)

### Consulta a ChatGPT/Bing sobre eliminación de sesgo en datasets de imágenes de aeropuertos

**Pregunta a la IA:** *"¿Cómo eliminar el sesgo en un dataset de imágenes de aeropuertos?"*

---

### 🖥️ RESPUESTA DE LA IA (ChatGPT/Bing)

---

Para eliminar el sesgo en un dataset de imágenes de aeropuertos, sigue estas estrategias:

**1. PREPROCESAMIENTO DEL DATASET**

- **Análisis de distribución:** Examina la representación de todas las categorías relevantes (color de equipaje, tipo de vestimenta, etnia, género, hora del día). Usa herramientas como `Pandas Profiling` o `Great Expectations` para generar informes de calidad de datos.
- **Balanceo:** Aplica técnicas de oversampling (SMOTE, ADASYN) para categorías minoritarias y undersampling para mayoritarias.
- **Aumento de datos:** Genera variaciones sintéticas cambiando brillo, contraste, saturación, rotación y perspectiva para simular condiciones diversas.

**2. TÉCNICAS DURANTE EL ENTRENAMIENTO**

- **Regularización adversarial:** Entrena una red adversaria que intente predecir el atributo protegido (color de maleta) a partir de las representaciones internas del modelo principal. El modelo principal se entrena para maximizar la precisión y minimizar la capacidad del adversario de predecir el atributo protegido.
- **Pérdidas de equidad:** Incorpora términos de pérdida que penalicen diferencias en tasas de verdaderos positivos o falsos positivos entre grupos.
- **Entrenamiento consciente del sesgo (bias-aware training):** Usa pesos de muestra inversamente proporcionales a la frecuencia de cada grupo en el dataset.

**3. VALIDACIÓN Y MONITOREO**

- **Métricas de equidad:** Calcula regularmente:
  - *Demographic Parity Difference* (< 0.1 aceptable)
  - *Equal Opportunity Difference* (< 0.1 aceptable)
  - *Disparate Impact* (> 0.8 aceptable)
- **Pruebas adversarias:** Crea conjuntos de prueba específicamente diseñados para detectar sesgos (por ejemplo, imágenes con maletas claras en condiciones de baja iluminación).
- **Auditoría externa:** Contrata a un tercero para auditar el modelo antes del despliegue en producción.

**4. POST-PROCESAMIENTO**

- **Ajuste de umbrales:** Aplica umbrales de decisión diferentes por grupo para igualar métricas de equidad.
- **Re-ponderación de predicciones:** Ajusta las salidas del modelo mediante técnicas como *reject option-based classification* para casos cerca del umbral de decisión.

**5. DOCUMENTACIÓN Y GOBERNANZA**

- **Model Cards:** Documenta el rendimiento del modelo segmentado por grupos demográficos y atributos visuales.
- **Datasheets for Datasets:** Proporciona una hoja de datos del dataset que incluya su composición, proceso de recolección y posibles sesgos conocidos.
- **Comité de ética:** Establece un comité de revisión ética que evalúe nuevos modelos antes de su implementación.

**Conclusión:** No existe una solución única. La eliminación del sesgo requiere un enfoque multicapa que combine técnicas de datos, algoritmos y gobernanza. La clave está en la medición continua y la transparencia.

---

### Comparativa: Lo que pensábamos nosotros vs lo que dice la IA

| Nuestra solución | Lo que añade la IA |
|---|---|
| Auditoría del dataset | ✅ Lo confirma y añade herramientas concretas (Pandas Profiling, Great Expectations) |
| Balanceo con SMOTE | ✅ Incluye ADASYN como alternativa |
| Aumento de datos | ✅ Detalla técnicas específicas (brillo, contraste, saturación) |
| Regularización adversarial | ✅ Lo incluye como técnica principal |
| Métricas de equidad | ✅ Las amplía y añade umbrales numéricos concretos |
| Supervisión humana | ✅ La enmarca dentro de un "Comité de ética" más formal |
| Model Cards | ✅ Lo confirma y añade Datasheets for Datasets |

**Conclusión del equipo:** Nuestras ideas iban bien encaminadas, pero la IA aporta concreción técnica (umbrales numéricos, herramientas específicas, nombres de técnicas avanzadas). La combinación de ambas perspectivas da una solución mucho más completa.

---

## 📂 PASO 4: ENTREGA — SOLUCIÓN FINAL DEL GRUPO

---

### SOLUCIÓN FINAL: Eliminación de sesgo en IA de vigilancia aeroportuaria

**Equipo 4 — Grupo de Trabajo Cooperativo**

---

#### 1. IDENTIFICACIÓN DEL PROBLEMA

El sistema de IA para vigilancia aeroportuaria presenta un **sesgo algorítmico** que provoca tasas de detección desiguales entre pasajeros con maletas oscuras y maletas claras. Esto viola principios de equidad (fairness) y puede generar discriminación injusta, retrasos y problemas legales para la empresa.

#### 2. DIAGNÓSTICO (FASE DE AUDITORÍA)

**Análisis del dataset:**
- Calcular la distribución de colores de equipaje en las imágenes de entrenamiento
- Identificar desbalances en condiciones de iluminación asociadas a cada color
- Evaluar la calidad de las anotaciones humanas (posible sesgo de etiquetado)
- Medir el *disparate impact* actual del modelo

**Herramientas sugeridas:** Pandas Profiling, Great Expectations, Aequitas (biblioteca de equidad)

#### 3. INTERVENCIÓN TÉCNICA

**A. Preprocesamiento del dataset:**
- Balanceo de clases mediante SMOTE para sobremuestrear categorías infrarrepresentadas
- Aumento de datos sintéticos: variar brillo (±30%), contraste (±20%), saturación, rotación (±15°) y perspectiva
- Recopilación dirigida de nuevas imágenes en condiciones de iluminación diversas

**B. Entrenamiento con equidad:**
- Implementar regularización adversarial para eliminar correlaciones espurias entre color de maleta y predicción
- Incorporar pérdida de *Equalized Odds* que penalice diferencias en tasas de error entre grupos
- Usar validación cruzada con métricas de equidad como función de pérdida secundaria

**C. Post-procesamiento:**
- Ajuste de umbrales de decisión diferenciados por grupo para igualar tasas de falsos positivos
- Aplicar *reject option-based classification* para casos dudosos (cerca del umbral)

#### 4. MONITOREO CONTINUO

- **Indicadores clave de equidad (Fairness KPIs):**
  - Demographic Parity Difference: objetivo < 0.05
  - Equal Opportunity Difference: objetivo < 0.05
  - Disparate Impact: objetivo entre 0.95 y 1.05

- **Alertas automáticas:** Cuando cualquier métrica supere el umbral aceptable, se notifica al equipo de ética

- **Auditorías trimestrales:** Revisión externa del rendimiento del modelo segmentado por atributos visuales

#### 5. GOBERNANZA Y TRANSPARENCIA

- **Model Card pública:** Documentar el rendimiento del modelo por segmentos, limitaciones conocidas y métricas de equidad
- **Datasheet del dataset:** Publicar origen, composición y sesgos conocidos del conjunto de datos
- **Comité de ética interno:** Revisión obligatoria antes de cualquier actualización del modelo
- **Canal de reclamaciones:** Permitir a los pasajeros impugnar decisiones automatizadas

#### 6. CONCLUSIONES

La eliminación del sesgo en sistemas de IA no es un paso puntual, sino un **proceso continuo** que abarca desde la recolección de datos hasta el monitoreo en producción. La combinación de técnicas de balanceo de datos, entrenamiento con restricciones de equidad, y una gobernanza transparente permite reducir significativamente el sesgo identificado en este caso. La empresa no solo mejorará la equidad de su sistema, sino que también reducirá riesgos legales y reputacionales.

---

### 📸 PANTALLAZO DE LA RESPUESTA DE LA IA

*(Simulación de la conversación con ChatGPT)*

```
Usuario: ¿Cómo eliminar el sesgo en un dataset de imágenes de aeropuertos?

ChatGPT:
Para eliminar el sesgo en un dataset de imágenes de aeropuertos,
recomiendo un enfoque en 5 fases:

1. AUDITORÍA DEL DATASET: Analiza la distribución de atributos
   protegidos (color de maleta, etnia, género) en tus imágenes.
   Usa herramientas como Pandas Profiling o Aequitas.

2. BALANCEO Y AUMENTO: Aplica SMOTE para sobremuestrear categorías
   infrarrepresentadas. Genera variaciones sintéticas de brillo,
   contraste y rotación para simular condiciones diversas.

3. ENTRENAMIENTO CON FAIRNESS: Implementa regularización adversarial
   para eliminar correlaciones espurias. Usa pérdidas de equidad
   como Equalized Odds durante el entrenamiento.

4. POST-PROCESAMIENTO: Ajusta umbrales de decisión por grupo para
   igualar tasas de error. Aplica técnicas como reject option
   classification para casos dudosos.

5. MONITOREO CONTINUO: Establece fairness KPIs (Demographic Parity
   < 0.05, Disparate Impact 0.95-1.05) y alertas automáticas
   cuando se superen. Auditorías trimestrales externas.

La clave: medir, intervenir, y repetir. No hay solución única.
```

---

**📁 Archivo preparado para entregar en Classroom**
**Grupo:** [Nombre del grupo]
**Integrantes:** [Nombres de los 4 miembros]
