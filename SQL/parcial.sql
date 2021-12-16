-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-12-2021 a las 00:19:05
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET
time_zone = "+00:00";


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

CREATE TABLE `contactos`
(
    `ID_CONTACTO` int(11) NOT NULL,
    `DESCRIPCION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contactos`
--

INSERT INTO `contactos` (`ID_CONTACTO`, `DESCRIPCION`)
VALUES (1, 'EMAIL'),
       (2, 'SMS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios`
(
    `ID_USUARIO`      int(11) NOT NULL,
    `NOMBRE`          varchar(100) NOT NULL,
    `ESTADO`          varchar(20)  NOT NULL,
    `POSICION_PREMIO` int(11) DEFAULT NULL,
    `CANT_INTENTOS`   int(11) NOT NULL DEFAULT 0,
    `ID_CONTACTO`     int(11) NOT NULL,
    `TELEFONO`        varchar(20)  NOT NULL,
    `EMAIL`           varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_USUARIO`, `NOMBRE`, `ESTADO`, `POSICION_PREMIO`, `CANT_INTENTOS`, `ID_CONTACTO`, `TELEFONO`,
                        `EMAIL`)
VALUES (1, 'ALEXANDER', 'PARTICIPANTE', NULL, 0, 1, '+541168854315', 'alexorte03@gmail.com'),
       (2, 'GASTON', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com'),
       (3, 'DANIEL', 'PARTICIPANTE', NULL, 0, 1, '+541168854315', 'alexorte03@gmail.com'),
       (4, 'GUILLE', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com'),
       (5, 'RAQUEL', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com'),
       (6, 'CARLA', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com'),
       (7, 'ESTER', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com'),
       (8, 'NOEMI', 'PARTICIPANTE', NULL, 0, 2, '+541168854315', 'alexorte03@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_premio`
--

CREATE TABLE `usuario_premio`
(
    `ID_USUARIO_PREMIO` int(11) NOT NULL,
    `ID_USUARIO`        int(11) NOT NULL,
    `NOMBRE_PREMIO`     varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



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
    MODIFY `ID_CONTACTO` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
    MODIFY `ID_USUARIO` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario_premio`
--
ALTER TABLE `usuario_premio`
    MODIFY `ID_USUARIO_PREMIO` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
