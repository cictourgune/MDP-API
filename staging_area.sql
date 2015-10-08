-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: staging_area
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.12.04.1-log

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
-- Table structure for table `api_log`
--

DROP TABLE IF EXISTS `api_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `call_time` timestamp NULL DEFAULT NULL,
  `duration` float DEFAULT NULL,
  `controller` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url_target` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(45) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `active` tinyint(4) NOT NULL,
  `procedures` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`,`api_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_aal1`
--

DROP TABLE IF EXISTS `prices_aal1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_aal1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2360 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_aal2`
--

DROP TABLE IF EXISTS `prices_aal2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_aal2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4974 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_aal3`
--

DROP TABLE IF EXISTS `prices_aal3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_aal3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_aal4`
--

DROP TABLE IF EXISTS `prices_aal4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_aal4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `aal4` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_country`
--

DROP TABLE IF EXISTS `prices_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prices_localidad`
--

DROP TABLE IF EXISTS `prices_localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices_localidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `aal4` varchar(200) DEFAULT NULL,
  `localidad` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `num_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74325 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_aal1`
--

DROP TABLE IF EXISTS `ratings_aal1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_aal1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6245 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_aal2`
--

DROP TABLE IF EXISTS `ratings_aal2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_aal2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22945 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_aal3`
--

DROP TABLE IF EXISTS `ratings_aal3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_aal3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_aal4`
--

DROP TABLE IF EXISTS `ratings_aal4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_aal4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `aal4` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_country`
--

DROP TABLE IF EXISTS `ratings_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=410 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings_localidad`
--

DROP TABLE IF EXISTS `ratings_localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings_localidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(100) DEFAULT NULL,
  `aal1` varchar(100) DEFAULT NULL,
  `aal2` varchar(200) DEFAULT NULL,
  `aal3` varchar(200) DEFAULT NULL,
  `aal4` varchar(200) DEFAULT NULL,
  `localidad` varchar(200) DEFAULT NULL,
  `accommodation_type` varchar(100) DEFAULT NULL,
  `data_year` int(11) DEFAULT NULL,
  `data_month` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `segment` varchar(45) DEFAULT NULL,
  `clean` float DEFAULT NULL,
  `comfort` float DEFAULT NULL,
  `location` float DEFAULT NULL,
  `services` float DEFAULT NULL,
  `staff` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `average` float DEFAULT NULL,
  `num_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=269117 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-06 13:04:26
