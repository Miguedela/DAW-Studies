<?php
// 1 esCapicua: Devuelve  verdadero si el número que  se pasa como  parámetro es capicúa  y falso en caso 
// contrario. 
function esCapicua($num)
{
    $numReves = voltea($num);

    if ($num == $numReves) {
        return true;
    } else {
        return false;
    }
}

// 2 esPrimo:  Devuelve  verdadero  si  el  número  que  se  pasa  como  parámetro  es  primo  y  falso  en  caso 
// contrario.
function esPrimo($num)
{
    $esPrimo = true;

    if (($num == 0) || ($num == 1)) {
        $esPrimo = false;
    }

    for ($i = 2; $i < $num; $i++) {
        if ($num % $i == 0) {
            $esPrimo = false;
        }
    }

    return $esPrimo;
}

// 3 siguientePrimo: Devuelve el menor primo que es mayor al número que se pasa como parámetro.
function siguientePrimo($num)
{
    do {
        $num++;
    } while (!esPrimo($num));
    return $num;
}

// 4 potencia: Dada una base y un exponente devuelve la potencia. 
function potencia($base, $exponente)
{
    if ($exponente == 0) {
        return 1;
    }

    $aux = $base;

    for ($i = 1; $i < $exponente; $i++) {
        $aux *= $base;
    }

    return $aux;
}

// 5 digitos: Cuenta el número de dígitos de un número entero. 
function digitos($num)
{
    $aux = 0;

    do {
        $num /= 10;
        $aux++;
    } while ($num >= 1);

    return $aux;
}

// 6 voltea: Le da la vuelta a un número.
function voltea($num)
{
    $aux = 0;

    while ($num >= 1) {
        $aux = ($aux * 10) + ($num % 10);
        $num = (int)($num / 10);
    }

    return $aux;
}

// 7 digitosN: Devuelve el dígito que está en la posición n de un número entero. Se empieza contando por el 
// 0 y de izquierda a derecha. 
function digitoN($num, $posicion)
{
    $num = trozoDeNumero($num, ($posicion + 1), ($posicion + 1));
    return $num;
}

// 8 posicionDeDigito: Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si 
// no se encuentra, devuelve -1. 
function posicionDeDigito($num, $numBuscador)
{
    for ($i = 0; $i < digitos($num); $i++) {
        $aux = digitoN($num, $i);
        if ($aux == $numBuscador) {
            return ($i + 1);
        }
    }

    return -1;
}

// 9 quitaPorDetras: Le quita a un número n dígitos por detrás (por la derecha). 
function quitaPorDetras($num, $eliminar)
{
    for ($i = 0; $i < $eliminar; $i++) {
        $num = $num / 10;
    }

    return (int)$num;
}

// 10 quitaPorDelante: Le quita a un número n dígitos por delante (por la izquierda).
function quitaPorDelante($num, $eliminar)
{
    $numReves = voltea($num);

    for ($i = 0; $i < $eliminar; $i++) {
        $numReves = $numReves / 10;
    }

    return voltea((int)$numReves);
}

// 11 pegaPorDetras: Añade un dígito a un número por detrás.
function pegaPorDetras($num, $numAnadir)
{
    return (int)($num * 10) + $numAnadir;
}

// 12 pegaPorDelante: Añade un dígito a un número por delante. 
function pegaPorDelante($num, $numAnadir)
{
    $num = voltea($num);
    $num = (int)($num * 10) + $numAnadir;
    return voltea($num);
}

// 13 trozoDeNumero: Toma como parámetros las posiciones inicial y final dentro de un número y devuelve 
// el trozo correspondiente. 
function trozoDeNumero($num, $posicion1, $posicion2)
{
    $aux = $num;
    if ($posicion1 != 1) {
        $num = quitaPorDelante($num, ($posicion1 - 1));
    }
    if ($posicion2 < digitos($aux)) {
        $num = quitaPorDetras($num, (digitos($aux) - $posicion2));
    }
    return $num;
}

// 14 juntaNumeros: Pega dos números para formar uno.
function juntaNumeros($num1, $num2)
{
    $num2Cant = digitos($num2);
    return $num1 * pow(10, $num2Cant) + $num2;
}
