const ERROR_MES = "Mes incorrecto";

function primerLunesUltimoDomingo(año, mes) {
  // Escribe aquí tu código
  let fecha = new Date(año, mes);
  console.log(fecha);

  let lunes = fecha.setDate(0);
  console.log("Lunes: " + lunes.getDay());
  let domingo = fecha.setDate(-1);
  console.log("Domingo: " + domingo.getDay());

  // return { primerLunes: , ultimoDomingo: domingo.getDay() };
}
