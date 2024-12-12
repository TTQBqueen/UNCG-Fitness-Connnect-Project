-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 12, 2024 at 07:30 AM
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
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `details` varchar(255) NOT NULL,
  `duration` int(11) NOT NULL,
  `end_time` time(6) NOT NULL,
  `flag` bit(1) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `instructor_name` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL,
  `start_time` time(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `details`, `duration`, `end_time`, `flag`, `image_path`, `instructor_name`, `level`, `start_time`, `status`, `title`, `creator_id`, `date`) VALUES
(1, 'Beginner Yoga Class focusing on flexibility and relaxation.', 60, '10:00:00.000000', b'0', 'https://images.unsplash.com/photo-1501889088093-90b27410d97e?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHBhdGh8ZW58MHx8MHx8fDA%3D', 'InstructorTest', 'Beginner', '09:00:00.000000', 'Open', 'Morning Yoga', 602, '2024-12-12'),
(2, 'Intermediate Pilates Class to strengthen your core.', 45, '11:15:00.000000', b'0', 'https://i0.wp.com/post.healthline.com/wp-content/uploads/2021/04/pilates-1296x728-header.jpg?w=1155&h=1528', 'Raven Griffen', 'Intermediate', '10:30:00.000000', 'Open', 'Core Pilates', 753, '2024-12-12'),
(3, 'Advanced HIIT Class for high-intensity cardio and strength.', 30, '18:30:00.000000', b'0', 'https://breakingmuscle.com/wp-content/uploads/2022/06/shutterstock_1999653764-1.jpg', 'Jabrielle Boler', 'Advanced', '18:00:00.000000', 'Open', 'Evening HIIT', 754, '2024-12-13'),
(4, 'Zumba Dance Class to improve fitness while having fun.', 50, '17:00:00.000000', b'0', 'https://princetonfitnessandwellness.com/wp-content/uploads/2024/09/40357010_0924_PRI_GFI_WEB_ZumbaPartyinPinkh_Vr1-400x250-1.jpg', 'Raven Griffen', 'Beginner', '16:10:00.000000', 'Open', 'Zumba Party', 753, '2024-12-13'),
(5, 'Beginner Spinning Class for low-impact cardio.', 45, '19:30:00.000000', b'0', 'https://www.vice.com/wp-content/uploads/sites/2/2019/11/1573215275084-ariana-grande-spin-class-emotion.jpeg', 'InstructorTest', 'Beginner', '18:45:00.000000', 'Open', 'Spinning Basics', 602, '2024-12-14'),
(6, 'Advanced Strength Training for building muscle.', 90, '20:30:00.000000', b'0', 'https://img.freepik.com/premium-photo/building-strength-unity-empowering-gym-class-with-diverse-workout-groups-intense-weightlift_983420-155661.jpg', 'Jabrielle Boler', 'Advanced', '19:00:00.000000', 'Open', 'Strength Builder', 754, '2024-12-14'),
(7, 'Morning Meditation for relaxation and focus.', 30, '07:30:00.000000', b'0', 'https://www.blueosa.com/wp-content/uploads/2017/07/the-magical-time-to-meditate.jpg', 'InstructorTest', 'Beginner', '07:00:00.000000', 'Open', 'Meditation Hour', 602, '2024-12-15');

-- --------------------------------------------------------

--
-- Table structure for table `class_seq`
--

CREATE TABLE `class_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class_seq`
--

INSERT INTO `class_seq` (`next_val`) VALUES
(2051);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `report_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `reason` varchar(255) NOT NULL,
  `report_type` varchar(255) NOT NULL,
  `reporter_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `report_seq`
--

CREATE TABLE `report_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report_seq`
--

INSERT INTO `report_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `review_id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `details` varchar(255) NOT NULL,
  `rating` int(11) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`review_id`, `created_at`, `details`, `rating`, `status`, `updated_at`, `user_id`, `class_id`, `reply`) VALUES
(1, '2024-12-12 10:00:00.000000', 'Great yoga class, very relaxing!', 5, b'0', NULL, 652, 1, NULL),
(2, '2024-12-12 10:10:00.000000', 'Good class, but could use more time for stretching.', 4, b'0', NULL, 755, 1, NULL),
(3, '2024-12-12 11:30:00.000000', 'Pilates session was intense but rewarding.', 5, b'0', NULL, 752, 2, NULL),
(4, '2024-12-12 12:00:00.000000', 'Enjoyed the focus on core strength.', 4, b'0', NULL, 756, 2, NULL),
(5, '2024-12-13 19:00:00.000000', 'The HIIT class pushed me to my limits!', 5, b'1', NULL, 652, 3, 'jjj'),
(6, '2024-12-13 19:10:00.000000', 'Could use a bit more rest time between sets.', 3, b'0', NULL, 755, 3, NULL),
(7, '2024-12-13 17:15:00.000000', 'The Zumba class was a blast!', 5, b'0', NULL, 756, 4, 'Thank you!'),
(8, '2024-12-13 17:20:00.000000', 'Great energy from the instructor.', 5, b'0', NULL, 652, 4, NULL),
(9, '2024-12-14 20:00:00.000000', 'Loved the spinning class, very engaging!', 5, b'0', NULL, 755, 5, NULL),
(10, '2024-12-14 20:10:00.000000', 'Could use better music choices.', 4, b'0', NULL, 756, 5, NULL),
(11, '2024-12-14 21:45:00.000000', 'Strength training was top-notch!', 5, b'1', NULL, 652, 6, NULL),
(12, '2024-12-14 22:00:00.000000', 'Challenging but effective workout.', 5, b'0', NULL, 752, 6, 'Happy to hear!'),
(13, '2024-12-15 08:00:00.000000', 'The meditation class was so calming.', 5, b'0', NULL, 755, 7, NULL),
(14, '2024-12-15 08:10:00.000000', 'Great way to start the day!', 5, b'0', NULL, 756, 7, NULL),
(15, '2024-12-12 11:45:00.000000', 'Good beginner class.', 4, b'0', NULL, 652, 1, NULL),
(16, '2024-12-13 17:30:00.000000', 'Zumba class was full of energy!', 5, b'0', NULL, 752, 4, 'Thank you for the feedback!'),
(17, '2024-12-14 20:30:00.000000', 'Good instructor but room was too crowded.', 3, b'0', NULL, 755, 5, NULL),
(18, '2024-12-14 22:15:00.000000', 'Loved the guidance and tips during strength training.', 5, b'0', NULL, 756, 6, NULL),
(202, NULL, 'I cant wait to go again', 4, b'0', NULL, 652, 1, NULL),
(203, NULL, 'hfhfhf', 3, b'0', NULL, 652, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `review_seq`
--

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_seq`
--

INSERT INTO `review_seq` (`next_val`) VALUES
(301);

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `subs_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`subs_id`, `class_id`, `user_id`) VALUES
(1, 1, 652),
(2, 1, 652),
(52, 1, 652),
(102, 1, 652),
(152, 1, 652);

-- --------------------------------------------------------

--
-- Table structure for table `subscription_seq`
--

CREATE TABLE `subscription_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscription_seq`
--

INSERT INTO `subscription_seq` (`next_val`) VALUES
(251);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `flagged` bit(1) DEFAULT NULL,
  `join_date` datetime(6) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `first_name`, `flagged`, `join_date`, `last_name`, `role`, `user_name`, `password`) VALUES
(602, 'Instructor@uncg.edu', 'Instructor', b'0', NULL, 'Instructor', 'INSTRUCTOR', 'InstructorTest', '$2a$10$3R8vsijosAyeBZH9P4FpZu.Wa2vfgiyzOh6zeSKb9uBClovVAecm6'),
(652, 'StudentTest@gmail.com', 'Student', b'0', NULL, 'Student', 'STUDENT', 'StudentTest', '$2a$10$5D7ixEc6UQdo804jldsOE.oZD2e3eqA53qYeDpTCw69yy2VW92PRi'),
(703, 'Admin@gmail.com', 'Admin', b'0', NULL, 'Admin', 'ADMIN', 'AdminTest', '$2a$10$nI/GfOM7fYV3p3K69LHd8Ofz44pbxi.ZJSruxTPqrm3uIdpBl86le'),
(752, 'ttboler@uncg.edu', 'Trinity', b'0', NULL, 'Boler', 'STUDENT', 'TBQueen', '$2a$10$jItrZNLh1QBvX16r0az1AOpImOAFjht2GtRZfGVqSKNGCB.BfqWnS'),
(753, 'raven@gmail.com', 'Raven', b'0', NULL, 'Griffen', 'INSTRUCTOR', 'Raven Griffen', '$2a$10$2tbDM3VhTgnVa4I1uT9.ceaXWTISf45DvRFr.n0xjekInfUB1EgCW'),
(754, 'jboler@gmail.com', 'Jabrielle', b'0', NULL, 'Boler', 'INSTRUCTOR', 'Jabrielle Boler', '$2a$10$xcOC7B17dm978QOQNn/H9evNREuE4AbLqhkm5/OQ/10pZQsQZNRca'),
(755, 'sj@gmail.com', 'Summer', b'0', NULL, 'Johnson', 'STUDENT', 'SummerJ', '$2a$10$h.hab3gbujdYXWcoN0zEAeFxYsqy2WwIHFamVnTOdC45RaJ2nFFhS'),
(756, 'Mcole@yahoo.com', 'Markia', b'0', NULL, 'Colmen', 'STUDENT', 'MooMan', '$2a$10$70kpkkIdr26ljNloUa161e7QV9rAnNb4oFMZxaYzdAsfum4ScuDL.'),
(802, 'rGreen@gmail.com', 'Raveen', b'0', NULL, 'Green', 'STUDENT', 'RavenG', '$2a$10$lD3HfIvKJFu8cp2DvPfDeeTAomrFCQuvfv5JSR8W3a75DZ3z0oUI.');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(901);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `FKnwf2umoo8j7kswufmcmbnbwiv` (`creator_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`report_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `FKive3yn620j28n7vl2ebfrasjb` (`class_id`),
  ADD KEY `FK6cpw2nlklblpvc7hyt7ko6v3e` (`user_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`subs_id`),
  ADD KEY `FKniykie4me700t2jh29hc85ml` (`class_id`),
  ADD KEY `FKqwd9pkhbsmapx9poug5wnnpkc` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `FKnwf2umoo8j7kswufmcmbnbwiv` FOREIGN KEY (`creator_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK6cpw2nlklblpvc7hyt7ko6v3e` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKive3yn620j28n7vl2ebfrasjb` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `FKniykie4me700t2jh29hc85ml` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `FKqwd9pkhbsmapx9poug5wnnpkc` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
