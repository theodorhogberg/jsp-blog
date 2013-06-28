<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, entities.*"%>    

<%
    List<Bloggpost> bloggposts = (List<Bloggpost>)request.getAttribute("bloglist");
    String contextPath = request.getContextPath();
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sezars salladsblogg</title>
</head>
<body>

<%	
for (Bloggpost post : bloggposts) {
	String postRubrik = post.getName();
	String postText = post.getPost();
	String postDate = post.getDate().toString();
	String postID = post.getId();
%>

	<li>
		<a href="<%= contextPath %>/Postcomment?blog=<%=postID%>"><%= postRubrik %></a>  - <%= postDate %>:
		<%= postText %>
	</li>	
	

<% } %>

<form action="<%= contextPath %>/Postblog" method="post">
			<div>
				<dl>
					<dt><label for="rubrik" >Rubrik</label></dt>
					<dd><input type="text" id="rubrik" name="rubrik" required="required" placeholder="Skriv rubrik"></dd>
					<dt><label for="blogpost">Blogginlägg</label></dt>
					<dd><textarea rows="12" cols="60" id="blogpost" name="blogpost" placeholder="Skriv ditt inlägg" required="required"></textarea></dd>
				</dl>
				<input type="submit" value="Posta">
			</div>
		</form>
</body>
<a href="<%= contextPath %>/Login"><h1>Till inloggning & utloggning</h1></a>
</html>