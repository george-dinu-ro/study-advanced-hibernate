DROP TABLE IF EXISTS `ms_car_tab`;
DROP TABLE IF EXISTS `ms_truck_tab`;

CREATE TABLE `ms_car_tab`
(
    `id`        int(5) NOT NULL AUTO_INCREMENT,
    `fuel`      varchar(20) DEFAULT NULL,
    `max_speed` int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `ms_truck_tab`
(
    `id`       int(5) NOT NULL AUTO_INCREMENT,
    `fuel`     varchar(20) DEFAULT NULL,
    `max_load` int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
