// NO SE PUEDE CAMBIAR LA ESTRUCTURA DE LOS DATOS SUMINISTRADOS
let articulos = [
  {
    id: 1,
    nombre: "Monitor",
    caracteristicas: { precio: 151.23, descuento: 10 },
  },
  {
    id: 2,
    nombre: "Ratón",
    caracteristicas: { precio: 5.45, descuento: 5 },
  },
  {
    id: 3,
    nombre: "Cascos",
    caracteristicas: { precio: 15.59, descuento: 15 },
  },
  {
    id: 4,
    nombre: "Escáner",
    caracteristicas: { precio: 95.12, descuento: 20 },
  },
];

// Escribe aquí tu código
addEventListener("load", inicio);

function inicio() {
  // datos iniciales de la tabla izquierda
  let filaInfoIzquierda;
  let casillaInfoIzquierda;
  for (const element of articulos) {
    filaInfoIzquierda = document.createElement("tr");
    filaInfoIzquierda.setAttribute("id", element.id);
    filaInfoIzquierda.addEventListener("mouseover", () =>
      pintarAmarillo(element.id)
    );
    filaInfoIzquierda.addEventListener("mouseout", () =>
      pintarBlanco(element.id)
    );
    casillaInfoIzquierda = `<td>${element.nombre}</td>`;
    casillaInfoIzquierda += `<td>${element.caracteristicas.precio}</td>`;
    casillaInfoIzquierda += `<td>
    <button id="${element.id}" onclick='moverIzquierda(this)' value="izquierda"><</button>
    <button id="${element.id}" onclick='moverDerecha(this)' value="izquierda">></button>
    <button onclick='mostrarDescuento("${element.caracteristicas.descuento}")' value="">Dto.</button>
    </td>`;
    filaInfoIzquierda.innerHTML = casillaInfoIzquierda;
    // tablaIzquierda.appendChild(filaInfoIzquierda);
    document.getElementsByTagName("tbody")[0].appendChild(filaInfoIzquierda);
  }
}

function moverIzquierda(boton) {
  if (boton.value === "izquierda") {
    alert("No se puede mover a la izquierda");
    return;
  }

  // let tablaIzquierda = document.getElementById("tblIzquierda");

  let filaInfo;
  let casillaInfo;
  for (const element of articulos) {
    filaInfo = document.createElement("tr");
    filaInfo.setAttribute("id", element.id);
    filaInfo.addEventListener("mouseover", () => pintarAmarillo(element.id));
    filaInfo.addEventListener("mouseout", () => pintarBlanco(element.id));
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = element.nombre;
    filaInfo.appendChild(casillaInfo);
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = element.caracteristicas.precio;
    filaInfo.appendChild(casillaInfo);
    casillaInfo = document.createElement("td");
    if (boton.id == element.id.toString()) {
      boton.parentElement.parentElement.remove();
      casillaInfo.innerHTML = `
        <button id="${element.id}" onclick='moverIzquierda(this)' value="izquierda"><</button>
        <button id="${element.id}" onclick='moverDerecha(this)' value="izquierda">></button>
        <button onclick='mostrarDescuento("${element.caracteristicas.descuento}")' value="">Dto.</button>`;
      filaInfo.appendChild(casillaInfo);
      // tablaIzquierda.appendChild(filaInfo);
      document.getElementsByTagName("tbody")[0].appendChild(filaInfo);
    }
  }
}

function moverDerecha(boton) {
  if (boton.value === "derecha") {
    alert("No se puede mover a la derecha");
    return;
  }

  // let tablaDerecha = document.getElementById("tblDerecha");

  let filaInfo;
  let casillaInfo;
  for (const element of articulos) {
    filaInfo = document.createElement("tr");
    filaInfo.setAttribute("id", element.id);
    filaInfo.addEventListener("mouseover", () => pintarAmarillo(element.id));
    filaInfo.addEventListener("mouseout", () => pintarBlanco(element.id));
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = element.nombre;
    filaInfo.appendChild(casillaInfo);
    casillaInfo = document.createElement("td");
    casillaInfo.innerHTML = element.caracteristicas.precio;
    filaInfo.appendChild(casillaInfo);
    casillaInfo = document.createElement("td");
    if (boton.id == element.id.toString()) {
      boton.parentElement.parentElement.remove();
      casillaInfo.innerHTML = `
        <button id="${element.id}" onclick='moverIzquierda(this)' value="derecha"><</button>
        <button id="${element.id}" onclick='moverDerecha(this)' value="derecha">></button>
        <button onclick='mostrarDescuento("${element.caracteristicas.descuento}")' value="">Dto.</button>`;
      filaInfo.appendChild(casillaInfo);
      // tablaDerecha.appendChild(filaInfo);
      document.getElementsByTagName("tbody")[1].appendChild(filaInfo);
    }
  }
}

function mostrarDescuento(porcentajeDescuento) {
  alert("Dto: " + porcentajeDescuento + "%");
}
function pintarAmarillo(id) {
  document.getElementById(id).style.backgroundColor = "yellow";
}

function pintarBlanco(id) {
  document.getElementById(id).style.backgroundColor = "white";
}
