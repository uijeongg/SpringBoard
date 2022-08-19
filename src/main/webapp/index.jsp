<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- requestMapping에 BoardController라고 써있잖아. 그렇게 BoardController로 연결해주는 링크 --%>
<a href="${pageContext.request.contextPath}/board">게시판으로 가줘라~!</a><br><br>


<%-- board/write 요청이 들어오면 새글등록 ㄱㄱ --%>
<a href="${pageContext.request.contextPath}/board/write">새글등록</a><br><br>


<%-- springboard/login 요청 @GetMapping("/login") 이니까! --%>
<a href="${pageContext.request.contextPath}/login">로그인</a><br><br>


<a href="${pageContext.request.contextPath}/logout">로그아웃</a><br><br>


</body>
</html>