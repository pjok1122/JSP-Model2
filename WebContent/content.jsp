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
			<form method="POST" name="form">
				<input type="hidden" name="bSeq" value="${article.bSeq}" />
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" class="form-control" id="title" name="title"
						value="${article.bTitle}" readonly>
				</div>
				<div class="form-group">
					<label for="uId">작성자</label>
					<input class="form-control" id="uId"
						name="uId" value="${article.uId}" readonly></input>
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea class="form-control" rows="12" id="content"
						name="content" readonly>"${article.bContent}"</textarea>
				</div>
				<button type="button" class="btn btn-primary" onclick="location.href='main.do'">돌아가기</button>
				<c:if test="${sessionScope.userId eq article.uId}">
					<button class="btn btn-primary" onclick="javascript: form.action='update_view.do?bSeq=${article.bSeq}';">수정하기</button>
					<button class="btn btn-primary" onclick="javascript: form.action='delete.do?bSeq=${article.bSeq}'">삭제하기</button>
				</c:if>
			</form>
			</div>
		</div>
	
	</div>
	
</body>
</html>