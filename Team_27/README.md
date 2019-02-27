Team-27 project2
Web application with Java Servlets

Team is as follows:

Bharat Goel (Product Owner)

Team 1: Sumanth Paranjape (Scrum Master) Sajith Manisha Miriyala Shashidhar Reddy Srivan Surya Narendra Mohan

Team 2: Palak Chugh(Scrum Master) Bharat Goel Sarthak Tiwari Yuti Desai Bijayalaxmi Panda Lakshmi Kala Shefali Anand

START TOMCAT SERVER

1. Run Cmd as Administrator.
2. Change directory to the bin folder of Tomcat.
3. Start the Tomcat Server by using “startup.bat”
4. Open the server from the browser using the link : http://localhost:8080/
5. Go to Manager App and click on /Quiz Path. If prompted for username and password, add tomcat for username and password.

PROJECT SETUP

1. Open the project folder in Eclipse.
2. Set 'tomcat.home' property in build.properties file of the project to your local tomcat folder path. For eg.
-> 'tomcat.home = C:/Program Files/Apache Software Foundation/Tomcat 7.0'
3. Necessary jar files have been added in the lib folder of the project
4. For building the project, copy Quiz.war file inside the wepapps folder of Tomcat.
5. As an alternative, you can build the project by following the below instructions on Eclipse: •	Right click on build.xml •	Click on Run-as?External Tools Configuration?Targets •	Add init, clean, compile, build ,dist, deploy in the order. •	Click on Run
6. Open browser and go to 'http://localhost:8080/Quiz/'

INFO: MySQL Database is setup on ClearDB, a remote Heroku server. 
