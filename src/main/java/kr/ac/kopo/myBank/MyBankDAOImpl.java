package kr.ac.kopo.myBank;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.addPocket.AddPocketVO;

@Repository
public class MyBankDAOImpl implements MyBankDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 1. 1) t_account에서 통장 이름 update
	 */
	@Override
	public void updateAccount(String accountNo) {
		 
		sqlSessionTemplate.update("myBank.MyBankDAO.updateAccount", accountNo); 
	}
	
	
	/**
	 * 1. 2) 마이뱅크t에 insert
	 */
	@Override
	public void insertNew(AccountVO newAccount) {
		
		sqlSessionTemplate.insert("myBank.MyBankDAO.insertNew", newAccount); 
	
	}
	
	
	
	/**
	 * 1. 3) changeSuccess.jsp에 전환한 통장 정보 뿌려주기
	 */
	@Override
	public MyBankVO selectNew(String accountNo) {
		
		MyBankVO mybankAccount = sqlSessionTemplate.selectOne("myBank.MyBankDAO.selectNew", accountNo);		
		 
		return mybankAccount;
		
	}
	
	
	/**
	 * 2. 
	 */
	@Override
	public MyBankVO selectSuccess(String accountNo) {
		
		MyBankVO mybankAccount = sqlSessionTemplate.selectOne("myBank.MyBankDAO.selectSuccess", accountNo);		
		 
		return mybankAccount;
	}
	
	
	
	/**
	 * 3. 
	 */
	@Override
	public void insertPocket(AddPocketVO newPocket) {
		
		System.out.println("디에이오" + newPocket);
		
		sqlSessionTemplate.insert("myBank.MyBankDAO.insertNewPoc", newPocket); 
	}
	
}
