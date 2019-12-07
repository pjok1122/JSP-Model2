<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="base.jsp"></jsp:include>
<title>Index</title>
</head>
<body>
<div class="container">
	<jsp:include page="navBar.jsp"></jsp:include>
	<h1 class="mt-5 text-center"> 글 목록</h1>
	<div>
		<ul class="list-group">
			<ul class="list-group list-group-horizontal-sm center">
			  <li class="list-group-item col-md-3">글 번호</li>
			  <li class="list-group-item col-md-6">글 제목</li>
			  <li class="list-group-item .col-md-3">작성 시간</li>
			</ul>
			<ul class="list-group list-group-horizontal-sm">
			  <li class="list-group-item col-md-3">1</li>
			  <li class="list-group-item col-md-6">aaabbb</li>
			  <li class="list-group-item .col-md-3">2 min ago</li>
			</ul>
		</ul>
	</div>
	<div class="mt-5">
	    <button class="btn btn-primary" onclick="location.href='write.do'">글쓰기</button>
	    <button class="btn btn-primary" onclick="location.href='index.jsp'">홈으로</button>
    </div>
</div>
</body>
</html>