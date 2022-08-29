package kr.ac.kopo.myBank;

import kr.ac.kopo.account.AccountVO;

public interface MyBankService {

	void updateOne(String accountNo);
	
	void insertOne(AccountVO newAccount);
	
	MyBankVO getNewAccount(String account);
}
