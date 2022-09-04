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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>






</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>

	<h2>나의 모하나 통장 메인입니다</h2>
	<hr>
	<h3> 내 주머니 현황</h3> <%-- ui 홍씨처럼 가로로 만들기 --%>

	<div id="pocket_div">
	
	
	
	<div style="border: 1px solid black; padding: 10px;">	
	
		<h3>기본 주머니</h3>	
		<small>모든 금액은 여기서 시작!</small><br>
   <%-- <h5>통장이름 ${ MyAccount.accountName }</h5><br> --%>
		<h5>계좌번호 ${ MyAccount.accountNo }</h5><br>
		<h5>잔액 ${ MyAccount.basicBal }원</h5><br>
		<input id="basic" type="hidden" value=""/>
	
		<!-- 조회, 이체 버튼 만들기 -> 여기서 jsp 넘어가기 거래내역 나오는! -->
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
			<h4>파킹 주머니</h4><br>
			<small>종잣돈 마련을 위해 야금야금</small><br>
			<h4>{parkingBal}원</h4>
		</div><br>
	
	</div>
	
	
		<div id="createDiv">
			<%-- 여기에 ajax로 추가해준 주머니 자동 div 생성 하기!!!!!!!!!!!!! --%>
		</div>
	
	
	

	
	
	
	
	
	
	
	
	
	
		<div>
			<input type="button" id="pocket" value="주머니 추가" onclick="displayPocket1()">
			
			
				<form action="${pageContext.request.contextPath}/addPocket" method="post"
					  id="addPocket" style="display:none; border-style:solid;">
					추가할 주머니 이름 : <input type="text" name="pocketName" placeholder="주머니 이름을 입력하세요"><br>
					용도 : <input type="text" name="pocketPurpose" placeholder="최대 30자까지 입력 가능합니다"><br>
					
					<input type="submit" value="주머니 추가2">
				</form>
	
		</div><br>
	
	
	<script>
	//주머니추가
	
 		function displayPocket1() { 
			
		//1. 주머니 추가 insert
			let pock = document.getElementById("addPocket");
			if(pock.style.display == "none"){
				pock.style.display = "";
			} else {
				pock.style.display = "none";
			}	
			
			
	 	} 
		
</script>	
	




<!-- 
<script>
	function getPocket() {
	
		$.ajax({
			
		  	url: '${pageContext.request.contextPath}/mybankMain' //해당 글 번호 함께 넘겨주기
		  , type: 'post'
		  , success: function(data){  //return된 값을 data라고 지정
			  
			  	$('#pocket_div').empty();  
				alert('성공')
			  
			    console.log(typeof data)
		 		//let list = JSON.parse(data);
				//console.log(list)
				
				$(data).each(function(){
					let str = '';
					
					str += '<strong>' + this.accountName + '</strong>';
					
					
					$('#pocket_div').append(str);
					
				})
				
				
		},
			 error: function() {
				 alert('함수실패')
			 }
	})
	}



</script>

 -->






</body>
</html>