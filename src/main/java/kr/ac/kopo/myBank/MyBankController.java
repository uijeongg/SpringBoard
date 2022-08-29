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
	 * (service 3개 호출)
	 */
	@PostMapping("/changeSuccess")
	public String finalChange(HttpServletRequest request) {
		
		String accountNo = request.getParameter("accountNo");
		int balance = Integer.parseInt(request.getParameter("balance"));
		
		//System.out.println("AccountNo랑 balance 가져옴? : " + accountNo + balance);

		
		
		AccountVO newAccount = new AccountVO();
		newAccount.setAccountNo(accountNo);
		newAccount.setBalance(balance);
		
	
		/*
		 * 1. t_account 에서 accountName을 '내서비스통장' 으로 update
		 * 2. t_mybank 에서 고객정보 그대로 insert (balance는 basicBal로)
		 * 3. changeSuccess.jsp에서 뿌려줄 전환 성공한 내서비스통장의 정보를 select 쿼리문
		 */
		
		//1. 서비스 호출할 때 (accountNo) 가져가기
		//2. 서비스 호출할 때 (newAccount) 가져가기
		
		mybankService.updateOne(accountNo); 
		System.out.println("업데이트 성공");    
		
		mybankService.insertOne(newAccount);
		System.out.println("인서트 성공");
		
		MyBankVO MyBank = mybankService.getNewAccount(accountNo);
		System.out.println(MyBank + " 셀렉트성공");
		
		request.setAttribute("MyBank", MyBank); //request에 저장해주자
	
		return "/myBank/changeSuccess";
	}
	
	
	
	/**
	 * 2. 내서비스통장 메인화면 (조회)
	 * (통장 전환 후 '내서비스통장 확인하러 가기' 버튼 서밋)
	 */
	@PostMapping("/mybankMain")
	public String showMain(HttpServletRequest request) {
		
		
		
		
		
		
		return "/myBank/mybankMain";
	}

}
