// Formato h:mm am|pm (ej. 8:12 pm, 12:15 am)
function comprobarHora(fechaHoraStr) {
  // Escribe aquí tu código
  let expresion = /^(([0]?[1-9])|([1]?[1-2])):([0-5][0-9])\s(am|pm)$/;
  return expresion.test(fechaHoraStr);
}
