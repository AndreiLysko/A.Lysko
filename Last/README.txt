-----THIS IS A README FILE TO CREATE TEST MODULE DATABASE-----

CREATE DATABASE  IF NOT EXISTS `testmodule_db`
USE `testmodule_db`;

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id_subject` int(11) NOT NULL,
  `name_subject` varchar(100) NOT NULL,
  `question_text` varchar(1000) NOT NULL,
  `answer_number` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `question_text_UNIQUE` (`question_text`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) 


--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `subject_id_UNIQUE` (`subject_id`),
  UNIQUE KEY `subject_name_UNIQUE` (`subject_name`)
) 


--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `privileges` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`login`)
) 


--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `id_owner` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(100) NOT NULL,
  `test_date` varchar(45) NOT NULL,
  `points` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)
