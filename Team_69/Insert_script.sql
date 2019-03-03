<<<<<<< HEAD
<<<<<<< HEAD

insert into quiz values(1,1,0,"You are not allowed to take this quiz again!!", "Midterm1",'00:00:30','graded');
insert into quiz values(2,1,0,"You are not allowed to take this quiz again!!", "Midterm2",'00:00:30','graded');
 
insert into question values(1,1,10,"Who is the President of the United States?", 1);
insert into question values(2,1,10,"How many colors are there in the rainbow?", 1);
insert into question values(3,1,10,"How many continents are there?", 1);
 
insert into answer values(1,"Donald Trump",1,1);
insert into answer values(2,"Barack Obama",1,1);
insert into answer values(3,"Modi",1,1);
insert into answer values(4,"Beyonce",1,1);
=======
=======
use quizdb;

>>>>>>> 4bbeaf52dad6342568e8e58db64e23cffdec974c
insert into quiz values(1,1,0,"You are not allowed to take this quiz again!!", "Midterm1",'00:00:30','graded');
insert into quiz values(2,1,0,"You are not allowed to take this quiz again!!", "Midterm2",'00:00:30','graded');
insert into quiz values(3,0,1,"You are not allowed to take this quiz again!!", "Midterm3",'00:00:30','graded');
 
insert into question values(1,1,10,"Who is the President of the United States?", 1);
insert into question values(2,0,10,"How many colors are there in the rainbow?", 1);
insert into question values(3,1,10,"How many continents are there?", 1);

insert into answer values(1,"Donald Trump",1,1);
insert into answer values(2,"Barack Obama",1,1);
insert into answer values(3,"Modi",0,1);
insert into answer values(4,"Beyonce",0,1);
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
insert into answer values(5,"4",0,2);
insert into answer values(6,"7",1,2);
insert into answer values(7,"5",0,2);
insert into answer values(8,"0",0,2);
<<<<<<< HEAD
insert into answer values(9,"0",0,3);
insert into answer values(10,"7",1,3);
insert into answer values(11,"17",0,3);
=======
insert into answer values(9,"Seven",1,3);
insert into answer values(10,"7",1,3);
insert into answer values(11,"17",0,3);
insert into answer values(12,"1",0,3);


insert into User values(1,"12345","abc.com","ABC","student");
insert into User values(2,"67890","xyz.com","XYZ","professor");
insert into User values(3,"33333","def.com","DEF","student");

INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('1', '1', '1', '1', '1');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('2', '3', '1', '1', '1');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('3', '6', '2', '1', '1');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('4', '10', '3', '1', '1');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('5', '11', '3', '1', '1');


INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('6', '1', '1', '1', '3');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('7', '3', '1', '1', '3');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('8', '6', '2', '1', '3');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('9', '10', '3', '1', '3');
INSERT INTO `response_stats` (`Response_id`, `Answer_id`, `Question_id`, `Quiz_Id`, `user_id`) 
VALUES ('10', '9', '3', '1', '3');


INSERT INTO `calculatedscores` (`id`, `scores`, `quiz_id`, `user_id`) VALUES ('1', '25', '1', '1');
INSERT INTO `calculatedscores` (`id`, `scores`, `quiz_id`, `user_id`) VALUES ('2', '30', '1', '3');
<<<<<<< HEAD
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> 4bbeaf52dad6342568e8e58db64e23cffdec974c
