<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">


</head>
<body>
	
	
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>
	
	<table  class="table table-Secondary table-striped-columns">
		<tr>
			<th>제목</th>
			<th>${board.title}</th>
		</tr>
		
		<tr>
			<th>작성자</th>
			<th>${board.writer}</th>
		</tr>
		
		<tr>
			<th>등록일</th>
			<th>${board.regDate}</th>
		</tr>
		
		<tr>
			<th>내용</th>
			<th>${board.content}</th>
		</tr>
		
	</table>
	
	
	
	<%-- 댓글 에이잭스 구현 / 에러나서 페이지컨텍스트처리 안하고 에이젝스로 처리--%>
	<form name="rform"> <%-- document.rform.content --%>
		댓글 : <input type="text" size="30" name="content">  <!-- document.rform.content -->
		작성자 : <input type="text" size="20" name="writer">
	    
	    <input type="button" id="AddReplyBtn" value="댓글등록" >
	</form>
	
		
	<div id="replylist">
	</div>
	
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>


/* 해당 url에 에이젝스를 날리고 싶음 */
	function getAllReply() {
		//얘도 에이젝스 통신으로 호출
		$.ajax({
		
			  	url: '${pageContext.request.contextPath}/reply/${board.no}' //해당 글 번호 함께 넘겨주기
			  , type: 'get'
			  , success: function(data){  //return된 값을 data라고 지정
				  
				  	$('#replylist').empty();  //append해줘서 댓글 하나 달 때 마다 전에 댓글까지 다 붙으니까 매번 없애주기
				 
					//alert('성공')
				  
				    console.log(typeof data)
			 		//let list = JSON.parse(data);
					//console.log(list)
					
					$(data).each(function(){
						let str = '';
						str += '<hr>';
						str += '<div>';
						str += '<strong>' + this.content + ' ' + '</strong>';
						str += '<작성자>' + this.writer + ' ';
						str += '<작성일>' + this.regDate + ' ';
						str += '</div>';
						
						$('#replylist').append(str);
						
					})
					
					
			},
				 error: function() {
					 alert('함수실패')
				 }
		})
} 


$(document).ready(function(){
		
	getAllReply(); //디테일 들어가자마자 원래 있는 그 글의 댓글이 뜨게 하고 싶어서
		
		//alert('들어오니?');
		$('#AddReplyBtn').click(function(){
			
			let r_content = document.rform.content.value;  /* 값 여기서 가져다 쓰기  */
			let r_writer = document.rform.writer.value;
		    console.log(r_content)
		     console.log(r_writer)
		      console.log(${board.no})
		
		$.ajax({
			  url : '${pageContext.request.contextPath}/reply' 
			, method : 'post'
			, data : 		{
						    boardNo : ${board.no}
			  			,	content : r_content /* ${board.content} */
						,	writer	: r_writer /* ${board.writer} */
			},
			success : function(){
				/* 성공 시 여기 함수 실행 */
				alert('성공')
				/* 성공 시 그 댓글 보여줘 */
				getAllReply();
				
			},
			error : function(){
				alert('댓글작성실패')
				
			},
			complete : function(){
				document.rform.content.value =' ';
				document.rform.writer.value =' ';
			
			}
		})
	})
	}) 
	
</script>
	
		
</body>
</html>