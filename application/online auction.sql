-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.31-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for onlineauctiondb
CREATE DATABASE IF NOT EXISTS `onlineauctiondb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `onlineauctiondb`;

-- Dumping structure for table onlineauctiondb.bid
CREATE TABLE IF NOT EXISTS `bid` (
  `bidid` int(11) NOT NULL AUTO_INCREMENT,
  `buyerid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `bidvalue` decimal(10,2) NOT NULL,
  `bidquantity` int(11) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`bidid`),
  KEY `FK_bid_product` (`pid`),
  KEY `FK_bid_user` (`buyerid`),
  CONSTRAINT `FK_bid_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE CASCADE,
  CONSTRAINT `FK_bid_user` FOREIGN KEY (`buyerid`) REFERENCES `user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table onlineauctiondb.category
CREATE TABLE IF NOT EXISTS `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(60) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table onlineauctiondb.product
CREATE TABLE IF NOT EXISTS `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `cid` int(11) NOT NULL,
  `description` varchar(60) NOT NULL,
  `actualprice` decimal(10,2) NOT NULL,
  `quantity` int(10) NOT NULL,
  `image` varchar(60) DEFAULT NULL,
  `sellerid` int(11) NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_products_category` (`cid`),
  KEY `FK_products_user` (`sellerid`),
  CONSTRAINT `FK_products_category` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE CASCADE,
  CONSTRAINT `FK_products_user` FOREIGN KEY (`sellerid`) REFERENCES `user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table onlineauctiondb.productauction
CREATE TABLE IF NOT EXISTS `productauction` (
  `auctionid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `sellerid` int(11) NOT NULL,
  `buyerid` int(11) DEFAULT NULL,
  `minbidvalue` decimal(10,2) NOT NULL,
  `bidstartdate` date NOT NULL,
  `bidenddate` date NOT NULL,
  `soldprice` decimal(10,2) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`auctionid`),
  KEY `FK_productauction_product` (`pid`),
  KEY `FK_productauction_user` (`sellerid`),
  KEY `FK_productauction_user_2` (`buyerid`),
  CONSTRAINT `FK_productauction_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE CASCADE,
  CONSTRAINT `FK_productauction_user` FOREIGN KEY (`sellerid`) REFERENCES `user` (`userid`) ON DELETE CASCADE,
  CONSTRAINT `FK_productauction_user_2` FOREIGN KEY (`buyerid`) REFERENCES `user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table onlineauctiondb.user
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `emailid` varchar(30) NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `address` varchar(60) DEFAULT NULL,
  `walletamount` decimal(10,2) DEFAULT NULL,
  `typeofuser` varchar(15) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `password` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
