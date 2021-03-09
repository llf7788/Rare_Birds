-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: rarebirds
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `bird`
--

DROP TABLE IF EXISTS `bird`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bird` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT 'name',
  `image_id` bigint DEFAULT '0' COMMENT 'default image',
  `description` longtext NOT NULL COMMENT 'description',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bird`
--

LOCK TABLES `bird` WRITE;
/*!40000 ALTER TABLE `bird` DISABLE KEYS */;
INSERT INTO `bird` VALUES (1,'Ceyx rufidorsa',1,'Rufous-Backed Kingfisher (Ceyx rufidorsa) in Malaysia by Chong Lip Mun.'),(2,'Purple-breasted sunbird',3,'The purple-breasted sunbird (Nectarinia purpureiventris) is a species of bird in the family Nectariniidae.'),(3,'Red-crowned Crane',5,'Adult red-crowned cranes are named for a patch of red bare skin on the crown, which becomes brighter during mating season. Overall, they are snow white in color with black on the wing secondaries, which can appear almost like a black tail when the birds are standing, but the real tail feathers are actually white. Males are black on the cheeks, throat, and neck, while females are pearly gray in these spots. The bill is olive green to greenish horn, the legs are slate to grayish black, and the iris is dark brown.'),(4,'Stresemanns Bristlefront',6,'Stresemanns Bristlefront is a long-tailed, burrow-nesting songbird named for the bristly-looking tuft of feathers on its forehead. It belongs to the large family Rhinocryptidae, known as the tapaculos, native to Central and South America and notorious for their elusive habits and unresolved taxonomy.'),(5,'Antioquia Brushfinch',7,'The Antioquia Brushfinch is known only from a single locality in Colombia Central Andes. Due to its recent rediscovery, little is yet known about this songbird. Field studies are needed to better understand the brushfinch behavior and habitat requirements, and find more sites for this species.'),(6,'Blue-eyed Ground-Dove',8,'Already one of the worlds rarest birds, the Blue-eyed Ground-Dove becomes even harder to find outside of the breeding season. During these times, it eludes detection, slipping out of sight when approached. This small dove is named for its vivid blue eyes, which match the spots on its wings and contrast with the rest of its rich tawny and rufous plumage.'),(7,'Bahama Nuthatch',9,'The Bahama Nuthatch is closely related to the Brown-headed Nuthatch of the southeastern United States, but can be distinguished by its longer beak, shorter wings, whiter belly, and vocalizations. The bird is only known from native pine forest on Grand Bahama Island, which lies approximately 100 miles off Palm Beach, Fla.');
/*!40000 ALTER TABLE `bird` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT 'user id',
  `bird_id` bigint NOT NULL COMMENT 'bird id',
  `comment` longtext NOT NULL COMMENT 'comment',
  PRIMARY KEY (`id`),
  KEY `idx_bird_id` (`bird_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,2,1,'Great!'),(3,1,2,'Rufous-Backed Kingfisher'),(4,2,2,'Not bad!'),(5,1,1,'nice pic!'),(6,5,4,'How amazing!');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bird_id` bigint NOT NULL COMMENT 'bird id',
  `url` varchar(256) NOT NULL COMMENT 'url',
  PRIMARY KEY (`id`),
  KEY `idx_bird_id` (`bird_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,1,'https://www.sonyaz.net/images/galeri/2019/10/1570716422_bird5.jpg'),(2,1,'https://cdn.birdwatchingdaily.com/2014/04/Rufous-backed-Kingfisher.jpg'),(3,2,'https://mycarquest.com/wp-content/uploads/2016/10/Rare-Bird.jpg'),(4,2,'https://i.cbc.ca/1.3715248.1470848348!/fileImage/httpImage/p-e-i-blue-jay-in-snow.jpg'),(5,3,'https://www.sciencemag.org/sites/default/files/styles/article_main_image_-_1280w__no_aspect_/public/cranes_1280p.jpg?itok=4oj2zuRC'),(6,4,'https://abcbirds.org/wp-content/uploads/2019/01/bristlefront.jpg'),(7,5,'https://abcbirds.org/wp-content/uploads/2019/05/antioquia-brushfinch-Sergio-Chaparro.jpg'),(8,6,'https://abcbirds.org/wp-content/uploads/2019/01/blue-eyed-for-upload.jpg'),(9,7,'https://abcbirds.org/wp-content/uploads/2019/05/bahama-nuthatch-Tom-Benson.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT 'name',
  `password` varchar(32) NOT NULL COMMENT 'password',
  `role` varchar(32) NOT NULL COMMENT 'role',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','user','User'),(2,'manager','manager','Manager'),(3,'admin','admin','Admin'),(4,'aaa','aaa','User'),(5,'llf','123','User'),(6,'abc','abc','Manager'),(7,'qqq','qqq','Manager');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-18 18:47:39
