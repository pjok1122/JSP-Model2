<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="main_view.do">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
  	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
        	<c:choose>
        	<c:when test="${sessionScope.userId!=null }">
	        	<li class="nav-item"><a class="nav-link">${sessionScope.userId}님 환영합니다.</a></li>
		        <li class="nav-item"><a class="nav-link" href="logout.do">Log out</a></li>
	    	</c:when>
	    	<c:otherwise>
		    	<li class="nav-item"><a class="nav-link" href="login_view.do">Sign in</a></li>
		        <li class="nav-item"><a class="nav-link" href="register_view.do">Sign up</a></li>
	    	</c:otherwise>
	    	</c:choose>
	    </ul>
	</div>
</nav>
</body>