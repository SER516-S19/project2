Team-27 project2
Web application with Java Servlets

Team is a s follows:

Bharat Goel (Product Owner)

Team 1: Sumanth Paranjape (Scrum Master) Sajith Manisha Miriyala Shashidhar Reddy Srivan Surya Narendra Mohan

Team 2: Palak Chugh(Scrum Master) Bharat Goel Sarthak Tiwari Yuti Desai Bijayalaxmi Panda Lakshmi Kala Shefali Anand

START TOMCAT SERVER

Run Cmd as Administrator.
Change directory to the bin folder of Tomcat.
Start the Tomcat Server by using “startup.bat”
Open the server from the browser using the link : http://localhost:8080/
Go to Manager App and click on /Quiz Path. If prompted for username and password, add tomcat for username and password.
PROJECT SETUP

Open the project folder in Eclipse.
update 'tomcat.home' property in build.properties to your local tomcat folder path
Change the location of Tomcat in build.properties file.
Change the username and password of MYSQL Database in rdbm.properties file.
Also change the username and password of MYSQL in rdbm.properties file.
Necessary jar files have been added in the lib folder of the project
For building the project, add Quiz.war file in the wepapps folder of Tomcat.
As an alternative, you can build the project by following the below instructions: •	Right click on build.xml •	Click on Run-as?External Tools Configuration?Targets •	Add init, clean, compile, build ,dist, deploy in the order. •	Click on Run
DATABASE SETUP If you are using MacOS, do the following:

Install mysql shell;
From terminal, cd to /usr/local/bin
Then, run the following command to create required databases and tables:
./mysql --host=localhost --user= --password= < 4.	Replace username and password with your Mysql password 5.	For Windows OS, you can use the dump file present in the sql folder of the project.