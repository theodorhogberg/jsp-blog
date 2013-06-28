<%@page import="entities.Comment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
    String name = (String) session.getAttribute ("username");
	
boolean isLoggedIn = false;
    if( null != name ){
    	isLoggedIn = true;
    }
    
    String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<link href="<%= contextPath %>/css/style.css" rel="stylesheet" type="text/css">
		<meta charset="utf-8">
		<title>Login</title>
	</head>
	<body>

<% 		if( isLoggedIn ) { %>			
			Hej <%= name %>!
			<form action="<%= contextPath %>/Logout" method="post">
				<div>
					<input type="submit" value="Logout">
				</div>
			</form>
<%		} else { %>
			Hej anonym!
			<form action="<%= contextPath %>/Login" method="post">
				<div>
					<input type="text" name="username" placeholder="Username" required="required">
					<input type="password" name="password" placeholder="Password" required="required">
					<input type="submit" value="Login">
				</div>
			</form>
<%		} %>

	</body>
	<a href="<%= contextPath %>/"><h1>Till bloggen</h1></a>		
</html>









