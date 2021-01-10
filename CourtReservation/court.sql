-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2021 at 07:30 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `court`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL,
  `adname` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `ademail` varchar(50) DEFAULT NULL,
  `adpass` varchar(50) DEFAULT NULL,
  `adphone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `adname`, `address`, `ademail`, `adpass`, `adphone`) VALUES
(1, 'siti', 'china', 'madi@gmail.com', '1234', '01117829700'),
(2, 'abu', 'kelantan', 'madi@gmail.com', '1234', '01117829700'),
(3, 'ali', 'johor', 'madi@gmail.com', '1234', '01117829700');

-- --------------------------------------------------------

--
-- Table structure for table `badminton`
--

CREATE TABLE `badminton` (
  `cid` varchar(5) NOT NULL,
  `racket` tinyint(4) DEFAULT NULL,
  `shuttle` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookid` int(11) NOT NULL,
  `custid` int(11) DEFAULT NULL,
  `adminid` int(11) DEFAULT NULL,
  `cid` varchar(5) DEFAULT NULL,
  `booktime` time DEFAULT NULL,
  `bookdate` date DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookid`, `custid`, `adminid`, `cid`, `booktime`, `bookdate`, `totalprice`, `hours`) VALUES
(3, 1, 1, 'F01', '12:32:00', '2021-01-15', '12', 0),
(4, 1, 1, 'F01', '13:43:00', '2021-01-08', '20', 0),
(5, 1, 1, 'F01', '13:57:00', '2021-01-07', '88', 0);

-- --------------------------------------------------------

--
-- Table structure for table `courts`
--

CREATE TABLE `courts` (
  `cid` varchar(5) NOT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courts`
--

INSERT INTO `courts` (`cid`, `cname`, `status`) VALUES
('F01', 'Sidek', 'AVAILABLE');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custid` int(11) NOT NULL,
  `custname` varchar(50) DEFAULT NULL,
  `custaddress` varchar(50) DEFAULT NULL,
  `custemail` varchar(50) DEFAULT NULL,
  `custpass` varchar(50) DEFAULT NULL,
  `custphone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custid`, `custname`, `custaddress`, `custemail`, `custpass`, `custphone`) VALUES
(1, 'madi', 'korea', 'madi@gmail.com', '1234', '01117829700'),
(2, 'ali', 'india', 'madi@gmail.com', '1234', '01117829700'),
(3, 'abu', 'china', 'madi@gmail.com', '1234', '01117829700'),
(4, 'siti', 'china', 'madi@gmail.com', '1234', '01117829700');

-- --------------------------------------------------------

--
-- Table structure for table `futsal`
--

CREATE TABLE `futsal` (
  `cid` varchar(5) NOT NULL DEFAULT '0',
  `ball` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `futsal`
--

INSERT INTO `futsal` (`cid`, `ball`) VALUES
('F01', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminid`);

--
-- Indexes for table `badminton`
--
ALTER TABLE `badminton`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookid`),
  ADD KEY `custid` (`custid`),
  ADD KEY `adminid` (`adminid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `courts`
--
ALTER TABLE `courts`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custid`);

--
-- Indexes for table `futsal`
--
ALTER TABLE `futsal`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `cid` (`cid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `custid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `badminton`
--
ALTER TABLE `badminton`
  ADD CONSTRAINT `FK1_badminton_courts` FOREIGN KEY (`cid`) REFERENCES `courts` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `_booking_admin` FOREIGN KEY (`adminid`) REFERENCES `admin` (`adminid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `_booking_courts` FOREIGN KEY (`cid`) REFERENCES `courts` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `_booking_customer` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `futsal`
--
ALTER TABLE `futsal`
  ADD CONSTRAINT `FK1_futsal_courts` FOREIGN KEY (`cid`) REFERENCES `courts` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION;


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table admin
--

--
-- Metadata for table badminton
--

--
-- Metadata for table booking
--

--
-- Metadata for table courts
--

--
-- Metadata for table customer
--

--
-- Metadata for table futsal
--

--
-- Metadata for database court
--
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
