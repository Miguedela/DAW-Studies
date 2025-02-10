function areaPiramide(lado, altura) {
  // en caso de que alguno de los dos parametros sea negativo devuelvo un error
  if (lado < 0) {
    throw new Error("El lado es negativo");
  } else if (altura < 0) {
    throw new Error("La altura introducida es negativa");
  }

  // claculo del area
  let area =
    lado * (lado + Math.sqrt(4 * Math.pow(altura, 2) + Math.pow(lado, 2)));

  // devuelvo el area parseada a decimal
  return parseFloat(area.toFixed(5));
}

// -------------------------------------------------------------------------------------------------
function filtrarPrimosMayoresOnce(...numeros) {
  // creo el array donde se guardaran los números primos mayores que 11
  const resultado = [];

  // recorro el array pasado por el metodo
  numeros.forEach((numero) => {
    // compruebo que el número sea mayor que 11
    if (numero > 11) { 
      let esPrimoAux = esPrimo(numero);

      // en caso que el número sea mayor que 11 lo añado al array
      if (esPrimoAux) {
        resultado.push(numero);
      }
    }
  });

  // ordeno el array y lo devuelvo
  resultado.sort((a, b) => a - b);
  return resultado;
}

// funcion que comprueba si son primos
function esPrimo(num) {
  for (let i = 2; i < num; i++) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}

// _________________________________________________________________________________
//Filtar numeros primos V2

// Función que realiza el filtro de los números indicados
// function filtrarPrimosMayoresOnce(arryNum) {
//   return arryNum
//     .filter(esPrimoYMayorDe11(item) /*(item) =>esPrimo(item) && item > 11*/)
//     .sort();
// }
// function esPrimoYMayorDe11(item) {
//   return item > 11 && esPrimo(item);
// }

// -------------------------------------------------------------------------------------------------
function numeroDiasFechas(fechaInicio, fechaFin) {
  // realizo un split a la fechaInicio
  const partesInicio = fechaInicio.split("/");

  // combruebo que cada fecha pasada solo tenga 3 partes (dia, mes y año)
  if (partesInicio.length !== 3) {
    throw new Error("Uno o varios argumentos de las fechas es incorrecto");
  }

  let diaInicio = parseInt(partesInicio[0]);
  let mesInicio = parseInt(partesInicio[1]) - 1;
  let anioInicio = parseInt(partesInicio[2]);
  // CREACION DE FECHA1
  let fecha1 = new Date(anioInicio, mesInicio, diaInicio);

  // Validar si fechaDesde es correcta
  if (
    fecha1.getFullYear() !== anioInicio || // Verifica si el año de fecha1 coincide con anioInicio
    fecha1.getMonth() !== mesInicio || // Verifica si el mes de fecha1 coincide con mesInicio
    fecha1.getDate() !== diaInicio // Verifica si el día de fecha1 coincide con diaInicio
  ) {
    throw new Error("Uno o varios argumentos de las fechas es incorrecto");
  }

  // realizo un split a la fechaFin
  const partesFin = fechaFin.split("/");

  // combruebo que cada fecha pasada solo tenga 3 partes (dia, mes y año)
  if (partesFin.length !== 3) {
    throw new Error("Uno o varios argumentos de las fechas es incorrecto");
  }
  let diaHasta = parseInt(partesFin[0]);
  let mesHasta = parseInt(partesFin[1]) - 1;
  let anioHasta = parseInt(partesFin[2]);
  // CREACION DE FECHA2
  let fecha2 = new Date(anioHasta, mesHasta, diaHasta);

  // Validar si fechaHasta es correcta
  if (
    fecha2.getFullYear() !== anioHasta ||
    fecha2.getMonth() !== mesHasta ||
    fecha2.getDate() !== diaHasta
  ) {
    throw new Error("Uno o varios argumentos de las fechas es incorrecto");
  }

  // Calcular la diferencia en MILISEGUNDOS
  // Math.round (rendondea el número), para no sufrir error de pedida de decimales
  let diferenciaEnMilisegundos = Math.round(fecha2 - fecha1);

  // Convertir la diferencia a días
  let diferenciaEnDias = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

  return diferenciaEnDias;
}

// -------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
class Reserva {
  // CONSTRUCTOR
  constructor(nombreCompletoCSV, dni, fechaEntrada, fechaSalida) {
    this._nombreCompletoCSV = nombreCompletoCSV;
    this._dni = dni;
    if (this.parsearFecha(fechaEntrada) > this.parsearFecha(fechaSalida)) {
      throw new Error("Fecha de salida debe ser posterior a la de entrada");
    } else {
      this._fechaEntrada = fechaEntrada;
      this._fechaSalida = fechaSalida;
    }
  }

  // GETTERS Y SETTERS
  get nombreCompletoCSV() {
    return this._nombreCompletoCSV;
  }

  set nombreCompletoCSV(value) {
    this._nombreCompletoCSV = value;
  }

  get dni() {
    return this._dni;
  }

  set dni(value) {
    this._dni = value;
  }

  get fechaEntrada() {
    return this._fechaEntrada;
  }

  set fechaEntrada(value) {
    this._fechaEntrada = value;
  }

  get fechaSalida() {
    return this._fechaSalida;
  }

  set fechaSalida(value) {
    this._fechaSalida = value;
  }

  // GETTERS de ejercicos

  // metodo auxiliar para parsear fechas
  parsearFecha(fecha) {
    let fechaSplit = fecha.split("/");
    let fechaDate = new Date(fechaSplit[2], fechaSplit[1] - 1, fechaSplit[0]);
    return fechaDate;
  }

  // obtener codigo de cliente
  get codigoCliente() {
    // split del nombre
    const partesNombre = this._nombreCompletoCSV.split(";");
    // guardo las variables necesarias
    let inicialNombre = partesNombre[2].charAt(0).toUpperCase();
    let primerApellido = partesNombre[0].toUpperCase();
    const ultimosTresDNI = this._dni.substring(this._dni.length - 1, 5);

    // devuelvo el codigo concatenado de forma correcta
    return `${inicialNombre}${primerApellido}${ultimosTresDNI}`;
  }

  // obtener dias de la estancia
  get numeroDiasEstancia() {
    return numeroDiasFechas(this._fechaEntrada, this._fechaSalida);
  }

  // metodo para realizar modificaciones a las fechas
  modificarFechas(fechaEntradaModif, fechaSalidaModif) {
    // parseo ambas fechas de cambio
    let fecha1mod = this.parsearFecha(fechaEntradaModif);
    let fecha2mod = this.parsearFecha(fechaSalidaModif);

    // comprobaciónes de errores en caso de haberlo y cambio de fecha
    if (fecha2mod < fecha1mod) {
      throw new Error("Fecha de salida debe ser posterior a la de entrada");
    } else if (fecha2mod - fecha1mod < 1000 * 60 * 60 * 24) {
      throw new Error("Estancia mínima debe ser un día");
    } else {
      this.fechaEntrada = fecha1mod.toLocaleDateString();
      this.fechaSalida = fecha2mod.toLocaleDateString();
    }
  }

  // metodo que devuelve el coster de la estancia
  costeEstancia() {
    // Guardo los días de la estamcia
    let dias = this.numeroDiasEstancia;
    let coste = 0;

    // creo una variable auxiliar de la fecha para no modificar la origial
    let fechaAux = this.parsearFecha(this._fechaEntrada);

    // for repetido como tantos dias de estancia tenga la reserva
    for (let i = 0; i < dias; i++) {
      let diaSemana = fechaAux.getDay();
      fechaAux.setDate(fechaAux.getDate() + 1);

      // if para comprobar que precio debe pagar dependiendo del día
      if (diaSemana === 0) {
        coste += 39;
      } else if (diaSemana === 6) {
        coste += 32;
      } else {
        coste += 20;
      }
    }
    return coste;
  }
}
