-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `codcliente` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codcliente`,`cf`),
  UNIQUE KEY `cf_UNIQUE` (`cf`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('Andrea','Di Marco','DMRNDR01B25D843K',1),('Lorenzo','Cappellieri','CPPLRZ00D23K832L',2),('Vincenzo','Ciccarelli','CCCVCC00T23E232L',3),('Giovanni','Fosco','ANDFGL99R34L432K',4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_registrato`
--

DROP TABLE IF EXISTS `cliente_registrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_registrato` (
  `username` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `cf` varchar(16) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `cf_UNIQUE` (`cf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_registrato`
--

LOCK TABLES `cliente_registrato` WRITE;
/*!40000 ALTER TABLE `cliente_registrato` DISABLE KEYS */;
INSERT INTO `cliente_registrato` VALUES ('Andrew','12345678','DMRNDR01B25D843K'),('Lollo','Pocho123','CPPLRZ00D23K832L');
/*!40000 ALTER TABLE `cliente_registrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contatore`
--

DROP TABLE IF EXISTS `contatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contatore` (
  `ID_Fornitura` int NOT NULL,
  `Lettura_Aggiornata` double DEFAULT '0',
  `Lettura_Precedente` double DEFAULT '0',
  PRIMARY KEY (`ID_Fornitura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contatore`
--

LOCK TABLES `contatore` WRITE;
/*!40000 ALTER TABLE `contatore` DISABLE KEYS */;
INSERT INTO `contatore` VALUES (1,19200,19000),(2,1234,0),(3,0,0),(4,0,0),(5,0,0),(6,0,0);
/*!40000 ALTER TABLE `contatore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_consumi`
--

DROP TABLE IF EXISTS `db_consumi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `db_consumi` (
  `consumo` double NOT NULL,
  `idfornitura` int NOT NULL,
  `data` date NOT NULL,
  `citta` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`consumo`,`idfornitura`,`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_consumi`
--

LOCK TABLES `db_consumi` WRITE;
/*!40000 ALTER TABLE `db_consumi` DISABLE KEYS */;
INSERT INTO `db_consumi` VALUES (200,1,'2022-06-02','Formia','GAS'),(1234,2,'2022-06-11','Napoli','ACQUA'),(4000,1,'2022-05-01','Formia','GAS'),(15000,1,'2022-04-01','Formia','GAS');
/*!40000 ALTER TABLE `db_consumi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direttore_commerciale`
--

DROP TABLE IF EXISTS `direttore_commerciale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direttore_commerciale` (
  `username` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direttore_commerciale`
--

LOCK TABLES `direttore_commerciale` WRITE;
/*!40000 ALTER TABLE `direttore_commerciale` DISABLE KEYS */;
INSERT INTO `direttore_commerciale` VALUES ('Direttore01','LoViAn01');
/*!40000 ALTER TABLE `direttore_commerciale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitura`
--

DROP TABLE IF EXISTS `fornitura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornitura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(18) NOT NULL,
  `costo` double NOT NULL,
  `unita` varchar(20) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `citta` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitura`
--

LOCK TABLES `fornitura` WRITE;
/*!40000 ALTER TABLE `fornitura` DISABLE KEYS */;
INSERT INTO `fornitura` VALUES (1,'GAS',20.43,'MetriCubi','DMRNDR01B25D843K','Formia'),(2,'ACQUA',15.34,'MetriCubi','CPPLRZ00D23K832L','Napoli'),(3,'ACQUA',15.34,'MetriCubi','CCCVCC00T23E232L','Formia'),(4,'ENERGIA ELETTRICA',32.24,'KiloWattOra','CCCVCC00T23E232L','Arzano'),(5,'GAS',20.43,'MetriCubi','CPPLRZ00D23K832L','Salerno'),(6,'GAS',20.43,'MetriCubi','ANDFGL99R34L432K','Napoli');
/*!40000 ALTER TABLE `fornitura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impiegato`
--

DROP TABLE IF EXISTS `impiegato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `impiegato` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(8) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impiegato`
--

LOCK TABLES `impiegato` WRITE;
/*!40000 ALTER TABLE `impiegato` DISABLE KEYS */;
INSERT INTO `impiegato` VALUES ('Impiegato01','Enel2022'),('Impiegato02','LoViAn22');
/*!40000 ALTER TABLE `impiegato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indirizzo`
--

DROP TABLE IF EXISTS `indirizzo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `indirizzo` (
  `via` varchar(50) NOT NULL,
  `ncivico` varchar(6) NOT NULL,
  `ninterno` varchar(6) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `Cap` varchar(5) NOT NULL,
  `cf` varchar(16) NOT NULL,
  PRIMARY KEY (`ninterno`,`ncivico`,`via`,`Cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indirizzo`
--

LOCK TABLES `indirizzo` WRITE;
/*!40000 ALTER TABLE `indirizzo` DISABLE KEYS */;
INSERT INTO `indirizzo` VALUES ('Luca Giordano','8','1','Napoli','80128','ANDFGL99R34L432K'),('Via Domenica Fontana','41','18','Napoli','80128','aaaassssddddffff'),('Via Fossa Nuova','20','1B','Napoli','08150','CPPLRZ00D23K832L'),('Forio','34','1B','Salerno','84121','CPPLRZ00D23K832L'),('Via Olimpia','3','2','Formia','04023','DMRNDR01B25D843K'),('Via Sarno','12','2B','Formia','04023','CCCVCC00T23E232L'),('Via Gran Sasso','45','5A','Arzano','80022','CCCVCC00T23E232L');
/*!40000 ALTER TABLE `indirizzo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariffa`
--

DROP TABLE IF EXISTS `tariffa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariffa` (
  `tipo` varchar(18) NOT NULL,
  `costo` double NOT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariffa`
--

LOCK TABLES `tariffa` WRITE;
/*!40000 ALTER TABLE `tariffa` DISABLE KEYS */;
INSERT INTO `tariffa` VALUES ('ACQUA',15.34),('ENERGIA ELETTRICA',32.24),('GAS',20.43);
/*!40000 ALTER TABLE `tariffa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-13 22:52:42
