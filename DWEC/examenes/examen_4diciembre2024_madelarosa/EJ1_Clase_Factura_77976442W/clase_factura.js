class Factura {
  // Escribe aquí tu código

  // CONSTRUCTOR
  constructor(codigoFactura, fechaFactura, { nombre: nombre, dni: dni }) {
    this._codigoFactura = codigoFactura;
    this._fechaFactura = fechaFactura;
    this._nombre = nombre;
    this._dni = dni;
    this._articulos = [];
  }

  // GETTERS
  get letraDNICliente() {
    console.log(this._dni.at(-1));
    return this._dni.at(-1);
  }

  get nombreCliente() {
    return this._nombre;
  }

  // METODOS
  añadirArticulo(...articulos) {
    for (const articulo of articulos) {
      this._articulos.push(articulo);
    }
  }

  totalFactura() {
    let precioTotal = 0;
    for (const articulo of this._articulos) {
      precioTotal += articulo.cantidad * articulo.precio;
    }
    console.log(precioTotal);
    return precioTotal;
  }

  buscarArticulos(palabra) {
    let codigosEncontrados = [];
    for (const articulo of this._articulos) {
      articulo.descripcion = articulo.descripcion;
      const partesNombre = articulo.descripcion.split(" ");
      for (const parte of partesNombre) {
        if (parte.toLowerCase() == palabra.toLowerCase()) {
          codigosEncontrados.push(articulo.codigo);
          break;
        }
      }
    }
    return codigosEncontrados;
  }
}

// -------------------------TESTEO PRESONAL-------------------------------------------------------------------
// Creo el objeto factura1
const factura1 = new Factura("B1232", "12/04/2024", {
  nombre: "Javier Soldado",
  dni: "44967891X",
});

// Muestro la letra del DNI por consola
factura1.letraDNICliente;

// Creo dos objetos literales de articulos
const articulo1 = {
  codigo: "A732",
  descripcion: "Grifo fregadero",
  cantidad: 2,
  precio: 29.19,
};

const articulo2 = {
  codigo: "A735",
  descripcion: "Grifo eléctrico baño",
  cantidad: 3,
  precio: 32.93,
};

factura1.añadirArticulo(articulo1);
factura1.añadirArticulo(articulo1, articulo2);

factura1.totalFactura();
