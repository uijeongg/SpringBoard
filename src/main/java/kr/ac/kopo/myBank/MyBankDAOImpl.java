package kr.ac.kopo.myBank;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.AccountVO;

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
	
}
