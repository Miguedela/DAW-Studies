describe("Parking", () => {
  let parking;

  beforeEach(() => {
    parking = new Parking(10, 0.02); // 10 plazas y tarifa de 0.02€ por minuto
  });

  // Comprobamos el getter plazasOcupadas
  it("Tras la entrada de tres vehículos y la salida de uno, plazasOcupadas debería devolver 2", () => {
    parking.entradaVehiculo("8025JHH", 1, "05/11/2023 11:35");
    parking.entradaVehiculo("2025AZH", 3, "05/11/2023 12:15");
    parking.entradaVehiculo("3025ZAH", 4, "05/11/2023 13:37");
    parking.salidaVehiculo(3, "05/11/2023 13:15");
    expect(parking.plazasOcupadas).toEqual(2);
  });

  // Comprobamos el getter plazasLibres
  it("Tras la entrada de dos vehículos plazasLibres debería devolver 8", () => {
    parking.entradaVehiculo("8025JHH", 1, "05/11/2023 11:35");
    parking.entradaVehiculo("2025AZH", 3, "05/11/2023 12:15");
    expect(parking.plazasLibres).toEqual(8);
  });

  // Comprobamos la salida de un vehículo (matrícula correcta)
  it("La matrícula del vehículo que sale de la plaza 7 debería ser 8025JHH", () => {
    parking.entradaVehiculo("8025JHH", 7, "05/11/2023 14:30");
    const salida = parking.salidaVehiculo(7, "05/11/2023 15:42");
    expect(salida.matricula).toBe("8025JHH");
  });

  // Comprobamos la salida de un vehículo (tiempo en el parking correcto)
  it("El tiempo del estacionamiento del vehículo en la plaza 7 debería ser 72 minutos", () => {
    parking.entradaVehiculo("8025JHH", 7, "05/11/2023 14:30");
    const salida = parking.salidaVehiculo(7, "05/11/2023 15:42");
    expect(salida.minutosEstacionamiento).toBe(72);
  });

  // Comprobamos la salida de un vehículo (coste del aparcamiento)
  it("El coste de estacionamiento del vehículo en la plaza 7 debería ser 1.44", () => {
    parking.entradaVehiculo("8025JHH", 7, "05/11/2023 14:30");
    const salida = parking.salidaVehiculo(7, "05/11/2023 15:42");
    expect(salida.costeEstacionamiento).toBe(1.44);
  });

  // Comprobamos que se lanza una excepción si al método salidaVehiculo le damos una plaza que no está ocupada
  it("La salida de un vehículo de una plaza que no está ocupada debería lazar un error", () => {
    parking.entradaVehiculo("8025JHH", 7, "05/11/2023 14:30");
    expect(() => parking.salidaVehiculo(8, "05/11/2023 15:42")).toThrow(
      new Error(Parking.ERROR_PLAZA_SIN_VEHICULO)
    );
  });
});
