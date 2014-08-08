CREATE DATABASE `musica`;

USE `musica`;

DROP TABLE IF EXISTS `cancion`;

CREATE TABLE `cancion` (
  `dir` varchar(300) NOT NULL,
  `tit` varchar(300) NOT NULL,
  PRIMARY KEY (`dir`,`tit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `servidor`;

CREATE TABLE `servidor` (
  `host` varchar(600) NOT NULL,
  `dir` varchar(600) NOT NULL,
  PRIMARY KEY (`host`,`dir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
