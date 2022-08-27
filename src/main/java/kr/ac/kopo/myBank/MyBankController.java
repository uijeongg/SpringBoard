package kr.ac.kopo.myBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.ac.kopo.account.AccountService;

@Controller
public class MyBankController {

	@Autowired
	private MyBankService mybankService;
	
	@Autowired
	private AccountService accountService;
	


	
	  
}
