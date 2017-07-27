-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 30, 2014 at 10:11 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `compdept`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `Lastname` varchar(50) DEFAULT NULL,
  `Firstname` varchar(25) DEFAULT NULL,
  `Title` varchar(10) DEFAULT 'crew',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `Lastname`, `Firstname`, `Title`) VALUES
(1, 'femi', 'silas', 'programmer'),
(2, 'femi', 'silas', NULL),
(3, 'femi', NULL, NULL),
(4, 'boluDefault', NULL, NULL),
(5, 'onlyName', NULL, 'crew');

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE IF NOT EXISTS `exams` (
  `eid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(45) NOT NULL DEFAULT '',
  `active` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`eid`, `exam_name`, `active`) VALUES
(1, 'JavascriptExpert', 1),
(2, 'LostSurvivalCourse', 0),
(3, 'ZendPHPCertification', 1),
(4, 'SuperheroAdvancedSkills', 1),
(5, 'DesperationCertificate', 1);

-- --------------------------------------------------------

--
-- Table structure for table `info2011_12`
--

CREATE TABLE IF NOT EXISTS `info2011_12` (
  `MatricNo` varchar(8) NOT NULL,
  `Surname` longtext,
  `Firstname` longtext,
  `Lastname` longtext,
  `level` int(5) DEFAULT NULL,
  `yearOfEntry` varchar(12) DEFAULT NULL,
  `sex` text,
  PRIMARY KEY (`MatricNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info2011_12`
--

INSERT INTO `info2011_12` (`MatricNo`, `Surname`, `Firstname`, `Lastname`, `level`, `yearOfEntry`, `sex`) VALUES
('12638', 'Ojo', 'Oluwatobi', 'Eziekiel', 100, '2012/13', 'M'),
('163425', 'Nwoke', 'Chidera', 'Sumtin', 100, '2011/2012', 'F'),
('163428', 'Nwoke2', 'Chidera', 'Nwaneri', 100, '2011/2012', 'F'),
('164209', 'Ajao', 'Boluwatife', 'Belief', 100, '2011/2012', 'F'),
('164234', 'Anifowose', 'Moronke', 'Emiola', 100, '2011/2012', 'F'),
('164324', 'Elueze', 'Nedum2', 'Chukuwuka', 100, '2011/2012', 'M'),
('164443', 'Oluwaniran', 'Olorunfemi', 'Silas', 100, '2011/12', 'M'),
('164445', 'Yagboyaju', 'Sultan', 'Sumtin', 100, '2011/12', 'M'),
('164449', 'Omozopia', 'Osagie', 'Nelson', 100, '2011/2012', 'M'),
('165437', NULL, NULL, NULL, NULL, NULL, NULL),
('2345', NULL, 'kklcc', 'kklcc', 100, 'kklcc', 'm');

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE IF NOT EXISTS `logininfo` (
  `s/n` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `job_id` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`s/n`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`s/n`, `username`, `loginTime`, `job_id`) VALUES
(1, 'femi', '2013-06-03 15:40:53', NULL),
(2, 'femi', '2013-06-03 15:49:12', NULL),
(3, 'femi', '2013-06-06 14:28:36', NULL),
(4, 'femi', '2013-06-15 00:28:52', NULL),
(5, 'femi', '2013-06-15 00:30:45', NULL),
(6, 'femi', '2013-06-15 22:11:48', NULL),
(7, '', '2013-06-16 12:20:27', NULL),
(8, '', '2013-06-16 18:14:24', 'carpenter'),
(9, 'femi', '2013-06-18 01:00:51', NULL),
(10, 'femi', '2013-06-18 01:03:19', NULL),
(11, 'femi', '2013-06-18 18:35:16', NULL),
(12, 'femi', '2013-06-18 19:24:58', NULL),
(13, 'femi', '2013-06-18 23:50:06', NULL),
(14, 'femi', '2013-06-19 12:41:50', NULL),
(15, 'femi', '2013-06-19 16:34:30', NULL),
(16, 'femi', '2013-06-19 17:24:05', NULL),
(17, 'femi', '2013-06-20 16:50:04', NULL),
(18, 'femi', '2013-06-24 11:20:41', NULL),
(19, 'femi', '2013-07-09 19:01:11', NULL),
(20, 'femi', '2013-10-11 12:40:50', NULL),
(21, 'femi', '2013-12-30 20:03:12', NULL),
(22, 'femi', '2014-03-22 11:15:47', NULL),
(23, 'femi', '2014-04-05 16:32:45', NULL),
(24, 'femi', '2014-05-13 20:29:11', NULL),
(25, 'femi', '2014-05-16 05:18:02', NULL),
(26, 'femi', '2014-06-03 23:54:07', NULL),
(27, 'femi', '2014-06-24 12:56:01', NULL),
(28, 'femi', '2014-06-26 14:01:56', NULL),
(29, 'femi', '2014-06-26 14:18:39', NULL),
(30, 'femi', '2014-06-26 14:39:51', NULL),
(31, 'femi', '2014-10-23 02:25:35', NULL),
(32, 'femi', '2014-10-23 02:31:16', NULL),
(33, 'femi', '2014-10-23 02:32:24', NULL),
(34, 'femi', '2014-10-23 02:33:20', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `play`
--

CREATE TABLE IF NOT EXISTS `play` (
  `s/n` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` text NOT NULL,
  `job` text NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`s/n`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `play`
--

INSERT INTO `play` (`s/n`, `user`, `job`, `time`) VALUES
(1, 'great', 'happiness', '2013-06-16 18:30:17'),
(2, '', 'joy', '2013-06-16 18:32:16'),
(3, 'No Job', '', '2013-06-16 19:06:55'),
(4, 'inserted only', '', '2013-06-16 19:10:44'),
(5, '12638', '', '2013-06-16 19:14:19'),
(6, '163425', '', '2013-06-16 19:14:19'),
(7, '163428', '', '2013-06-16 19:14:19'),
(8, '164209', '', '2013-06-16 19:14:19'),
(9, '164234', '', '2013-06-16 19:14:19'),
(10, '164324', '', '2013-06-16 19:14:19'),
(11, '164443', '', '2013-06-16 19:14:19'),
(12, '164445', '', '2013-06-16 19:14:19'),
(13, '164449', '', '2013-06-16 19:14:19');

-- --------------------------------------------------------

--
-- Table structure for table `registrations`
--

CREATE TABLE IF NOT EXISTS `registrations` (
  `registration_id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(10) unsigned NOT NULL DEFAULT '0',
  `sid` int(10) unsigned NOT NULL DEFAULT '0',
  `registration_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`registration_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `registrations`
--

INSERT INTO `registrations` (`registration_id`, `eid`, `sid`, `registration_date`) VALUES
(1, 5, 14, '0000-00-00 00:00:00'),
(2, 5, 3, '0000-00-00 00:00:00'),
(3, 5, 4, '0000-00-00 00:00:00'),
(4, 4, 2, '0000-00-00 00:00:00'),
(5, 4, 5, '0000-00-00 00:00:00'),
(6, 4, 6, '0000-00-00 00:00:00'),
(7, 5, 2, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `scores100`
--

CREATE TABLE IF NOT EXISTS `scores100` (
  `MatricNo` int(8) NOT NULL,
  `csc101` int(2) NOT NULL,
  `csc101Unit` int(2) NOT NULL,
  `ges101` int(2) NOT NULL,
  `ges101Unit` int(2) NOT NULL,
  `ges107` int(2) NOT NULL,
  `ges107Unit` int(2) NOT NULL,
  `mat111` int(2) NOT NULL,
  `mat111Unit` int(2) NOT NULL,
  `mat121` int(2) NOT NULL,
  `mat121Unit` int(2) NOT NULL,
  `mat141` int(2) NOT NULL,
  `mat141Unit` int(2) NOT NULL,
  `phy112` int(2) NOT NULL,
  `phy112Unit` int(2) NOT NULL,
  `phy113` int(2) NOT NULL,
  `phy113Unit` int(2) NOT NULL,
  `phy114` int(2) NOT NULL,
  `phy114Unit` int(2) NOT NULL,
  `phy115` int(2) NOT NULL,
  `phy115Unit` int(2) NOT NULL,
  `phy118` int(2) NOT NULL,
  `phy118Unit` int(2) NOT NULL,
  `sta112` int(2) NOT NULL,
  `sta112Unit` int(2) NOT NULL,
  `sta121` int(2) NOT NULL,
  `sta121Unit` int(2) NOT NULL,
  PRIMARY KEY (`MatricNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scores100`
--

INSERT INTO `scores100` (`MatricNo`, `csc101`, `csc101Unit`, `ges101`, `ges101Unit`, `ges107`, `ges107Unit`, `mat111`, `mat111Unit`, `mat121`, `mat121Unit`, `mat141`, `mat141Unit`, `phy112`, `phy112Unit`, `phy113`, `phy113Unit`, `phy114`, `phy114Unit`, `phy115`, `phy115Unit`, `phy118`, `phy118Unit`, `sta112`, `sta112Unit`, `sta121`, `sta121Unit`) VALUES
(12344, 34, 0, 0, 58, 87, 45, 78, 0, 86, 76, 42, 79, 0, 89, 23, 56, 56, 67, 89, 26, 55, 83, 17, 0, 46, 45),
(163428, 45, 4, 12, 3, 23, 2, 34, 4, 23, 4, 67, 4, 88, 3, 23, 3, 78, 3, 78, 3, 89, 3, 45, 1, 78, 4),
(164209, 78, 0, 80, 0, 80, 0, 68, 0, 79, 0, 97, 0, 57, 0, 78, 0, 79, 0, 69, 0, 89, 0, 80, 0, 89, 0),
(164234, 68, 5, 80, 4, 80, 2, 68, 1, 59, 2, 37, 4, 57, 6, 78, 4, 79, 3, 39, 3, 89, 4, 60, 7, 89, 5),
(164324, 68, 5, 80, 4, 80, 2, 68, 1, 59, 2, 37, 4, 57, 6, 78, 4, 79, 3, 39, 3, 89, 4, 60, 7, 89, 5);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `sid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL DEFAULT '',
  `lastname` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`sid`, `firstname`, `lastname`) VALUES
(1, 'Jack', 'Malone'),
(2, 'Hiro', 'Nakamura'),
(3, 'Bree', 'VandeKamp'),
(4, 'Susan', 'Mayer'),
(5, 'Matt', 'Parkman'),
(6, 'Claire', 'Bennet');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE IF NOT EXISTS `student_info` (
  `MatricNo` varchar(8) NOT NULL,
  `surname` longtext,
  `firstname` longtext NOT NULL,
  `Othername` longtext NOT NULL,
  `level` int(5) NOT NULL,
  `yearOfEntry` varchar(12) NOT NULL,
  `sex` text NOT NULL,
  PRIMARY KEY (`MatricNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`MatricNo`, `surname`, `firstname`, `Othername`, `level`, `yearOfEntry`, `sex`) VALUES
('12638', 'Ojo', 'Oluwatobi', 'Eziekiel', 100, '2012/13', 'M'),
('156723', 'Afolabi', 'Ife', 'Ifedayo', 100, '2011/2012', 'F'),
('163425', 'Nwoke', 'Chidera', 'Sumtin', 100, '2011/2012', 'F'),
('163428', 'Nwoke2', 'Chidera', 'Nwaneri', 100, '2011/2012', 'F'),
('164209', 'Ajao', 'Boluwatife', 'Belief', 100, '2011/2012', 'F'),
('164234', 'Anifowose', 'funto', 'Emiola', 100, '2011/2012', 'F'),
('164324', 'Elueze', 'Nedum2', 'Chukuwuka', 100, '2011/2012', 'M'),
('164443', 'Oluwaniran', 'Olorunfemi', 'Silas', 100, '2011/12', 'M'),
('164445', 'Yagboyaju', 'Sultan', 'Sumtin', 100, '2011/12', 'M'),
('164449', 'Omozopia', 'Osagie', 'Nelson', 100, '2011/2012', 'M'),
('2345', NULL, 'kklcc', 'kklcc', 100, 'kklcc', 'm');

-- --------------------------------------------------------

--
-- Table structure for table `weekly_payroll`
--

CREATE TABLE IF NOT EXISTS `weekly_payroll` (
  `employee_id` varchar(10) NOT NULL,
  `total_hours` int(11) DEFAULT NULL,
  `hourly_rate` bigint(20) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
