-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2022 a las 21:04:23
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recipick`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('valez', 'ADMIN'),
('normal1', 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `id` int(3) NOT NULL,
  `idUsuario` int(3) NOT NULL,
  `idReceta` int(3) NOT NULL,
  `cuerpo` varchar(255) NOT NULL,
  `isRecetas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likes`
--

CREATE TABLE `likes` (
  `idUsuario` int(3) NOT NULL,
  `idReceta` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `id` int(3) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(2500) NOT NULL,
  `recetaOriginal` int(3) DEFAULT NULL,
  `usuarios` int(3) NOT NULL,
  `ingredientes` varchar(255) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `recetas`
--

INSERT INTO `recetas` (`id`, `nombre`, `descripcion`, `recetaOriginal`, `usuarios`, `ingredientes`, `imagen`) VALUES
(1, 'Pizza napoletana', '\r\n\r\nMezclar la harina con una pizca de sal.Disolver la levadura en agua templada y añadir una cucharada de aceite.Hacer un hueco en la harina y añadir desp', NULL, 1, '- Harina 500g\r\n- Agua 300/400ml\r\n- Aceite\r\n- Tomate\r\n- Mozzarella\r\n- Una pizca de sal\r\n- Levadura 8g', 'napolitana.jpg'),
(6, 'Pasta a la carbonara', 'Cocer la pasta al dente.\r\nBatir las yemas de huevo añadiendo el parmesano poco a poco, una pizca de sal y de pimienta negra recién molida.\r\nEn una sarten preparar el guanciale hasta que suelte toda la grasa y se quede doradito.\r\nUna vez lista la pasta,añadir el guanciale con la grasa para que no se pegue.Añadir el batido de yema con parmesano, sal y pimienta y una cucharada de agua de cocción y añadirla a la pasta.\r\nMover hasta que el huevo quede como una cremita, sin cocerse.Disfruta!', NULL, 1, '- 2 huevos (yema);\r\n- 150g de queso parmesano rallado;\r\n- 120g guanciale;\r\n- sal y pimienta;\r\n- un pequeño chorrito de aceite de oliva (al gusto);\r\n- 400g espaguettis.\r\n\r\n', 'carbonara.jpg'),
(8, 'Tortilla de patatas', 'Pelar y cortar las patatas en rodajas finitas y freir en una sarten hasta que queden crujientes.\r\nBate los huevos y añade sal.\r\nUna vez listas las papatas quita el aceite que sobre y juntalas con los huevos batidos en una sarten.\r\nCuecela dos minutos a fuego normal por cada lado (estilo Betanzos) o 4 minutos si la quieres más hecha.', NULL, 1, '- Patatas 700 g\r\n- Huevos 6\r\n- Sal\r\n- Aceite de oliva\r\n', 'tortilla.jpg'),
(9, 'Lasaña Boloñesa', 'Haz un sofrito de lo que más te guste para la carne picada.\r\nAñade la carne picada y dejala a fuego lento durante unos minutos hasta que se pierda el color rojo.\r\nPon la fritada de tomate y deja cocer a fuego lento durante 2 h.\r\nCuando la carne esté lista, prepara la bechamel.\r\nBechamel : un dadito de mantequilla en una ollita hasta que se derrita.Añade leche hasta la mitad, sal y nuez moscada.\r\nCon la leche caliente, añade harina poco a poco removiendo hasta que quede la bechamel.Que quede algo liquida para que sea más facil luego.\r\nAhora en una bandeja de horno añade algo de salsa boloñesa al fondo para que no pegue (muy poquito será suficiente).\r\nEl proceso es el siguiente:\r\n- una capa de laminas de pasta\r\n- una capa de bechamel\r\n- una capa de salsa\r\nCada capa encima de la otra hasta llenar la bandeja.\r\nCuando acabes, cubre la ultima capa con parmesano rallado, no te cortes cuanto más mejor!\r\nHornea 35 minutos a 200 grados con papel albal, y luego otros 10 minutos sin papel en modo gratinado.', NULL, 1, '- 1kg de carne picada (mix ternera y cerdo)\r\n- laminas de pasta\r\n- 800 g de tomate frito\r\n- harina\r\n- mantequilla\r\n- leche\r\n- nuez moscada\r\n- parmesano\r\n- sal \r\n- pimienta negra', 'lasagna.jpg'),
(13, 'imagen prueba', 'imghhhdhdhsjj', NULL, 1, 'imagen', 'JF0FCH11logo3.png'),
(17, 'prueba22222', 'ghjhjghjghj', NULL, 1, 'erqrwqeqweqrqw', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(3) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `email`, `password`, `username`, `fechaRegistro`) VALUES
(1, 'Valentino', 'Zampieri', 'valentino.z88@gmail.com', 'soymuymalo', 'valez', NULL),
(3, 'normal', 'normal', 'normal@gmail.com', 'soynormal', 'normal1', NULL),
(4, 'manuel', 'rico', 'rico123@gmail.com', 'soyrico', 'rico', '2022-06-05');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `username` (`username`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`,`idReceta`),
  ADD KEY `idReceta` (`idReceta`),
  ADD KEY `FKs7j5cpatb3i50o1utp00b8hmh` (`isRecetas`);

--
-- Indices de la tabla `likes`
--
ALTER TABLE `likes`
  ADD UNIQUE KEY `UK_b2t86o8d8evryokkj8bc543fq` (`idUsuario`),
  ADD KEY `idUsuario` (`idUsuario`,`idReceta`),
  ADD KEY `idReceta` (`idReceta`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recetaOriginal` (`recetaOriginal`),
  ADD KEY `usuario` (`usuarios`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recetas`
--
ALTER TABLE `recetas`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `FKs7j5cpatb3i50o1utp00b8hmh` FOREIGN KEY (`isRecetas`) REFERENCES `recetas` (`id`),
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`idReceta`) REFERENCES `recetas` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`idReceta`) REFERENCES `recetas` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `recetas_ibfk_1` FOREIGN KEY (`recetaOriginal`) REFERENCES `recetas` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `recetas_ibfk_2` FOREIGN KEY (`usuarios`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
