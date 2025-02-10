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
  { id: 1, nombre: "", grupo: "", aula: "", color: "white" },
  { id: 2, nombre: "Música", grupo: "1º ESO A", aula: "Aula 6", color: "blue" },
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
  { id: 9, nombre: "RECREO", grupo: "", aula: "", color: "LightGrey" },
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

// Escribe aquí tu código

// Obtiene el botón "inputCrearHorario" y le añade un evento click para generar el horario
let btnGeneraHorario = document.getElementById("inputCrearHorario");
btnGeneraHorario.addEventListener("click", generaHorario);

// Función que genera el horario dinámicamente
function generaHorario() {
  let table = document.getElementById("horario"); // Obtiene la tabla donde se generará el horario

  let filaEncabezado = document.createElement("tr"); // Crea la etiqueta fila de encabezado
  let celda;

  // Crea la primera celda vacía en la esquina superior izquierda
  let celdaBlanco = `<th></th>`;
  filaEncabezado.innerHTML = celdaBlanco;

  // Añade cada día como encabezado de la tabla
  for (let i = 0; i < dias.length; i++) {
    let fila = `<th>${dias[i].nombre}</th>`; // Genera la celda del día
    filaEncabezado.innerHTML += fila; // Añade la celda a la fila de encabezado
  }
  table.appendChild(filaEncabezado); // Añade la fila de encabezado a la tabla

  // Itera sobre cada tramo del array horario
  for (let i = 0; i < horario.length; i++) {
    filaHorario = document.createElement("tr"); // Crea una nueva fila para cada tramo
    let codigoFila = `<td>${tramos[i].hora} <br> (${tramos[i].descripcion})</td>`; // Celda del tramo horario
    filaHorario.innerHTML = codigoFila; // Añade la celda del tramo a la fila

    // Añadir asignaturas por día
    for (let j = 0; j < dias.length; j++) {
      // let asignaturaDia = horario[i].asignaturas.find(asig => asig.idDia === dias[j].id);

      // Busca la asignatura correspondiente al día
      let asignaturaDia = null;
      for (let k = 0; k < horario[i].asignaturas.length; k++) {
        if (horario[i].asignaturas[k].idDia === dias[j].id) {
          asignaturaDia = horario[i].asignaturas[k].idAsignatura;
          break;
        }
      }

      // let asignaturaInfo = asignaturas.find(asig => asig.id === asignaturaDia.idAsignatura);
      let asignaturaInfo = null;
      // Busca los detalles de la asignatura por su ID
      for (let k = 0; k < asignaturas.length; k++) {
        if (asignaturas[k].id === asignaturaDia) {
          asignaturaInfo = asignaturas[k];
          break;
        }
      }

      // Crea una celda para la asignatura
      let celdaAsignatura = document.createElement("td");
      celdaAsignatura.style.backgroundColor = asignaturaInfo.color; // Asigna el color de fondo
      celdaAsignatura.innerHTML = `
                ${asignaturaInfo.nombre}<br>
                ${asignaturaInfo.grupo}<br>
            `;

      // Añade eventos de mouse a la celda
      celdaAsignatura.addEventListener("mouseover", () =>
        mostrarAula(asignaturaInfo.aula)
      );
      celdaAsignatura.addEventListener("mouseout", borrarAula);

      // Añade la celda a la fila del horario
      filaHorario.appendChild(celdaAsignatura);

      //Otra forma de añadir celdas
      // let celdaAsignatura =`<td onmouseover="mostrarAula('${asignaturaInfo.aula}')" onmouseout="borrarAula()" style="background-color:${asignaturaInfo.color};">
      // ${asignaturaInfo.nombre}<br>
      // ${asignaturaInfo.grupo}<br>
      // </td>`;
      // filaHorario.innerHTML += celdaAsignatura;
    }

    // Añadir la fila al cuerpo de la tabla
    table.appendChild(filaHorario);
  }
}

// Muestra el aula en el div "aula" al pasar el ratón sobre una celda
function mostrarAula(aula) {
  let divAula = document.getElementById("aula");
  divAula.innerHTML = aula; // Inserta el texto del aula en el div
}

// Borra el contenido del div "aula" al salir el ratón de una celda
function borrarAula() {
  let divAula = document.getElementById("aula");
  divAula.innerHTML = "";
}
