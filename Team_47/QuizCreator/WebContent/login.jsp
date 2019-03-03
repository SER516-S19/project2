<html>
<body>
  <head>
    <link rel="stylesheet" href="CSS/styles.css" />
    <meta charset="utf-8">
    <title></title>
  </head>
        <%
        // get info from request
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        
        %>

       <div class="login-page">
  <div class="form">
    <form class="login-form action="LoginServlet">
        You've entered the <%= email %> ,<%= password %>      
    </form>
  </div>
</div>

        </body>
        </html>