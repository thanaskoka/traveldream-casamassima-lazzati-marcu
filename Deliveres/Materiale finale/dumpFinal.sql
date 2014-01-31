CREATE DATABASE  IF NOT EXISTS `traveldreamdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `traveldreamdb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: traveldreamdb
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `acquistapacchetto`
--

DROP TABLE IF EXISTS `acquistapacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acquistapacchetto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtente` varchar(45) DEFAULT NULL,
  `idPacchetto` int(11) DEFAULT NULL,
  `numPers` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_idx` (`idUtente`),
  KEY `pacchetto_idx` (`idPacchetto`),
  CONSTRAINT `pacchetto_acq_pacch` FOREIGN KEY (`idPacchetto`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `utente_acqu_pacch` FOREIGN KEY (`idUtente`) REFERENCES `users` (`EMAIL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acquistapacchetto`
--

LOCK TABLES `acquistapacchetto` WRITE;
/*!40000 ALTER TABLE `acquistapacchetto` DISABLE KEYS */;
INSERT INTO `acquistapacchetto` VALUES (1,'user@user.com',48,2),(2,'user@user.com',54,1),(3,'user@user.com',55,1),(4,'user@user.com',56,1);
/*!40000 ALTER TABLE `acquistapacchetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aderiscegiftlist`
--

DROP TABLE IF EXISTS `aderiscegiftlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aderiscegiftlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtente` varchar(45) NOT NULL,
  `idGift` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_idx` (`idUtente`),
  KEY `gift_idx` (`idGift`),
  CONSTRAINT `gift` FOREIGN KEY (`idGift`) REFERENCES `giftlist` (`idGiftlist`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aderiscegiftlist`
--

LOCK TABLES `aderiscegiftlist` WRITE;
/*!40000 ALTER TABLE `aderiscegiftlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `aderiscegiftlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `albergo`
--

DROP TABLE IF EXISTS `albergo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `albergo` (
  `idAlbergo` int(11) NOT NULL AUTO_INCREMENT,
  `idLuogo` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `numero_stelle` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAlbergo`),
  KEY `luogo_idx` (`idLuogo`),
  CONSTRAINT `luogoalbergo` FOREIGN KEY (`idLuogo`) REFERENCES `luogo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albergo`
--

LOCK TABLES `albergo` WRITE;
/*!40000 ALTER TABLE `albergo` DISABLE KEYS */;
INSERT INTO `albergo` VALUES (6,13,'romano1',4),(8,13,'romano2',4),(9,13,'romano3',3);
/*!40000 ALTER TABLE `albergo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camera`
--

DROP TABLE IF EXISTS `camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camera` (
  `nrCamera` int(11) NOT NULL,
  `idAlbergo` int(11) NOT NULL,
  `numPersCam` int(10) unsigned DEFAULT NULL,
  `CostoPersoneCam` float DEFAULT NULL,
  `idCamera` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCamera`),
  KEY `albergoid_idx` (`idAlbergo`),
  CONSTRAINT `albergoid` FOREIGN KEY (`idAlbergo`) REFERENCES `albergo` (`idAlbergo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera`
--

LOCK TABLES `camera` WRITE;
/*!40000 ALTER TABLE `camera` DISABLE KEYS */;
INSERT INTO `camera` VALUES (11,8,1,10,8),(3,9,1,10,9),(8,9,2,20,10),(10,9,3,30,11),(15,6,1,12,12),(9,6,2,14,13),(16,6,3,20,14);
/*!40000 ALTER TABLE `camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camerepacchetto`
--

DROP TABLE IF EXISTS `camerepacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camerepacchetto` (
  `numposticamera` int(11) NOT NULL,
  `idPacchetto` int(11) NOT NULL,
  `idCamerePacc` int(11) NOT NULL AUTO_INCREMENT,
  `numcamere` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCamerePacc`),
  KEY `pacchetto_idx` (`idPacchetto`),
  KEY `camera` (`numposticamera`),
  CONSTRAINT `pacchettocamera` FOREIGN KEY (`idPacchetto`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camerepacchetto`
--

LOCK TABLES `camerepacchetto` WRITE;
/*!40000 ALTER TABLE `camerepacchetto` DISABLE KEYS */;
INSERT INTO `camerepacchetto` VALUES (1,48,3,2),(1,50,4,1),(1,52,5,1),(1,54,6,3),(1,55,7,3),(1,56,8,1),(1,58,9,1),(1,59,10,1),(1,59,11,1),(1,60,12,1),(1,61,13,1),(2,61,14,2),(2,39,15,2),(2,39,16,1),(2,62,17,1),(2,62,18,1);
/*!40000 ALTER TABLE `camerepacchetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elememtobase`
--

DROP TABLE IF EXISTS `elememtobase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elememtobase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idViaggio` int(11) NOT NULL,
  `idAlbergo` int(11) NOT NULL,
  `idEscursione` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idviaggio_idx` (`idViaggio`),
  KEY `idEscursione_idx` (`idEscursione`),
  CONSTRAINT `idAlbergo` FOREIGN KEY (`id`) REFERENCES `albergo` (`idAlbergo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idEscursione` FOREIGN KEY (`idEscursione`) REFERENCES `escursione` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idviaggio` FOREIGN KEY (`idViaggio`) REFERENCES `mezzotrasporto` (`idMezzoTrasporto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elememtobase`
--

LOCK TABLES `elememtobase` WRITE;
/*!40000 ALTER TABLE `elememtobase` DISABLE KEYS */;
/*!40000 ALTER TABLE `elememtobase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escursione`
--

DROP TABLE IF EXISTS `escursione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escursione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLuogo` int(11) NOT NULL,
  `dataInizio` datetime DEFAULT NULL,
  `dataFine` datetime DEFAULT NULL,
  `costoPerEsc` int(11) DEFAULT NULL,
  `postiDisponibili` int(10) unsigned DEFAULT NULL,
  `info escursione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `luogo_idx` (`idLuogo`),
  CONSTRAINT `luogoescursione` FOREIGN KEY (`idLuogo`) REFERENCES `luogo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escursione`
--

LOCK TABLES `escursione` WRITE;
/*!40000 ALTER TABLE `escursione` DISABLE KEYS */;
INSERT INTO `escursione` VALUES (11,17,'2014-02-03 00:00:00','2014-02-03 04:00:00',13,24,'giro notturno per le vie e i monumenti di roma'),(12,17,'2014-02-02 10:30:00','2014-02-02 12:00:00',45,24,'santa messa a san pietro');
/*!40000 ALTER TABLE `escursione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escursionipacchetto`
--

DROP TABLE IF EXISTS `escursionipacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escursionipacchetto` (
  `idEscursione` int(11) NOT NULL,
  `idPacchetto` int(11) NOT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`),
  KEY `escursione_idx` (`idEscursione`),
  KEY `pacchetto_idx` (`idPacchetto`),
  CONSTRAINT `escursione` FOREIGN KEY (`idEscursione`) REFERENCES `escursione` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pacchetto` FOREIGN KEY (`idPacchetto`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escursionipacchetto`
--

LOCK TABLES `escursionipacchetto` WRITE;
/*!40000 ALTER TABLE `escursionipacchetto` DISABLE KEYS */;
INSERT INTO `escursionipacchetto` VALUES (11,62,10),(12,62,11),(11,63,12);
/*!40000 ALTER TABLE `escursionipacchetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giftlist`
--

DROP TABLE IF EXISTS `giftlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giftlist` (
  `idGiftlist` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` varchar(45) DEFAULT NULL,
  `idPack` int(11) NOT NULL,
  PRIMARY KEY (`idGiftlist`),
  UNIQUE KEY `idGiftlist_UNIQUE` (`idGiftlist`),
  KEY `creatore_idx` (`idUser`),
  KEY `pacchetto_idx` (`idPack`),
  CONSTRAINT `creatoregift` FOREIGN KEY (`idUser`) REFERENCES `users` (`EMAIL`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pacchettogift` FOREIGN KEY (`idPack`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giftlist`
--

LOCK TABLES `giftlist` WRITE;
/*!40000 ALTER TABLE `giftlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `giftlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luogo`
--

DROP TABLE IF EXISTS `luogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `luogo` (
  `citta` varchar(45) NOT NULL,
  `nazione` varchar(45) NOT NULL,
  `indirizzo` varchar(45) CHARACTER SET dec8 DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luogo`
--

LOCK TABLES `luogo` WRITE;
/*!40000 ALTER TABLE `luogo` DISABLE KEYS */;
INSERT INTO `luogo` VALUES ('roma','italy','via colosseo',13,'ALBERGO'),('berlino','germania','alexanderplatz 41',14,'ALBERGO'),('milano','italia','malpensa',15,'AEREOPORTO'),('roma','italia','fiumicino',16,'AEREOPORTO'),('roma','italia','piazza di spagna',17,'ESCURSIONE');
/*!40000 ALTER TABLE `luogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mezzotrasporto`
--

DROP TABLE IF EXISTS `mezzotrasporto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mezzotrasporto` (
  `idMezzoTrasporto` int(11) NOT NULL,
  `IdLuogoPartenza` int(11) NOT NULL,
  `IdLuogoArrivo` int(11) NOT NULL,
  `dataInizio` datetime DEFAULT NULL,
  `dataFine` datetime DEFAULT NULL,
  `costoPers` int(11) DEFAULT NULL,
  `postiDisponibili` int(10) unsigned DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `luogo_partenza_idx` (`IdLuogoPartenza`),
  KEY `luogo_arrivo_idx` (`IdLuogoArrivo`),
  KEY `indexMezzoIdentific` (`idMezzoTrasporto`),
  CONSTRAINT `luogomezzoarrivo` FOREIGN KEY (`IdLuogoArrivo`) REFERENCES `luogo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `luogomezzopartenza` FOREIGN KEY (`IdLuogoPartenza`) REFERENCES `luogo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mezzotrasporto`
--

LOCK TABLES `mezzotrasporto` WRITE;
/*!40000 ALTER TABLE `mezzotrasporto` DISABLE KEYS */;
INSERT INTO `mezzotrasporto` VALUES (124,15,16,'2014-01-27 05:00:00','2014-01-27 06:30:00',76,345,22),(453,16,15,'2014-01-31 12:00:00','2014-01-31 14:00:00',56,265,23),(124,15,16,'2014-02-01 00:00:00','2014-02-28 02:00:00',21,345,24),(345,16,15,'2014-02-08 08:00:00','2014-02-08 10:00:00',342,23,25);
/*!40000 ALTER TABLE `mezzotrasporto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacchetto`
--

DROP TABLE IF EXISTS `pacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacchetto` (
  `idPacchetto` int(11) NOT NULL AUTO_INCREMENT,
  `IdLuogo` int(11) DEFAULT NULL,
  `titolo` varchar(45) DEFAULT NULL,
  `numPers` int(10) unsigned DEFAULT '1',
  `isModify` int(10) DEFAULT '0',
  `idMezzoAndata` int(11) DEFAULT NULL,
  `idMezzoRitorno` int(11) DEFAULT NULL,
  `idAlbergo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPacchetto`),
  KEY `luogopacch_idx` (`IdLuogo`),
  KEY `mezzoandata_idx` (`idMezzoAndata`),
  KEY `idmezzoRitorno_idx` (`idMezzoRitorno`),
  CONSTRAINT `idMezzoAnd` FOREIGN KEY (`idMezzoAndata`) REFERENCES `mezzotrasporto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idMezzoRit` FOREIGN KEY (`idMezzoRitorno`) REFERENCES `mezzotrasporto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `luogopacch` FOREIGN KEY (`IdLuogo`) REFERENCES `luogo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacchetto`
--

LOCK TABLES `pacchetto` WRITE;
/*!40000 ALTER TABLE `pacchetto` DISABLE KEYS */;
INSERT INTO `pacchetto` VALUES (39,16,NULL,1,0,22,23,6),(44,16,NULL,1,1,22,23,7),(45,16,NULL,1,1,22,23,8),(46,16,NULL,1,1,22,23,9),(47,16,NULL,1,1,22,23,9),(48,16,NULL,1,1,22,23,9),(49,16,NULL,1,1,22,23,8),(50,16,NULL,1,1,22,23,8),(51,16,NULL,1,1,22,23,8),(52,16,NULL,1,1,22,23,8),(53,16,NULL,1,1,22,23,8),(54,16,NULL,1,1,22,23,8),(55,16,NULL,1,1,22,23,8),(56,16,NULL,1,1,22,23,9),(57,16,NULL,1,1,22,23,8),(58,16,NULL,1,1,22,23,8),(59,16,NULL,1,1,22,23,9),(60,16,NULL,1,1,22,23,9),(61,16,NULL,1,1,22,23,9),(62,16,NULL,1,0,24,25,6),(63,16,NULL,1,1,22,25,6);
/*!40000 ALTER TABLE `pacchetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partecipapacchetto`
--

DROP TABLE IF EXISTS `partecipapacchetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partecipapacchetto` (
  `idPartecipaPacchetto` int(11) NOT NULL AUTO_INCREMENT,
  `idUtente` varchar(45) DEFAULT NULL,
  `idPacchetto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPartecipaPacchetto`),
  KEY `utente_idx` (`idUtente`),
  KEY `pacchetto_idx` (`idPacchetto`),
  CONSTRAINT `pacchetto_partecipa` FOREIGN KEY (`idPacchetto`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partecipapacchetto`
--

LOCK TABLES `partecipapacchetto` WRITE;
/*!40000 ALTER TABLE `partecipapacchetto` DISABLE KEYS */;
INSERT INTO `partecipapacchetto` VALUES (1,'r.lazzati@gmail.com',39),(2,'nicola1591@libero.it',39),(3,'r.lazzati@gmail.com',39);
/*!40000 ALTER TABLE `partecipapacchetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazionealbergo`
--

DROP TABLE IF EXISTS `prenotazionealbergo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazionealbergo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPack` int(11) DEFAULT NULL,
  `idAlbergo` int(11) DEFAULT NULL,
  `costo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `albergo_idx` (`idAlbergo`),
  KEY `idPack_idx` (`idPack`),
  CONSTRAINT `albergo_prenotaz` FOREIGN KEY (`idAlbergo`) REFERENCES `albergo` (`idAlbergo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPack_prenotaz` FOREIGN KEY (`idPack`) REFERENCES `pacchetto` (`idPacchetto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazionealbergo`
--

LOCK TABLES `prenotazionealbergo` WRITE;
/*!40000 ALTER TABLE `prenotazionealbergo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazionealbergo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storicopagamenti`
--

DROP TABLE IF EXISTS `storicopagamenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storicopagamenti` (
  `userId` varchar(45) NOT NULL,
  `giftId` int(11) DEFAULT NULL,
  `idStorico` int(11) NOT NULL AUTO_INCREMENT,
  `Viaggio` int(11) DEFAULT '0',
  `Albergo` int(11) DEFAULT '0',
  `Escursione` int(11) DEFAULT '0',
  `idElemento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStorico`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storicopagamenti`
--

LOCK TABLES `storicopagamenti` WRITE;
/*!40000 ALTER TABLE `storicopagamenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `storicopagamenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `EMAIL` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `REGISTEREDON` datetime DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@admin.com','admin','admin','admin',NULL),('r.lazzati@gmail.com','r','l','pippo','2014-01-31 11:16:50'),('user@user.com','user','user','pippo','2014-01-28 13:38:11');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_groups`
--

DROP TABLE IF EXISTS `users_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_groups` (
  `email` varchar(255) DEFAULT NULL,
  `groupname` varchar(255) DEFAULT NULL,
  KEY `FK_USERS_GROUPS_email` (`email`),
  CONSTRAINT `FK_USERS_GROUPS_email` FOREIGN KEY (`email`) REFERENCES `users` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_groups`
--

LOCK TABLES `users_groups` WRITE;
/*!40000 ALTER TABLE `users_groups` DISABLE KEYS */;
INSERT INTO `users_groups` VALUES ('admin@admin.com','ADMIN'),('user@user.com','USER'),('r.lazzati@gmail.com','USER');
/*!40000 ALTER TABLE `users_groups` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-31 19:04:56
