# Actividad Propuesta 1.1 — ¿Qué es la programación reactiva?

Enunciado de la actividad (apartado G):
> *Averigua qué es la programación reactiva. Investiga cómo se comporta una hoja de cálculo
> cuando modificas una celda y las celdas dependientes se recalculan de inmediato.*

## 1. Qué es la programación reactiva

Según el apartado E (Vocabulario Técnico Fundamental) del tema:

> **Patrón reactivo:** Modelo de programación basado en **flujos de datos asíncronos** que
> **reacciona de forma automática propagando los cambios en la interfaz cuando el estado de
> los datos varía**.

Es decir, la interfaz no se escribe: **se deriva del estado de los datos**. El programador no
indica cómo actualizar cada elemento de la pantalla, sino que declara qué datos existen y qué
se muestra a partir de ellos; cuando esos datos cambian, la pantalla se actualiza sola.

## 2. La hoja de cálculo como modelo mental

La actividad pide observar qué ocurre en una hoja de cálculo al modificar una celda. Ese
comportamiento es exactamente el del patrón reactivo:

1. La hoja tiene **celdas de entrada** (las que escribe el usuario) y **celdas dependientes**
   (las que contienen fórmulas).
2. Al cambiar una celda de entrada, **no hay que reescribir a mano las fórmulas** de las
   celdas que dependen de ella.
3. La hoja **detecta sola** el cambio y **recalcula de inmediato** todas las celdas
   afectadas, propagando el nuevo valor en cascada.
4. El resultado es una pantalla **siempre coherente con los datos**, sin código de
   sincronización explícito.

| Hoja de cálculo | Aplicación web reactiva |
|---|---|
| Celda de entrada | Estado (`state`) del componente |
| Fórmula de una celda | Función que deriva un valor del estado |
| Celda dependiente | Elemento de la interfaz que muestra ese valor |
| Recálculo automático al cambiar una entrada | Propagación automática del cambio a la interfaz |
| El usuario solo escribe datos | El desarrollador solo declara qué se muestra |

## 3. El DOM Virtual hace que ese recálculo sea eficiente

El apartado D explica el problema: **manipular el DOM nativo es una operación lenta**, porque
obliga al motor a recalcular geometrías y repintar píxeles.

Para evitarlo, el framework guarda en la **memoria RAM una copia ligera del DOM** y, cuando
los datos cambian, **calcula las diferencias mínimas entre el DOM virtual y el real**
(reconciliación), **actualizando únicamente los nodos estrictamente necesarios**.

La hoja de cálculo también sabe de antemano qué celdas dependen de cuál, y por eso solo
recalcula esas. El DOM Virtual cumple esa misma función en la web.

Por eso van juntos: **el patrón reactivo decide *qué* debe cambiar; el DOM Virtual decide *cómo*
se cambia sin bloquear el navegador.**

## 4. Dónde aparece en los frameworks del tema

- **ReactJS:** cada componente gestiona su **propio estado interno**, de modo que un componente
  es, en la analogía, una mini hoja de cálculo que se recalcula cuando su estado cambia.
- **Angular:** el tema indica que exige dominar **programación reactiva con RxJS**, lo que
  confirma que es una pieza estructural de este framework.
- **Vue.js:** emplea también **DOM Virtual** para optimizar el renderizado.

---

*Elaborado exclusivamente a partir del tema 1.3 (apartados A, D y E).*
