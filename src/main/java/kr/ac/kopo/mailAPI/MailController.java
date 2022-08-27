package kr.ac.kopo.mailAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	   
	@RequestMapping("/mailform")
	public String mailFrom() {
	      
	    return "/api/mailAPI";
	}
	   
	@ResponseBody
	@GetMapping("/mailCheck")
	public String mail(@RequestParam("email") String email) { //void말고 String
	   System.out.println("email : " + email);
	      
	   return mailService.joinEmail(email);
 }
}