# Team 47's quiz creator application.

## Structure
`/src/main/java`: Java Source Code directory  
`./WebContent/`: Web Assets. HTML,jsp code.  
`./WebContent/CSS`: CSS files

## Members

Front End:
 - Meng-Ze Chen
 - Yu-Ting Tsao
 - Jiayan Wang
 - Krishna Chandu Akula
 - Sairam Eadala
 - Bhavana Vakkalagadda
 - Suraj Atmakuri

Back End:
 - John Alden
 - Trevor Forrey
 - Paul Horton
 - David Lahtinen
 - Cecilia La Place
 - Amit Pandey
 - Qianru "Ruby" Zhao

## Instructions

Scripts are provided to build and run the rpoejct for Windows, macOS, and linux.

Prerequisites:
Make sure maven is installed

macOS and linux:
`brew install maven`

macOS and linux:  
`cd QuizCreator`  
`./build.sh`  
`./run.sh`  

windows
`cd QuizCreator`  
`./build.bat`
`./run.bat`

After successfully building and running, you can view the project by going to:
http://localhost:8080

####Example Quizzes
calling `SQLScriptRunner.run("exampleQuiz");` somewhere in main before tomcat runs will insert some example quizzes into the database. exampleQuiz.sql is meant to be run EXACTLY ONCE on a database with the schema loaded, but no entries. For testing purposes only.

