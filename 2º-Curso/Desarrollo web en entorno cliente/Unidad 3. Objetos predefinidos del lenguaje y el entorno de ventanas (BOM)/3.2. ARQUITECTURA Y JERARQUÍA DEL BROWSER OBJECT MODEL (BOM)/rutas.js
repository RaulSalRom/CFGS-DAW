const vista = document.getElementById("vista");

// Función encargada de actualizar la pantalla según el estado
function actualizarPantalla(estado) {
  if (!estado || estado.seccion === "inicio") {
    vista.textContent = "Estás en: Inicio";
  } else if (estado.seccion === "perfil") {
    vista.textContent = "Estás en: Perfil del usuario" +
      (estado.filtro ? ` (Filtro: ${estado.filtro})` : "");
  }
}

function estadoDesdeUrl() {
  const parametros = new URLSearchParams(location.search);
  const seccion = parametros.get("seccion");
  if (seccion === "perfil") {
    return {
      seccion: "perfil",
      filtro: parametros.get("filtro") || undefined
    };
  }
  return { seccion: "inicio" };
}

// 1. pushState: Navega a Inicio creando una nueva entrada en el historial
document.getElementById("btn-inicio").addEventListener("click", () => {
  const estado = { seccion: "inicio" };
  history.pushState(estado, "", "?seccion=inicio");
  actualizarPantalla(estado);
});

// 1. pushState: Navega a Perfil creando otra entrada en el historial
document.getElementById("btn-perfil").addEventListener("click", () => {
  const estado = { seccion: "perfil" };
  history.pushState(estado, "", "?seccion=perfil");
  actualizarPantalla(estado);
});

// 2. replaceState: Modifica la URL y el estado actual SIN añadir entradas a la pila
document.getElementById("btn-filtro").addEventListener("click", () => {
  const estadoModificado = { seccion: "perfil", filtro: "activos" };
  history.replaceState(estadoModificado, "", "?seccion=perfil&filtro=activos");
  actualizarPantalla(estadoModificado);
});

// 3. onpopstate: Se activa cuando el usuario pulsa Atrás o Adelante en el navegador
window.onpopstate = (event) => {
  actualizarPantalla(event.state || estadoDesdeUrl());
};

actualizarPantalla(estadoDesdeUrl());