<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="base.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-12">
			<h1 class="text-center">Login</h1>
				<form action="login.do" method="POST">
					<div class="form-group">
						<label for="id"><small>아이디</small> </label>
						<input type="text" id="id" placeholder="id" class="form-control" name="id">
					</div>
					<div class="form-group">
						<label for="pw"><small>비밀번호</small></label>
						<input type="password" id="pw" placeholder="password" class="form-control" name="password">
					</div>
					<div><small style="color:red;">${requestScope.error }</small></div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>