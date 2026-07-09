DROP TABLE IF EXISTS `employee_with_address_tab`;

CREATE TABLE `employee_with_address`
(
    `id`          int(5) NOT NULL AUTO_INCREMENT,
    `first_name`  varchar(20) DEFAULT NULL,
    `last_name`   varchar(20) DEFAULT NULL,
    `home_street` varchar(30) DEFAULT NULL,
    `home_number` int(5) DEFAULT NULL,
    `home_city`   varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
