-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2025 a las 21:34:39
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
-- Base de datos: `ejercicio1__11_4`
--
CREATE DATABASE IF NOT EXISTS `ejercicio1__11_4` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE `ejercicio1__11_4`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
    `codigo` int(11) NOT NULL,
    `titulo` varchar(50) NOT NULL,
    `fecha_hora` datetime NOT NULL,
    `contenido` varchar(1000) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_spanish_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO
    `articulo` (
        `codigo`,
        `titulo`,
        `fecha_hora`,
        `contenido`
    )
VALUES (
        1,
        'Teclado Razer',
        '2025-01-15 21:32:28',
        'Es un teclado gaming.'
    ),
    (
        2,
        'Raton Razer DeathAdder',
        '2025-01-15 21:32:57',
        'Es un ratón gaming.'
    ),
    (
        3,
        'Nothing ear',
        '2025-01-15 21:33:36',
        'Auriculares inalámbricos con cancelación de ruido.'
    );

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo` ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 4;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;