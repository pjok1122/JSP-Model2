<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="base.jsp"></jsp:include>
<title>Index</title>
</head>
<body>
	<div class="container">
		<%@ include file="navBar.jsp"%>
		<div class="row mt-5">
			<div class="col-12 text-center">
				<h1>글 목록</h1>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.bSeq}</td>
							<td><a href="content.do?bSeq=${board.bSeq}">${board.bTitle}</a></td>
							<td>${board.uId}</td>
							<td>${board.registered_at}</td>
							<td>${board.bHit}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="mt-5">
			<button class="btn btn-primary"
				onclick="location.href='write_view.do'">글쓰기</button>
		</div>
	</div>
</body>
</html>