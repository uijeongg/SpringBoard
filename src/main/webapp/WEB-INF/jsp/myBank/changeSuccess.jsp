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

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>
	
	
	
	<h3> 통장 전환이 완료되었습니다 </h3>

	
	<%-- 전환할 통장 정보 --%>
	<h4> [ 전환 선택한 통장 ] </h4>
		<div style="border: 1px solid black; padding: 10px;">		
			
			<h4>전환일 ${ accountOne.accountName }</h4><br>
			<h4>예금 종류 ${ accountOne.accountName }</h4><br>
			<h5>계좌번호 ${ accountOne.accountNo }</h5><br>
			<h5>잔액 ${ accountOne.balance }원</h5><br>
				  
		</div>
	
	
</body>
</html>