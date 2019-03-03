<<<<<<< HEAD
﻿Team-27 project2
Web application with Java Servlets

Team is as follows:
=======
Team-27 project2
Web application with Java Servlets

Team is a s follows:
>>>>>>> Team_58

Bharat Goel (Product Owner)

Team 1: Sumanth Paranjape (Scrum Master) Sajith Manisha Miriyala Shashidhar Reddy Srivan Surya Narendra Mohan

Team 2: Palak Chugh(Scrum Master) Bharat Goel Sarthak Tiwari Yuti Desai Bijayalaxmi Panda Lakshmi Kala Shefali Anand

<<<<<<< HEAD
DEPLOY PROJECT

1. Copy Quiz.war folder in wepapps folder in your Tomcat
2. Run Cmd as Administrator.
2. Change directory to the bin folder of Tomcat.
3. Start the Tomcat Server by using “startup.bat”
4. Open the server from the browser using the link : http://localhost:8080/Quiz.
5. If prompted for username and password, add tomcat for username and password.


INFO: MySQL Database is setup on ClearDB, a remote Heroku server.
=======
START TOMCAT SERVER

1. Run Cmd as Administrator.
2. Change directory to the bin folder of Tomcat.
3. Start the Tomcat Server by using “startup.bat”
4. Open the server from the browser using the link : http://localhost:8080/
5. Go to Manager App and click on /Quiz Path. If prompted for username and password, add tomcat for username and password.

PROJECT SETUP

1. Open the project folder in Eclipse.
2. update 'tomcat.home' property in build.properties to your local tomcat folder path
3. Change the location of Tomcat in build.properties file.
4. Change the username and password of MYSQL Database in rdbm.properties file.
5. Also change the username and password of MYSQL in rdbm.properties file.
6. Necessary jar files have been added in the lib folder of the project
7. For building the project, add Quiz.war file in the wepapps folder of Tomcat.
8. As an alternative, you can build the project by following the below instructions: •	Right click on build.xml •	9. 
Click on Run-as?External Tools Configuration?Targets •	Add init, clean, compile, build ,dist, deploy in the order. •	Click on Run

DATABASE SETUP If you are using MacOS, do the following:

1. Install mysql shell;
2. From terminal, cd to /usr/local/bin
3. Then, run the following command to create required databases and tables:

./mysql --host=localhost --user= --password= < 4.	Replace username and password with your Mysql password 5.For Windows OS, you can use the dump file present in the sql folder of the project.
>>>>>>> Team_58
