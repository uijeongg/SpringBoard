<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>내서비스통장 메인입니다</h2>
	<hr>
	
	
	<div style="border: 1px solid black; padding: 10px;">		
			
		<%-- <h3>통장이름 ${ accountOne.accountName }</h3><br> <!-- strong사용? -->
		<h5>계좌번호 ${ accountOne.accountNo }</h5><br>
		<h5>잔액 ${ accountOne.balance }원</h5><br> --%>
		
		<!-- 이체, 조회버튼 
		<button></button> -->		
	</div>
	
	
	<hr>
	<h3> 주머니 현황</h3> <%-- ui 홍씨처럼 가로로 만들기 --%>
	
		<div style="border: 1px solid black; padding: 10px; width: 1000px;">
			<h4>기본 주머니</h4><br>
			<small>모든 금액은 여기서 시작!</small><br>
			<h4>{basicBal}원</h4>
		</div>
		
		
		<div style="border: 1px solid black; padding: 10px; width: 500px;">
			<h4>고정비 주머니</h4><br>
			<small>숨만 쉬어도 빠져 나가는 돈이 얼마지?</small><br>
			<h4>{fixedBal}원</h4>
		</div>
		
		
		<div style="border: 1px solid black; padding: 10px; width: 500px;">
			<h4>생활비 주머니</h4><br>
			<small>나의 한달 소비는 이 만큼만</small><br>
			<h4>{livingBal}원</h4>
		</div>
		
		
		<div style="border: 1px solid black; padding: 10px; width: 500px;">
			<h4>생활비 주머니</h4><br>
			<small>나의 한달 소비는 이 만큼만</small><br>
			<h4>{livingBal}원</h4>
		</div>
		
		<div style="border: 1px solid black; padding: 10px; width: 500px;">
			<h4>파킹 주머니</h4><br>
			<small>종잣돈 마련을 위해 야금야금</small><br>
			<h4>{parkingBal}원</h4>
		</div>
	
	
	
	
</body>
</html>