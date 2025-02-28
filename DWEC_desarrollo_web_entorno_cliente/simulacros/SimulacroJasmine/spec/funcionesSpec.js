// test para comprobar que los números sean pares
describe("areaPiramide", function () {
  const areaPir = [
    {
      lado: 6.8,
      altura: 9,
      resultado: 177.083,
      debeLanzarError: false,
    },
    {
      lado: 7.1,
      altura: 9.4,
      resultado: 193.092,
      debeLanzarError: false,
    },
    {
      lado: 7.4,
      altura: 9.8,
      resultado: 209.793,
      debeLanzarError: false,
    },
    {
      lado: -7.4,
      altura: 9.8,
      resultado: "El lado es negativo",
      debeLanzarError: true,
    },
    {
      lado: 7.4,
      altura: -9.8,
      resultado: "La altura introducida es negativa",
      debeLanzarError: true,
    },
  ];

  areaPir.forEach((obj) => {
    it(
      "debería devolver el area de la piramide o un error en su defecto: " +
        obj.resultado,
      function () {
        if (obj.debeLanzarError) {
          expect(() =>
            parseFloat(areaPiramide(obj.lado, obj.altura).toFixed(3))
          ).toThrowError(obj.resultado);
        } else {
          expect(
            parseFloat(areaPiramide(obj.lado, obj.altura).toFixed(3))
          ).toEqual(obj.resultado);
        }
      }
    );
  });
});

// -------------------------------------------------------------------------------------------------
describe("filtrarPrimosMayoresOnce", function () {
  const datos = [
    {
      entrada: [6, 11, 18, 43, 8, 5, 45, 53, 9, 7, 24, 23],
      salida: [23, 43, 53],
    },
    {
      entrada: [6, 5, 24, 47, 8, 11, 18, 41, 9, 2, 35, 19],
      salida: [19, 41, 47],
    },
    {
      entrada: [4, 5, 45, 47, 6, 7, 27, 43, 10, 11, 35, 23],
      salida: [23, 43, 47],
    },
    {
      entrada: [9, 11, 20, 23, 6, 3, 24, 17, 8, 5, 14, 47],
      salida: [17, 23, 47],
    },
    {
      entrada: [9, 2, 45, 29, 8, 7, 18, 19, 6, 5, 12, 13],
      salida: [13, 19, 29],
    },
  ];

  datos.forEach((numeros) => {
    it(
      "debería devolver los números primos mayores que 11: " + numeros.salida,
      function () {
        expect(filtrarPrimosMayoresOnce(...numeros.entrada)).toEqual(
          numeros.salida
        );
      }
    );
  });
});

// -------------------------------------------------------------------------------------------------
describe("numeroDiasFechas", function () {
  const datos = [
    {
      fechaInicio: "9/11/2021",
      fechaFin: "9/11/2021",
      resultado: 0,
      debeLanzarError: false,
    },
    {
      fechaInicio: "28/02/2020",
      fechaFin: "1/3/2020",
      resultado: 2,
      debeLanzarError: false,
    },
    {
      fechaInicio: "28/02/2021",
      fechaFin: "1/3/2021",
      resultado: 1,
      debeLanzarError: false,
    },
    {
      fechaInicio: "17/04/1973",
      fechaFin: "14/11/1979",
      resultado: 2402,
      debeLanzarError: false,
    },
    {
      fechaInicio: "32/04/1973",
      fechaFin: "14/11/1979",
      resultado: "Uno o varios argumentos de las fechas es incorrecto",
      debeLanzarError: true,
    },
  ];

  datos.forEach((fechas) => {
    it(
      "debería devolver la diferencia de tiempo de las fedchas en días: " +
        fechas.resultado,
      function () {
        if (fechas.debeLanzarError) {
          expect(() =>
            numeroDiasFechas(fechas.fechaInicio, fechas.fechaFin)
          ).toThrowError(fechas.resultado);
        } else {
          expect(numeroDiasFechas(fechas.fechaInicio, fechas.fechaFin)).toEqual(
            fechas.resultado
          );
        }
      }
    );
  });
});

// -------------------------------------------------------------------------------------------------
// describe("reserva", function () {
//   const reservas = [
//     {
//       reserva: new Reserva(
//         "Ortiz;García;Juan Antionio",
//         "44958625A",
//         "27/2/2020",
//         "3/3/2020"
//       ),
//       codigoEsperado: "JGARCÍA625",
//       diasEsperados: 5,
//     },
//   ];

//   reservas.forEach((obj) => {
//     it(
//       "debería devolver el codigo del cliente: " + obj.codigoEsperado,
//       function () {
//         expect(obj.reserva.codigoCliente).toEqual(obj.codigoEsperado);
//       }
//     );
//     it(
//       "debería devolver los días que el cliente se quedara en el hotel: " +
//         obj.diasEsperados,
//       function () {
//         expect(obj.reserva.numeroDiasEstancias).toEqual(obj.diasEsperados);
//       }
//     );
//   });
// });
