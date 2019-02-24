CREATE DATABASE IF NOT EXISTS `project2_team27`;

USE `project2_team27`;

CREATE TABLE `quiz`
  (
     `quiz_id`           INT NOT NULL auto_increment,
     `title`             VARCHAR(255),
     `instructions`      TEXT,
     `assignment_group`  VARCHAR(255),
     `isshuffled`        BOOLEAN,
     `isgraded`          BOOLEAN,
     `time_limit`        INT,
     `ismultipleattempt` BOOLEAN,
     PRIMARY KEY (quiz_id)
  );

CREATE TABLE `questions`
  (
     `question_id`      INT NOT NULL auto_increment,
     `quiz_id`          INT NOT NULL,
     `question`         TEXT,
     `option1`          VARCHAR(1024),
     `isoption1correct` BOOLEAN,
     `option2`          VARCHAR(1024),
     `isoption2correct` BOOLEAN,
     `option3`          VARCHAR(1024),
     `isoption3correct` BOOLEAN,
     `option4`          VARCHAR(1024),
     `isoption4correct` BOOLEAN,
     `ismultipleanswer` BOOLEAN,
     `points`           INT,
     PRIMARY KEY (question_id),
     FOREIGN KEY (quiz_id) REFERENCES `quiz`(quiz_id) ON DELETE CASCADE
  );
  
  CREATE TABLE 	`Student`
(
	`student_id`	INT(10) PRIMARY KEY,
	`first_name`	VARCHAR(20),
	`last_name`	VARCHAR(20),
	`email_id`	VARCHAR(30)
);

CREATE TABLE 	`Quiz_Attempt`
(

	FOREIGN KEY 	fk_quiz_id(quiz_id)
	REFERENCES 	`Quiz`(quiz_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,

	FOREIGN KEY 	fk_student_id(student_id)
	REFERENCES 	`Student`(student_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,

	FOREIGN KEY 	fk_question_id(question_id)
	REFERENCES 	`Questions`(question_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,

	response VARCHAR(10)
);
  
