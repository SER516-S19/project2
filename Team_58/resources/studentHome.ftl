<html>
    <body>
        HELLO
        <p>Welcome  ${Session.UserVO.getFirstname()}</p>
        <form action="courseDashboard" method="POST">
            <select name="Course">
            </select>
            <input type ="submit" value="Submit"/>
        </form>
    </body>
</html>