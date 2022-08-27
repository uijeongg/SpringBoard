package kr.ac.kopo.myBank;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBankDAOImpl implements MyBankDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
}
