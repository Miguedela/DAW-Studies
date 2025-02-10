// 1. Función para comprobar si un número es par
function comprobarEsPar(numero) {
  return numero % 2 === 0;
}

// 2. Función para calificación con nota entera
function verCalificacion(nota) {
  switch (nota) {
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
      return "INSUFICIENTE";
    case 5:
      return "SUFICIENTE";
    case 6:
      return "BIEN";
    case 7:
    case 8:
      return "NOTABLE";
    case 9:
    case 10:
      return "SOBRESALIENTE";
    default:
      return "VALOR INCORRECTO";
  }
}

// el sele
// 3. Función para calificación con nota decimal
function verCalificacionDecimal(nota) {
  if (nota < 0 || nota > 10) {
    return "VALOR INCORRECTO";
  } else if (nota < 5) {
    return "INSUFICIENTE";
  } else if (nota < 6) {
    return "SUFICIENTE";
  } else if (nota < 7) {
    return "BIEN";
  } else if (nota < 9) {
    return "NOTABLE";
  } else {
    return "SOBRESALIENTE";
  }
}

// 4. Función para calcular el perímetro y área de una circunferencia
function parametrosCircunferencia(radio) {
  const perimetro = 2 * Math.PI * radio;
  const area = Math.PI * Math.pow(radio, 2);

  return {
    perimetro: perimetro.toFixed(2),
    area: area.toFixed(2),
  };
}

// 5. Función para comprobar si un año es bisiesto
function esBisiesto(anio) {
  if ((anio % 4 === 0 && anio % 100 !== 0) || anio % 400 === 0) {
    return true;
  } else {
    return false;
  }
}

// 6. Conversor de hexadecimal a decimal
function hexa2decimal(hexadecimal) {
  let decimal = 0;
  const hexDigits = hexadecimal.toUpperCase(); // Paso los digitos a mayusculas

  for (let i = 0; i < hexDigits.length; i++) {
    const digito = hexDigits[i];
    decimal = decimal * 16 + digitoHexa2Dec(digito);
  }

  return decimal;
}

// Función auxiliar para convertir un dígito hexadecimal a decimal
function digitoHexa2Dec(digito) {
  const digitosValidos = "0123456789ABCDEF";
  const valor = digitosValidos.indexOf(digito.toUpperCase()); // Paso los digitos a mayusculas comprobando si es valido

  if (valor === -1) {
    throw new Error("Dígito hexadecimal no válido");
  }

  return valor;
}

// // Ejemplos de uso:
// console.log(comprobarEsPar(4)); // true
// console.log(verCalificacion(7)); // NOTABLE
// console.log(verCalificacionDecimal(8.5)); // NOTABLE
// console.log(parametrosCircunferencia(5)); // perimetro: "31.42", area: "78.54"
// console.log(esBisiesto(2024)); // true
// console.log(hexa2decimal("FA8")); // 4008
