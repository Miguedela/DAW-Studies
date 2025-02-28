let dias = [
  { id: 1, nombre: "L" },
  { id: 2, nombre: "M" },
  { id: 3, nombre: "X" },
  { id: 4, nombre: "J" },
  { id: 5, nombre: "V" },
];

let tramos = [
  { id: 1, hora: "8:00-9:00", descripcion: "1ª Hora" },
  { id: 2, hora: "9:00-10:00", descripcion: "2ª Hora" },
  { id: 3, hora: "10:00-11:00", descripcion: "3ª Hora" },
  { id: 4, hora: "11:00-11:30", descripcion: "RECREO" },
  { id: 5, hora: "11:30-12:30", descripcion: "4ª Hora" },
  { id: 6, hora: "12:30-13:30", descripcion: "5ª Hora" },
  { id: 7, hora: "13:30-14:30", descripcion: "6ª Hora" },
];

let asignaturas = [
  {
    id: 1,
    nombre: "",
    grupo: "",
    aula: "",
    color: "white",
  },
  {
    id: 2,
    nombre: "Música",
    grupo: "1º ESO A",
    aula: "Aula 6",
    color: "blue",
  },
  {
    id: 3,
    nombre: "Entorno Desarrollo",
    grupo: "1ºDAW",
    aula: "Aula 9C",
    color: "magenta",
  },
  {
    id: 4,
    nombre: "Comput. y robótica",
    grupo: "1ºESO D",
    aula: "Aula 10A",
    color: "cyan",
  },
  {
    id: 5,
    nombre: "Comput. y robótica",
    grupo: "1ºESO B",
    aula: "Aula VII",
    color: "yellow",
  },
  {
    id: 6,
    nombre: "Despl. Aplic. Web",
    grupo: "2ºDAW",
    aula: "Aula 10B",
    color: "green",
  },
  {
    id: 7,
    nombre: "Guardia Mant.",
    grupo: "",
    aula: "Taller Informática",
    color: "SteelBlue",
  },
  {
    id: 8,
    nombre: "Música",
    grupo: "1º ESO B",
    aula: "Aula 7",
    color: "brown",
  },
  {
    id: 9,
    nombre: "RECREO",
    grupo: "",
    aula: "",
    color: "LightGrey",
  },
];

let horario = [
  {
    idTramo: 1,
    asignaturas: [
      { idDia: 1, idAsignatura: 2 },
      { idDia: 2, idAsignatura: 3 },
      { idDia: 3, idAsignatura: 3 },
      { idDia: 4, idAsignatura: 1 },
      { idDia: 5, idAsignatura: 7 },
    ],
  },
  {
    idTramo: 2,
    asignaturas: [
      { idDia: 1, idAsignatura: 7 },
      { idDia: 2, idAsignatura: 2 },
      { idDia: 3, idAsignatura: 3 },
      { idDia: 4, idAsignatura: 1 },
      { idDia: 5, idAsignatura: 4 },
    ],
  },
  {
    idTramo: 3,
    asignaturas: [
      { idDia: 1, idAsignatura: 1 },
      { idDia: 2, idAsignatura: 4 },
      { idDia: 3, idAsignatura: 7 },
      { idDia: 4, idAsignatura: 1 },
      { idDia: 5, idAsignatura: 5 },
    ],
  },
  {
    idTramo: 4,
    asignaturas: [
      { idDia: 1, idAsignatura: 9 },
      { idDia: 2, idAsignatura: 9 },
      { idDia: 3, idAsignatura: 9 },
      { idDia: 4, idAsignatura: 9 },
      { idDia: 5, idAsignatura: 9 },
    ],
  },
  {
    idTramo: 5,
    asignaturas: [
      { idDia: 1, idAsignatura: 1 },
      { idDia: 2, idAsignatura: 1 },
      { idDia: 3, idAsignatura: 1 },
      { idDia: 4, idAsignatura: 8 },
      { idDia: 5, idAsignatura: 6 },
    ],
  },
  {
    idTramo: 6,
    asignaturas: [
      { idDia: 1, idAsignatura: 1 },
      { idDia: 2, idAsignatura: 1 },
      { idDia: 3, idAsignatura: 1 },
      { idDia: 4, idAsignatura: 8 },
      { idDia: 5, idAsignatura: 6 },
    ],
  },
  {
    idTramo: 7,
    asignaturas: [
      { idDia: 1, idAsignatura: 1 },
      { idDia: 2, idAsignatura: 1 },
      { idDia: 3, idAsignatura: 1 },
      { idDia: 4, idAsignatura: 1 },
      { idDia: 5, idAsignatura: 6 },
    ],
  },
];

// ---------------------------------------------------------------------------------------------------
let botonGenerarHorario = document.getElementById("inputCrearHorario");
botonGenerarHorario.addEventListener("click", generarHorario);

function generarHorario() {
  let table = document.getElementById("horario");

  let filaEncabezado = document.createElement("tr");
  let filaInfo;
  let casillaInfo;
  // Bucle for para generar el encabezado de la tabla
  // Genero la primera casilla vacia
  let casillaEncabezado = document.createElement("th");
  casillaEncabezado.innerHTML = "HORAS";
  filaEncabezado.appendChild(casillaEncabezado);
  for (let i = 0; i < dias.length; i++) {
    casillaEncabezado = document.createElement("th");
    casillaEncabezado.innerHTML = dias[i].nombre;
    filaEncabezado.appendChild(casillaEncabezado);
  }
  table.appendChild(filaEncabezado);

  // Bucle for para generar la información de la tabla
  for (let i = 0; i < tramos.length; i++) {
    // Creacion de la casilla de la hora
    filaInfo = document.createElement("tr");
    casillaInfo = document.createElement("th");
    casillaInfo.innerHTML = `${tramos[i].hora}<br>(${tramos[i].descripcion})`;
    filaInfo.appendChild(casillaInfo);

    for (let j = 0; j < dias.length; j++) {
      let indice = horario[i].asignaturas[j].idAsignatura - 1; // Variable indice de la asignatura que eestamos iterando

      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = `${asignaturas[indice].nombre}<br>${asignaturas[indice].grupo}`;
      casillaInfo.style.backgroundColor = asignaturas[indice].color;

      // Añadir eventos con valores capturados
      casillaInfo.addEventListener("mouseover", () =>
        mostrarAula(asignaturas[indice].aula)
      );
      casillaInfo.addEventListener("mouseout", borrarAula);

      // Añadir la cuadricula a la fila
      filaInfo.appendChild(casillaInfo);
    }
    // Añadir la fila a la tabla
    table.appendChild(filaInfo);
  }
}

// Metodo par mostrar el aula
function mostrarAula(aula) {
  document.getElementById("aula").innerHTML = aula;
}

// Metodo par ocultar el aula
function borrarAula() {
  document.getElementById("aula").innerHTML = "";
}
