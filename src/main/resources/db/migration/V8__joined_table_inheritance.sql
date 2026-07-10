DROP TABLE IF EXISTS `jt_vehicle_tab`;
DROP TABLE IF EXISTS `jt_car_tab`;
DROP TABLE IF EXISTS `jt_truck_tab`;

CREATE TABLE `jt_vehicle_tab`
(
    `id`   int(5) NOT NULL AUTO_INCREMENT,
    `fuel` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `jt_car_tab`
(
    `vehicle_id` int(5) NOT NULL,
    `max_speed`  int(5) DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE `jt_truck_tab`
(
    `vehicle_id` int(5) NOT NULL,
    `max_load`   int(5) DEFAULT NULL
) ENGINE = InnoDB;