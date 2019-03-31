CREATE DATABASE ser516p2v2;

SHOW DATABASES;

USE ser516p2v2;

 CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';
 
 GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';

CREATE TABLE answer_table
(studentID INTEGER,
quizID INTEGER,
questionID INTEGER,
answerGiven TEXT,
marks INTEGER,
PRIMARY KEY (studentID, questionID)
);


CREATE TABLE quiz (
 ProfId INT NOT NULL ,
 QuizId INT NOT NULL,
 status VARCHAR(25) NOT NULL,
 DueDate date NOT NULL,
 Timelimit INT NOT NULL,
 QuizTitle VARCHAR(30) NOT NULL,
 Qinstruct VARCHAR(1000) NOT NULL,
 QuizType VARCHAR(30) NOT NULL,
 OptionSelected VARCHAR(10) NOT NULL,
 PRIMARY KEY (ProfId, QuizId)
 );
 
   INSERT INTO quiz(
  ProfId,
  QuizId,
  Status,
  DueDate,
  Timelimit,
  QuizTitle,Qinstruct,QuizType,OptionSelected)
  values
(1,1,'Active','2020-01-11',2,'Demo','Please attempt the quiz by choosing the correct answer.','multiple','Yes');

 CREATE TABLE Question (
 QuizId INT NOT NULL ,
 QuestionId INT NOT NULL PRIMARY KEY,
 Questions VARCHAR(255) NOT NULL,
 Options VARCHAR(255) NOT NULL,
 CORRECT_ANSWER VARCHAR(255) NOT NULL,
 marks INT NOT NULL
 );
 
 INSERT INTO 
 Question(
 QuizId,
QuestionId,
Questions,
Options,
CORRECT_ANSWER,
marks)
VALUES(
1,101,'How are you?','Good$$@Not good$$@Can not Say$$@None of the above','Good',10);

INSERT INTO 
 Question(
 QuizId,
QuestionId,
Questions,
Options,
CORRECT_ANSWER,
marks)
VALUES(
1,102,'Are you Student?','Yes$$@No$$@Do Not Know$$@None of the above','Yes',10);

INSERT INTO 
 Question(
 QuizId,
QuestionId,
Questions,
Options,
CORRECT_ANSWER,
marks)
VALUES(
1,103,'Are you Asurite?','Yes$$@No$$@Do Not Know$$@None of the above','Yes',10);

INSERT INTO 
 Question(
 QuizId,
QuestionId,
Questions,
Options,
CORRECT_ANSWER,
marks)
VALUES(
1,104,'Are you in Ser516 class?','Yes$$@No$$@Do Not Know$$@None of the above','Yes',10);

  CREATE TABLE user (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 username varchar(30) NOT NULL,
 password varchar(30) NOT NULL,
 name varchar(30) NOT NULL,
 usertype varchar(30) NOT NULL);
 
  INSERT INTO USER(
username,
password,
name,
usertype)
VALUES
('prof','123','John','Professor');

 INSERT INTO USER(
username,
password,
name,
usertype)
VALUES
('student1','123','Mani','Student');

 INSERT INTO USER(
username,
password,
name,
usertype)
VALUES
('student2','123','Jenny','Student');

 INSERT INTO USER(
username,
password,
name,
usertype)
VALUES
('student3','123','Nikki','Student');

 INSERT INTO USER(
username,
password,
name,
usertype)
VALUES
('student4','123','Jack','Student');
 
  CREATE TABLE grade(
 studentID INT NOT NULL,
 QuizId INT NOT NULL,
 quiztitle VARCHAR(30) NOT NULL,
 studentName varchar(30) NOT NULL,
 grade INT NOT NULL,
 PRIMARY KEY (studentID, QuizId)
 );
 
  insert INTo grade(
 studentID,
QuizId,
quiztitle,
studentName,
grade)
 values
 (2,1,'Demo','Mani', 40);
 
  insert INTo grade(
 studentID,
QuizId,
quiztitle,
studentName,
grade)
 values
 (3,1,'Demo','Jenny','30');
 
  insert INTo grade(
 studentID,
QuizId,
quiztitle,
studentName,
grade)
 values
 (4,1,'Demo','Nikki',20);
 
  insert INTo grade(
 studentID,
QuizId,
quiztitle,
studentName,
grade)
 values
 (5,1,'Demo','Jack',10);
 