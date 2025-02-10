// Escribe aquí tu código
addEventListener("load", inicio);

const apiKey = "b0c591f7";

function inicio() {
  let formulario = document.getElementById("formulario_busqueda");
  formulario.addEventListener("submit", recogerObjetos);
}

let conexion1;
function recogerObjetos(e) {
  e.preventDefault();
  let nombrePelicula = document.getElementById("nombre_pelicula");
  console.log(nombrePelicula);
  let url = `https://www.omdbapi.com/?apikey=${apiKey}&s=${nombrePelicula.value}`;

  console.log(url);

  conexion1 = new XMLHttpRequest();
  conexion1.open("GET", url, true);
  conexion1.timeout = 3000; // Tiempo máximo de espera del API 3sg
  conexion1.addEventListener("readystatechange", crearObjetos); // Añadimos el callback
  conexion1.addEventListener("timeout", tiempoVencido); // El evento ontimeout se dispara cuando se ha superado el tiempo de espera
  conexion1.send();
}

function tiempoVencido() {
  document.getElementById("resultados").innerHTML = "Tiempo de espera vencido";
}

let peliculas;
function crearObjetos() {
  if (conexion1.readyState == 4) {
    if (conexion1.status == 200) {
      let resultados = document.getElementById("resultados");
      try {
        let peliculas = document.getElementById("peliculas");
        resultados.innerHTML = "";

        // Con JSON.parse se convierte el texto JSON en un objeto JavaScript
        let datos = JSON.parse(conexion1.responseText); // Los datos JSON se recuperan al igual que el texto plano

        let salida = "";

        let arrayPeliculas = datos.Search;
        for (const pelicula of arrayPeliculas) {
          salida += `<h1">Titulo: ${pelicula.Title}</h1>`;
          salida += `<p>Año de salida: ${pelicula.Year}</p>`;
          salida += `<h2">Codigo: ${pelicula.imdbID}</h1>`;
          salida += `<h2">Tipo: ${pelicula.Type}</h1>`;
          salida += `<img src="${pelicula.Poster}" alt="poster_pelicula">`;
        }

        for (let x = 0; x < datos.length; x++) {
          salida += `<h1">Titulo: ${datos[x].Title}</h1>`;
          salida += `<p>Año de salida: ${datos[x].Year}</p>`;
          salida += `<h2">Codigo: ${datos[x].imdbID}</h1>`;
          salida += `<h2">Tipo: ${datos[x].Type}</h1>`;
          salida += `<img src="${datos[x].Poster}" alt="poster_pelicula">`;
        }

        peliculas.innerHTML = salida;
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
