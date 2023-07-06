CREATE DATABASE IF NOT EXISTS `sugar_rush`;

USE `sugar_rush`;

DROP TABLE IF EXISTS `category`;

CREATE TABLE
    `category` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `name` varchar(255) DEFAULT NULL,
        `slug` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
    );

LOCK TABLES `category` WRITE;

INSERT INTO `category`
VALUES (1, 'Fun', 'fun'), (2, 'Sport', 'sport'), (3, 'Carie', 'carie'), (4, 'Miam', 'miam'), (
        5,
        'Ça coute bonbon',
        'ca-coute-bonbon'
    );

;

UNLOCK TABLES;