INSERT INTO Professors (firstname, lastname, username, hashedpass)
VALUES ("Dolores", "Umbridge", "xXKitten_OwnerXx", "qo843hb5r8q4");

INSERT INTO Courses (professor_fk, prefix, suffix)
VALUES ("xXKitten_OwnerXx", "DDA", "123");

INSERT INTO Quizzes (title, course_fk, instructions, shuffle,
	time_limit, date_open, date_close, quiz_type, attempts, quiz_group, total_points)
VALUES ("Minute Quiz", 1, "This is a straightforward quiz. You have 1 minute.",
	1, 60, "2018-12-25 00:00:00.000", "2020-04-08 00:00:00.000", "quiz",
	3, "Cool Questions", 340.5);
INSERT INTO Quizzes (title, course_fk, instructions, shuffle,
	time_limit, date_open, date_close, quiz_type, attempts, quiz_group, total_points)
VALUES	("Nasty Quiz", 1,
	"This quiz will test how the system responds to 0s in certain areas", 0,
	0, "2018-12-25 00:00:00.000", "2020-04-08 00:00:00.000", "quiz", 0, "null", 90);
INSERT INTO Quizzes (title, course_fk, instructions, shuffle,
	time_limit, date_open, date_close, quiz_type, attempts, quiz_group, total_points)
VALUES	("Surveillance Survey", 1,
	"This isn't for a grade, yet there are points.",
	1, 0, "2018-12-25 00:00:00.000", "2020-04-08 00:00:00.000", "survey", 2, "likeability", 29);
INSERT INTO Quizzes (title, course_fk, instructions, shuffle,
	time_limit, date_open, date_close, quiz_type, attempts, quiz_group, total_points)
VALUES	("Late Quiz", 1, "Dude, this was due a while ago.",
	1, 90000, "1995-12-25 00:00:00.000", "2012-10-31 00:00:00.000", "quiz", 5, "Being totally radical",
	9000000.9);


INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES (1, "mc", 20.5, "1. What species has the greatest knees?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(1, "ma", 280, "2. Which of the following are cool places?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(1, "mc", 20, "3. I am feeling ok today.");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(1, "mc", 20, "4. This question exists to test shuffle functionality.");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(2, "mc", 0, "1. You are special.");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(2, "ma", 1, "2. Which of the following are beverages?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(2, "mc", 1, "3. Why are there 2 correct answers to this question?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(2, "mc", 1, "4. Why are there not enough points per question?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(3, "ma", 1, "How are you feeling?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(3, "mc", 1, "Would you like a glass of milk?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(3, "mc", 1, "Hang on, there's only one answer here?");
INSERT INTO Questions (quiz_fk, quesType, points, content)
VALUES 	(4, "mc", 9000000.9, "Who authored this file?");

INSERT INTO Choices (question_fk, content, correct)
VALUES	(1, "Bears", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(1, "Bees", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(1, "Alpacas", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(1, "Spiders", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(2, "Antarctica", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(2, "The Sonoran Desert", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(2, "Greenland", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(2, "Finland", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(2, "Venus", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(3, "True", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(3, "False", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(4, "True", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(4, "False", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(5, "True", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(5, "False", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(6, "Wine", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(6, "A Ceramic Tile", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(6, "Water", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(6, "A 5-star review of a cornfield on Yelp", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(7, "Beats me.", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(7, "It needs to be tested.", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(7, "It is necessary to test this.", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(8, "I want to know what happens", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(9, "Happy", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(9, "Sad", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(9, "Angry", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(10, "Yes", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(10, "Double Yes", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(10, "Actually, I brought my own milk.", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(10, "No, I want an entire gallon.", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(11, "yep, looks like it.", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(12, "David Lahtinen", 1);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(12, "King Louis XIV", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(12, "some loser lol", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(12, "A swarm of bees", 0);
INSERT INTO Choices (question_fk, content, correct)
VALUES 	(12, "3 midgets in a trench coat", 0);

INSERT INTO Students (username, firstname, lastname, hashedpass)
VALUES ("boywholived", "Harry", "Potter", "214988dgsadg79");

INSERT INTO Enrolled (course_fk, student_fk)
VALUES (1, "boywholived");