package kr.ac.kopo.account;

import java.util.List;

public interface AccountDAO {

	/**
	 * 1. 전환 가능한(로그인 회원) 전체 계좌 조회
	 */
	List<AccountVO> selectAll(String id);

	/**
	 * 2. 전환할 계좌의 정보 조회
	 * @return
	 */
	AccountVO selectOne(String checkAccountNo);
}
