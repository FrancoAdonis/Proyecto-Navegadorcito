-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2017 a las 00:55:05
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `navegadorcitodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `cod_asign` int(11) NOT NULL,
  `nom_asign` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `sigla` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`cod_asign`, `nom_asign`, `sigla`) VALUES
(100, 'prueba', 'pru001'),
(1180022, 'SEMINARIO DE MEMORIA', 'ICI315'),
(1180023, 'SEMINARIO DE INFORMATICA', 'ICI318'),
(1180024, 'INGENIERIA DE SOFTWARE II', 'ICI332'),
(1180025, 'TALLER DE BASES DE DATOS', 'ICI335'),
(1180026, 'SISTEMA INFORMACION DISTRIBUIDO', 'ICI342'),
(1180028, 'REDES DE COMPUTADORES', 'ICI344'),
(1180029, 'TALLER DE SISTEMAS OPERATIVOS', 'ICI345'),
(1180030, 'MANEJO DE DATOS Y SIST. DE INFORMACION', 'ICI351'),
(1180031, 'TALLER DE COMPILADORES', 'ICI356'),
(1180032, 'SIST. DE ADM. MODELOS DE INF.', 'ICI362'),
(1180033, 'SEM. DE LEGISLACION LABORAL', 'ICI366'),
(1180034, 'SEMINARIO DE LEGISLACION LABORAL', 'ICI367'),
(1180035, 'ADM.DE RECURSOS EN INFORMATIC', 'ICI371'),
(1180036, 'EST. ECO. DEL TRAT. DE LA INF', 'ICI372'),
(1180037, 'SIMULACION', 'ICI382'),
(1180039, 'INGENIERIA ECONOMICA', 'ICI391'),
(1180040, 'ECONOMETRIA', 'ICI392'),
(1180042, 'SISTEMA COMP. DISTRIBUIDOS', 'ICI394'),
(1180043, 'EVALUACION DE PROYECTOS', 'ICI395'),
(1180044, 'TALLER DE SIMULACION', 'ICI398'),
(1180048, 'INTRODUCCION A ING. INFORMATICA', 'IEI110'),
(1180049, 'COMPUTACION I', 'IEI121'),
(1180050, 'COMPUTACION II', 'IEI122'),
(1180052, 'PROGRAMACION', 'IEI131'),
(1180053, 'ELEMENTOS DE LENGUAJES DE PROGRAMACION', 'IEI132'),
(1180054, 'LENGUAJES DE PROGRAMACION', 'IEI133'),
(1180055, 'ELEM. DE ESTRUCTURA Y MANEJO DE DATOS', 'IEI134'),
(1180056, 'SISTEMAS DE COMPUTACION I', 'IEI141'),
(1180057, 'SISTEMAS OPERATIVOS', 'IEI142'),
(1180058, 'ADMINISTRACION EN INFORMATICA', 'IEI161'),
(1180059, 'TEORIA DE SISTEMAS', 'IEI162'),
(1180060, 'INTR. A LA INFORMATICA', 'IEI171'),
(1180061, 'TRABAJO DE TITULACION', 'IEI210'),
(1180062, 'SEMINARIO DE INFORMATICA', 'IEI218'),
(1180063, 'SEMINARIO DE S.I.A./COMPUTACION', 'IEI219'),
(1180064, 'ORGANIZACION Y MANEJO DE ARCHIVOS', 'IEI231'),
(1180065, 'INGENIERIA DE SOFTWARE', 'IEI232'),
(1180066, 'MODELO DE DATOS', 'IEI233'),
(1180067, 'TALLER DE ANALISIS DE SISTEMAS', 'IEI234'),
(1180068, 'TALLER DE DISEÑO DE SISTEMAS', 'IEI235'),
(1180069, 'TALLER DE PROGRAMACION', 'IEI238'),
(1180070, 'SISTEMAS DE COMPUTACION II', 'IEI241'),
(1180071, 'APLICACIONES EN COMPUTACION', 'IEI248'),
(1180072, 'ORGANIZACION Y METODOS', 'IEI261'),
(1180073, 'SISTEMAS DE GESTION', 'IEI262'),
(1180074, 'SISTEMAS DE INFORMACION I', 'IEI271'),
(1180075, 'TALLER DE SISTEMAS DE INFORMACION I', 'IEI272'),
(1180076, 'SISTEMAS DE INFORMACION II', 'IEI273'),
(1180077, 'TALLER DE SISTEMAS DE INFORMACION II', 'IEI274'),
(1180078, 'INVESTIGACION DE OPERACIONES', 'IEI281'),
(1180079, 'TALLER DE TITULACION', 'IEI311'),
(1180080, 'PROYECTO DE TITULACION PARA ING. INFORMATICA', 'IIN311'),
(1180081, 'INTR. A LA INGENIERIA', 'ILI111'),
(1180082, 'PROGRAMACION DE COMPUTADORES', 'ILI131'),
(1180083, 'TEORIA DE LENGUAJES', 'ILI132'),
(1180084, 'ESTRUCTURA DE DATOS I', 'ILI133'),
(1180085, 'ESTRUCTURA DE DATOS', 'ILI134'),
(1180086, 'RECUPERACION DE INFORMACION', 'ILI135'),
(1180087, 'TALLER DE PROGRAMACION', 'ILI140'),
(1180088, 'ARQ. DE SIST. DE COMPUTADORES', 'ILI141'),
(1180089, 'ARQUITECTURA DE COMPUTADORES I', 'ILI142'),
(1180090, 'MATEMATICA DISCRETA', 'ILI151'),
(1180091, 'FUNDAMENTOS DE INFORMATICA I', 'ILI152'),
(1180092, 'FUNDAMENTOS INFORMATICA II', 'ILI153'),
(1180093, 'DISEÑO Y ANALISIS DE ALGORITMOS', 'ILI221'),
(1180094, 'INGENIERIA DE SOFTWARE', 'ILI225'),
(1180095, 'TALLER DE DESARROLLO DE SOFTWARE', 'ILI228'),
(1180096, 'PROGRAMACION DE COMPUTADORES', 'ILI230'),
(1180097, 'TEORIA DE AUTOMATAS Y LENGUAJES FORMALES', 'ILI231'),
(1180099, 'ESTRUCTURA DE DATOS II', 'ILI233'),
(1180100, 'MODELO DE DATOS', 'ILI234'),
(1180101, 'INT. A LA ORGANIZACION Y MANEJO DE DATOS', 'ILI235'),
(1180102, 'FUNDAMENTOS DE INGENIERIA DE SOFTWARE', 'ILI236'),
(1180103, 'COMPILADORES', 'ILI237'),
(1180104, 'ORGANIZACION Y MANEJO DE ARCHIVOS', 'ILI238'),
(1180105, 'BASES DE DATOS', 'ILI239'),
(1180106, 'SISTEMAS OPERATIVOS', 'ILI241'),
(1180107, 'ARQUITECTURA DE COMPUTADORES II', 'ILI242'),
(1180108, 'SISTEMAS OPERATIVOS', 'ILI243'),
(1180110, 'ARQUITECTURA DE COMPUTADORES', 'ILI245'),
(1180111, 'SISTEMAS OPERATIVOS', 'ILI246'),
(1180112, 'PROGRAMACION DE COMPUTADORES PERSONALES', 'ILI249'),
(1180113, 'PRINCIPIOS DE LENGUAJES DE PROGRAMACION', 'ILI252'),
(1180114, 'LENGUAJES DE PROGRAMACION', 'ILI253'),
(1180115, 'INTR. A LA INFORMATICA TEORICA', 'ILI255'),
(1180116, 'REDES DE COMPUTADORES', 'ILI256'),
(1180117, 'TALLER DE SISTEMAS DE COMPUTACION', 'ILI258'),
(1180120, 'TEORIA DE SISTEMAS II', 'ILI262'),
(1180121, 'SISTEMAS Y ORGANIZACIONES', 'ILI263'),
(1180123, 'SISTEMAS DE GESTION', 'ILI266'),
(1180124, 'COMPORTAMIENTO, ORGANIZACION Y TECNOLOG.', 'ILI268'),
(1180125, 'SISTEMAS DE INFORMACION', 'ILI270'),
(1180126, 'SISTEMAS DE INFORMACION I', 'ILI271'),
(1180130, 'PROYECTO DE SISTEMAS DE INFORMACION', 'ILI275'),
(1180131, 'INFORMATICA Y SOCIEDAD', 'ILI276'),
(1180132, 'PROYECTO DE SIST.DE INFORMAC.', 'ILI278');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `cod_carrera` int(11) NOT NULL,
  `nom_carrera` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`cod_carrera`, `nom_carrera`) VALUES
(100, 'Ingeniería Civil Matemática'),
(110, 'Ingeniería Civil'),
(120, 'Construcción Civil123'),
(130, 'ArquitecturaA'),
(140, 'Ingeniería Civil Electrónica'),
(150, 'Ingeniería de Ejecución Electrónica'),
(160, 'Ingeniería Civil Eléctrica'),
(170, 'Ingeniería de Ejecución Eléctrica'),
(180, 'Ingeniería Eléctrica'),
(190, 'Ingeniería Electrónica'),
(210, 'Ingeniería Civil Telemática'),
(220, 'Ingeniería Mecánica Industrial'),
(230, 'Ingeniería Civil Mecánica'),
(240, 'Ingeniería de Ejecución Mecánica'),
(250, 'Ingeniería Mecánica Industrial'),
(280, 'Ingeniería Informatica'),
(500, 'nueva carrera mo'),
(1300, 'ArquitecturaB'),
(1400, 'Arquitecturacc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera_estudiante`
--

CREATE TABLE `carrera_estudiante` (
  `cod_carrera` int(11) NOT NULL,
  `usu_rut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `carrera_estudiante`
--

INSERT INTO `carrera_estudiante` (`cod_carrera`, `usu_rut`) VALUES
(280, 15042203),
(280, 15042726),
(280, 15043217),
(280, 15044368);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion_asignatura`
--

CREATE TABLE `inscripcion_asignatura` (
  `ins_año` int(11) NOT NULL,
  `ins_paralelo` int(11) NOT NULL,
  `ins_semestre` int(11) NOT NULL,
  `cod_asign` int(11) NOT NULL,
  `usu_rut` int(11) NOT NULL,
  `est_aprobado` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `est_inscripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `inscripcion_asignatura`
--

INSERT INTO `inscripcion_asignatura` (`ins_año`, `ins_paralelo`, `ins_semestre`, `cod_asign`, `usu_rut`, `est_aprobado`, `est_inscripcion`) VALUES
(2017, 1, 1, 1180023, 15042203, 'APROBADA', 'INSCRITA'),
(2017, 1, 1, 1180024, 15042203, 'REPROBADA', 'INSCRITA'),
(2017, 1, 1, 1180025, 15042203, 'APROBADA', 'INSCRITA'),
(2017, 1, 1, 1180026, 15042203, 'PENDIENTE', 'DESINSCRITA'),
(2017, 1, 1, 1180028, 15042203, 'APROBADA', 'INSCRITA'),
(2017, 1, 2, 1180024, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 1, 2, 1180043, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 1, 2, 1180044, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 1, 2, 1180048, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 1, 2, 1180049, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 1, 2, 1180050, 15042203, 'PENDIENTE', 'INSCRITA'),
(2017, 34, 2, 1180043, 13855538, 'PENDIENTE', 'INSCRITA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `malla_curricular`
--

CREATE TABLE `malla_curricular` (
  `cod_plan` int(11) NOT NULL,
  `cod_carrera` int(11) NOT NULL,
  `cod_asign` int(11) NOT NULL,
  `año_malla` int(11) NOT NULL,
  `vigente` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `malla_curricular`
--

INSERT INTO `malla_curricular` (`cod_plan`, `cod_carrera`, `cod_asign`, `año_malla`, `vigente`) VALUES
(1, 100, 100, 2000, 'VIGENTE'),
(1, 280, 1180022, 2018, 'NO VIGENTE'),
(1, 280, 1180043, 2017, 'VIGENTE'),
(1, 280, 1180048, 2017, 'VIGENTE'),
(1, 500, 500, 2017, 'VIGENTE'),
(1, 1300, 100, 2024, 'VIGENTE'),
(1, 1300, 1180040, 2017, '1'),
(1, 1400, 1180037, 2020, 'VIGENTE'),
(2, 280, 1180023, 2017, 'VIGENTE'),
(2, 280, 1180049, 2017, 'VIGENTE'),
(3, 280, 1180024, 2017, 'VIGENTE'),
(3, 280, 1180050, 2017, 'VIGENTE'),
(4, 280, 1180025, 2017, 'VIGENTE'),
(5, 280, 1180026, 2017, 'VIGENTE'),
(6, 280, 1180028, 2017, 'VIGENTE'),
(7, 280, 1180029, 2017, 'VIGENTE'),
(8, 280, 1180030, 2017, 'VIGENTE'),
(9, 280, 1180031, 2017, 'VIGENTE'),
(10, 280, 1180032, 2017, 'VIGENTE'),
(11, 280, 1180033, 2017, 'VIGENTE'),
(12, 280, 1180034, 2017, 'VIGENTE'),
(13, 280, 1180035, 2017, 'VIGENTE'),
(14, 280, 1180036, 2017, 'VIGENTE'),
(15, 280, 1180037, 2017, 'VIGENTE'),
(16, 280, 1180039, 2017, 'VIGENTE'),
(17, 280, 1180040, 2017, 'VIGENTE'),
(18, 280, 1180042, 2017, 'VIGENTE'),
(19, 280, 1180043, 2017, 'VIGENTE'),
(20, 280, 1180044, 2017, 'VIGENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `mat_año` int(11) NOT NULL,
  `mat_semestre` int(11) NOT NULL,
  `cod_carrera` int(11) NOT NULL,
  `usu_rut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`mat_año`, `mat_semestre`, `cod_carrera`, `usu_rut`) VALUES
(2017, 1, 280, 13855538),
(2017, 1, 280, 15042203),
(2017, 1, 280, 15042726),
(2017, 1, 280, 15043217),
(2017, 1, 280, 15044368),
(2017, 2, 280, 13855538),
(2017, 2, 280, 15042203),
(2017, 2, 280, 15042726),
(2017, 2, 280, 15043217),
(2017, 2, 280, 15044368),
(2018, 1, 280, 15043217);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programacion_profesor`
--

CREATE TABLE `programacion_profesor` (
  `pro_año` int(11) NOT NULL,
  `pro_semestre` int(11) NOT NULL,
  `cod_asign` int(11) NOT NULL,
  `pro_paralelo` int(11) NOT NULL,
  `usu_rut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `programacion_profesor`
--

INSERT INTO `programacion_profesor` (`pro_año`, `pro_semestre`, `cod_asign`, `pro_paralelo`, `usu_rut`) VALUES
(2017, 1, 1180023, 1, 7498940),
(2017, 1, 1180024, 1, 7498940),
(2017, 1, 1180025, 1, 7498940),
(2017, 1, 1180026, 1, 7498940),
(2017, 1, 1180028, 1, 7498940),
(2017, 2, 1180043, 1, 7498940),
(2017, 2, 1180043, 1, 13855538),
(2017, 2, 1180044, 1, 7498940),
(2017, 2, 1180048, 1, 7498940),
(2017, 2, 1180049, 1, 7498940),
(2017, 2, 1180050, 1, 7498940);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_perfil`
--

CREATE TABLE `tipo_perfil` (
  `cod_perfil` int(11) NOT NULL,
  `nom_perfil` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_perfil`
--

INSERT INTO `tipo_perfil` (`cod_perfil`, `nom_perfil`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'PROFESOR'),
(3, 'ESTUDIANTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usu_rut` int(11) NOT NULL,
  `usu_dv` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `usu_nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `usu_paterno` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `usu_materno` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cod_perfil` int(11) NOT NULL,
  `clave` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usu_rut`, `usu_dv`, `usu_nombre`, `usu_paterno`, `usu_materno`, `direccion`, `correo`, `cod_perfil`, `clave`) VALUES
(1234, '0', 'dde', 'ded', 'ddede', 'defrr', 'xedee@gmail.com', 2, '123'),
(7498940, '3', 'LUISA', 'VELASQUEZ', 'PALACIOS', 'LAS ROSAS 1235', 'luisa@gmail.com', 2, '123456'),
(13855538, '0', 'KARINA', 'PASTEN', 'VELASQUEZ', 'ALTAMIRANO 14199', 'karina.pasten@gmail.com', 1, '123'),
(15042203, '5', 'JOSE ANDRES', 'VILLARROEL', 'PACHECO', 'VILLA ALBORADAS N°S37', 'jose.villarroelz@alumno.cl', 3, '123'),
(15042726, '6', 'DANIEL PATRICIO', 'ORTIS', 'GUAJARDO', 'SAN PABLO 622', ' daniel.ortis@gmail.com', 3, '123456'),
(15043217, '0', 'ANA', 'SARGENTO', 'ARAYA', 'LA PALMA 234', 'asarmien123@gmail.com', 3, '123456'),
(15044368, '7', 'NELSON', 'CORTÉS', 'DÍAZ', 'PJE. 15  BLOCKS 1   CASAS DE VALENCIA', ' nelson.cortes@gmail.com', 3, '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`cod_asign`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`cod_carrera`);

--
-- Indices de la tabla `carrera_estudiante`
--
ALTER TABLE `carrera_estudiante`
  ADD PRIMARY KEY (`cod_carrera`,`usu_rut`);

--
-- Indices de la tabla `inscripcion_asignatura`
--
ALTER TABLE `inscripcion_asignatura`
  ADD PRIMARY KEY (`ins_año`,`ins_semestre`,`ins_paralelo`,`cod_asign`,`usu_rut`);

--
-- Indices de la tabla `malla_curricular`
--
ALTER TABLE `malla_curricular`
  ADD PRIMARY KEY (`cod_plan`,`cod_carrera`,`cod_asign`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`mat_año`,`mat_semestre`,`cod_carrera`,`usu_rut`);

--
-- Indices de la tabla `programacion_profesor`
--
ALTER TABLE `programacion_profesor`
  ADD PRIMARY KEY (`pro_año`,`pro_semestre`,`pro_paralelo`,`cod_asign`,`usu_rut`);

--
-- Indices de la tabla `tipo_perfil`
--
ALTER TABLE `tipo_perfil`
  ADD PRIMARY KEY (`cod_perfil`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usu_rut`),
  ADD KEY `KF_USU_TIPPER` (`cod_perfil`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `KF_USU_TIPPER` FOREIGN KEY (`cod_perfil`) REFERENCES `tipo_perfil` (`cod_perfil`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
