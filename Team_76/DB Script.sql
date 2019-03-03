CREATE DATABASE ser516p2;

SHOW DATABASES;

USE ser516p2;

CREATE TABLE answer_table
(studentID INTEGER PRIMARY KEY,
quizID INTEGER,
questionID INTEGER,
answerGiven TEXT,
marks INTEGER
);



insert into answer_table(
studentID,
quizID,
questionID,
answerGiven,
marks) 
VALUES 
(1,1,1,'ans',20);




USE ser516p2;
CREATE TABLE quiz (
 ProfId INT NOT NULL ,
 QuizId INT NOT NULL,
 status VARCHAR(25) NOT NULL,
 DueDate date NOT NULL,
 Timelimit INT NOT NULL,
 QuizType VARCHAR(30),
<<<<<<< HEAD
 quiztitle VARCHAR(30) NOT NULL,
 qinstruct VARCHAR(1000) NOT NULL,
 qtype VARCHAR(20) NOT NULL,
=======
>>>>>>> Team_58
 PRIMARY KEY (ProfId, QuizId)
 ); 
 

  
  INSERT INTO quiz(
  ProfId,
QuizId,
status,
DueDate,
Timelimit,
QuizType)
values
<<<<<<< HEAD
(1,1,'EXPIRE','2020-01-11',20,'DeepScale','title','instructions','multiple');
=======
(1,1,'EXPIRE','2020-01-11',20,'DeepScale');
>>>>>>> Team_58


 
  
  USE ser516p2;
CREATE TABLE Question (
 QuizId INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 QuestionId INT NOT NULL,
 Questions VARCHAR(255) NOT NULL,
 Options VARCHAR(255) NOT NULL,
 CORRECT_ANSWER VARCHAR(1)
 );
 
 INSERT INTO 
 Question(
 QuizId,
QuestionId,
Questions,
Options,
CORRECT_ANSWER)
VALUES(
1,1,'How are you ?','option 1: good$$@ option 2: Not good','1');
 

 

 
 

 
 
 CREATE TABLE user (
 id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 username varchar(30) NOT NULL,
 password varchar(30) NOT NULL,
 name varchar(30) NOT NULL,
 usertype varchar(30) NOT NULL);
 

 
 INSERT INTO USER(
 id,
username,
password,
name,
usertype)
VALUES
(1,'prof','123','John','Professor');
 


 
 CREATE TABLE grade(
 studentID INT NOT NULL,
 QuizId INT NOT NULL,
<<<<<<< HEAD
 quiztitle VARCHAR(30) NOT NULL,
 studentName varchar(30) NOT NULL,
=======
>>>>>>> Team_58
 grade VARCHAR(3));
 

 
 insert into grade(
 studentID,
QuizId,
<<<<<<< HEAD
quiztitle,
studentName,
grade)
 values
 (1,1,'title','John','A');
=======
grade)
 values
 (1,1,'A');
 

 

 
>>>>>>> Team_58
