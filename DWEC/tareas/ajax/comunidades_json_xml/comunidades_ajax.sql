-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2025 a las 20:58:35
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `comunidades_ajax`
--
CREATE DATABASE IF NOT EXISTS `comunidades_ajax` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `comunidades_ajax`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comunidades_autonomas`
--

CREATE TABLE `comunidades_autonomas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `comunidades_autonomas`
--

INSERT INTO `comunidades_autonomas` (`id`, `nombre`) VALUES
(1, 'Andalucía'),
(3, 'Extremadura'),
(4, 'Murcia'),
(2, 'Valencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE `provincias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_comunidad_autonoma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`id`, `nombre`, `id_comunidad_autonoma`) VALUES
(1, 'Sevilla', 1),
(2, 'Cádiz', 1),
(3, 'Málaga', 1),
(4, 'Castellon', 2),
(5, 'Alicante', 2),
(6, 'Cáceres', 3),
(7, 'Badajoz', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comunidades_autonomas`
--
ALTER TABLE `comunidades_autonomas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique` (`nombre`);

--
-- Indices de la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_comunidad_autonoma` (`id_comunidad_autonoma`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comunidades_autonomas`
--
ALTER TABLE `comunidades_autonomas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `provincias`
--
ALTER TABLE `provincias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD CONSTRAINT `provincias_ibfk_1` FOREIGN KEY (`id_comunidad_autonoma`) REFERENCES `comunidades_autonomas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
