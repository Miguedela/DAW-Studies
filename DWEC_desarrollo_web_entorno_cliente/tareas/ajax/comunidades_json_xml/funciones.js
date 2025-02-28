// Escribe aquí tu código
addEventListener("load", inicio);

const formulario1 = document.getElementById("comunidades_autonomas");
const formulario2 = document.getElementById("provincias");

function inicio() {
  inicioComunidades();
}

let conexion1;
function inicioComunidades() {
  conexion1 = new XMLHttpRequest();
  conexion1.open("GET", "cargar_comunidades_autonomas.php", true);
  conexion1.timeout = 3000; // Tiempo máximo de espera del API 3sg
  conexion1.addEventListener("readystatechange", rellenarComunidadesAutonomas); // Añadimos el callback
  conexion1.addEventListener("timeout", tiempoVencido); // El evento ontimeout se dispara cuando se ha superado el tiempo de espera
  conexion1.send();
}

let conexion2;
function inicioProvincias() {
  conexion2 = new XMLHttpRequest();
  conexion2.open(
    "GET",
    `cargar_provincias.php?comunidad=${formulario1.value}`,
    true
  );
  conexion2.timeout = 3000; // Tiempo máximo de espera del API 3sg
  conexion2.addEventListener("readystatechange", rellenarProvincias); // Añadimos el callback
  conexion2.addEventListener("timeout", tiempoVencido); // El evento ontimeout se dispara cuando se ha superado el tiempo de espera
  conexion2.send();
}

function tiempoVencido() {
  document.getElementById("resultados").innerHTML = "Tiempo de espera vencido";
}

function rellenarComunidadesAutonomas() {
  if (conexion1.readyState == 4) {
    if (conexion1.status == 200) {
      let resultados = document.getElementById("resultados");
      try {
        let salida = `<option value="null">Seleccionar</option>`;
        resultados.innerHTML = "";

        // Con JSON.parse se convierte el texto JSON en un objeto JavaScript
        let datos = JSON.parse(conexion1.responseText); // Los datos JSON se recuperan al igual que el texto plano

        for (let x = 0; x < datos.length; x++) {
          salida += `<option value="${datos[x].id}">${datos[x].nombre}</option>`;
        }

        formulario1.innerHTML = salida;

        formulario1.addEventListener("change", inicioProvincias);
      } catch (ex) {
        document.getElementById("resultados").innerHTML =
          "Error al cargar parsear el JSON: " + ex.message;
      }
    } else {
      // Se ha recibido un código status distinto de 200
      document.getElementById("resultados").innerHTML =
        "Error al cargar los datos";
    }
  } else {
    document.getElementById("resultados").innerHTML = "Cargando...";
  }
}

function rellenarProvincias() {
  if (conexion2.readyState == 4) {
    if (conexion2.status == 200) {
      let resultados = document.getElementById("resultados");
      try {
        resultados.innerHTML = "";

        let xmlDoc = conexion2.responseXML;
        let salida = `<option value="null">Seleccionar</option>`;

        let provincias = xmlDoc.getElementsByTagName("provincia");

        for (let x = 0; x < provincias.length; x++) {
          // Acceder a los datos de cada elemento <periferico>
          let id = provincias[x].getElementsByTagName("id")[0].textContent;
          let nombre =
            provincias[x].getElementsByTagName("nombre")[0].textContent;

          salida += `<option value="${id}">${nombre}</option>`;
        }

        formulario2.innerHTML = salida;

        formulario2.addEventListener("change", pintar);
      } catch (ex) {
        document.getElementById("resultados").innerHTML =
          "Error al cargar parsear el XML: " + ex.message;
      }
    } else {
      // Se ha recibido un código status distinto de 200
      document.getElementById("resultados").innerHTML =
        "Error al cargar los datos";
    }
  } else {
    document.getElementById("resultados").innerHTML = "Cargando...";
  }
}

function pintar() {
  let resultados = document.getElementById("resultados");

  resultados.innerHTML = `ID comunidad autonoma: ${formulario1.value} - ID provincia: ${formulario2.value}`;
}
