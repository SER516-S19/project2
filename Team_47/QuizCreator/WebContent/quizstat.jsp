<!-- 
  - Author(s): Meng-Ze Chen
  - Date: 2019/2/23
  - Description: Display graphic statistic data for specific quiz.
  -->
<html>

<head>
    <% String quizIdx = request.getParameter("Quiz_title"); %>
    <title> Quiz <%= quizIdx %> Statistic </title>
    <meta id="request-method" name="request-method" content="GET">
    <meta name="author" content="Meng-Ze Chen">
    <meta name="copyright" content="© 2019 Meng-Ze Chen. All Rights Reserved.">
    <meta name="keywords" content="Quizzes Overview">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>

    <%@ page import="com.asu.ser516.team47.database.*" %>
    <%@ page import="java.util.List" %>
</head>

<body>
    <div class="container">
        <div class="bg-light">
            <h1 align="center">Forum Analysis</h1>
            <br> <br>
            <ol>
                <h2 align="center">Student id vs Marks Graph</h2><br>

                <%
                QuizDAO quizDAO = new QuizDAOImpl();
                int quizID = Integer.parseInt(request.getParameter("Quiz_id"));
                SubmissionDAO submissionDAO = new SubmissionDAOImpl();

                int scoreRange = 5;
                int[] scoreBucket = new int[scoreRange];
                Quiz quiz = quizDAO.getQuiz(quizID);
                List<Submission> submissionForThisQuiz = submissionDAO.getQuizSubmissions(quiz.getQuiz_id());
                for (int submissionIdx=0; submissionIdx<submissionForThisQuiz.size(); submissionIdx++) {
                    Submission thisSubmission = submissionForThisQuiz.get(submissionIdx);
                    float score = thisSubmission.getScore();
                    if (score < 60) {
                        scoreBucket[0] += 1;
                    } else if (score < 70) {
                        scoreBucket[1] += 1;
                    } else if (score < 80) {
                        scoreBucket[2] += 1;
                    } else if (score < 90) {
                        scoreBucket[3] += 1;
                    } else if (score <= 100) {
                        scoreBucket[4] += 1;
                    }
                } 
                %>

                <div id="area2">
                    <!-- <h2>Line Graph</h2> -->
                    <!-- bar chart canvas element -->
                    <canvas id="chart2" width="600" height="400"></canvas>

                    <script>
                        var scoreRangeDescript = [...Array(<%=scoreRange%>)];
                        var scores = [...Array(<%=scoreRange%>)];
                        scoreRangeDescript[0] = "F";
                        scoreRangeDescript[1] = "60 - 69";
                        scoreRangeDescript[2] = "70 - 79";
                        scoreRangeDescript[3] = "80 - 89";
                        scoreRangeDescript[4] = "90 - 100";

                        <% for (int i=0; i<scoreBucket.length; i++) { %>
                        scores[<%= i %>] = "<%= scoreBucket[i] %>"; 
                        <% } %>

                        // bar chart data
                        var barData = {
                            labels: scoreRangeDescript,
                            datasets: [
                                {
                                    fillColor: "rgba(151,187,205,0.2)",
                                    strokeColor: "rgba(151,187,205,1)",
                                    pointColor: "rgba(151,187,205,1)",
                                    pointStrokeColor: "#fff",
                                    pointHighlightFill: "#fff",
                                    pointHighlightStroke: "rgba(151,187,205,1)",
                                    bezierCurve: false,
                                    data: scores
                                }
                            ]
                        }

                        Chart.defaults.global.animationSteps = 50;
                        Chart.defaults.global.tooltipYPadding = 16;
                        Chart.defaults.global.tooltipCornerRadius = 0;
                        Chart.defaults.global.tooltipTitleFontStyle = "normal";
                        Chart.defaults.global.tooltipFillColor = "rgba(0,0,0,0.8)";
                        Chart.defaults.global.animationEasing = "easeOutBounce";
                        Chart.defaults.global.responsive = false;
                        Chart.defaults.global.scaleLineColor = "black";
                        Chart.defaults.global.scaleFontSize = 16;

                        // get bar chart canvas
                        var mychart = document.getElementById("chart2").getContext("2d");

                        steps = 10
                        max = 100
                        // draw bar chart
                        var LineChartDemo = new Chart(mychart).Line(barData, {
                            scaleOverride: true,
                            scaleSteps: steps,
                            scaleStepWidth: Math.ceil(max / steps),
                            scaleStartValue: 0,
                            scaleShowVerticalLines: true,
                            scaleShowGridLines: true,
                            barShowStroke: true,
                            scaleShowLabels: true,
                            bezierCurve: false,

                        });
                    </script>
                </div>

                <br><br><br>

            </ol>
        </div>
    </div>
    <input id="beginbtn" type="button" value="Dashbaord" onclick='location.href=("dashboard_professor.jsp")'>

</body>

</html>