-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: capstoneproject
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `skiinventory`
--

DROP TABLE IF EXISTS `skiinventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skiinventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `skiPair` int NOT NULL,
  `discipline` varchar(255) NOT NULL,
  `conditions` varchar(255) NOT NULL,
  `steepness` varchar(255) NOT NULL,
  `time` double(4,2) NOT NULL,
  `dateN` date NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skiinventory`
--

LOCK TABLES `skiinventory` WRITE;
/*!40000 ALTER TABLE `skiinventory` DISABLE KEYS */;
INSERT INTO `skiinventory` VALUES (48,1,'SL','Soft','Flat',41.60,'2023-03-15','Testing in Park City'),(49,1,'SL','Soft','Flat',41.80,'2023-03-15','Testing in Park City'),(50,1,'SL','Soft','Flat',41.73,'2023-03-15','Testing in Park City'),(51,2,'SL','Soft','Flat',41.39,'2023-03-15','Testing in Park City'),(53,2,'SL','Soft','Flat',41.15,'2023-03-15','Testing in Park City'),(54,3,'SL','Soft','Flat',41.90,'2023-03-15','Testing in Park City'),(55,3,'SL','Soft','Flat',42.36,'2023-03-15','Testing in Park City'),(56,3,'SL','Soft','Flat',42.20,'2023-03-15','Testing in Park City'),(57,1,'SL','Icy','Steep',35.67,'2023-03-20','Testing in Olympic Park'),(58,1,'SL','Icy','Steep',35.30,'2023-03-20','Testing in Olympic Park'),(59,1,'SL','Icy','Steep',35.45,'2023-03-20','Testing in Olympic Park'),(60,2,'SL','Icy','Steep',35.89,'2023-03-20','Testing in Olympic Park'),(61,2,'SL','Icy','Steep',35.56,'2023-03-20','Testing in Olympic Park'),(62,2,'SL','Icy','Steep',36.03,'2023-03-20','Testing in Olympic Park'),(63,3,'SL','Icy','Steep',35.63,'2023-03-20','Testing in Olympic Park'),(65,3,'SL','Icy','Steep',35.15,'2023-03-20','Testing in Olympic Park'),(66,3,'SL','Icy','Steep',35.21,'2023-03-20','Testing in Olympic Park'),(67,1,'GS','Icy','Rolling',59.36,'2023-02-20','Testing in Copper, turny course '),(68,1,'GS','Icy','Rolling',59.10,'2023-02-20','Testing in Copper, turny course '),(69,1,'GS','Icy','Rolling',58.63,'2023-02-20','Testing in Copper, turny course '),(70,2,'GS','Icy','Rolling',59.93,'2023-02-20','Testing in Copper, turny course '),(71,2,'GS','Icy','Rolling',60.36,'2023-02-20','Testing in Copper, turny course '),(72,2,'GS','Icy','Rolling',59.90,'2023-02-20','Testing in Copper, turny course '),(73,2,'GS','Soft','Rolling',50.10,'2023-02-21','Testing in Copper, straight course'),(74,2,'GS','Soft','Rolling',50.36,'2023-02-21','Testing in Copper, straight course'),(75,2,'GS','Soft','Rolling',50.59,'2023-02-21','Testing in Copper, straight course'),(76,2,'GS','Soft','Rolling',50.10,'2023-02-21','Testing in Copper, straight course'),(77,1,'GS','Soft','Rolling',50.96,'2023-02-21','Testing in Copper, straight course'),(78,1,'GS','Soft','Rolling',51.12,'2023-02-21','Testing in Copper, straight course'),(79,1,'GS','Soft','Rolling',51.26,'2023-02-21','Testing in Copper, straight course'),(80,1,'GS','Soft','Rolling',51.19,'2023-02-21','Testing in Copper, straight course'),(82,1,'SG','Salted Slush','Gradual',65.26,'2023-04-11','Aspen'),(83,1,'SG','Salted Slush','Gradual',65.76,'2023-04-11','Aspen'),(84,1,'SG','Salted Slush','Gradual',65.73,'2023-04-11','Aspen'),(85,2,'SG','Salted Slush','Gradual',65.69,'2023-04-11','Aspen'),(86,2,'SG','Salted Slush','Gradual',65.99,'2023-04-11','Aspen'),(87,2,'SG','Salted Slush','Gradual',66.45,'2023-04-11','Aspen'),(89,1,'SG','Grippy','Gradual',71.01,'2023-04-12','Aspen'),(90,1,'SG','Grippy','Gradual',71.32,'2023-04-12','Aspen'),(91,1,'SG','Grippy','Gradual',71.55,'2023-04-12','Aspen'),(92,2,'SG','Grippy','Gradual',70.50,'2023-04-12','Aspen'),(93,2,'SG','Grippy','Gradual',70.32,'2023-04-12','Aspen'),(94,2,'SG','Grippy','Gradual',70.41,'2023-04-12','Aspen'),(95,3,'DH','Icy','Steep',83.78,'2023-03-26','Kitzbühel '),(96,4,'DH','Icy','Steep',81.34,'2023-03-27','Kitzbühel '),(98,4,'DH','Icy','Steep',82.99,'2023-03-26','Kitzbühel'),(99,3,'DH','Icy','Steep',82.92,'2023-03-27','Kitzbühel'),(108,1,'SL','Soft','Flat',45.10,'2023-04-26','Ski testing in Austria');
/*!40000 ALTER TABLE `skiinventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-28 19:13:24
