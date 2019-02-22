CREATE DATABASE IF NOT EXISTS `project2`;

USE `project2`;

CREATE TABLE 	`Student`(
`student_id`	INT(10) PRIMARY KEY,
`first_name`	VARCHAR(20),
`last_name`		VARCHAR(20),
`email_id`		VARCHAR(30));

CREATE TABLE 	`Quiz_Attempt`(

FOREIGN KEY 	fk_quiz_id(quiz_id)
REFERENCES 		`Quiz`(quiz_id)
ON UPDATE CASCADE
ON DELETE RESTRICT,

FOREIGN KEY 	fk_student_id(student_id)
REFERENCES 		`Student`(student_id)
ON UPDATE CASCADE
ON DELETE RESTRICT,

FOREIGN KEY 	fk_question_id(question_id)
REFERENCES 		`Questions`(question_id)
ON UPDATE CASCADE
ON DELETE RESTRICT,

response VARCHAR(10));