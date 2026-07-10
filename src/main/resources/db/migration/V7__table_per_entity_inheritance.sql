DROP TABLE IF EXISTS `tpc_car_tab`;
DROP TABLE IF EXISTS `tpc_truck_tab`;
DROP TABLE IF EXISTS `table_generator_tab`;

CREATE TABLE `tpc_car_tab`
(
    `id`        int(5) NOT NULL,
    `fuel`      varchar(20) DEFAULT NULL,
    `max_speed` int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `tpc_truck_tab`
(
    `id`       int(5) NOT NULL,
    `fuel`     varchar(20) DEFAULT NULL,
    `max_load` int(5) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE table_generator_tab
(
    pk_name  VARCHAR(100) PRIMARY KEY,
    pk_value BIGINT NOT NULL
);

INSERT INTO table_generator_tab(pk_name, pk_value)
VALUES ('vehicle_id', 1);