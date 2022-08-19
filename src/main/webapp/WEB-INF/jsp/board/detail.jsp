<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</head>
<body>
	
	detail.jsp입니다
	
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
	
		
</body>
</html>