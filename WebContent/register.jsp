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
	<div class="row mt-5">
	    <div class="col-12 text-center">
	        <h1>회원가입</h1>
	    </div>
	</div>
	<div class="row mt-5">
	    <div class="col-12">
	        <form method="POST" action=".">
	            <div class="form-group">
	                <label for="username">사용자 이름</label>
	                <input type="text" class="form-control" id="username"  placeholder="사용자 이름" name="username">
	            </div>
	            <div class="form-group">
	                <label for="useremail">사용자 이메일</label>
	                <input type="email" class="form-control" id="useremail"  placeholder="사용자 이메일" name="useremail">
	                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	            </div>
	            <div class="form-group">
	                <label for="password">비밀번호</label>
	                <input type="password" class="form-control" id="password" placeholder="비밀번호" name="password">
	            </div>
	            <div class="form-group">
	                <label for="re-password">비밀번호 확인</label>
	                <input type="password" class="form-control" id="re-password" placeholder="비밀번호 확인" name="re-password">
	            </div>
	            <button type="submit" class="btn btn-primary">등록</button>
	        </form>
	    </div>
	</div>
</div>
</body>
</html>