-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teach_competition
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcements` (
  `announcement_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`announcement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `files` (
  `file_id` int NOT NULL AUTO_INCREMENT,
  `work_id` int DEFAULT NULL,
  `file_type` varchar(255) NOT NULL,
  `file_url` varchar(255) NOT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`file_id`),
  KEY `work_id` (`work_id`),
  CONSTRAINT `files_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `works` (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (1,4,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:27:54'),(2,4,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:27:55'),(3,5,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:29:55'),(4,5,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:29:56'),(5,5,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-18 13:29:57'),(6,6,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:31:58'),(7,6,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:31:59'),(8,6,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-18 13:31:59'),(9,6,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:32:00'),(10,6,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:32:01'),(11,6,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:32:02'),(12,7,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:37:30'),(13,7,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:37:31'),(14,7,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-18 13:37:31'),(15,7,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:37:32'),(16,7,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:37:33'),(17,7,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:37:34'),(18,8,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:40:20'),(19,8,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:40:21'),(20,8,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-18 13:40:21'),(21,8,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:40:21'),(22,8,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:40:23'),(23,8,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:40:24'),(24,7,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/在校线上实习说明.pdf','在校线上实习说明.pdf','2024-06-18 13:41:27'),(25,7,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:41:27'),(26,7,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:41:27'),(27,7,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:41:27'),(28,7,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:41:28'),(29,7,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-18 13:41:28'),(30,11,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:20'),(31,11,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:20'),(32,11,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:20'),(33,11,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:20'),(34,11,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:20'),(35,11,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:47:21'),(36,12,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:57'),(37,12,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:57'),(38,12,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:58'),(39,12,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:58'),(40,12,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:58'),(41,12,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:49:58'),(42,13,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(43,13,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(44,13,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(45,13,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(46,13,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(47,13,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:52:03'),(48,13,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:41'),(49,13,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:41'),(50,13,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:41'),(51,13,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:42'),(52,13,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:42'),(53,13,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-19 12:54:42'),(54,13,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:59'),(55,13,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:59'),(56,13,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:59'),(57,13,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:59'),(58,13,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:54:59'),(59,13,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-19 12:54:59'),(60,13,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:05'),(61,13,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:05'),(62,13,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:06'),(63,13,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:06'),(64,13,'研究报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:06'),(65,13,'项目计划','http://sf9cmkal1.hd-bkt.clouddn.com/2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024年上半年英语六级笔试准考证(360313200407125013).pdf','2024-06-19 12:55:06'),(66,14,'教案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:37'),(67,14,'教学实施报告','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:37'),(68,14,'评分表','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:37'),(69,14,'设计方案','http://sf9cmkal1.hd-bkt.clouddn.com/Java简历.pdf','Java简历.pdf','2024-06-19 12:55:37');
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `work_id` int DEFAULT NULL,
  `expert_id` int DEFAULT NULL,
  `overall_score` decimal(5,2) DEFAULT NULL,
  `teaching_report_score` decimal(5,2) DEFAULT NULL,
  `lesson_plan_score` decimal(5,2) DEFAULT NULL,
  `video_material_score` decimal(5,2) DEFAULT NULL,
  `talent_training_score` decimal(5,2) DEFAULT NULL,
  `course_standard_score` decimal(5,2) DEFAULT NULL,
  `textbook_usage_score` decimal(5,2) DEFAULT NULL,
  `comments` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`review_id`),
  KEY `work_id` (`work_id`),
  KEY `expert_id` (`expert_id`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `works` (`work_id`),
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`expert_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,1,2,100.00,20.00,20.00,40.00,8.00,8.00,4.00,'不错','2024-06-16 12:03:35'),(2,1,2,90.50,18.50,19.00,35.00,7.50,7.00,3.50,'非常优秀的作品','2024-06-18 05:06:45'),(3,1,2,90.50,18.50,19.00,35.00,7.50,7.00,3.50,'非常优秀的作品','2024-06-18 05:29:19'),(4,1,2,90.50,18.50,19.00,35.00,7.50,7.00,3.50,'非常优秀的作品','2024-06-18 05:29:52'),(5,2,2,90.20,15.00,20.00,35.00,7.00,7.00,4.00,'一般','2024-06-18 11:35:53'),(6,5,2,90.50,18.50,19.00,35.00,7.50,7.00,3.50,'非常优秀的作品','2024-06-19 12:41:54');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','expert','teacher') NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT 'https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'lry','12345678','teacher','lry','https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png'),(2,'专家','123456','expert','专家','https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png'),(3,'管理员','123456','admin','管理员','https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png'),(5,'updated_user','a12345678','teacher','Updated User','https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `work_id` int DEFAULT NULL,
  `video_url` varchar(255) NOT NULL,
  `video_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `work_id` (`work_id`),
  CONSTRAINT `videos_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `works` (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (1,6,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(2,7,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(3,8,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(4,7,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(5,11,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(6,12,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(7,13,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4'),(8,13,'http://sf9cmkal1.hd-bkt.clouddn.com/2024-03-31 18-21-06.mp4','2024-03-31 18-21-06.mp4');
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works`
--

DROP TABLE IF EXISTS `works`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `works` (
  `work_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `school` varchar(100) NOT NULL,
  `team_members` text,
  `qualification` tinyint(1) DEFAULT '0',
  `contact_info` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`work_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `works_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works`
--

LOCK TABLES `works` WRITE;
/*!40000 ALTER TABLE `works` DISABLE KEYS */;
INSERT INTO `works` VALUES (1,'测试','思政课程组','东华理工大学','lry',1,'15297995139','2024-06-16 07:12:22',2),(2,'测试2','专业技能课程一组','中国地质大学','ljc',1,'13707992562','2024-06-18 11:32:13',2),(3,'','','','',0,'','2024-06-18 12:50:49',NULL),(4,'','','','',0,'','2024-06-18 13:27:54',NULL),(5,'','','Updated School','',1,'','2024-06-18 13:29:55',NULL),(6,'','','','',0,'','2024-06-18 13:31:58',NULL),(7,'测试2','思政课程组','东华理工大学','lry，mark',0,'15297995139','2024-06-18 13:37:30',NULL),(8,'测试2','专业技能课程二组','东华理工大学','lry，mark',0,'13707992562','2024-06-18 13:40:20',NULL),(9,NULL,NULL,'Some School',NULL,0,NULL,'2024-06-19 12:02:18',5),(11,'','','','',0,'','2024-06-19 12:47:20',NULL),(12,'','','','',0,'','2024-06-19 12:49:57',NULL),(13,'222','思政课程组','中国地质大学','lry',0,'15297995139','2024-06-19 12:52:03',NULL),(14,'111','思政课程组','东华理工大学','lll,bbb,ccc',0,'13707992562','2024-06-19 12:55:37',NULL);
/*!40000 ALTER TABLE `works` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

