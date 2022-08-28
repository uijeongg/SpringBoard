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
	 * 1.
	 */
	@Override
	public void changeName(String accountNo) {
		 
		sqlSessionTemplate.update("myBank.MyBankDAO.changeName", accountNo); 
	}
}
