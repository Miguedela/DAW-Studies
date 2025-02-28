-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-01-2025 a las 18:21:22
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
-- Base de datos: `almacen`
--
CREATE DATABASE IF NOT EXISTS `ejercicio5__10_5` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `ejercicio5__10_5`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `codigo` varchar(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `precio_compra` float NOT NULL,
  `precio_venta` float NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`codigo`, `descripcion`, `precio_compra`, `precio_venta`, `stock`) VALUES
('h020', 'Barra acero 16mm longitud 6m', 35.3, 45.4, 50),
('h007', 'barra para cortina 2,00 m.', 10.3, 22.33, 5),
('h005', 'Caja tuercas 16mm', 21, 25.05, 20),
('h006', 'Chapa galvanizada', 10.5, 20.55, 3),
('m001', 'Estanteria para pared', 25.3, 30.6, 5),
('h008', 'Caja tornillos planos', 19.05, 24.55, 6),
('h009', 'Caja de arandelas 50 piezas', 12.55, 19.99, 10),
('h010', 'Caja tornillos estrella', 19.05, 24.55, 8);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
