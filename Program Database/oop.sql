-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2021 at 03:00 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `AdminName` varchar(30) NOT NULL,
  `AdminPassword` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`AdminName`, `AdminPassword`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `engineer`
--

CREATE TABLE `engineer` (
  `id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `salary` int(11) NOT NULL,
  `grade` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `WorkingHours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `engineer`
--

INSERT INTO `engineer` (`id`, `Name`, `salary`, `grade`, `age`, `WorkingHours`) VALUES
(1, 'Kareem', 99000, 'CEO', 35, 99);

-- --------------------------------------------------------

--
-- Table structure for table `trainee`
--

CREATE TABLE `trainee` (
  `id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `salary` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `UniversityName` varchar(30) NOT NULL,
  `GPA` float NOT NULL,
  `AcademicYear` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trainee`
--

INSERT INTO `trainee` (`id`, `Name`, `salary`, `age`, `UniversityName`, `GPA`, `AcademicYear`) VALUES
(1, 'Ahmed', 5000, 18, 'Ain Shams', 3, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
