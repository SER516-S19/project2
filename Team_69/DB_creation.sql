<<<<<<< HEAD
create DATABASE quizdb;

use quizdb;
=======
<<<<<<< HEAD
create database quizdb;

use quizdb;

<<<<<<< HEAD
=======
create DATABASE quizdb;

use quizdb;
=======
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

>>>>>>> Team_58
>>>>>>> origin/master
--
-- Database: `quizdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `Answer_id` int(11) NOT NULL,
  `Answer` varchar(255) DEFAULT NULL,
  `Correct_Answer` bit(1) DEFAULT NULL,
  `Question_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
-- Table structure for table `calculatedscores`
--

CREATE TABLE `calculatedscores` (
  `id` int(11) NOT NULL,
  `scores` float DEFAULT NULL,
  `quiz_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
<<<<<<< HEAD
=======
=======
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
>>>>>>> Team_58
>>>>>>> origin/master
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `Question_id` int(11) NOT NULL,
  `Is_Multiple` bit(1) DEFAULT NULL,
  `Points` int(11) DEFAULT NULL,
  `Question` varchar(255) DEFAULT NULL,
  `Quiz_Id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `Quiz_Id` int(11) NOT NULL,
  `Is_Published` bit(1) DEFAULT NULL,
  `Is_Shuffled` bit(1) DEFAULT NULL,
  `Instructions` varchar(255) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Time_Limit` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> Team_58
>>>>>>> origin/master
-- --------------------------------------------------------

--
-- Table structure for table `response_stats`
--

CREATE TABLE `response_stats` (
  `Response_id` int(11) NOT NULL,
  `Answer_id` int(11) DEFAULT NULL,
  `Question_id` int(11) DEFAULT NULL,
  `Quiz_Id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
<<<<<<< HEAD
  `password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
=======
<<<<<<< HEAD
  `password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
=======
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
>>>>>>> Team_58
>>>>>>> origin/master
  `user_name` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> Team_58
>>>>>>> origin/master
--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`Answer_id`),
  ADD KEY `FK4gqkoeudft33t02p6hese58kd` (`Question_id`);

--
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
-- Indexes for table `calculatedscores`
--
ALTER TABLE `calculatedscores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKambcuh0dk2rtmg1vrfa70o9kq` (`quiz_id`),
  ADD KEY `FK2buby660ff44i5x4hi03vs7kn` (`user_id`);

--
<<<<<<< HEAD
=======
=======
>>>>>>> Team_58
>>>>>>> origin/master
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`Question_id`),
  ADD KEY `FK7ti9u1nx100stei50vc1hc5jc` (`Quiz_Id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`Quiz_Id`);

--
-- Indexes for table `response_stats`
--
ALTER TABLE `response_stats`
  ADD PRIMARY KEY (`Response_id`),
  ADD KEY `FKmhlwdcayxv613wn7jh84xitfq` (`Answer_id`),
  ADD KEY `FKa45hs40bhjvh01rwqrsflnyyi` (`Question_id`),
  ADD KEY `FK6ytng8um8dhhve2ggv6vovys7` (`Quiz_Id`),
  ADD KEY `FKhh7jm3kx51crcofuhfcf92hcg` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `Answer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `calculatedscores`
--
ALTER TABLE `calculatedscores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `Question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `Quiz_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `response_stats`
--
ALTER TABLE `response_stats`
  MODIFY `Response_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> Team_58
>>>>>>> origin/master
