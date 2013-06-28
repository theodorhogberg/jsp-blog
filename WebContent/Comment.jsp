<%@page import="entities.Comment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
    
String name = (String)session.getAttribute("username");
	boolean isLoggedIn = false;
    if( null != name ){
    	isLoggedIn = true;
    }
    
    String postid = (String) request.getParameter("blog");
    List<Comment> comments = (List<Comment>)request.getAttribute("comments");
    String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<link href="<%= contextPath %>/css/style.css" rel="stylesheet" type="text/css">
		<meta charset="utf-8">
		<title>Kommentarer</title>
	</head>
	<body>
	
	
		<form action="<%= contextPath %>/Postcomment?blog=<%=postid%>" method="post">
			<div>
				<dl>
					<dd><input type="hidden" name="post_id" value="<%=postid%>"></dd>				
					<dt><label for="name">Alias</label></dt>
					<dd><input type="text" id="name" name="name" value="<%= isLoggedIn?name:""%>"></dd>
					<dt><label for="comment">Kommentar</label></dt>
					<dd><textarea rows="8" cols="40" id="comment" name="comment"></textarea></dd>
				</dl>
				<input type="submit" value="Kommentera">
			</div>
		</form>
		

		<ol>
<%		for(Comment comment : comments){ 
			String commentName = comment.getName();
			String commentText = comment.getComment();
			String commentDate = comment.getDate().toString();
%>
			<li>
				<%= commentName %> - <%= commentDate %>:
				<%= commentText %>
			</li>
<% 		} %>
		</ol>
	</body>
<a href="<%= contextPath %>/Login"><h1>Till inloggning & utloggning</h1></a>
<a href="<%= contextPath %>/"><h1>Till bloggen</h1></a>
</html>









