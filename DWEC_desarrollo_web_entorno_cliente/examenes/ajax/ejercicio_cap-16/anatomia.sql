-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-01-2025 a las 20:04:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;

--
-- Base de datos: `anatomia`
--
CREATE DATABASE IF NOT EXISTS `anatomia` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE `anatomia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anatomia`
--

CREATE TABLE `anatomia` (
    `id` int(11) NOT NULL,
    `descripcion` text NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_spanish_ci;

--
-- Volcado de datos para la tabla `anatomia`
--

INSERT INTO
    `anatomia` (`id`, `descripcion`)
VALUES (
        1,
        'El corazón (del latín: cor) es el órgano principal del aparato circulatorio de los animales.En mamíferos y aves, el corazón se divide en cuatro cámaras: la aurícula derecha, la aurícula izquierda, el ventrículo derecho y el ventrículo izquierdo.'
    ),
    (
        2,
        'Los pulmones son estructuras anatómicas pertenecientes al sistema respiratorio, se ubican en la caja torácica, a ambos lados del mediastino. Debido al espacio ocupado por el corazón, el pulmón derecho es más grande que su homólogo izquierdo. '
    ),
    (
        3,
        'El esqueleto humano es el conjunto de huesos que proporciona al cuerpo humano su estructura. En el adulto consta de 206 huesos. Otros autores, dependiendo de sus propias consideraciones, citan hasta 210.\r\nEstá formado por tejido óseo y tejido cartilaginoso.'
    ),
    (
        4,
        'El aparato digestivo es el conjunto de órganos encargados del proceso de la digestión, es decir, la transformación de los alimentos para que puedan ser absorbidos y utilizados por las células del organismo.'
    ),
    (
        5,
        'Los riñones son los órganos principales del aparato urinario humano. Se encargan de la excreción de sustancias de desecho a través de la orina y cuentan con otras funciones muy importantes, entre ellas la regulación del equilibrio del medio interno del organismo (homeostasis), controlando el volumen de los líquidos extracelulares, la osmolaridad del plasma sanguíneo, el balance de electrolitos y el pH del medio interno.'
    ),
    (
        6,
        'El páncreas (del griego πάνκρεας) es un órgano del aparato digestivo y del sistema endocrino de los vertebrados.​ En los seres humanos se localiza en la cavidad abdominal, justo detrás del estómago.'
    );

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anatomia`
--
ALTER TABLE `anatomia` ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anatomia`
--
ALTER TABLE `anatomia`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 7;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;