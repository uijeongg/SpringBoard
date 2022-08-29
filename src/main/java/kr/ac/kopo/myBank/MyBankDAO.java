package kr.ac.kopo.myBank;

import kr.ac.kopo.account.AccountVO;

public interface MyBankDAO {

	
	//update
	void updateAccount(String accountNo);

	//insert
	void insertNew(AccountVO newAccount);
	
	//select
	MyBankVO selectNew(String accountNo);

}
