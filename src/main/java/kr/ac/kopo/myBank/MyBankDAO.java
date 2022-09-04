package kr.ac.kopo.myBank;

import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.addPocket.AddPocketVO;

public interface MyBankDAO {

	
	//update
	void updateAccount(String accountNo);

	//insert
	void insertNew(AccountVO newAccount);
	
	//select
	MyBankVO selectNew(String accountNo);
	
	//select
	MyBankVO selectSuccess(String accountNo);

	//insert pocket
	void insertPocket(AddPocketVO newPocket);
}
