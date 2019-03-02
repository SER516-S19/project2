# SER-516_Project2_Quiz
----------------------------
SER 516- Project2 
Team_69

I) Points to note : 
---------------------
Build.properties contains information related to the application: Application Name, Tomcat path.

1. Inside Build.properties replace Tomcat.home with your Tomcat Home Directory Path

2. Run build.xml file with deploy command using ANT build

3. This will deploy the application under the webapps folder of your tomcat directory.

4. To run the database go to the file
\src\main\java\bean\HibernateUtil.java and update the following as per you credentials.
	a. Environment.USER
	b. Environment.PASS
	c. Environment.URL
	
5. Add Users in the User table by using the below queries in mysql:
	insert into User values(1,"12345","abc.com","ABC","student");
	insert into User values(2,"67890","xyz.com","XYZ","professor");
	insert into User values(3,"33333","def.com","DEF","student");
	
6. Run tomcat and start the application deployed in step 3. The application name would be project2. 

NOTE: The URL to hit the application will be something like (http://localhost:8080//Team_69) but it depends on your port number.
	
------------------------	
II) Steps to execute
----------------------
1. Run the application as mentioned in the (I.3).

2. Go to the professor page and create the Quiz. Use the Professor's credentials to login. 
    name: xyz.com
    pass : 67890
    
3. Come back to the Login page using http://localhost:8080//Team_69 .

4. Go to student page to view and take the Quiz. Use the Student's credentials to login. 
    name: abc.com
    pass : 12345
