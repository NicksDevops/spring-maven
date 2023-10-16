DROP SCHEMA IF EXISTS `employee_sample_project`;

CREATE SCHEMA `employee_sample_project`;

use `employee_sample_project`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dept_id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `sl_no` int(5) NOT NULL AUTO_INCREMENT,
  `emp_number` int(10) NOT NULL UNIQUE,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `education` varchar(45) NOT NULL,
  `address` varchar(200) NOT NULL,
  `married` varchar(1) NOT NULL,
  `dept_id` int(10) NOT NULL,
  `password` varchar(11) NOT NULL,
  `is_admin` varchar(1) NOT NULL,
  PRIMARY KEY (`sl_no`),
  KEY `departmentFK_DEPT_idx` (`dept_id`),
  CONSTRAINT `FK_DEPT` FOREIGN KEY (`dept_id`) 
  REFERENCES `department` (`dept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(10) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) NOT NULL,
  `project_description` varchar(200) DEFAULT NULL,
  
  PRIMARY KEY (`project_id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `employee_project`;

CREATE TABLE `employee_project` (
  `employee_id` int(10) NOT NULL,
  `project_id` int(10) NOT NULL,
  
  PRIMARY KEY (`employee_id`,`project_id`),
  
  KEY `FK_PROJECT_idx` (`project_id`),
  
  CONSTRAINT `FK_EMP_05` FOREIGN KEY (`employee_id`) 
  REFERENCES `employee` (`sl_no`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_PROJECT` FOREIGN KEY (`project_id`) 
  REFERENCES `PROJECT` (`project_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
