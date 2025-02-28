-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-01-2025 a las 11:06:02
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
-- Base de datos: `tienda_tractores`
--
CREATE DATABASE IF NOT EXISTS `tienda_tractores` DEFAULT CHARACTER SET utf32 COLLATE utf32_spanish_ci;
USE `tienda_tractores`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tractor`
--

DROP TABLE IF EXISTS `tractor`;
CREATE TABLE `tractor` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `imagen` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish_ci;

--
-- Volcado de datos para la tabla `tractor`
--

INSERT INTO `tractor` (`codigo`, `nombre`, `precio`, `imagen`, `descripcion`, `stock`) VALUES
(0, 'Tractor de prueba 1', 15900, '', 'Descripción del tractor de prueba 1.', 3),
(1, 'Tractor de prueba 2', 24750, '', 'Descripción del tractor de prueba 2', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tractor`
--
ALTER TABLE `tractor`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tractor`
--
ALTER TABLE `tractor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
