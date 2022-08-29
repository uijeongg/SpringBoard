package kr.ac.kopo.myBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;

@Service
public class MyBankServiceImpl implements MyBankService {

	@Autowired
	private MyBankDAO mybankDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	
	/**
	 * 1. 1)
	 */
	@Override
	public void updateOne(String accountNo) {
		
		mybankDAO.updateAccount(accountNo);
		
		
	}


	
	
	
	
	/**
	 * 1. 2)
	 */
	  @Override 
	  public void insertOne(AccountVO newAccount) {
	  
		  mybankDAO.insertNew(newAccount);
	  
	  }
	  
	  
	  /**
	   * 1. 3)
	   */
	  @Override
	  public MyBankVO getNewAccount(String accountNo) {
		  
		  MyBankVO mybankAccount = mybankDAO.selectNew(accountNo);
		  
		  return mybankAccount ; //여기서 받아온 값으로 success.jsp에서 뿌려줌
	  }
	  
}
