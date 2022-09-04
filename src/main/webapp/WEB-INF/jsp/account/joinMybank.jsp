<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 통장 전환 or 가입 선택 --%>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>
	
	<br><br><br>
	

	<%-- 통장전환 --%>
	<form action="${pageContext.request.contextPath}/accountList" method="get"> 
		<div style="border:solid; width:200px;">
			<input type="submit" value="통장 전환">			
		</div>
	</form>
	
	<br>




	<%-- 통장신규가입 --%>
	<form action="${pageContext.request.contextPath}/newJoin" method="get"> 
		<div style="border:solid; width:200px;">
			<input type="submit" value="통장 신규 가입">			
		</div>
	</form>




</body>
</html>