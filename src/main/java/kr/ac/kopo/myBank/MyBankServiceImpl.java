package kr.ac.kopo.myBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.account.AccountDAO;

@Service
public class MyBankServiceImpl implements MyBankService {

	@Autowired
	private MyBankDAO mybankDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	
	/**
	 * 1. 
	 */
	@Override
	public void updateName(String accountNo) {
		
		mybankDAO.changeName(accountNo);
		
		
	}
	
}
