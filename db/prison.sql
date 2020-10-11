-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2020 at 08:50 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prison`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `name` varchar(120) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `nic`, `name`, `designation`, `password`) VALUES
(1, '981962729v', 'osura', 'officer', '$2a$12$IxuVjL/qsmzF/o1WOhcGHueIRab92xreZ14.jkEw.LD8SR1ySJ93i'),
(2, '981962730v', 'ushan', 'officer', '$2a$12$DCXsGy4V8EGWg5Y4ZsTzPOGE06B6bGa3Oa1auKr5YObi7I7yFT01.');

-- --------------------------------------------------------

--
-- Table structure for table `courts`
--

CREATE TABLE `courts` (
  `court_id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courts`
--

INSERT INTO `courts` (`court_id`, `name`, `address`) VALUES
(1, 'kegalla', 'kegalla1'),
(2, 'Mt-lavinia', 'Mt-lavinia');

-- --------------------------------------------------------

--
-- Table structure for table `prisoners`
--

CREATE TABLE `prisoners` (
  `prisoner_id` int(10) NOT NULL,
  `p_nic` varchar(10) NOT NULL,
  `name` varchar(120) NOT NULL,
  `cell_no` varchar(10) NOT NULL,
  `place` varchar(20) NOT NULL,
  `relations_phone_no` int(10) NOT NULL,
  `relations_email` varchar(120) NOT NULL,
  `court_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prisoners`
--

INSERT INTO `prisoners` (`prisoner_id`, `p_nic`, `name`, `cell_no`, `place`, `relations_phone_no`, `relations_email`, `court_id`) VALUES
(1, '981962729v', 'osura', 'c12', 'Hospital', 768405056, 'ushanalwis81@gmail.com', 1),
(2, '981962721v', 'aa', 'aa2', 'Hospital', 768405056, 'ushanalwis81@gmail.com', 1),
(3, '981962723v', 'asd', 'asd', 'Hospital', 768405056, 'ushanalwis81@gmail.com', 1),
(4, '981962726v', 'asdasd', 'asd', 'Hospital', 768405056, 'ushanalwis81@gmail.com', 1),
(5, '981962798v', 'alwis', 'c15', 'Hospital', 702348481, 'ushanalwis81@gmail.com', 1),
(6, '981962725v', 'asd', 'asd', 'Hospital', 768405056, 'osuramahanama11@gmail.com', 1),
(7, '981962720v', 'asd', 'asd', 'Hospital', 768405056, 'osuramahanama11@gmail.com', 1),
(8, '981962734v', 'alwis', 'a10', 'Magazine', 702348481, 'ushanindeewara81@gmail.com', 1),
(9, '981962735v', 'Ushan', 'c18', 'CRP', 702348481, 'ushanalwis81@gmail.con', 1),
(10, '981962736v', 'kasun', 'c19', 'CRP', 702348481, 'ushanindeewara81@gmail.com', 1),
(11, '981962750v', 'sahan', 'c20', 'Hospital', 702348481, 'ushanindeewara81@gmail.com', 2),
(12, '981962753v', 'rohan', 'c21', 'CRP', 702348481, 'ushanindeewara81@gmail.com', 1),
(13, '981962755v', 'sarath', 'c22', 'CRP', 702348481, 'ushanindeewara81@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `prisoner_moved`
--

CREATE TABLE `prisoner_moved` (
  `move_id` int(10) NOT NULL,
  `move_from` varchar(20) NOT NULL,
  `move_to` varchar(20) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  `prisoner_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prisoner_moved`
--

INSERT INTO `prisoner_moved` (`move_id`, `move_from`, `move_to`, `time`, `date`, `prisoner_id`) VALUES
(1, 'Hospital', 'Magazine', '22:34:46', '2020-05-23', 1),
(2, 'Magazine', 'Hospital', '19:26:36', '2020-05-25', 1),
(3, 'Hospital', 'Courts', '01:03:16', '2020-05-27', 1),
(4, 'Hospital', 'Magazine', '01:06:19', '2020-05-27', 2),
(5, 'Hospital', 'Magazine', '08:38:24', '2020-05-27', 1),
(6, 'Magazine', 'Hospital', '13:55:12', '2020-05-27', 1),
(7, 'Magazine', 'Courts', '13:55:57', '2020-05-27', 2),
(8, 'Hospital', 'Courts', '23:41:49', '2020-05-27', 1),
(9, 'Hospital', 'Magazine', '23:48:46', '2020-05-27', 1),
(10, 'Hospital', 'Courts', '00:00:40', '2020-05-28', 1),
(11, 'Magazine', 'Hospital', '00:11:00', '2020-05-28', 2),
(12, 'Hospital', 'Magazine', '01:48:07', '2020-05-28', 6),
(13, 'Courts', 'Magazine', '01:49:19', '2020-05-28', 1),
(14, 'CRP', 'Magazine', '09:04:24', '2020-06-09', 11),
(15, 'Hospital', 'Courts', '10:17:41', '2020-06-09', 12),
(16, 'CRP', 'Magazine', '11:14:48', '2020-06-09', 13);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `visitor_id` int(10) NOT NULL,
  `v_nic` varchar(10) NOT NULL,
  `name` varchar(120) NOT NULL,
  `address` varchar(120) NOT NULL,
  `contact_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`visitor_id`, `v_nic`, `name`, `address`, `contact_no`) VALUES
(1, '981962729v', 'osura', 'kiribathgoda1', 768405056),
(2, '981962721v', 'asd', 'asd', 768405056),
(3, '981962722v', 'qwe', 'qwe', 768405056),
(4, '981962723v', 'asds', 'sadas', 768405056),
(5, '981962740v', 'Alwis', 'no 11 alwis avenue , Dehiwala', 702348481),
(6, '981962741v', 'ushan', 'no 11 alwis avenue ,kalubowila ,dehiwala', 702348481),
(7, '981962742v', 'ushan', 'no 11 alwis avenue , mathara ', 702348481),
(8, '981962790v', 'Ushan', 'no 11 alwis avenue .dehiwala', 702348481);

-- --------------------------------------------------------

--
-- Table structure for table `visits`
--

CREATE TABLE `visits` (
  `visit_id` int(10) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  `place` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Not Approved',
  `relation_to_prisoner` varchar(20) NOT NULL,
  `admin_id` int(10) DEFAULT NULL,
  `v_id` int(10) NOT NULL,
  `prisoner_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visits`
--

INSERT INTO `visits` (`visit_id`, `time`, `date`, `place`, `status`, `relation_to_prisoner`, `admin_id`, `v_id`, `prisoner_id`) VALUES
(2, '22:50:47', '2020-05-23', 'Hospital', 'Approved', 'asd', 1, 1, 1),
(3, '00:19:40', '2020-05-28', 'Hospital', 'Approved', 'kok', 1, 4, 1),
(4, '08:55:58', '2020-06-09', 'CRP', 'Approved', 'cousin', 1, 5, 10),
(5, '09:02:06', '2020-06-09', 'CRP', 'Approved', 'son', 1, 6, 11),
(6, '10:10:00', '2020-06-09', 'CRP', 'Approved', 'cousin', 1, 7, 12),
(7, '11:11:17', '2020-06-09', 'CRP', 'Approved', 'son', 1, 8, 13);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `courts`
--
ALTER TABLE `courts`
  ADD PRIMARY KEY (`court_id`);

--
-- Indexes for table `prisoners`
--
ALTER TABLE `prisoners`
  ADD PRIMARY KEY (`prisoner_id`),
  ADD KEY `court_id` (`court_id`);

--
-- Indexes for table `prisoner_moved`
--
ALTER TABLE `prisoner_moved`
  ADD PRIMARY KEY (`move_id`),
  ADD KEY `prisoner_id` (`prisoner_id`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`visitor_id`);

--
-- Indexes for table `visits`
--
ALTER TABLE `visits`
  ADD PRIMARY KEY (`visit_id`),
  ADD KEY `admin_id` (`admin_id`),
  ADD KEY `v_id` (`v_id`),
  ADD KEY `prisoner_id` (`prisoner_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `courts`
--
ALTER TABLE `courts`
  MODIFY `court_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `prisoners`
--
ALTER TABLE `prisoners`
  MODIFY `prisoner_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `prisoner_moved`
--
ALTER TABLE `prisoner_moved`
  MODIFY `move_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `visitor_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `visits`
--
ALTER TABLE `visits`
  MODIFY `visit_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `prisoners`
--
ALTER TABLE `prisoners`
  ADD CONSTRAINT `prisoners_ibfk_1` FOREIGN KEY (`court_id`) REFERENCES `courts` (`court_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prisoner_moved`
--
ALTER TABLE `prisoner_moved`
  ADD CONSTRAINT `prisoner_moved_ibfk_1` FOREIGN KEY (`prisoner_id`) REFERENCES `prisoners` (`prisoner_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `visits`
--
ALTER TABLE `visits`
  ADD CONSTRAINT `visits_ibfk_2` FOREIGN KEY (`v_id`) REFERENCES `visitor` (`visitor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `visits_ibfk_3` FOREIGN KEY (`prisoner_id`) REFERENCES `prisoners` (`prisoner_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `visits_ibfk_4` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
