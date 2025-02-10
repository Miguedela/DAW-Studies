// No se puede cambiar la estructura de los datos suministrados
let provincias = [
  { id: 1, nombre: "Sevilla" },
  { id: 2, nombre: "Huelva" },
  { id: 3, nombre: "Cádiz" },
];
let encabezados = ["provincia", "localidad", ""];

let localidades = [
  {
    id: 1,
    nombre: "Utrera",
    idProvincia: 1,
    datos: { cp: 41710, poblacion: 51700 },
  },
  {
    id: 2,
    nombre: "Los Palacios",
    idProvincia: 1,
    datos: { cp: 41720, poblacion: 38600 },
  },
  {
    id: 3,
    nombre: "Dos Hermanas",
    idProvincia: 1,
    datos: { cp: 41700, poblacion: 138900 },
  },
  {
    id: 4,
    nombre: "Alcalá de Guadaíra",
    idProvincia: 1,
    datos: { cp: 41500, poblacion: 76600 },
  },
  {
    id: 5,
    nombre: "Niebla",
    idProvincia: 2,
    datos: { cp: 21840, poblacion: 4244 },
  },
  {
    id: 6,
    nombre: "Bonares",
    idProvincia: 2,
    datos: { cp: 21830, poblacion: 6101 },
  },
  {
    id: 7,
    nombre: "Chipiona",
    idProvincia: 3,
    datos: { cp: 11550, poblacion: 19600 },
  },
  {
    id: 8,
    nombre: "Jerez",
    idProvincia: 3,
    datos: { cp: 11401, poblacion: 213200 },
  },
  {
    id: 9,
    nombre: "Rota",
    idProvincia: 3,
    datos: { cp: 11520, poblacion: 29700 },
  },
];

// Escribe aquí tu código
addEventListener("load", inicio);

function inicio() {
  // Relleno el select de las provincias
  let selectProvincias = document.getElementById("selectProvincias");
  selectProvincias.addEventListener("change", () =>
    imprimirTabla(selectProvincias.value)
  );
  let option;
  for (const provincia of provincias) {
    option = document.createElement("option");
    option.id = provincia.id;
    option.innerHTML = provincia.nombre;
    selectProvincias.appendChild(option);
  }

  // Relleno la tabla con las provincias y el encabezado
  let table = document.getElementById("tblLocalidades");

  // ENCABEZADO
  let filaEncabezado = document.createElement("tr");
  let casillaEncabezado;
  for (const element of encabezados) {
    casillaEncabezado = document.createElement("th");
    casillaEncabezado.value = element;
    casillaEncabezado.innerHTML = element;
    filaEncabezado.appendChild(casillaEncabezado);
  }
  table.appendChild(filaEncabezado);

  // INFORMACIÓN TABLA
  let filaInfo;
  let casillaInfo;
  for (let i = 0; i < localidades.length; i++) {
    filaInfo = document.createElement("tr");
    // casilla id
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = provincias[localidades[i].idProvincia - 1].nombre;
    filaInfo.appendChild(casillaInfo);
    // casilla nombre
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = localidades[i].nombre;
    filaInfo.appendChild(casillaInfo);
    // casilla informacions
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = `<img id="mostrarInfo" src="img/info.png" alt="imgInfo" onmouseenter=mostrarInfo("${
      localidades[i].id - 1
    }") onmouseout=borrarInfo() >`;
    filaInfo.appendChild(casillaInfo);

    table.appendChild(filaInfo);
  }
}

function imprimirTabla(nombreProvincia) {
  // Relleno la tabla con las provincias y el encabezado
  let table = document.getElementById("tblLocalidades");

  table.innerHTML = ""; // Vacio la tabla al completo

  // ENCABEZADO
  let filaEncabezado = document.createElement("tr");
  let casillaEncabezado;
  for (const element of encabezados) {
    casillaEncabezado = document.createElement("th");
    casillaEncabezado.innerHTML = element;
    filaEncabezado.appendChild(casillaEncabezado);
  }
  table.appendChild(filaEncabezado);

  // INFORMACIÓN TABLA
  let filaInfo;
  let casillaInfo;
  for (let i = 0; i < localidades.length; i++) {
    if (provincias[localidades[i].idProvincia - 1].nombre == nombreProvincia) {
      filaInfo = document.createElement("tr");
      // casilla id
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = provincias[localidades[i].idProvincia - 1].nombre;
      filaInfo.appendChild(casillaInfo);
      // casilla nombre
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = localidades[i].nombre;
      filaInfo.appendChild(casillaInfo);
      // casilla informacions
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = `<img id="mostrarInfo" src="img/info.png" alt="imgInfo" onmouseenter=mostrarInfo("${
        localidades[i].id - 1
      }") onmouseout=borrarInfo() >`;
      filaInfo.appendChild(casillaInfo);

      table.appendChild(filaInfo);
    } else if (nombreProvincia == "") {
      filaInfo = document.createElement("tr");
      // casilla id
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = provincias[localidades[i].idProvincia - 1].nombre;
      filaInfo.appendChild(casillaInfo);
      // casilla nombre
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = localidades[i].nombre;
      filaInfo.appendChild(casillaInfo);
      // casilla informacions
      casillaInfo = document.createElement("td");
      casillaInfo.innerHTML = `<img id="mostrarInfo" src="img/info.png" alt="imgInfo" onmouseenter=mostrarInfo("${
        localidades[i].id - 1
      }") onmouseout=borrarInfo() >`;
      filaInfo.appendChild(casillaInfo);

      table.appendChild(filaInfo);
    }
  }
}

function mostrarInfo(indiceLocalidad) {
  let datos = document.getElementById("datos");
  datos.innerHTML = `CP: ${localidades[indiceLocalidad].datos.cp}<br>Poblacion: ${localidades[indiceLocalidad].datos.poblacion}`;
}

function borrarInfo() {
  let datos = document.getElementById("datos");
  datos.innerHTML = "";
}
