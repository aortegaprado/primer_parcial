-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2021 a las 04:57:47
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parcial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactos`
--

CREATE TABLE `contactos` (
  `ID_CONTACTO` int(11) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contactos`
--

INSERT INTO `contactos` (`ID_CONTACTO`, `DESCRIPCION`) VALUES
(1, 'EMAIL'),
(2, 'SMS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_USUARIO` int(11) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `ESTADO` varchar(20) NOT NULL,
  `POSICION_PREMIO` int(11) DEFAULT NULL,
  `CANT_INTENTOS` int(11) NOT NULL DEFAULT 0,
  `ID_CONTACTO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_USUARIO`, `NOMBRE`, `ESTADO`, `POSICION_PREMIO`, `CANT_INTENTOS`, `ID_CONTACTO`) VALUES
(2, 'ALEXANDER', 'PREMIO_NOTIFICADO', 3, 0, 1),
(3, 'GASTON', 'PERDEDOR', NULL, 1, 2),
(4, 'DANIEL', 'PREMIO_NOTIFICADO', 1, 0, 1),
(5, 'PEDRO', 'PREMIO_NOTIFICADO', 2, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_premio`
--

CREATE TABLE `usuario_premio` (
  `ID_USUARIO_PREMIO` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `NOMBRE_PREMIO` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_premio`
--

INSERT INTO `usuario_premio` (`ID_USUARIO_PREMIO`, `ID_USUARIO`, `NOMBRE_PREMIO`) VALUES
(1, 4, 'iphone 13'),
(2, 4, 'Comida Balanceada * 1 año'),
(3, 4, 'peluqueria Mascota * 1año'),
(4, 5, 'Mixer Philips'),
(5, 5, 'Comida Balanceada * 1 año'),
(6, 5, 'peluqueria Mascota * 1año'),
(7, 2, 'Comida Balanceada * 1 año'),
(8, 2, 'peluqueria Mascota * 1año');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contactos`
--
ALTER TABLE `contactos`
  ADD PRIMARY KEY (`ID_CONTACTO`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `CTS_ID_CONTACTO` (`ID_CONTACTO`);

--
-- Indices de la tabla `usuario_premio`
--
ALTER TABLE `usuario_premio`
  ADD PRIMARY KEY (`ID_USUARIO_PREMIO`),
  ADD KEY `CONT_ID_USUARIO` (`ID_USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contactos`
--
ALTER TABLE `contactos`
  MODIFY `ID_CONTACTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario_premio`
--
ALTER TABLE `usuario_premio`
  MODIFY `ID_USUARIO_PREMIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `CTS_ID_CONTACTO` FOREIGN KEY (`ID_CONTACTO`) REFERENCES `contactos` (`ID_CONTACTO`);

--
-- Filtros para la tabla `usuario_premio`
--
ALTER TABLE `usuario_premio`
  ADD CONSTRAINT `CONT_ID_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID_USUARIO`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
