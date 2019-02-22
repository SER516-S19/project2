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

DESCRIBE answer_table;
