package kr.ac.kopo.mailAPI;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	 
	@Autowired
	private JavaMailSenderImpl mailSender;
	   
	   // 인증번호 필요하면 써
		/*
		 * private int authNumber;
		 * 
		 * public int makeRandomNum() { Random r = new Random(); int checkNum =
		 * r.nextInt(888888)+11111; System.out.println("인증번호 : " + checkNum); return
		 * checkNum; }
		 */
	   
	   
	   public void mailSend(String setForm,String toMail,String title,String content) {
	      MimeMessage message = mailSender.createMimeMessage();
	      try {
	         MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
	         helper.setFrom(setForm);
	         helper.setTo(toMail);
	         helper.setSubject(title);
	         
	         helper.setText(content,true);
	         mailSender.send(message);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public String joinEmail(String email) {
	   //   int authNum = makeRandomNum();
	      String setForm = "uijeong970929@gmail.com";
	      String toMail = email;
	      String title="OOO님의 O9월 My Own HANA 통장 금융 레포트 입니다.";
	      
	      String content = 
					/*
					 * "홈페이지를 방문해주셔서 감사합니다." + //html 형식으로 작성 ! // 메일에 들어갈 양식 
					 * "<br><br>" + 
					 * "인증 번호는 "
					 * + authNum + "입니다." + 
					 * "<br>" + 
					 * "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
					 */
	      
			      "OOO님의 O월 My Own HANA 통장 금융 레포트 입니다." +    //html 형식으로 작성 ! // 메일에 들어갈 양식
		          "첨부파일을 클릭하여 확인해 주세요.";
	      
	      mailSend(setForm, toMail, title, content);
	 
	      return null;
	   }

	   
	}









