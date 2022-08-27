package kr.ac.kopo.account;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired //나 이거 필요하니까 스프링한테 나 이거줘! 하는거 - 마이바티스 쿼리문을 수행해주는 역할
	private SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 1. 전환 가능한(로그인 회원) 전체 계좌 조회
	 */
	@Override
	public List<AccountVO> selectAll(String id) { //AccountDAO랑 같게 
		
		List<AccountVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("account.accountDAO.selectAll", id); 
		//쿼리 날리는 중! selectAll() 쓸거라고 호출 -> list에 담아!
		
		return list;
		
	
	}

	

	/**
	 * 2. 전환할 통장 선택 -> 전환하기 버튼 submit
	 */
	public AccountVO selectOne(String checkAccountNo) {
		
		AccountVO changeAccount = new AccountVO();
		changeAccount = sqlSessionTemplate.selectOne("account.accountDAO.selectOne", checkAccountNo); 
		
		return changeAccount;
	}
}
