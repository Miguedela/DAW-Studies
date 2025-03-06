// test para comprobar que la útlima vocal es acentuada
describe("terminaVocalAcentuada", function () {
  const pruebas = [
    { dato: "holá", respuestaEsperada: true },
    { dato: "hola", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si la ultima vocal es acentuada y false si la última vocal no es acentuada",
      function () {
        expect(terminaVocalAcentuada(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para comprobar que un dni es válido
describe("validaDNI", function () {
  const pruebas = [
    { dato: "12345678w", respuestaEsperada: true },
    { dato: "12345678-w", respuestaEsperada: true },
    { dato: "12345678", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si el dni es válido y false si el dni no es válido",
      function () {
        expect(validaDNI(element.dato)).toEqual(element.respuestaEsperada);
      }
    );
  });
});

// test para comprobar que un número es válido
describe("validaNumeroEntero", function () {
  const pruebas = [
    { dato: "123", respuestaEsperada: true },
    { dato: "+123", respuestaEsperada: true },
    { dato: "-123", respuestaEsperada: true },
    { dato: "123.23", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si el número es entero y false si el número no es entero",
      function () {
        expect(validaNumeroEntero(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para comprobar que un número decimal o no es válido
describe("validaNumeroDecimal", function () {
  const pruebas = [
    { dato: "123", respuestaEsperada: true },
    { dato: "+123", respuestaEsperada: true },
    { dato: "-123", respuestaEsperada: true },
    { dato: "123.23", respuestaEsperada: false },
    { dato: "123,23", respuestaEsperada: true },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si el número es válido y false si el número no es válido",
      function () {
        expect(validaNumeroDecimal(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para comprobar que el formato de la hora es válido
describe("validaHora", function () {
  const pruebas = [
    { dato: "12:43:54", respuestaEsperada: true },
    { dato: "12:43:61", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si la hora es válida y false si la hora no es válida",
      function () {
        expect(validaHora(element.dato)).toEqual(element.respuestaEsperada);
      }
    );
  });
});

// test para detectar los emails en una frase
describe("extraerPosicionesEmails", function () {
  const pruebas = [
    {
      dato: "Hola me llamo Miguel Ángel y mi correo es: miguelangeldelarosaleva@gmail.com",
      respuestaEsperada: ["miguelangeldelarosaleva@gmail.com"],
    },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si la hora es válida y false si la hora no es válida",
      function () {
        expect(extraerPosicionesEmails(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para validar IPs
describe("validaDireccionIP", function () {
  const pruebas = [
    { dato: "192.168.0.106", respuestaEsperada: true },
    { dato: "192.168.100.106", respuestaEsperada: true },
    { dato: "192.168.-1.106", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si la IP es válida y false si la IP no es válida",
      function () {
        expect(validaDireccionIP(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para validar IPs
describe("validaNumerosSeparados", function () {
  const pruebas = [
    { dato: "0.0.0", respuestaEsperada: true },
    { dato: "0-0-0", respuestaEsperada: true },
    { dato: "0.0-0", respuestaEsperada: false },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver true si la cadena númerica es válida y false si la cadena númerica no es válida",
      function () {
        expect(validaNumerosSeparados(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});

// test para recoger las opreaciones matematicas de un texto
describe("extraeExpresionesMatemáticas", function () {
  const pruebas = [
    {
      dato: "La ecuación de una recta es {y=a*x + b}, la de un círculo {x^2+y^2 = r} y la de la parábola {y = x^2}",
      respuestaEsperada: ["{y=a*x + b}", "{x^2+y^2 = r}", "{y = x^2}"],
    },
  ];

  pruebas.forEach((element) => {
    it(
      "(" +
        element.dato +
        ") debería devolver un array con las operaciones matematicas encontradas en el texto",
      function () {
        expect(extraeExpresionesMatemáticas(element.dato)).toEqual(
          element.respuestaEsperada
        );
      }
    );
  });
});
