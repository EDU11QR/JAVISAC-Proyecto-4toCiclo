-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-10-2024 a las 10:08:28
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
-- Base de datos: `bdjavisac1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `cod_det_venta` bigint(20) NOT NULL,
  `cant_det_venta` int(11) DEFAULT NULL,
  `monto_det_venta` double DEFAULT NULL,
  `pre_det_venta` double DEFAULT NULL,
  `producto_idp` bigint(20) DEFAULT NULL,
  `venta_cod_ven` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha` date NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `salario` double NOT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `apellido`, `email`, `fecha`, `nombre`, `salario`, `sexo`, `telefono`) VALUES
(1, 'Pérez', 'juan.perez@gmail.com', '1990-05-15', 'Juan', 2500, 'M', 912345678),
(2, 'Gómez', 'maria.gomez@outlook.com', '1985-11-20', 'María', 2800, 'F', 912345679),
(3, 'Sánchez', 'carlos.sanchez@gmail.com', '1992-02-28', 'Carlos', 2700, 'M', 912345680),
(4, 'Fernández', 'luis.fernandez@outlook.com', '1988-08-08', 'Luis', 2600, 'M', 912345681),
(5, 'Rodríguez', 'ana.rodriguez@gmail.com', '1993-10-10', 'Ana', 2900, 'F', 912345682),
(6, 'López', 'jorge.lopez@outlook.com', '1991-03-18', 'Jorge', 2400, 'M', 912345683),
(7, 'Martínez', 'laura.martinez@gmail.com', '1987-06-12', 'Laura', 3100, 'F', 912345684),
(8, 'García', 'franco.garcia@outlook.com', '1990-01-25', 'Franco', 2700, 'M', 912345685),
(9, 'Hernández', 'lucia.hernandez@gmail.com', '1986-12-15', 'Lucía', 2950, 'F', 912345686),
(10, 'Torres', 'jose.torres@outlook.com', '1994-04-20', 'José', 2600, 'M', 912345687),
(11, 'Ramírez', 'carla.ramirez@gmail.com', '1992-09-05', 'Carla', 2850, 'F', 912345688),
(12, 'Flores', 'pablo.flores@outlook.com', '1989-07-07', 'Pablo', 2750, 'M', 912345689),
(13, 'Díaz', 'marta.diaz@gmail.com', '1991-08-08', 'Marta', 2650, 'F', 912345690),
(14, 'Castro', 'pedro.castro@outlook.com', '1985-05-25', 'Pedro', 2550, 'M', 912345691),
(15, 'Reyes', 'sara.reyes@gmail.com', '1987-11-12', 'Sara', 3000, 'F', 912345692),
(16, 'Mendoza', 'david.mendoza@outlook.com', '1993-02-18', 'David', 2800, 'M', 912345693),
(17, 'Romero', 'luz.romero@gmail.com', '1990-12-01', 'Luz', 2950, 'F', 912345694),
(18, 'Rojas', 'andrea.rojas@outlook.com', '1989-03-22', 'Andrea', 3100, 'F', 912345695),
(19, 'Silva', 'edgar.silva@gmail.com', '1986-10-05', 'Edgar', 2650, 'M', 912345696),
(20, 'Cruz', 'gloria.cruz@outlook.com', '1992-09-09', 'Gloria', 3200, 'F', 912345697),
(21, 'Robles', 'jesus@gmail.com', '1999-05-11', 'Jorge', 10000, 'M', 94578120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idp` bigint(20) NOT NULL,
  `nombrep` varchar(255) DEFAULT NULL,
  `preciop` double NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idp`, `nombrep`, `preciop`, `stock`) VALUES
(1, 'Martillo de uña', 15.5, 45),
(2, 'Destornillador plano', 7.25, 80),
(3, 'Destornillador estrella', 7.5, 75),
(4, 'Alicate universal', 12, 40),
(5, 'Sierra manual', 18, 30),
(6, 'Taladro eléctrico', 120, 20),
(7, 'Llave inglesa', 25.5, 25),
(8, 'Cinta métrica 5m', 9, 60),
(9, 'Escalera de aluminio 3m', 150, 15),
(10, 'Pala de jardinero', 20, 45),
(11, 'Flexómetro 10m', 15, 35),
(12, 'Broca para concreto 6mm', 3.5, 100),
(13, 'Broca para madera 8mm', 3, 90),
(14, 'Llave de tubo', 22.5, 40),
(15, 'Serrucho de carpintero', 17, 30),
(16, 'Nivel de burbuja 30cm', 12.5, 50),
(17, 'Lima para metal', 10, 45),
(18, 'Mazo de goma', 13, 25),
(19, 'Caja de herramientas', 80, 20),
(20, 'Llave Allen set 10 piezas', 14, 60);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `cod_ven` bigint(20) NOT NULL,
  `fch_ven` datetime(6) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `empleado_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`cod_det_venta`),
  ADD KEY `FKa7k5rxd6in5hqjw2pknhvtvl2` (`producto_idp`),
  ADD KEY `FKht3xehys5j13y4vmmayn5v46k` (`venta_cod_ven`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idp`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`cod_ven`),
  ADD KEY `FKig2j5du6ft2ie7dohh2jri2ag` (`empleado_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `cod_det_venta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idp` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `cod_ven` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `FKa7k5rxd6in5hqjw2pknhvtvl2` FOREIGN KEY (`producto_idp`) REFERENCES `producto` (`idp`),
  ADD CONSTRAINT `FKht3xehys5j13y4vmmayn5v46k` FOREIGN KEY (`venta_cod_ven`) REFERENCES `venta` (`cod_ven`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FKig2j5du6ft2ie7dohh2jri2ag` FOREIGN KEY (`empleado_id`) REFERENCES `empleados` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
