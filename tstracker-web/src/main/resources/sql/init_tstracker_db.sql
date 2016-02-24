-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.28-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para tstracker
DROP DATABASE IF EXISTS `tstracker`;
CREATE DATABASE IF NOT EXISTS `tstracker` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tstracker`;


-- Volcando estructura para tabla tstracker.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `id_consultoria` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `FK334B85FAD0395C70` (`id_consultoria`),
  CONSTRAINT `FK334B85FAD0395C70` FOREIGN KEY (`id_consultoria`) REFERENCES `consultoria` (`id_consultoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.cliente: ~0 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.consultoria
DROP TABLE IF EXISTS `consultoria`;
CREATE TABLE IF NOT EXISTS `consultoria` (
  `id_consultoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `ejecutivo_cuenta` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_consultoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.consultoria: ~0 rows (aproximadamente)
DELETE FROM `consultoria`;
/*!40000 ALTER TABLE `consultoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultoria` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.consultoria_desarrollador
DROP TABLE IF EXISTS `consultoria_desarrollador`;
CREATE TABLE IF NOT EXISTS `consultoria_desarrollador` (
  `id_consultoria` bigint(20) NOT NULL,
  `nombre_desarrollador` varchar(255) NOT NULL,
  KEY `FK851E4DEE39A71DDC` (`nombre_desarrollador`),
  KEY `FK851E4DEED0395C70` (`id_consultoria`),
  CONSTRAINT `FK851E4DEE39A71DDC` FOREIGN KEY (`nombre_desarrollador`) REFERENCES `desarrollador` (`nombre_desarrollador`),
  CONSTRAINT `FK851E4DEED0395C70` FOREIGN KEY (`id_consultoria`) REFERENCES `consultoria` (`id_consultoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.consultoria_desarrollador: ~0 rows (aproximadamente)
DELETE FROM `consultoria_desarrollador`;
/*!40000 ALTER TABLE `consultoria_desarrollador` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultoria_desarrollador` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.desarrollador
DROP TABLE IF EXISTS `desarrollador`;
CREATE TABLE IF NOT EXISTS `desarrollador` (
  `nombre_desarrollador` varchar(255) NOT NULL,
  PRIMARY KEY (`nombre_desarrollador`),
  KEY `FK9DD2F8062D65E584` (`nombre_desarrollador`),
  CONSTRAINT `FK9DD2F8062D65E584` FOREIGN KEY (`nombre_desarrollador`) REFERENCES `usuario` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.desarrollador: ~1 rows (aproximadamente)
DELETE FROM `desarrollador`;
/*!40000 ALTER TABLE `desarrollador` DISABLE KEYS */;
INSERT INTO `desarrollador` (`nombre_desarrollador`) VALUES
	('asalas');
/*!40000 ALTER TABLE `desarrollador` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.lider_tecnico
DROP TABLE IF EXISTS `lider_tecnico`;
CREATE TABLE IF NOT EXISTS `lider_tecnico` (
  `id_lider_tecnico` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_lider_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.lider_tecnico: ~0 rows (aproximadamente)
DELETE FROM `lider_tecnico`;
/*!40000 ALTER TABLE `lider_tecnico` DISABLE KEYS */;
/*!40000 ALTER TABLE `lider_tecnico` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.proyecto
DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE IF NOT EXISTS `proyecto` (
  `id_proyecto` bigint(20) NOT NULL AUTO_INCREMENT,
  `clave` varchar(100) NOT NULL,
  `duracion_dias` int(11) NOT NULL,
  `estatus` varchar(30) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_lider_tecnico` bigint(20) NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `FKC54C7905C4AA2069` (`id_lider_tecnico`),
  KEY `FKC54C7905A81D2116` (`id_cliente`),
  CONSTRAINT `FKC54C7905A81D2116` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FKC54C7905C4AA2069` FOREIGN KEY (`id_lider_tecnico`) REFERENCES `lider_tecnico` (`id_lider_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.proyecto: ~0 rows (aproximadamente)
DELETE FROM `proyecto`;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.proyecto_desarrollador
DROP TABLE IF EXISTS `proyecto_desarrollador`;
CREATE TABLE IF NOT EXISTS `proyecto_desarrollador` (
  `id_proyecto` bigint(20) NOT NULL,
  `nombre_desarrollador` varchar(255) NOT NULL,
  KEY `FK75EE964C79D58128` (`id_proyecto`),
  CONSTRAINT `FK75EE964C79D58128` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.proyecto_desarrollador: ~0 rows (aproximadamente)
DELETE FROM `proyecto_desarrollador`;
/*!40000 ALTER TABLE `proyecto_desarrollador` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto_desarrollador` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.reporte
DROP TABLE IF EXISTS `reporte`;
CREATE TABLE IF NOT EXISTS `reporte` (
  `id_reporte` bigint(20) NOT NULL AUTO_INCREMENT,
  `estatus` varchar(255) DEFAULT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_final` date NOT NULL,
  `fecha_inicial` date NOT NULL,
  `id_proyecto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_reporte`),
  KEY `FK413E51B179D58128` (`id_proyecto`),
  CONSTRAINT `FK413E51B179D58128` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.reporte: ~0 rows (aproximadamente)
DELETE FROM `reporte`;
/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_rol` varchar(255) DEFAULT NULL,
  `descripcion_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.rol: ~0 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id_rol`, `codigo_rol`, `descripcion_rol`) VALUES
	(1, 'ROL_ADMIN', 'ROL_ADMIN'),
	(2, 'ROL_DESARROLLADOR', 'ROL_DESARROLLADOR'),
	(3, 'ROL_LIDER_TECNICO', 'ROL_LIDER_TECNICO'),
	(4, 'ROL_REPRESENTANTE_EMPRESA', 'ROL_REPRESENTANTE_EMPRESA');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.tarea
DROP TABLE IF EXISTS `tarea`;
CREATE TABLE IF NOT EXISTS `tarea` (
  `id_tarea` bigint(20) NOT NULL AUTO_INCREMENT,
  `actividad` varchar(150) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` date NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `tiempo_hrs` int(11) NOT NULL,
  `id_reporte` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `FK6907701C402B884` (`id_reporte`),
  CONSTRAINT `FK6907701C402B884` FOREIGN KEY (`id_reporte`) REFERENCES `reporte` (`id_reporte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.tarea: ~0 rows (aproximadamente)
DELETE FROM `tarea`;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre_usuario` varchar(255) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `password` varchar(30) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombre_usuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.usuario: ~1 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`nombre_usuario`, `apellidos`, `direccion`, `email`, `nombre`, `password`, `telefono`) VALUES
	('asalas', 'Salas', 'conocido', 'asalasmx@gmail.com', 'Antonino', 'desarrollo', '1061438');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


-- Volcando estructura para tabla tstracker.usuario_roles
DROP TABLE IF EXISTS `usuario_roles`;
CREATE TABLE IF NOT EXISTS `usuario_roles` (
  `nombre_usuario` varchar(255) NOT NULL,
  `id_rol` bigint(20) NOT NULL,
  KEY `FK4D484A6C1AD5B02C` (`nombre_usuario`),
  KEY `FK4D484A6CE59569C0` (`id_rol`),
  CONSTRAINT `FK4D484A6C1AD5B02C` FOREIGN KEY (`nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`),
  CONSTRAINT `FK4D484A6CE59569C0` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tstracker.usuario_roles: ~0 rows (aproximadamente)
DELETE FROM `usuario_roles`;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
INSERT INTO `usuario_roles` (`nombre_usuario`, `id_rol`) VALUES
	('asalas', 2);
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
