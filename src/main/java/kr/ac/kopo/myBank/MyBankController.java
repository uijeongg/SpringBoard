package kr.ac.kopo.myBank;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.account.AccountService;
import kr.ac.kopo.account.AccountVO;

@Controller
public class MyBankController {

	@Autowired
	private MyBankService mybankService;
	
	@Autowired
	private AccountService accountService;
	

	/**
	 * 1. 최종 통장 전환
	 * changing.jsp에서 모든 약관 동의 후 통장전환 submit
	 */
	@PostMapping("/changeSuccess")
	public String finalChange(HttpServletRequest request) {
		
	//	String checkAccountNo = request.getParameter("checkAccountNo");
	//	System.out.println("checkAccountNo 가져옴? : " + checkAccountNo); //라디오버튼으로 받아온 전환할 통장의 계좌번호
	
		String accountNo = request.getParameter("accountNo");
		System.out.println("AccountNo 가져옴? : " + accountNo);
//		
//		AccountVO account = accountService.getOneAccount(checkAccountNo);
//		String balance = account.getBalance();
//		
//		AccountVO newAccount = new AccountVO();
//		newAccount.setAccountNo(checkAccountNo);
//		newAccount.setBalance(balance);
		
		/*
		 * 1. t_account 에서 accountName을 '내서비스통장' 으로 update
		 * 2. t_mybank 에서 고객정보 그대로 insert (balance는 basicBal로)
		 */
		
		//1. 서비스 호출할 때 (checkAccountNo) 가져가기
		//2. 서비스 호출할 때 (checkAccountNo, balance) 가져가기
		
		mybankService.updateName(accountNo);
		
		//3. changeSuccess.jsp에서 뿌려줄 select 쿼리문도 만들어주기
		
		
		return "/myBank/changeSuccess";
	}
	
	  
}
