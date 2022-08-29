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
$(document).on('click','#checkAll',function(){
    if($('#checkAll').is(':checked')){
       $('.checkOne').prop('checked',true);
    }else{
       $('checkOne').prop('checked',false);
    }
});
</script>


</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>


	<%-- 전환할 통장 정보 --%>
	<h4> [ 전환 선택한 통장 ] </h4>
		<div style="border: 1px solid black; padding: 10px;">		
			
			<h4>통장이름 ${ accountOne.accountName }</h4><br>
			<h5>계좌번호 ${ accountOne.accountNo }</h5><br>
			<h5>잔액 ${ accountOne.balance }원</h5><br>
				  
		</div>

	<br><hr><br>
	
	
	
	
	<form action="${pageContext.request.contextPath}/changeSuccess" method="post">	
	<input type="hidden" name="accountNo" value="${ accountOne.accountNo }">
	<input type="hidden" name="balance" value="${ accountOne.balance }">
	<%-- controller로 값 전달 --%>
	
	
		<%-- 상품정보, 금리 등 안내 확인 --%>
		<h4> [ 상품 정보 및 금리 안내 ] </h4>
		
			<table  id="check" style="width : 95%; margin: auto;">
			<br>
		   		<tr>
	      			<td><b> 통장 상품 설명서 </b></td>
	      		</tr>
	      		
	      		<tr>
	      			<td><b> 통장 금리 안내 </b></td>
	      		</tr>
			</table>
	
	
	
		<br><hr><br>
	
		<%-- 약관 동의 --%>
		<h4> [ 통장 약관 동의 ]</h4>
		<h6> 통장전환 및 안전한 금융거래를 위하여 관련 법률과 규정에 따라 동의 및 확인이 필요합니다. </h6>
		   
		   <table  id="check" style="width : 95%; margin: auto;">
		   	
		   		<br>
		   		<tr>
	      			<th colspan="2"> 통장약관</th>
	      		</tr>
	      		
	      		
	      		<tr>
	      			<td><b> 통장전환 약관 전체 동의</b></td>
	      			<td><input name="checkAgree" id="checkAll" type="checkbox" value="agree"> <label>전체동의</label></td>
	      			<!-- <td><input name="checkTerm1" id="chk_all" type="checkbox" value="agree"> <label class="inpSchClass00" for="checkbox1">전체동의</label></td> -->
	      		</tr>
	      		
	      		<tr>
	      			<td>예금거래 기본 약관</td>
	      			<td><input name="checkAgree" class="checkOne" type="checkbox" value="agree"> <label>약관동의</label></td></td>
	      		</tr>
	      		
	      		<tr>
	      			<td>입출금이 자유로운 예금 약관</td>
	      			<td><input name="checkAgree" class="checkOne" type="checkbox" value="agree"> <label>약관동의</label></td></td>
	      		</tr>
	      		
	      		<tr>
	      			<td>비과세 종합저축 특약</td>
	      			<td><input name="checkAgree" class="checkOne" type="checkbox" value="agree"> <label>약관동의</label></td></td>
	      		</tr>
	      		
	      		<tr>
	      			<td>하나로 통장 특약</td>
	      			<td><input name="checkAgree" class="checkOne" type="checkbox" value="agree"> <label>약관동의</label></td></td>
	      		</tr>
		
		   </table>


<%--	
		<input name="checkTerm1" type="checkbox" value="agree"> 
			<label class="inpSchClass00" for="checkbox1">
				본인은 위 안내에 대해 이해하고 확인 및 동의합니다
			</label>
--%>



		<!-- <button type="submit" class="send" id="submitBtn" data-toggle="modal" data-target="#confirm-modal">확인</button> -->
		<input type="submit" id="gogo" value="확인"> 
		
	
<%--    
	<button type="submit" class="send" id="submitBtn" data-toggle="modal" data-target="#confirm-modal">확인</button>
	<button class="send" id="cancleBtn">취소</button>
					
 	<input type="submit" id="gogo" value="확인"> post버튼
 --%>
 
 
	</form>
	
	
</body>
</html>