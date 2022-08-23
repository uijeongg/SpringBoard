<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</head>
<body>	
	
	<%-- 
		<c:if test="${not empty loginVO}">
			${loginVO.name} 님 반갑습니다
		</c:if> 
	--%>


	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>


	<!-- BoardController에서 selectAllBoard 실행해서 담긴 boardlist를 뿌려주자! -->
	
	<table class="table table-Secondary table-striped-columns">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
		</tr>

		<c:forEach items="${boardlist}" var="board">
		<tr>
			<td>${ board.no }</td>
			<td> <!-- 제목 누르면 상세글로 가도록 a태그 ?boardNo방식 & /boardNo 방식 -->
			   <%-- <a href="${pageContext.request.contextPath}/board/detail?boardNo=${board.no}"> --%>
					<a href="${pageContext.request.contextPath}/board/detail/${board.no}">
					${ board.title }
				</a>
			</td>
			<td>${ board.writer }</td>
			<td>${ board.regDate } </td>
		</tr>	
		</c:forEach>
	</table>
	
		
	
</body>
</html>