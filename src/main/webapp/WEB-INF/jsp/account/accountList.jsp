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
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
//통장전환 버튼 눌렀을 시 라디오버튼 값 넘겨주기
$(document).ready(function() {
    $('#gogo').click(function() {
        var checkAccountNo = $("input[type=radio][name=checkAccountNo]:checked").val();
       /*  if (value) {
           alert(value); 
        }
        else {
            alert('Nothing is selected');
        } */
    })
});

</script>



</head>
<body>

	<%-- 통장 전환 전 전환 가능한 계좌 리스트 보여주는 페이지 -> loginVO를 가지고 있어야 함! --%>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>

	<!-- accountList.jsp입니다
	통장이름, 계좌번호, 잔액 -->
	
	
	
	
	<h3>전환 가능 통장 목록</h3>
	
	<form action="${pageContext.request.contextPath}/changing" method="post">	
	
	<table class="table table-Secondary table-striped-columns">
	
		<tr>
			<td>전환 여부</td>
			<td>예금종류</td>
			<td>계좌번호</td>
			<td>잔액</td>
		</tr>

		<%-- <c:forEach items="${boardlist}" var="board"> --%>
		<c:forEach items="${accountList}" var="account">
		<tr>


			<td> <input type="radio" id="gogo" name="checkAccountNo" value=${ account.accountNo }> </td>
			<%-- 서버에 전달될 값이 value --%>

			<td>${ account.accountName }</td>
			<td>${ account.accountNo }</td>
			<td>${ account.balance } </td>
		</tr>	
		</c:forEach>

	</table>

	<input type="submit" id="gogo" value="통장전환"> <%-- post버튼 --%>
	<!-- <input type="submit" id="goback" value="돌아가기"> -->
	<!-- <button type="submit" class="send" id="submitBtn">통장전환</button> -->
	<!--  <button id="submit">Submit</button> -->

	</form>

</body>
</html>