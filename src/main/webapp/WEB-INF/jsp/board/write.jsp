<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- 입력 널값은 script로 앞단에서 막아주기 필요하면 ㄱㄱ --%>
	<%-- 입력 널값은 script로 앞단에서 막아주기 필요하면 ㄱㄱ --%>
	<%-- 입력 널값은 script로 앞단에서 막아주기 필요하면 ㄱㄱ --%>
	
	
	
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</header>
	
	
	
	<form action="${pageContext.request.contextPath}/board/write" method="post">	
						
		<table>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="title" size="30" > </td>
			</tr>
			
			
			<tr>
				<td> 작성자 </td>
				<td> <input type="text" name="writer" size="30" /> </td>
			</tr>
			
			
			<tr>
				<td> 내용 </td>
				<td> <textarea name="content" rows="4" cols="50"></textarea></td>
			</tr>
		
			<%-- 이 때, input값에서 name값을 boardVO랑 같은 이름으로 설정해주어야 함! boardVO로 받아와야하니까!! --%>		
		</table>
	
		<input type="submit" value="새글등록"> <%-- post버튼 --%>
	
	</form>
	
	
</body>
</html>