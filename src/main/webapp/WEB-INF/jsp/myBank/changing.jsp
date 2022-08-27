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

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>


	<h3>전환 선택한 통장</h3>


	<form action="${pageContext.request.contextPath}/changeSuccess" method="post">	
	

	<div>
		
			
		<h3>통장이름 ${ accountOne.accountName }</h3><br>
		<h5>계좌번호 ${ accountOne.accountNo }</h5><br>
		<h5>잔액 ${ accountOne.balance }원</h5><br>
	
	  
	</div>


	   








	<input type="submit" id="gogo" value="확인"> <%-- post버튼 --%>
	

	</form>
	
	
</body>
</html>