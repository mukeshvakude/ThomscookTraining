# ThomscookTraining
1) you need to install apache 9.0 server
2)libraries you required
-jackson-annotations-2.7.0-rc4-20160106.061927-1.jar
-jackson-core-2.7.0-rc4-20160106.062135-1.jar
-jackson-core-asl-1.9.13.jar
-jackson-databind-2.7.0-rc4-20160109.222726-11.jar
-jackson-mapper-asl-1.9.13.jar
-jstl-1.2.jar
-mysql-connector-java-8.0.24.jar
-org.json.jar

3) keep all libraries in WEB_INF->lib Folder

4) Database- Mysql
5) Database Name - student
6) Tables 
1) categories

CREATE TABLE `categories` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) NOT NULL,
  `cat_description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

2) likededisliked
CREATE TABLE `likededisliked` (
  `like_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `liked` int DEFAULT '0',
  `disliked` int DEFAULT '0',
  PRIMARY KEY (`like_id`),
  KEY `post_id_idx` (`post_id`),
  KEY `user_id2_idx` (`user_id`),
  CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
3) posts

CREATE TABLE `posts` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `post_title` varchar(45) DEFAULT NULL,
  `post_description` text,
  `posted_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `post_pic` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `cat_id` int DEFAULT NULL,
  `photos` mediumblob,
  PRIMARY KEY (`post_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `user_id1_idx` (`user_id`),
  KEY `cat_id_idx` (`cat_id`),
  CONSTRAINT `cat_id` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
4 )todos

CREATE TABLE `todos` (
  `todo_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `target_date` datetime DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`todo_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
5) users

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_number` varchar(45) CHARACTER SET armscii8 COLLATE armscii8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

