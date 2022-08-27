package kr.ac.kopo.account;

import java.util.List;

public interface AccountService {
	
	
	/**
	 * 1. 전환 가능한(로그인 회원) 전체 계좌 조회
	 */
	List<AccountVO> getAllAccount(String id);
	

	/**
	 * 2.
	 */
	AccountVO getOneAccount(String checkAccountNo);
	//AccountVO getOneAccount(String accountNo??);


}
