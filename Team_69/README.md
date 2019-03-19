# SER-516_Project2_Quiz
----------------------------
SER 516- Project2 
Team_69

I) Points to note : 
---------------------
Build.properties contains information related to the application: Application Name, Tomcat path.

1. Inside Build.properties replace Tomcat.home with your Tomcat Home Directory Path

2. To configure the database go to the file
\src\main\java\bean\HibernateUtil.java and update the following as per you credentials.
	a. Environment.USER - SQL Username
	b. Environment.PASS - SQL Password
	c. Environment.URL - jdbc:mysql://localhost:3306/<name of the database>
	
3. Run build.xml file with deploy command using ANT build
   3.1 Open command line 
   3.2 Go to the folder where you have cloned the project
   3.3 Go to Team_69
   3.4 Run the command "ant deploy"

4. This will deploy the application under the webapps folder of your tomcat directory.

5. Run the DB_creation.sql script, to create the database schema

6. Run the Insert_script.sql script, to insert the values in the database
	
7. Run tomcat and start the application deployed in step 3. The application name would be project2. 

NOTE: The URL to hit the application will be something like (http://localhost:8080/project2) but it depends on your port number.
	
------------------------	
II) Steps to execute
----------------------
1. Run the application as mentioned in the (I.3).

2. Go to the professor page and create the Quiz. Use the Professor's credentials to login. 
    name: xyz.com
    pass : 67890
    
3. Come back to the Login page using http://localhost:8080/project2 .

4. Go to student page to view and take the Quiz. Use the Student's credentials to login.. 
    name: abc.com
    pass : 12345
