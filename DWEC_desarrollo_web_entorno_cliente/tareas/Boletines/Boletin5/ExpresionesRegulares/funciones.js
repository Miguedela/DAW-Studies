// 3.2) Crea una función llamada terminaVocalAcentuada que valide si una palabra termina en vocal
// acentuada, sin distinguir mayúsculas de minúsculas.  Haz un testeo de la función.
function terminaVocalAcentuada(texto) {
  let expresion = /^\w[áéíóú]$/i;
  return expresion.test(texto);
}

// 3.3) Crea una función llamada validaDNI que tendrá como argumento el DNI que se desea validar.
// Un DNI tiene una estructura correcta si consta de 8 dígitos, un guión opcional y una de las
// siguientes letras: trwagmyfpdxbnjzsqvhlcke (la letra podrá estar en minúsculas o mayúsculas).
// Haz un testeo de la función.
function validaDNI(texto) {
  let expresion = /^\d{8}-?[trwagmyfpdxbnjzsqvhlcke]$/i;
  return expresion.test(texto);
}

// 3.4) Crea una función llamada validaNumeroEntero que valide si un string que representa un número
// entero es correcto. Dicho número podrá estar precedido opcionalmente por los caracteres + o -
// (por ejemplo se consideran válidos: “123”, “-25”, “+4882”).  Haz un testeo de la función.
function validaNumeroEntero(texto) {
  let expresion = /^[+-]?\d+$/;
  return expresion.test(texto);
}

// 3.5) Crea una función llamada validaNumeroDecimal que valide si un string que representa un número entero
// o decimal es correcto. Dicho número podrá estar precedido opcionalmente por los caracteres + o - y se
// usará la coma como separador decimal(por ejemplo se consideran válidos: “123”, “-25,09”, “+0,23”).
// Haz un testeo de la función.
function validaNumeroDecimal(texto) {
  let expresion = /^[+-]?\d+(,\d{2})?$/;
  return expresion.test(texto);
}

// 3.6) Crea una función llamada validaHora que valide si un string que representa una hora con el formato hh:mm:ss
// usando la representación de  24 horas.  Haz un testeo de la función.

function validaHora(texto) {
  let expresion = /^(([0-1][0-9])|([2][0-4])):([0-5][0-9]):([0-5][0-9])$/;
  return expresion.test(texto);
}

// 3.7) Crea una función llamada extraerPosicionesEmails que tenga como argumento de entrada un texto (dato string) y
// devuelva un vector con todas las posiciones en que se haya encontrado un emails en el texto de entrada.
// Para validar un email utiliza la siguiente expresión regular:
// /\w+@([a-zA-Z_]+\.)+[a-zA-Z]{2,6}/
// Haz un testeo de la función.
function extraerPosicionesEmails(texto) {
  let regex = /\w+@([a-zA-Z_]+\.)+[a-zA-Z]{2,6}/g;

  if (regex.search(texto) === null) {
    return null;
  }

  let posiciones = [];
  let match;

  while ((match = regex.search(texto)) !== null) {
    posiciones.push(match.index);
  }

  return posiciones;
}

// 3.8) Crea una función llamada validaDireccionIP que valide si un string que representa una dirección IP tiene
// un formato correcto. La función debe devolver true o false.  Haz un testeo de la función. Realiza un testeo
// con Jasmine de al menos 5 direcciones IPs válidas y otras 5 que no lo sean (Ej: “192.168.16.20”  => Son
// cuatro bytes en formato decimal (0-255) separados por un punto)
function validaDireccionIP(texto) {
  let expresion = /^\d{3}\.\d{3}\.\d{3}\.\d{3}$/;

  if (!expresion.test(numeros)) {
    return false;
  }

  let numeros = texto.split(".");

  numeros.array.forEach((element) => {
    if (element > 255 || element < 0) {
      return false;
    }
  });

  return true;
}

// 3.8.2) Crea una función llamada validaNumerosSeparados(dato) que tenga un argumento de entrada de tipo string y valide
// si dicho dato tiene el formato de tres números del 0 al 9 separados por un guión “-” o por un punto “.” Aunque el
// separador entre los número puede ser el guión o el punto debe usarse el mismo (por ejemplo, serían válidos “3-8-5”
// y “3.8.5” pero no sería válido “3.8-5” o “3-8.5” porque se ha mezclado el tipo de separador).
function validaNumerosSeparados(texto) {
  let expresion = /^[0-9](\.|-)[0-9]\1[0-9]$/;

  return expresion.test(texto);
}

// 3.9)  Crea una función llamada extraeExpresionesMatemáticas que use como argumento de entrada un string que contendrá
// entre llaves expresiones matemáticas. La función debe devolver un array que contenga las expresiones matemáticas.

// Por ejemplo, si le pasamos a la función la siguiente cadena de caracteres:
// “La ecuación de una recta es {y=a*x + b}, la de un círculo {x^2+y^2 = r} y la de la parábola {y = x^2}”
// la función debe devolver el array: [{y=a*x + b}, {x^2+y^2 = r}, {y = x^2}]
function extraeExpresionesMatemáticas(texto) {
  let regex = /[{]\w[}]/g;

  if (regex.search(texto) === null) {
    return null;
  }

  let posiciones = [];
  let match;

  while ((match = regex.search(texto)) !== null) {
    posiciones.push(match.index);
  }

  return posiciones;
}
