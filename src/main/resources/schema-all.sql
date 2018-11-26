DROP TABLE people IF EXISTS;


CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'UNPROCESSED',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;