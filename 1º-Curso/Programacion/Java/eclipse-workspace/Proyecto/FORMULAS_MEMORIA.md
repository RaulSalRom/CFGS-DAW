# Fórmulas del Proyecto - Liga eSports

Documentación de todas las fórmulas utilizadas en el proyecto para la memoria técnica.

---

## 1. Cálculo de Rendimiento de Jugador

### Fórmula
```
calcularRendimiento() = (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2)
```

### Explicación
- **nivelMecanicas (40%)**: Tiene el mayor peso porque en eSports la habilidad mecánica (velocidad de reacción, precisión, control) es fundamental para ganar partidas.
- **nivelEstrategia (30%)**: La capacidad táctica y toma de decisiones aporta un tercio del rendimiento, siendo clave para situaciones complejas.
- **partidasJugadas (2% por partida)**: Representa la experiencia acumulada. Cuantas más partidas tiene, más situaciones ha vivido, aunque con peso menor para no penalizar a jugadores nuevos.
- **mvpTotales (peso 2)**: Los MVP (Most Valuable Player) indican excelencia individual. Tener varios MVP demuestra que el jugador puede carrilear partidas.

### Por qué se eligió
Se buscó un equilibrio entre habilidad actual (mecánicas/estrategia) y track record (partidas/MVP). El peso mayoritario va a las habilidades porque son lo que determina el rendimiento inmediato.

---

## 2. Cálculo de Coste Mensual de Jugador

### Fórmula
```
calcularCosteMensual() = salarioBase + (mvpTotales * 200)
```

### Explicación
- **salarioBase**: Cantidad fija acordada en el contrato, independiente del rendimiento.
- **mvpTotales * 200**: Bonus por méritos individuales. Cada MVP suma 200€ al coste mensual.

### Por qué se eligió
Los jugadores con más MVP son más demandados y valiosos para el equipo, por lo que su coste de mantenimiento es mayor. Refleja un sistema de incentivos por rendimiento individual.

---

## 3. Cálculo de Rendimiento de Entrenador

### Fórmula
```
calcularRendimiento() = (añosExperiencia * 2) + (victoriasTotales * 1.5)
```

### Explicación
- **añosExperiencia (peso 2)**: La experiencia aporta consistencia y capacidad de adaptación a diferentes metas del juego.
- **victoriasTotales (peso 1.5)**: Es el indicador real de éxito. Un entrenador se evalúa por sus victorias conseguidas a lo largo de su carrera.

### Por qué se eligió
A diferencia del jugador, al entrenador se le valora más la experiencia que las victorias puras, porque un buen entrenador no solo gana, sino que sabe gestionar equipos a largo plazo.

---

## 4. Cálculo de Coste Mensual de Entrenador

### Fórmula
```
calcularCosteMensual() = salarioBase + (victoriasTotales * 150)
```

### Explicación
- **salarioBase**: Pago fijo mensual.
- **victoriasTotales * 150**: Bonus por éxito conseguido. Cada victoria suma 150€ al coste.

### Por qué se eligió
Similar al jugador, pero con menor bonus por victoria (150€ vs 200€) porque el impacto directo en el resultado del partido es menor que el del jugador.

---

## 5. Precio de Fichaje de un Jugador

### Fórmula
```
precioFichaje = jugador.calcularRendimiento() * 100 + jugador.getSalarioBase() * 3
```

### Explicación
- **calcularRendimiento() * 100**: El rendimiento actual del jugador se multiplica por 100 para obtener el valor base de mercado.
- **salarioBase * 3**: El equipo comprador debe pagar el equivalente a 3 meses de salario como "comisión de fichaje".

### Por qué se eligió
El precio refleja tanto el valor deportivo actual (rendimiento) como el coste futuro que asumirá el equipo comprador (salario). Esto evita que equipos con poco presupuesto fichen jugadores muy caros.

---

## 6. Simulación de Partidos

### Fórmula del Rendimiento del Equipo
```
rendimientoEquipo = (suma de jugador.calcularRendimiento() * 0.8) + (entrenador.calcularRendimiento() * 0.2)
```

### Explicación
- **Jugadores (80%)**: Los jugadores son quienes juegan y determinan el resultado. Su rendimiento individual pesa más.
- **Entrenador (20%)**: Aporta estrategia y preparación, pero no juega directamente.

### Factor Aleatorio
```
factorAleatorio = 0.8 + Math.random() * 0.4   (rango: 0.8 a 1.2)
resultado = (int) (rendimientoEquipo * factorAleatorio)
```

### Por qué se eligió
El factor aleatorio simula la variabilidad real de los eSports: un equipo puede jugar por debajo de su nivel o hacer una "puesta en escena" excepcional. El rango 0.8-1.2 (±20%) es realista.

---

## 7. Sistema de Puntos en Clasificación

### Fórmula
```
Victoria = 3 puntos
Empate = 1 punto
Derrota = 0 puntos
```

### Por qué se eligió
Es el sistema estándar de la mayoría de ligas deportivas del mundo (FIFA, UEFA, etc.). Premia la victoria con el triple de puntos que el empate para incentivar el juego ofensivo.

---

## 8. Cálculo de Diferencia de Puntos (Clasificación)

### Fórmula
```
diferenciaPuntos = puntosAFavor - puntosEnContra
```

### Por qué se eligió
La diferencia de puntos es el primer criterio de desempate en caso de que dos equipos tengan los mismos puntos. Indica la solidez defensiva y ofensiva del equipo.

---

## 9. Entrenamiento de Jugador

### Fórmula
```
nivelMecanicas += random(1, 5)
nivelEstrategia += random(1, 5)
Tope máximo: 100
```

### Por qué se eligió
El entrenamiento mejora gradualmente las habilidades (entre 1 y 5 puntos). Se limita a 100 porque representa el máximo nivel humano posible en el juego.

---

## 10. Ordenación de Clasificación Final

### Criterio (orden de prioridad)
1. **Número de victorias** (mayor a menor)
2. **Diferencia de puntos** (mayor a menor)
3. **Nombre del equipo** (alfabético A-Z)

### Por qué se eligió
Se priorizan las victorias porque es el objetivo principal. Si hay empate, la diferencia de puntos indica quién tuvo mejor rendimiento global. El nombre es el desempate final para garantizar orden determinista.

---

## 11. Buenas Prácticas en Métodos de Salida (toString)

### Uso de Getters en toString

En los métodos `toString()` de todas las clases se utilizan los **getters** en lugar de acceder directamente a los atributos.

**Ejemplo en Jugador.java:**
```java
@Override
public String toString() {
    return "Jugador{" +
            "id='" + getIdentificador() + '\'' +   // Getter de PersonaLiga
            ", nombre='" + getNombre() + '\'' +     // Getter de PersonaLiga
            ", rol='" + getRol() + '\'' +          // Getter de Jugador
            ...
            '}';
}
```

### Por qué se utiliza getters en lugar de campos directos

1. **Encapsulamiento**: Los getters pueden contener lógica adicional (lazy loading, validación, formateo) que no se ejecutaría si accedemos al campo directamente.
2. **Herencia**: `PersonaLiga` es clase abstracta. Al usar getters, si una subclase sobreescribe el getter, se ejecutará la versión correcta (polimorfismo).
3. **Mantenibilidad**: Si cambia la forma de calcular/almacenar un valor, solo hay que modificar el getter, no todos los `toString()`.
4. **Consistencia**: Misma forma de acceder a datos en toda la aplicación.

---

## Resumen de Pesos y Constantes

| Concepto | Valor | Unidad |
|----------|-------|--------|
| Peso mecánicas en rendimiento jugador | 0.4 | proporción |
| Peso estrategia en rendimiento jugador | 0.3 | proporción |
| Peso experiencia en rendimiento entrenador | 2 | puntos por año |
| Peso victorias en rendimiento entrenador | 1.5 | puntos por victoria |
| Bonus MVP mensual (jugador) | 200€ | euros por MVP |
| Bonus victoria mensual (entrenador) | 150€ | euros por victoria |
| Multiplicador fichaje por rendimiento | 100 | euros por punto |
| Multiplicador fichaje por salario | 3 | meses de salario |
| Factor aleatorio partido (mín-máx) | 0.8 - 1.2 | proporción |
| Puntos por victoria | 3 | puntos |
| Puntos por empate | 1 | puntos |
| Tope máximo nivel jugador | 100 | nivel |

---

## 12. Excepciones Personalizadas

### Por qué creamos excepciones personalizadas

Las excepciones estándar de Java (`NullPointerException`, `IllegalArgumentException`, etc.) no describen con precisión los errores de dominio de nuestra liga de eSports. Las excepciones personalizadas permiten:

1. **Semántica clara**: `JugadorSancionadoException` indica exactamente qué falló, en lugar de un genérico.
2. **Mensajes específicos**: Cada excepción incluye información contextual (nombre del equipo, presupuesto, etc.).
3. **Control de flujo**: Permite capturar errores específicos del dominio y tratarlos de forma diferente.
4. **Documentación**: El código se auto-documenta al ver qué excepciones puede lanzar cada método.

### Lista de excepciones y cuándo se lanzan

| Excepción | Cuándo se lanza | Ejemplo de mensaje |
|-----------|-----------------|-------------------|
| `PresupuestoExcedidoException` | Precio fichaje > presupuesto equipo | "El equipo X no tiene presupuesto suficiente. Presupuesto: 1000€, Coste: 1500€" |
| `JugadorSancionadoException` | Alinear jugador sancionado | "El jugador Y está sancionado y no puede jugar." |
| `EquipoNoEncontradoException` | Buscar equipo inexistente | "No se ha encontrado ningún equipo con el nombre Z." |
| `DatoInvalidoException` | Edad < 16, salario <= 0, email inválido | "El campo edad tiene un valor inválido: 15" |
| `NombreDuplicadoException` | Crear equipo/jugador duplicado | "Ya existe un equipo con el nombre A." |

### Jerarquía

Todas extienden `Exception` (son excepciones chequeadas), lo que obliga al programador a manejarlas con try-catch o declararlas en la firma del método. Esto es intencional para forzar el manejo de errores en una aplicación de gestión.

---

## 13. Valor en Mercado (Dinámico)

### Concepto

Cada persona (`Jugador` y `Entrenador`) tiene un **valor en mercado** que varía según su desempeño en los partidos a lo largo de la temporada.

### Por qué es dinámico

A diferencia de un valor fijo, el mercado refleja el estado actual del jugador:
- Si rinde bien y suma MVPs → su valor sube
- Si no juega o pierde partidos → su valor baja
- Es un sistema realista de valoración de activos

### Implementación en Jugador

```java
// El valor se calcula dinámicamente basado en el rendimiento actual
public double getValorMercado() {
    return calcularRendimiento() * 100 + getSalarioBase() * 3;
}
```

Este valor se recalcula cada vez que se invoca, por lo que tras un partido donde el jugador:
- Suma `partidasJugadas++` → afecta a `calcularRendimiento()`
- Suma `mvpTotales++` → afecta a `calcularRendimiento()` y `calcularCosteMensual()`

Su valor en mercado cambia automáticamente sin necesidad de actualizar un campo manualmente.

### Implementación en Entrenador (pendiente)

Se añadirá un método similar basado en `calcularRendimiento()` del entrenador.

---

| Tope máximo nivel jugador | 100 | nivel |
