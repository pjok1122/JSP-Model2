<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="base.jsp"></jsp:include>
<title>Register</title>
</head>
<body>
<div class="container">
	<%@ include file="navBar.jsp" %>
	<div class="row mt-5">
	    <div class="col-12 text-center">
	        <h1>회원가입</h1>
	    </div>
	</div>
	<div class="container">
	<div class="row mt-5">
	    <div class="col-12">
	        <form method="POST" action="register.do">
	            <div class="form-group">
	                <label for="id">* 아이디</label>
	                <input type="text" class="form-control" id="id"  placeholder="아이디" name="id">
	            	<small style="color:red;">${requestScope.id_error} </small>
	            </div>
	            <div class="form-group">
	                <label for="password">* 비밀번호</label>
	                <input type="password" class="form-control" id="password"  placeholder="비밀번호" name="password">
	            </div>
	            <div class="form-group">
	                <label for="re_password">* 비밀번호 확인</label>
	                <input type="password" class="form-control" id="re_password" placeholder="비밀번호 확인" name="re_password">
	            	<small style="color:red;">${requestScope.pw_error} </small>
	            </div>
	            <div class="form-group">
	                <label for="name">이름</label>
	                <input type="text" class="form-control" id="name" placeholder="이름" name="name">
	            </div>
	            
	            <div class="form-group">
	                <label for="gender">성별 : </label>
	                <input type="radio" id="gender" name="gender" value="0"> 남성
	                <input type="radio" id="gender" name="gender" value="1"> 여성	               
	            </div>
	            <button type="submit" class="btn btn-primary">등록</button>
	        </form>
	    </div>
	</div>
</div>
</div>
</body>
</html>