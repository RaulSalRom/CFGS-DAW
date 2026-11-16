<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Viviendas</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Insertar vivienda</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <form action="insertarVivienda.php" method="post">

          <div class="mb-3">
            <label for="tipo" class="form-label">Tipo de vivienda</label>
            <select class="form-select" id="tipo" name="tipo">
              <option value="">Selecciona un tipo</option>
              <option value="Adosado">Adosado</option>
              <option value="Unifamiliar">Unifamiliar</option>
              <option value="Piso">Piso</option>
            </select>
          </div>

          <div class="mb-3">
            <label for="zona" class="form-label">Zona</label>
            <select class="form-select" id="zona" name="zona">
              <option value="Centro">Centro</option>
              <option value="Norte">Norte</option>
              <option value="Sur">Sur</option>
              <option value="Este">Este</option>
              <option value="Oeste">Oeste</option>
            </select>
          </div>

          <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion">
          </div>

          <div class="mb-3">
            <label for="habitaciones" class="form-label">Habitaciones</label>
            <input type="number" class="form-control" id="habitaciones" name="habitaciones" min="1">
          </div>

          <div class="mb-3">
            <label for="precio" class="form-label">Precio (€)</label>
            <input type="number" class="form-control" id="precio" name="precio" step="0.01" min="0">
          </div>

          <fieldset class="mb-3">
            <legend class="form-label fs-6">Extras</legend>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="garage" name="extras[]" value="Garaje">
              <label class="form-check-label" for="garage">Garaje</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="trastero" name="extras[]" value="Trastero">
              <label class="form-check-label" for="trastero">Trastero</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="piscina" name="extras[]" value="Piscina">
              <label class="form-check-label" for="piscina">Piscina</label>
            </div>
          </fieldset>

          <div class="mb-3">
            <label for="observaciones" class="form-label">Observaciones</label>
            <textarea class="form-control" id="observaciones" name="observaciones" rows="3"></textarea>
          </div>

          <button type="submit" class="btn btn-primary">Guardar vivienda</button>

        </form>
      </div>
    </div>

  </main>

</body>
</html>
