package kr.ac.kopo.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	
	/**
	 * 1. 전환 가능한(로그인 회원) 전체 계좌 조회
	 */
	@Override
	public List<AccountVO> getAllAccount(String id) {
		
		List<AccountVO> list = new ArrayList<>();
		list = accountDAO.selectAll(id);
		
		return list;
	}
	
	
	/**
	 * 2. 기본통장 -> 내통장 전환
	 */
	
	public AccountVO getOneAccount(String checkAccountNo) {
		
		AccountVO accountOne = new AccountVO();
		accountOne = accountDAO.selectOne(checkAccountNo);
		
		return accountOne;
	}
	
}

