CREATE
DATABASE IF NOT EXISTS `my_db`;

USE
`my_db`;

DROP TABLE IF EXISTS `person_with_image_set_tab`;

CREATE TABLE `person_with_image_set_tab`
(
    `id`         int(5) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(20) DEFAULT NULL,
    `last_name`  varchar(20) DEFAULT NULL,
    `email`      varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `image_set_tab`;

CREATE TABLE `image_set_tab`
(
    `person_id` int(5) NOT NULL,
    `file_name` varchar(30) DEFAULT NULL
) ENGINE = InnoDB;