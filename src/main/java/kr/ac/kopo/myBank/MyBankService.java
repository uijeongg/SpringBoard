package kr.ac.kopo.myBank;

import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.addPocket.AddPocketVO;

public interface MyBankService {

	void updateOne(String accountNo);
	
	void insertOne(AccountVO newAccount);
	
	MyBankVO getNewAccount(String account);
	
	MyBankVO getAccount(String accountNo);
	
	void insertNewPoc(AddPocketVO newPocket);
}
