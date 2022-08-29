<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>
	
	
	
	<h3> 통장 전환이 완료되었습니다 </h3>

	
	<form action="${pageContext.request.contextPath}/mybankMain" method="post">	
	<%-- <input type="hidden" name="accountNo" value="${ accountOne.accountNo }"> --%>
	
	
		<%-- 전환할 통장 정보 --%>
		<h4> [ 전환 선택한 통장 ] </h4>
			<div style="border: 1px solid black; padding: 10px;" id="newAccountList">		
		 		
				<h4>전환일 ${ MyBank.openDate }</h4><br>
				<h4>예금 종류 ${ MyBank.accountName }</h4><br>
				<h5>계좌번호 ${ MyBank.accountNo }</h5><br>
				<h5>잔액 ${ MyBank.basicBal }원</h5><br> 	  
			</div>
	


	
		<input type="submit" id="gogo" value="내서비스통장 확인하러 가기"> 
		
		
		
		
	</form>
	
	
	
</body>
</html>