-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 07, 2024 at 03:56 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `UNCG-Fitness-Connect`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `flagged` bit(1) DEFAULT NULL,
  `join_date` datetime(6) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `role`, `user_name`, `first_name`, `flagged`, `join_date`, `last_name`) VALUES
(302, 'johndoe.user@example.com', 'USER', 'johndoe', 'John', b'0', '2024-11-06 19:00:00.000000', 'Doe'),
(303, 'sarasmith.user@example.com', 'ADMIN', 'sarasmith', 'Sara', b'1', '2024-11-06 19:00:00.000000', 'Smith'),
(304, 'brianlee.user@example.com', 'USER', 'brianlee', 'Brian', b'0', '2024-11-06 19:00:00.000000', 'Lee'),
(305, 'emilyclark.user@example.com', 'USER', 'emilyclarkUPDATED', 'Emily', b'1', '2024-11-06 19:00:00.000000', 'Clark'),
(306, 'davidmiller.user@example.com', 'USER', 'davidmiller', 'David', b'0', '2024-11-06 19:00:00.000000', 'Miller');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
