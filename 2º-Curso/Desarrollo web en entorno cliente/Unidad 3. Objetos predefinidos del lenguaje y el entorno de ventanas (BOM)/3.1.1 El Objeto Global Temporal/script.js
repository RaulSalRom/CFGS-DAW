// 1. Fecha base
const fechaPublicacionNotas = Temporal.PlainDate.from("2027-06-15");

// 2. Plazos legales (inmutabilidad)
const finAlegaciones = fechaPublicacionNotas.add({ days: 3 });      // 2027-06-18
const resolucionDefinitiva = finAlegaciones.add({ weeks: 2 });     // 2027-07-02

console.log(finAlegaciones.toString());
console.log(resolucionDefinitiva.toString());
console.log(fechaPublicacionNotas.toString() === "2027-06-15");    // true

// 3. Cuenta atrás
const hoy = Temporal.Now.plainDateISO();
const restante = hoy.until(fechaPublicacionNotas, { largestUnit: "months" });
console.log(`Faltan ${restante.months} meses y ${restante.days} días`);

// 4. Sincronización Madrid → Tokio
const aperturaMadrid = Temporal.ZonedDateTime.from({
   timeZone: "Europe/Madrid",
   year: 2027, month: 6, day: 15,
   hour: 9, minute: 0, second: 0
});
const aperturaTokio = aperturaMadrid.withTimeZone("Asia/Tokyo");

console.log(aperturaMadrid.toString()); // 2027-06-15T09:00:00+02:00[Europe/Madrid]
console.log(aperturaTokio.toString());  // 2027-06-15T16:00:00+09:00[Asia/Tokyo]