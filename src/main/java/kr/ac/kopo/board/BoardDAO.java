package kr.ac.kopo.board;

import java.util.List;

public interface BoardDAO {

	/**
	 * 1. 전체게시글조회
	 */
	List<BoardVO> selectAll();
	
	
	/**
	 * 2. 상세게시글조회
	 * boardNo는 내가 주는 값!!
	 */
	BoardVO selectByNo(int BoardNo);


	/**
	 * 3. 새글등록
	 * 리턴값(받을값)은 없고, 새글등록값들 BoardVO에 담아서 줄테니까 이거 db에 저장해줘
	 */
	//BoardVO insertBoard();
	void insertBoard(BoardVO board);
	
	
	
	/**
	 * replyController에서 replyCnt increase 트랜잭션
	 */
	void increaseReplyCnt(int boardNo);
	
	
	
}
 