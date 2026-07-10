DROP TABLE IF EXISTS `engine_tab`;

CREATE TABLE `engine_tab`
(
    `id`    int(5) NOT NULL AUTO_INCREMENT,
    `fuel`  varchar(20) DEFAULT NULL,
    `power` int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
