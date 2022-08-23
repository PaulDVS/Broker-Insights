-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: policy_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `policies_tb`
--

DROP TABLE IF EXISTS `policies_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policies_tb` (
  `idpolicies_tb` int NOT NULL AUTO_INCREMENT,
  `idclient_tb` int NOT NULL,
  `idcustomer_tb` int NOT NULL,
  `premium` decimal(7,2) NOT NULL,
  `policy_type` varchar(45) NOT NULL,
  `insurer_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idpolicies_tb`),
  UNIQUE KEY `idpolicies_tb_UNIQUE` (`idpolicies_tb`),
  KEY `idclient_tb_idx` (`idclient_tb`),
  KEY `idcustomer_tb_idx` (`idcustomer_tb`),
  CONSTRAINT `idclient_tb` FOREIGN KEY (`idclient_tb`) REFERENCES `client_tb` (`idclient_tb`),
  CONSTRAINT `idcustomer_tb` FOREIGN KEY (`idcustomer_tb`) REFERENCES `customer_tb` (`idcustomer_tb`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policies_tb`
--

LOCK TABLES `policies_tb` WRITE;
/*!40000 ALTER TABLE `policies_tb` DISABLE KEYS */;
INSERT INTO `policies_tb` VALUES (1,1,1,123.87,'Public Liability','Aviva'),(2,1,2,2321.45,'Public Liability','Allianze'),(3,1,3,59897.00,'Motor Fleet','Aviva'),(4,1,3,6845.00,'Public Liability','QBE');
/*!40000 ALTER TABLE `policies_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-23  2:28:17
