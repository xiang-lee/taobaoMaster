CREATE DATABASE  IF NOT EXISTS `taobaomaster` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taobaomaster`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: taobaomaster
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `tm_buying`
--

DROP TABLE IF EXISTS `tm_buying`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tm_buying` (
  `order_id` bigint(20) unsigned NOT NULL,
  `payer` varchar(50) NOT NULL DEFAULT '',
  `arrive_date` date NOT NULL DEFAULT '0000-00-00',
  `remain` smallint(4) NOT NULL DEFAULT '0',
  `is_stockpile` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  CONSTRAINT `tm_buying_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tm_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tm_buying`
--

LOCK TABLES `tm_buying` WRITE;
/*!40000 ALTER TABLE `tm_buying` DISABLE KEYS */;
INSERT INTO `tm_buying` (`order_id`, `payer`, `arrive_date`, `remain`, `is_stockpile`) VALUES (4,'123','2015-05-17',1,1),(7,'邵雨薇','2015-03-07',0,1),(9,'顾珺','2015-03-07',2,1),(25,'顾珺','2015-03-23',1,1),(26,'顾珺','2015-03-20',2,1),(29,'顾珺','2015-01-01',0,0),(31,'顾珺','2015-01-01',0,0);
/*!40000 ALTER TABLE `tm_buying` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tm_order`
--

DROP TABLE IF EXISTS `tm_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tm_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `record_date` date NOT NULL DEFAULT '0000-00-00',
  `quantity` smallint(4) NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `unit_price` decimal(8,2) NOT NULL DEFAULT '0.00',
  `currency` varchar(10) NOT NULL DEFAULT 'euro',
  `exchange_rate` decimal(5,4) NOT NULL DEFAULT '0.0000',
  `order_number` varchar(100) NOT NULL DEFAULT '',
  `comment` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tm_order`
--

LOCK TABLES `tm_order` WRITE;
/*!40000 ALTER TABLE `tm_order` DISABLE KEYS */;
INSERT INTO `tm_order` (`id`, `name`, `record_date`, `quantity`, `insert_time`, `unit_price`, `currency`, `exchange_rate`, `order_number`, `comment`) VALUES (4,'UGG','2015-03-07',2,'2015-03-07 22:15:09',50.53,'euro',7.3000,'abca123123',''),(7,'UGG','2015-03-07',4,'2015-03-14 18:48:15',100.40,'euro',7.5000,'123123',''),(9,'香皂','2015-04-07',4,'2015-03-14 18:54:54',11.00,'cny',5.5000,'444',''),(15,'test','2015-03-03',3,'2015-03-14 20:57:14',122.00,'cny',7.5000,'abccc',''),(16,'test','2015-03-03',4,'2015-03-14 21:04:04',44.00,'euro',5.6000,'abbbbb','测试'),(18,'lush-sold','2015-12-11',4,'2015-03-14 23:02:43',3.00,'euro',6.7000,'afadsf',''),(20,'test','2015-12-11',4,'2015-03-14 23:20:34',3.00,'euro',6.7000,'231231',''),(21,'lush','2015-01-03',55,'2015-03-14 23:30:02',66.00,'cny',4.5600,'adfasf','测'),(24,'test','2015-03-03',3,'2015-03-15 00:24:09',2.00,'euro',6.7000,'asdfasdf',''),(25,'测试','2015-03-23',1,'2015-03-17 00:23:45',1.00,'euro',1.0000,'1333','测试备注'),(26,'测试商品','2015-03-17',2,'2015-03-17 10:45:01',11.00,'euro',6.5000,'adsfasdf','很快的'),(27,'测试卖出','2015-03-17',3,'2015-03-17 11:01:57',4.00,'euro',6.5000,'asdfasdf','测试备注'),(28,'鞋子','2015-03-09',3,'2015-03-17 11:07:03',34.00,'euro',6.5000,'asdf','没赚钱卖出'),(29,'泡泡纸','2015-03-09',3,'2015-03-17 11:09:46',3.00,'euro',6.5000,'',''),(30,'鞋子1','2015-03-10',1,'2015-03-17 11:11:46',100.00,'euro',6.7000,'basdfdas','刷单备注'),(31,'箱子','2015-03-20',1,'2015-03-17 11:17:37',1.56,'euro',6.7000,'','');
/*!40000 ALTER TABLE `tm_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tm_selling`
--

DROP TABLE IF EXISTS `tm_selling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tm_selling` (
  `order_id` bigint(20) unsigned NOT NULL,
  `sell_unit_price` decimal(8,2) NOT NULL DEFAULT '0.00',
  `postage` decimal(6,2) NOT NULL DEFAULT '0.00',
  `sell_currency` varchar(10) NOT NULL DEFAULT 'cny',
  `stockpile_id` bigint(20) unsigned DEFAULT '0',
  `reduced_price` decimal(8,2) NOT NULL DEFAULT '0.00',
  `is_received` tinyint(1) NOT NULL DEFAULT '0',
  `is_refund` tinyint(1) NOT NULL DEFAULT '0',
  `is_sold_to_friend` tinyint(1) NOT NULL DEFAULT '0',
  `is_brush` tinyint(1) NOT NULL DEFAULT '0',
  `is_repay_brush_buyer` tinyint(1) NOT NULL DEFAULT '0',
  `buyer` varchar(50) NOT NULL DEFAULT '',
  `deliver_date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`order_id`),
  KEY `stockpile_id` (`stockpile_id`),
  CONSTRAINT `tm_selling_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tm_order` (`id`),
  CONSTRAINT `tm_selling_ibfk_2` FOREIGN KEY (`stockpile_id`) REFERENCES `tm_buying` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tm_selling`
--

LOCK TABLES `tm_selling` WRITE;
/*!40000 ALTER TABLE `tm_selling` DISABLE KEYS */;
INSERT INTO `tm_selling` (`order_id`, `sell_unit_price`, `postage`, `sell_currency`, `stockpile_id`, `reduced_price`, `is_received`, `is_refund`, `is_sold_to_friend`, `is_brush`, `is_repay_brush_buyer`, `buyer`, `deliver_date`) VALUES (15,0.00,0.00,'cny',NULL,0.00,0,0,0,1,0,'xiang','2015-01-01'),(16,0.00,0.00,'cny',NULL,0.00,0,0,0,1,1,'李翔','2015-01-01'),(18,4.00,55.00,'euro',9,0.00,1,1,0,0,0,'','2015-01-01'),(20,6.00,44.00,'cny',9,0.00,1,0,0,0,0,'','2015-01-01'),(21,88.00,55.00,'cny',9,0.00,0,0,1,0,0,'李翔','2015-01-01'),(24,3.00,4.00,'euro',NULL,0.00,1,0,0,0,0,'','2015-01-01'),(27,6.00,10.00,'euro',NULL,0.00,1,0,0,0,0,'','2015-01-01'),(28,7.00,10.00,'cny',NULL,0.00,0,0,1,0,0,'小张','2015-01-01'),(30,0.00,0.00,'cny',NULL,0.00,0,0,0,1,1,'李翔','2015-01-01');
/*!40000 ALTER TABLE `tm_selling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tm_user`
--

DROP TABLE IF EXISTS `tm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tm_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `role` varchar(40) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tm_user`
--

LOCK TABLES `tm_user` WRITE;
/*!40000 ALTER TABLE `tm_user` DISABLE KEYS */;
INSERT INTO `tm_user` (`id`, `username`, `name`, `password`, `role`) VALUES (1,'xiang','Xiang Li','$2a$10$FFKTujg9eIlpA6YFZEZRXOVe3sg0xA9dBYLy0VRPwB6wf2z3kIwOq','ROLE_USER');
/*!40000 ALTER TABLE `tm_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-17 11:18:14
