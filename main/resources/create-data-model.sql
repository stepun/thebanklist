CREATE DATABASE app_db CHARACTER SET utf8;
 
USE app_db;
 
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int NOT NULL AUTO_INCREMENT COMMENT 'User ID',
  `name` varchar(45) DEFAULT NULL COMMENT 'User name.',
  `sureName` varchar(45) DEFAULT NULL COMMENT 'User surename.',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User table';

CREATE TABLE IF NOT EXISTS `account` (
  `accountid` int NOT NULL AUTO_INCREMENT COMMENT 'Account ID',
  `account` int DEFAULT NULL COMMENT 'Account',
  `amount` double DEFAULT NULL COMMENT 'Amount in account',
  `userid` int DEFAULT NULL COMMENT 'User ID.',
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Account table';