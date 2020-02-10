-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: ProjectMgmt
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `addprojectbyfaculty`
--

DROP TABLE IF EXISTS `addprojectbyfaculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addprojectbyfaculty` (
  `P_ID` decimal(10,0) NOT NULL,
  `Project_Title` varchar(60) DEFAULT NULL,
  `Abstract` varchar(1500) DEFAULT NULL,
  `reference_proj` varchar(600) DEFAULT NULL,
  `Project_Guide` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addprojectbyfaculty`
--

LOCK TABLES `addprojectbyfaculty` WRITE;
/*!40000 ALTER TABLE `addprojectbyfaculty` DISABLE KEYS */;
INSERT INTO `addprojectbyfaculty` VALUES (201701,'Online Data Analyzer','It will recognize the data from the table and according to the data various graph should be create','www.sas.som','Mr. Nilesh Ghavathe');
/*!40000 ALTER TABLE `addprojectbyfaculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addprojectbystudent`
--

DROP TABLE IF EXISTS `addprojectbystudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addprojectbystudent` (
  `p_id` decimal(10,0) NOT NULL,
  `Project_Title` varchar(60) DEFAULT NULL,
  `abstract` varchar(1500) DEFAULT NULL,
  `reference_proj` varchar(600) DEFAULT NULL,
  `Faculty` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addprojectbystudent`
--

LOCK TABLES `addprojectbystudent` WRITE;
/*!40000 ALTER TABLE `addprojectbystudent` DISABLE KEYS */;
INSERT INTO `addprojectbystudent` VALUES (2017101,'CSI Mgmtm System','kjjkdjkf jkdjfs jk sdj df','dsdsff','Mr. Tayyab Ali Sayed'),(2017102,'Bluetooth Base App','dfgfdfhthx hhh nfghgjggjgjfgjh hthft','fdwww.skks.sskk','Mr. Nilesh Ghavathe');
/*!40000 ALTER TABLE `addprojectbystudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `ID` varchar(20) DEFAULT NULL,
  `PW` varchar(30) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES ('admin','gxxoqzmxezg','Project Coordinator'),('nilesh','684ilkdyfa','Mr. Nilesh Ghavathe'),('tayyab','405vdqdyfa','Mr. Tayyab Ali Sayed'),('aruna','717xqruxdyfa','Mrs. Aruna Khubhalkar');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `query`
--

DROP TABLE IF EXISTS `query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `query` (
  `G_ID` varchar(10) DEFAULT NULL,
  `Query` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `query`
--

LOCK TABLES `query` WRITE;
/*!40000 ALTER TABLE `query` DISABLE KEYS */;
INSERT INTO `query` VALUES ('1002','rtgrttr'),('1003','djkjkjfdjjsld?');
/*!40000 ALTER TABLE `query` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `G_ID` varchar(10) DEFAULT NULL,
  `P_ID` varchar(10) DEFAULT NULL,
  `Approve` varchar(5) DEFAULT NULL,
  `dateA` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('1002','2017101','No','-'),('1003','2017102','No','-');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `S_ID` decimal(11,0) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` decimal(20,0) DEFAULT NULL,
  `G_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (101,'Asad','asadriyaz92@gmail.com',88898,'1002'),(102,'Raees','fdrf@jh.s',45,'1002'),(103,'Nazim','fdrf@jh.s',5454,'1002'),(104,'Anzar','fdrf@jh.s',45,'1002'),(105,'Zahid','zahidshaikh377@gmail.com',3443,'1003'),(106,'faiz','fd@s.s',456,'1003'),(107,'jjkd','fdrf@jh.s',6655,'1003'),(108,'fdfdff','fdrf@jh.s',4545,'1003');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-09 15:01:31
