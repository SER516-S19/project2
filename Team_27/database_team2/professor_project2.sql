CREATE DATABASE IF NOT EXISTS `project2_team27`;

USE `project2_team27`;

CREATE TABLE `Quiz`
(
	`quiz_id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255),
	`instructions` TEXT,
	`assignment_group` VARCHAR(255),
	`isShuffled` BOOLEAN,
	`isGraded` BOOLEAN,
	`time_limit` INT,
	`isMultipleAttempt` BOOLEAN,
    PRIMARY KEY (quiz_id)
);

CREATE TABLE `Questions`
(
	`question_id` INT NOT NULL AUTO_INCREMENT,
    `quiz_id` INT NOT NULL,
	`question` TEXT,
	`option1` VARCHAR(1024),
	`isOption1Correct` BOOLEAN,
	`option2` varchar(1024),
	`isOption2Correct` BOOLEAN,
	`option3` VARCHAR(1024),
	`isOption3Correct` boolean,
	`option4` VARCHAR(1024),
	`isOption4Correct` BOOLEAN,
	`isMultipleAnswer` BOOLEAN,
    `points` INT,
 	PRIMARY KEY (question_id),
    FOREIGN KEY (quiz_id) REFERENCES `Quiz`(quiz_id) ON DELETE CASCADE
);
