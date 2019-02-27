# SER-516_Project2_Quiz
SER 516- Project2 
Team_69

Build.properties contains information related to the application: Application Name, Tomcat path.

1. Inside Build.properties replace Tomcat.home with your Tomcat Home Directory Path

2. Run build.xml file with deploy command using ANT build

3. This will deploy the application under the webapps folder of your tomcat directory. Run tomcat and start the application.

4. To run the database go to the file
\src\main\java\bean\HibernateUtil.java and update the following as per you credentials.
	a. Environment.USER
	b. Environment.PASS
	c. Environment.URL
	
5. Steps to execute
1. Go to the professor page and create the Quiz.
2. Go to student page to view and take the Quiz.
