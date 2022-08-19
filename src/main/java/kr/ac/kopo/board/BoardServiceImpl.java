package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //BoardServiceImpl 얠 나중에 서비스로 써야하니까 service 어노
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	
	/**
	 * 1. 전체게시글조회 모든 board를 가지고 오는 메소드
	 */
	@Override
	public List<BoardVO> getAllBoard() {
	
		List<BoardVO> list = new ArrayList<>();
		list = boardDAO.selectAll();
		
		return list;
	}
	
	
	/**
	 * 2. 상세게시글조회
	 */
	@Override
	public BoardVO getOneBoard(int boardNo) {
		
		BoardVO board = new BoardVO();
		board = boardDAO.selectByNo(boardNo);
		
		return board;
	}


	
	/**
	 * 3. 새글등록
	 */
	@Override
	public void writeOneBoard(BoardVO board) {
		
		boardDAO.insertBoard(board);
		
	}
	



}
