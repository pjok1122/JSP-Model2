<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="base.jsp"></jsp:include>
<title>글쓰기</title>
</head>
<body>
	<div class="container">
	<%@ include file="navBar.jsp" %>
		<div class="row mt-5">
			<div class="col-12 text-center">
			<h1>글쓰기</h1>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<form action="write.do" method="POST">
					<div class="form-group">
						<label for="title">제목</label>
						<input type="text" class="form-control" id="title" name="title" placeholder="제목">
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<textarea class="form-control" rows="12" id="content" name="content" placeholder="내용"></textarea>
					</div>
					<div><small style="color:red;">${requestScope.error}</small></div>
					<button type="submit" class="btn btn-primary">글쓰기</button>
				</form>
			</div>
		</div>
	
	</div>
	
</body>
</html>