DROP TABLE IF EXISTS `st_vehicle_tab`;

CREATE TABLE `st_vehicle_tab`
(
    `id`           int(5) NOT NULL AUTO_INCREMENT,
    `vehicle_type` varchar(20) DEFAULT NULL,
    `fuel`         varchar(20) DEFAULT NULL,
    `max_speed`    int(5) DEFAULT NULL,
    `max_load`     int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
