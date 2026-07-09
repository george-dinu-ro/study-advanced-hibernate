CREATE DATABASE IF NOT EXISTS `my_db`;

USE `my_db`;

DROP TABLE IF EXISTS `person_tab`;

CREATE TABLE `person_tab`
(
    `id`         int(5) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(20) DEFAULT NULL,
    `last_name`  varchar(20) DEFAULT NULL,
    `email`      varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `image_tab`;

CREATE TABLE `image_tab`
(
    `person_id` int(5) NOT NULL,
    `file_name` varchar(30) DEFAULT NULL
) ENGINE = InnoDB;