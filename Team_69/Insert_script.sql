use quizdb;

insert into quiz values(1,1,0,"You are not allowed to take this quiz again!!", "Midterm1",'00:00:30','graded');
insert into quiz values(2,1,0,"You are not allowed to take this quiz again!!", "Midterm2",'00:00:30','graded');
insert into quiz values(3,0,1,"You are not allowed to take this quiz again!!", "Midterm3",'00:00:30','graded');
 
insert into question values(1,1,10,"Who is the President of the United States?", 1);
insert into question values(2,0,10,"How many colors are there in the rainbow?", 1);
insert into question values(3,1,10,"How many continents are there?", 1);
insert into question values(4,1,10,"Who is the President of the United States?", 2);
insert into question values(5,0,10,"How many colors are there in the rainbow?", 2);
insert into question values(6,1,10,"How many continents are there?", 2);
insert into question values(7,1,10,"Who is the President of the United States?", 3);
insert into question values(8,0,10,"How many colors are there in the rainbow?", 3);
insert into question values(9,1,10,"How many continents are there?", 3);

insert into answer values(1,"Donald Trump",1,1);
insert into answer values(2,"Barack Obama",1,1);
insert into answer values(3,"Modi",0,1);
insert into answer values(4,"Beyonce",0,1);
insert into answer values(5,"4",0,2);
insert into answer values(6,"7",1,2);
insert into answer values(7,"5",0,2);
insert into answer values(8,"0",0,2);
insert into answer values(9,"Seven",1,3);
insert into answer values(10,"7",1,3);
insert into answer values(11,"17",0,3);
insert into answer values(12,"1",0,3);
insert into answer values(13,"Donald Trump",1,4);
insert into answer values(14,"Barack Obama",1,4);
insert into answer values(15,"Modi",0,4);
insert into answer values(16,"Beyonce",0,4);
insert into answer values(17,"4",0,5);
insert into answer values(18,"7",1,5);
insert into answer values(19,"5",0,5);
insert into answer values(20,"0",0,5);
insert into answer values(21,"Seven",1,6);
insert into answer values(22,"7",1,6);
insert into answer values(23,"17",0,6);
insert into answer values(24,"1",0,6);
insert into answer values(25,"Donald Trump",1,7);
insert into answer values(26,"Barack Obama",1,7);
insert into answer values(27,"Modi",0,7);
insert into answer values(28,"Beyonce",0,7);
insert into answer values(29,"4",0,8);
insert into answer values(30,"7",1,8);
insert into answer values(31,"5",0,8);
insert into answer values(32,"0",0,8);
insert into answer values(33,"Seven",1,9);
insert into answer values(34,"7",1,9);
insert into answer values(35,"17",0,9);
insert into answer values(36,"1",0,9);


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
