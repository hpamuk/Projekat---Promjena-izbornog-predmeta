-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_Projektne tabele
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `NewSubjects`
--

DROP TABLE IF EXISTS `NewSubjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NewSubjects` (
  `id` int DEFAULT NULL,
  `naziv` varchar(60) NOT NULL,
  `profesor` varchar(60) NOT NULL,
  `brCasovaSemestralno` int NOT NULL,
  `brCasovaSedmicno` int NOT NULL,
  PRIMARY KEY (`naziv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NewSubjects`
--

LOCK TABLES `NewSubjects` WRITE;
/*!40000 ALTER TABLE `NewSubjects` DISABLE KEYS */;
INSERT INTO `NewSubjects` VALUES (1,'Analiza i dizajn','Prof.dr. Dženana Đonko',36,4),(2,'Inženjerska matematika','Prf.dr. Naida Mujić',40,6),(3,'Organizacija softverskog projekta','Prof.dr. Samir Omanović',40,6),(4,'Sistemsko programiranje','Prof.dr. Samir Ribić',38,5),(5,'Vještačka inteligencija','Prof.dr. Amila Akadić',40,6);
/*!40000 ALTER TABLE `NewSubjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OldSubjects`
--

DROP TABLE IF EXISTS `OldSubjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OldSubjects` (
  `id` int NOT NULL,
  `naziv` varchar(60) NOT NULL,
  `profesor` varchar(70) NOT NULL,
  `brCasovaSemestralno` int NOT NULL,
  `brCasovaSedmicno` int NOT NULL,
  PRIMARY KEY (`naziv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OldSubjects`
--

LOCK TABLES `OldSubjects` WRITE;
/*!40000 ALTER TABLE `OldSubjects` DISABLE KEYS */;
INSERT INTO `OldSubjects` VALUES (1,'Operativni sistemi','Prof.dr. Samir Ribić',40,6),(2,'Osnove baza podataka','Prof.dr. Emir Buza',38,5),(3,'Računarska grafika','Prof.dr. Selma Rizvić',36,4),(4,'Uvod u programiranje','Prof.dr. Dino Kečo',40,6),(5,'Verifikacija i validacija softvera','Prof.dr. Dženana Đonko',40,6);
/*!40000 ALTER TABLE `OldSubjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` int NOT NULL,
  `username` varchar(60) NOT NULL,
  `brIndeksa` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (3,'ffatic1','1432'),(2,'mmehic1','1324'),(1,'mmujic1','1234'),(4,'sselmic1','4321');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_subjects`
--

DROP TABLE IF EXISTS `users_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `naziv` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `naziv_idx` (`naziv`),
  KEY `username` (`username`),
  CONSTRAINT `naziv` FOREIGN KEY (`naziv`) REFERENCES `OldSubjects` (`naziv`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `Users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_subjects`
--

LOCK TABLES `users_subjects` WRITE;
/*!40000 ALTER TABLE `users_subjects` DISABLE KEYS */;
INSERT INTO `users_subjects` VALUES (1,'mmehic1','Operativni sistemi'),(2,'sselmic1','Operativni sistemi'),(3,'mmujic1','Osnove baza podataka'),(4,'ffatic1','Računarska grafika'),(5,'mmehic1','Računarska grafika'),(6,'mmujic1','Računarska grafika'),(7,'sselmic1','Računarska grafika'),(8,'ffatic1','Uvod u programiranje'),(9,'mmujic1','Uvod u programiranje'),(10,'mmehic1','Verifikacija i validacija softvera'),(11,'sselmic1','Verifikacija i validacija softvera');
/*!40000 ALTER TABLE `users_subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-09  0:35:46
