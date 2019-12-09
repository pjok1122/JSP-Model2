<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<form action="update.do" method="POST">
				<input type="hidden" name="bSeq" value="${requestScope.bSeq}" />
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" class="form-control" id="title" name="title"
						value="${requestScope.title}" >
				</div>
				<div class="form-group">
					<label for="uId">작성자</label>
					<input class="form-control" id="uId"
						name="uId" value="${requestScope.uId}" readonly></input>
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea class="form-control" rows="12" id="content"
						name="content">${requestScope.content}</textarea>
				</div>
				<div><small style="color:red;">${requestScope.error}</small></div>
				<button class="btn btn-primary">수정</button>
				<button class="btn btn-primary" onclick="location.href='main.do'">돌아가기</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>