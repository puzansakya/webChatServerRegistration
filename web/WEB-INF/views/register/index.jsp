<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register!</h1>
       


        <form method="post" action="${SITE_URL}/register">
            <div>
                username:
                <input type="text" name="username" required="required" placeholder="Enter username"/>
            </div>
            <div>
                password:
                <input type="password" name="password" required="required" placeholder="Enter password"/>
            </div>
            <div>
                <button type="submit">Register</button>
            </div>
        </form> 

    </body>
</html>
