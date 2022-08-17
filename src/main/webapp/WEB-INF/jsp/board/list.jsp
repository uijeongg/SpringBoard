<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${ boardlist }
	
	<!-- BoardController에서 selectAllBoard 실행해서 담긴 boardlist를 뿌려주자! -->
	<c:forEach items="${boardlist}" var="board">
		${ board.no } <br> ${ board.title } <br> ${ board.writer } 
	
	</c:forEach>
	
	
</body>
</html>