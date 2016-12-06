-- MySQL dump 10.13  Distrib 5.1.44, for apple-darwin8.11.1 (i386)
--
-- Host: localhost    Database: citasbibliograficas
-- ------------------------------------------------------
-- Server version	5.1.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `aPaterno` varchar(100) DEFAULT NULL,
  `Contrasenia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'Carlos','Campos','superman18'),(2,'Romina','Padilla','superman18'),(3,'Diego','Balcazar','superman18');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulodperiodicoenlinea`
--

DROP TABLE IF EXISTS `articulodperiodicoenlinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulodperiodicoenlinea`
--

LOCK TABLES `articulodperiodicoenlinea` WRITE;
/*!40000 ALTER TABLE `articulodperiodicoenlinea` DISABLE KEYS */;
INSERT INTO `articulodperiodicoenlinea` VALUES (1,'Brown','Dan','Dan brown y sus sombras','El reforma','10','12','2016','http://www.gandhi.com.mx/','10','10','2016',1);
/*!40000 ALTER TABLE `articulodperiodicoenlinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulorevista`
--

DROP TABLE IF EXISTS `articulorevista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulorevista`
--

LOCK TABLES `articulorevista` WRITE;
/*!40000 ALTER TABLE `articulorevista` DISABLE KEYS */;
INSERT INTO `articulorevista` VALUES (1,'Balniere','Zero','Rothfuss y el mito de kvothe','Magos','4','2',2016,4,7,1);
/*!40000 ALTER TABLE `articulorevista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulorevistaenlinea`
--

DROP TABLE IF EXISTS `articulorevistaenlinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulorevistaenlinea`
--

LOCK TABLES `articulorevistaenlinea` WRITE;
/*!40000 ALTER TABLE `articulorevistaenlinea` DISABLE KEYS */;
INSERT INTO `articulorevistaenlinea` VALUES (1,'Faurier','Johanna',10,12,2015,'Realidad y mentira en el sigo XX','Mentalidad actual',4,9,'Fugaz','4','4',1);
/*!40000 ALTER TABLE `articulorevistaenlinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES (5,'Patrick','Rothfuss',2012,'El temor de un hombre sabio','Trillas','EUA',1),(6,'Dan','Brown',2010,'El tesoro perdido','DeBolsillo','EUA',1),(7,'Isabel','Allende',1990,'La ciudad de las bestias','Trillas','UND',3);
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libroenlinea`
--

DROP TABLE IF EXISTS `libroenlinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libroenlinea`
--

LOCK TABLES `libroenlinea` WRITE;
/*!40000 ALTER TABLE `libroenlinea` DISABLE KEYS */;
INSERT INTO `libroenlinea` VALUES (2,'Rice','Anne',2016,'El principe lestat','2016','Trillas','http://www.gandhi.com.mx/',10,12,2016,'http://www.gandhi.com.mx/el-principe-lestat',1);
/*!40000 ALTER TABLE `libroenlinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginaweb`
--

DROP TABLE IF EXISTS `paginaweb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginaweb`
--

LOCK TABLES `paginaweb` WRITE;
/*!40000 ALTER TABLE `paginaweb` DISABLE KEYS */;
INSERT INTO `paginaweb` VALUES (1,'Ballesteros','Johanna','2009-2010','Arquitectura','EUA','www.wikipedia.org/arquitectura',2015,12,10,1);
/*!40000 ALTER TABLE `paginaweb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-25 13:57:49
