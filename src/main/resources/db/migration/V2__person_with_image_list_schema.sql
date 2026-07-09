DROP TABLE IF EXISTS `person_with_image_list_tab`;

CREATE TABLE `person_with_image_list_tab`
(
    `id`         int(5) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(20) DEFAULT NULL,
    `last_name`  varchar(20) DEFAULT NULL,
    `email`      varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `image_list_tab`;

CREATE TABLE `image_list_tab`
(
    `person_id`  int(5) NOT NULL,
    `file_order` int(5) NOT NULL,
    `file_name`  varchar(30) DEFAULT NULL
) ENGINE = InnoDB;