package kr.ac.kopo.board;

import java.util.List;

public interface BoardService {

	
	/**
	 * 1. 전체게시글조회
	 * @return
	 */
	List<BoardVO> getAllBoard();
	
	//BoardVO getOneBoard();

	/**
	 * 2. 상세게시글조회
	 */
	BoardVO getOneBoard(int boardNo);
	
	
	/**
	 * 3. 새글등록
	 */
	void writeOneBoard(BoardVO board);
}

