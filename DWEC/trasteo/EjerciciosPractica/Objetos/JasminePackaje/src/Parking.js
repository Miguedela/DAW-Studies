class Parking {
  static ERROR_PLAZA_SIN_VEHICULO = "No hay ningún vehículo en esa plaza";

  // Escribe tu código aquí

  // a) CONTRUCTOR
  constructor(plazas, precioMinuto) {
    this._plazas = Array(plazas).fill(null);
    this._precioMinuto = precioMinuto;
    this._registroEntrada = {};
  }

  // GETTERS
  // c) metodo para obtener las plazas libres
  get plazasLibres() {
    let plazasLibres = 0;
    for (const plaza of this._plazas) {
      if (plaza === null) {
        plazasLibres++;
      }
    }
    return plazasLibres;
  }

  // c) metodo para obtener las plazas ocupadas
  get plazasOcupadas() {
    let plazasOcupadas = 0;
    for (const plaza of this._plazas) {
      if (plaza !== null) {
        plazasOcupadas++;
      }
    }
    return plazasOcupadas;
  }

  // METODOS
  // b) metodo para la entrada de un vehiculo
  entradaVehiculo(matricula, plazasOcupa, fechaHoraEntrada) {
    if (this._plazas[plazasOcupa - 1] !== null) {
      throw new Error("No puedes alquilar esta plaza porque esta ocupada");
    }

    this._plazas[plazasOcupa - 1] = matricula; // Asignación de plaza al vehículo
    let fecha = this.convertirFecha(fechaHoraEntrada.trim()); // Convierto la fecha a tipo Date
    this._registroEntrada[matricula] = fecha; // Registro la fecha en el objeto
  }

  salidaVehiculo(plazasOcupa, fechaHoraSalida) {
    if (this._plazas[plazasOcupa - 1] === null) {
      throw new Error(Parking.ERROR_PLAZA_SIN_VEHICULO);
    }

    let fechaSalida = this.convertirFecha(fechaHoraSalida);
    let fechaEntradaVehiculo =
      this._registroEntrada[this._plazas[plazasOcupa - 1]];

    let tiempoTranscurridos = fechaSalida - fechaEntradaVehiculo;
    tiempoTranscurridos = tiempoTranscurridos / 1000 / 60;

    let costeParking = this._precioMinuto * tiempoTranscurridos;

    let vehiculoSale = {
      matricula: this._plazas[plazasOcupa - 1],
      minutosEstacionamiento: tiempoTranscurridos,
      costeEstacionamiento: costeParking,
    };

    this._plazas[plazasOcupa - 1] = null;
    return vehiculoSale;
  }

  // metodo auxiliar para formatear fecha
  convertirFecha(fecha) {
    const [fechaPart, horaPart] = fecha.split(" ");
    const [dia, mes, anio] = fechaPart.split("/");
    const [horas, minutos] = horaPart.split(":");
    return new Date(anio, mes - 1, dia, horas, minutos);
  }
}
