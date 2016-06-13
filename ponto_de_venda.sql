-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ponto_de_venda_development
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

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
-- Current Database: `ponto_de_venda_development`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ponto_de_venda_development` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ponto_de_venda_development`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `codcli` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) DEFAULT NULL,
  `bonus` float DEFAULT '0',
  `perfil` varchar(1) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`codcli`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Taco Bell',400,'P','A'),(2,'Extra Hipermercados',0,'G','A');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descontos`
--

DROP TABLE IF EXISTS `descontos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descontos` (
  `id_desconto` int(11) NOT NULL AUTO_INCREMENT,
  `codprod` int(11) NOT NULL,
  `percentual` int(11) DEFAULT NULL,
  `qtd_min` int(11) DEFAULT NULL,
  `qtd_max` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_desconto`),
  KEY `codprod` (`codprod`),
  CONSTRAINT `descontos_ibfk_1` FOREIGN KEY (`codprod`) REFERENCES `produtos` (`codprod`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descontos`
--

LOCK TABLES `descontos` WRITE;
/*!40000 ALTER TABLE `descontos` DISABLE KEYS */;
INSERT INTO `descontos` VALUES (1,4,20,3,20);
/*!40000 ALTER TABLE `descontos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `codlocal` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) DEFAULT NULL,
  `endereco` varchar(80) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`codlocal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'PEPSICO','RUA DA SILVA','(11) 3897-4578'),(2,'Coca-cola Company','USA','555-2347');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `codprod` int(11) NOT NULL AUTO_INCREMENT,
  `codlocal` int(11) NOT NULL,
  `descricao` varchar(35) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `preco_unitario` float DEFAULT NULL,
  PRIMARY KEY (`codprod`),
  KEY `codlocal` (`codlocal`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`codlocal`) REFERENCES `localidades` (`codlocal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,1,'Refrigerante Pepsi',1,3.5),(2,2,'Refrigerante Coca-cola',14,5.5),(3,1,'Biscoito Lucky',0,1),(4,2,'Refrigerante Sprite',146,3);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas` (
  `codcli` int(11) NOT NULL,
  `codprod` int(11) NOT NULL,
  `codlocal` int(11) NOT NULL,
  `qtd_venda` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `data_venda` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`codcli`,`codprod`,`codlocal`,`data_venda`),
  KEY `fk_codprod` (`codprod`),
  KEY `fk_codlocal` (`codlocal`),
  CONSTRAINT `fk_codcli` FOREIGN KEY (`codcli`) REFERENCES `clientes` (`codcli`),
  CONSTRAINT `fk_codlocal` FOREIGN KEY (`codlocal`) REFERENCES `localidades` (`codlocal`),
  CONSTRAINT `fk_codprod` FOREIGN KEY (`codprod`) REFERENCES `produtos` (`codprod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (1,1,2,7,24.5,'2016-06-12 20:33:45'),(1,2,1,3,16.5,'2016-06-11 00:53:20'),(1,2,2,2,9.9,'2016-06-11 15:08:51'),(1,3,1,2,1.8,'2016-06-11 15:16:38'),(1,4,2,4,8.64,'2016-06-12 19:56:44'),(2,1,2,2,7,'2016-06-13 14:46:19');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13 15:09:08
