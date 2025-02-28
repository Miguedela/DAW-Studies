// test para comprobar que los números sean pares
describe("comprobarEsPar", function () {
  it("debería devolver true si el número es par", function () {
    expect(comprobarEsPar(2)).toEqual(true);
  });

  it("debería devolver false si el número es impar", function () {
    expect(comprobarEsPar(3)).toEqual(false);
  });

  it("debería devolver true si el número es cero", function () {
    expect(comprobarEsPar(0)).toEqual(true);
  });

  it("debería devolver false si el número es negativo e impar", function () {
    expect(comprobarEsPar(-3)).toEqual(false);
  });

  it("debería devolver true si el número es negativo y par", function () {
    expect(comprobarEsPar(-4)).toEqual(true);
  });
});

// test para las calificaciones de número enteros
describe("verCalificacion", function () {
  const pruebas = [
    { dato: 11, respuestaEsperada: "VALOR INCORRECTO" },
    { dato: 2, respuestaEsperada: "INSUFICIENTE" },
    { dato: 3, respuestaEsperada: "INSUFICIENTE" },
    { dato: 5, respuestaEsperada: "SUFICIENTE" },
    { dato: 6, respuestaEsperada: "BIEN" },
  ];

  for (let i = 0; i < pruebas.length; i++) {
    it(
      pruebas[i].dato + " ha devuelto " + pruebas[i].respuestaEsperada,
      function () {
        expect(verCalificacion(pruebas[i].dato)).toEqual(
          pruebas[i].respuestaEsperada
        );
      }
    );
  }
});

// test para las calificaciones de número decimales
describe("verCalificacionDecimal", function () {
  const pruebas = [
    { dato: 11.2, respuestaEsperada: "VALOR INCORRECTO" },
    { dato: 2.2, respuestaEsperada: "INSUFICIENTE" },
    { dato: 3.2, respuestaEsperada: "INSUFICIENTE" },
    { dato: 4.9, respuestaEsperada: "INSUFICIENTE" },
    { dato: 5.9, respuestaEsperada: "SUFICIENTE" },
    { dato: 5.0, respuestaEsperada: "SUFICIENTE" },
    { dato: 6.0, respuestaEsperada: "BIEN" },
    { dato: 6.9, respuestaEsperada: "BIEN" },
    { dato: 7.0, respuestaEsperada: "NOTABLE" },
    { dato: 7.9, respuestaEsperada: "NOTABLE" },
    { dato: 8.0, respuestaEsperada: "NOTABLE" },
    { dato: 8.9, respuestaEsperada: "NOTABLE" },
    { dato: 9, respuestaEsperada: "SOBRESALIENTE" },
    { dato: 9.9, respuestaEsperada: "SOBRESALIENTE" },
    { dato: 10.0, respuestaEsperada: "SOBRESALIENTE" },
    { dato: 10.1, respuestaEsperada: "VALOR INCORRECTO" },
  ];

  for (let i = 0; i < pruebas.length; i++) {
    it(
      pruebas[i].dato + " deberia ser " + pruebas[i].respuestaEsperada,
      function () {
        expect(verCalificacionDecimal(pruebas[i].dato)).toEqual(
          pruebas[i].respuestaEsperada
        );
      }
    );
  }
});

// test para el perimetro y area de una circunferencia
describe("parametrosCircunferencia", function () {
  it("debería devolver el perimetro y el areaa de la circunferencia", function () {
    const esperado = {
      perimetro: "31.42",
      area: "78.54",
    };
    expect(parametrosCircunferencia(5)).toEqual(esperado);
  });
});

// test para la comprobación de años bisiestos
describe("esBisiesto", function () {
  it("debería devolver si el año es bisiesto o no", function () {
    expect(esBisiesto(2024)).toEqual(true);
  });
  it("debería devolver si el año es bisiesto o no", function () {
    expect(esBisiesto(2025)).toEqual(false);
  });
});

// test para traducción hexadecimal
describe("hexa2decimal", function () {
  it("debería devolver un número hexadecimal", function () {
    expect(hexa2decimal("FA8")).toEqual(4008);
  });
  it("debería devolver un error", function () {
    expect(() => {
      hexa2decimal("FaZ");
    }).toThrowError("Dígito hexadecimal no válido");
  });
});
