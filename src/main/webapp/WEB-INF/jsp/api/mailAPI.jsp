<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

   이메일 : <input type="email" id="mail_input"/>
   <button type="button" id="mail_button">메일전송</button>

<script type="text/javascript">
$(document).ready(function () {
   $('#mail_button').click(function () {
      
      const email = $('#mail_input').val() /* #아이디의 */
      
      /* if($('#userName').val() ==''){
         alert('이름을 입력하세요')
         $('#userName').focus()
      }else if($('#idNum1').val() =='' || $('#idNum2').val() =='' ){
         alert('주민번호를 입력하세요')
         $('#idNum1').focus()
      }else if($('#number').val() ==''){
         alert('전화번호를 입력하세요')
         $('#number').focus()
      }else if($('#email').val() ==''){
         alert('이메일을 입력하세요')
         $('#email').focus()
      }else if($('#ckBox').is(':checked') == false){
         alert('회원가입 및 이용약관에 동의해주세요')
      }else{ */
         
      $.ajax({
      type : 'get',
      url : '${pageContext.request.contextPath}/mailCheck?email='+email, // GET방식이라 Url 뒤에 email을 뭍힐수있다.
      success : function (data) { // data : 인증번호
         console.log("data : " +  data);
         code = data; //메일에 간 인증번호
         alert('메일이 전송되었습니다.')
         $("#inputAuth").show()
      }
      })
      /* } */
   })
})
</script>
</body>
</html>