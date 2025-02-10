-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-01-2025 a las 20:36:04
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
-- Base de datos: `ejercicio6__10_5`
--
CREATE DATABASE IF NOT EXISTS `ejercicio6__10_5` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `ejercicio6__10_5`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `dia` varchar(20) NOT NULL,
  `primera` varchar(55) NOT NULL,
  `segunda` varchar(55) NOT NULL,
  `tercera` varchar(55) NOT NULL,
  `cuarta` varchar(55) NOT NULL,
  `quinta` varchar(55) NOT NULL,
  `sexta` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`dia`, `primera`, `segunda`, `tercera`, `cuarta`, `quinta`, `sexta`) VALUES
('Lunes', 'Empresa e Iniciativa Emprendedora', 'Empresa e Iniciativa Emprendedora', 'Empresa e Iniciativa Emprendedora', 'Empresa e Iniciativa Emprendedora', 'Desarrollo Web en Entorno Servidor', 'Desarrollo Web en Entorno Servidor'),
('Martes', 'Despliegue de Aplicaciones Web', 'Despliegue de Aplicaciones Web', 'Despliegue de Aplicaciones Web', 'Diseño de Interfaces Web', 'Diseño de Interfaces Web', 'Diseño de Interfaces Web'),
('Miercoles', 'Empresa e Iniciativa Emprendedora', 'Despliegue de Aplicaciones Web', 'Desarrollo Web en Entorno Cliente', 'Desarrollo Web en Entorno Servidor', 'Desarrollo Web en Entorno Servidor', 'Desarrollo Web en Entorno Servidor'),
('Jueves', 'Diseño de Interfaces Web', 'Empresa e Iniciativa Emprendedora', 'Diseño de Interfaces Web', 'Desarrollo Web en Entorno Servidor', 'Desarrollo Web en Entorno Servidor', 'Desarrollo Web en Entorno Servidor'),
('Viernes', 'Horas de Libre Configuracion', 'Horas de Libre Configuracion', 'Empresa e Iniciativa Emprendedora', 'Desarrollo Web en Entorno Cliente', 'Desarrollo Web en Entorno Cliente', 'Desarrollo Web en Entorno Cliente');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
