-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema citasbibliograficas
--

CREATE DATABASE IF NOT EXISTS citasbibliograficas;
USE citasbibliograficas;

--
-- Definition of table `articulodperiodicoenlinea`
--

DROP TABLE IF EXISTS `articulodperiodicoenlinea`;
CREATE TABLE `articulodperiodicoenlinea` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Titulo` varchar(100) DEFAULT NULL,
  `TituloPeriodico` varchar(100) DEFAULT NULL,
  `FechaDia` varchar(10) DEFAULT NULL,
  `FechaMes` varchar(10) DEFAULT NULL,
  `FechaAnio` varchar(10) DEFAULT NULL,
  `NombreSitioWeb` varchar(100) DEFAULT NULL,
  `FechaAccesoDia` varchar(10) DEFAULT NULL,
  `FechaAccesoMes` varchar(10) DEFAULT NULL,
  `FechaAccesoAnio` varchar(10) DEFAULT NULL,
  `FK_Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulodperiodicoenlinea`
--

/*!40000 ALTER TABLE `articulodperiodicoenlinea` DISABLE KEYS */;
INSERT INTO `articulodperiodicoenlinea` (`Id`,`Apellido`,`Nombre`,`Titulo`,`TituloPeriodico`,`FechaDia`,`FechaMes`,`FechaAnio`,`NombreSitioWeb`,`FechaAccesoDia`,`FechaAccesoMes`,`FechaAccesoAnio`,`FK_Usuario`) VALUES 
 (1,'Brown','Dan','Dan brown y sus sombras','El reforma','10','12','2016','http://www.gandhi.com.mx/','10','10','2016',1);
/*!40000 ALTER TABLE `articulodperiodicoenlinea` ENABLE KEYS */;


--
-- Definition of table `articulorevista`
--

DROP TABLE IF EXISTS `articulorevista`;
CREATE TABLE `articulorevista` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `TituloArticulo` varchar(100) DEFAULT NULL,
  `TituloRevista` varchar(100) DEFAULT NULL,
  `Volumen` varchar(100) DEFAULT NULL,
  `NumEmision` varchar(100) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `PaginaInicioArt` int(11) DEFAULT NULL,
  `PaginaFinArt` int(11) DEFAULT NULL,
  `FK_Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulorevista`
--

/*!40000 ALTER TABLE `articulorevista` DISABLE KEYS */;
INSERT INTO `articulorevista` (`Id`,`Apellido`,`Nombre`,`TituloArticulo`,`TituloRevista`,`Volumen`,`NumEmision`,`Anio`,`PaginaInicioArt`,`PaginaFinArt`,`FK_Usuario`) VALUES 
 (1,'Balniere','Zero','Rothfuss y el mito de kvothe','Magos','4','2',2016,4,7,1);
/*!40000 ALTER TABLE `articulorevista` ENABLE KEYS */;


--
-- Definition of table `articulorevistaenlinea`
--

DROP TABLE IF EXISTS `articulorevistaenlinea`;
CREATE TABLE `articulorevistaenlinea` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Dia` int(11) DEFAULT NULL,
  `Mes` int(11) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `TituloArticulo` varchar(100) DEFAULT NULL,
  `TituloRevista` varchar(100) DEFAULT NULL,
  `PaginaInicioArt` int(11) DEFAULT NULL,
  `PaginaFinArt` int(11) DEFAULT NULL,
  `Editorial` varchar(100) DEFAULT NULL,
  `Volumen` varchar(100) DEFAULT NULL,
  `NumEmision` varchar(100) DEFAULT NULL,
  `FK_Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulorevistaenlinea`
--

/*!40000 ALTER TABLE `articulorevistaenlinea` DISABLE KEYS */;
INSERT INTO `articulorevistaenlinea` (`Id`,`Apellido`,`Nombre`,`Dia`,`Mes`,`Anio`,`TituloArticulo`,`TituloRevista`,`PaginaInicioArt`,`PaginaFinArt`,`Editorial`,`Volumen`,`NumEmision`,`FK_Usuario`) VALUES 
 (1,'Faurier','Johanna',10,12,2015,'Realidad y mentira en el sigo XX','Mentalidad actual',4,9,'Fugaz','4','4',1);
/*!40000 ALTER TABLE `articulorevistaenlinea` ENABLE KEYS */;


--
-- Definition of table `cita`
--

DROP TABLE IF EXISTS `cita`;
CREATE TABLE `cita` (
  `IdCita` int(11) NOT NULL AUTO_INCREMENT,
  `NombreAutor` varchar(100) DEFAULT NULL,
  `ApellidoPaterno` varchar(100) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `Titulo` varchar(100) DEFAULT NULL,
  `Editorial` varchar(100) DEFAULT NULL,
  `Pais` varchar(10) DEFAULT NULL,
  `FK_Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdCita`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cita`
--

/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` (`IdCita`,`NombreAutor`,`ApellidoPaterno`,`Anio`,`Titulo`,`Editorial`,`Pais`,`FK_Usuario`) VALUES 
 (5,'Patrick','Rothfuss',2012,'El temor de un hombre sabio','Trillas','EUA',1),
 (6,'Dan','Brown',2010,'El tesoro perdido','DeBolsillo','EUA',1);
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;


--
-- Definition of table `libroenlinea`
--

DROP TABLE IF EXISTS `libroenlinea`;
CREATE TABLE `libroenlinea` (
  `IdLibroEnLinea` int(11) NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `Titulo` varchar(50) DEFAULT NULL,
  `Pais` varchar(50) DEFAULT NULL,
  `Editorial` varchar(50) DEFAULT NULL,
  `SitioWeb` varchar(50) DEFAULT NULL,
  `FechaDia` int(11) DEFAULT NULL,
  `FechaMes` int(11) DEFAULT NULL,
  `FechaAnio` int(11) DEFAULT NULL,
  `Url` varchar(500) DEFAULT NULL,
  `FK_Usuairo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdLibroEnLinea`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `libroenlinea`
--

/*!40000 ALTER TABLE `libroenlinea` DISABLE KEYS */;
INSERT INTO `libroenlinea` (`IdLibroEnLinea`,`Apellido`,`Nombre`,`Anio`,`Titulo`,`Pais`,`Editorial`,`SitioWeb`,`FechaDia`,`FechaMes`,`FechaAnio`,`Url`,`FK_Usuairo`) VALUES 
 (2,'Rice','Anne',2016,'El principe lestat','2016','Trillas','http://www.gandhi.com.mx/',10,12,2016,'http://www.gandhi.com.mx/el-principe-lestat',1);
/*!40000 ALTER TABLE `libroenlinea` ENABLE KEYS */;


--
-- Definition of table `paginaweb`
--

DROP TABLE IF EXISTS `paginaweb`;
CREATE TABLE `paginaweb` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Apellido` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `RangoFecha` varchar(50) DEFAULT NULL,
  `TituloPagina` varchar(100) DEFAULT NULL,
  `LugarPublica` varchar(100) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  `dia` int(11) DEFAULT NULL,
  `FK_Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paginaweb`
--

/*!40000 ALTER TABLE `paginaweb` DISABLE KEYS */;
INSERT INTO `paginaweb` (`Id`,`Apellido`,`Nombre`,`RangoFecha`,`TituloPagina`,`LugarPublica`,`URL`,`Anio`,`mes`,`dia`,`FK_Usuario`) VALUES 
 (1,'Ballesteros','Johanna','2009-2010','Arquitectura','EUA','www.wikipedia.org/arquitectura',2015,12,10,1);
/*!40000 ALTER TABLE `paginaweb` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL DEFAULT '0',
  `Nombre` varchar(20) DEFAULT NULL,
  `aPaterno` varchar(20) DEFAULT NULL,
  `Contrasenia` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`IdUsuario`,`Nombre`,`aPaterno`,`Contrasenia`) VALUES 
 (1,'Carlos','Campos','Superman18');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
