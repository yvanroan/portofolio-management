-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 09, 2021 at 07:20 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `management`
--

-- --------------------------------------------------------

--
-- Table structure for table `boss`
--

DROP TABLE IF EXISTS `boss`;
CREATE TABLE IF NOT EXISTS `boss` (
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `address` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile` text NOT NULL,
  `phone` varchar(10) NOT NULL,
  `IDBoss` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IDBoss`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boss`
--

INSERT INTO `boss` (`name`, `surname`, `address`, `password`, `profile`, `phone`, `IDBoss`) VALUES
('Yvan', 'Tipak', 'Edmonton', 'Bamileke', '', '1234567890', 1);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `profile` text NOT NULL,
  `IDClient` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  `IDCom` int(11) NOT NULL,
  UNIQUE KEY `id` (`IDClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`name`, `surname`, `sex`, `address`, `phone`, `profile`, `IDClient`, `status`, `IDCom`) VALUES
('Ulrich', 'Fokou', 'male', 'Edmonton', '2345678901', '', 1, 'Pending', 1);

-- --------------------------------------------------------

--
-- Table structure for table `commercial`
--

DROP TABLE IF EXISTS `commercial`;
CREATE TABLE IF NOT EXISTS `commercial` (
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `profileC` text NOT NULL,
  `status` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `IDCom` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  `IDClient` int(11) NOT NULL,
  UNIQUE KEY `IDCom` (`IDCom`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commercial`
--

INSERT INTO `commercial` (`name`, `surname`, `profileC`, `status`, `address`, `phone`, `IDCom`, `password`, `IDClient`) VALUES
('Ulrich', 'Tiam', '', 'On', 'Edmonton', '4567890123', 1, 'tonton', 1);

-- --------------------------------------------------------

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
CREATE TABLE IF NOT EXISTS `visit` (
  `IDCom` int(11) NOT NULL,
  `IDClient` int(11) NOT NULL,
  `goal` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `period` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visit`
--

INSERT INTO `visit` (`IDCom`, `IDClient`, `goal`, `description`, `period`) VALUES
(1, 1, 'what\'s popping ?', 'i heard that you got a new job', '2021-08-05 18:20:36'),
(1, 1, 'cest la chimamelure', 'Description : cest toi qui voit moi je suis seulement depasser par les evenements', '2021-08-06 18:30:30');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
