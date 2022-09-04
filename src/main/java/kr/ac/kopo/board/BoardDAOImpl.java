package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //이 어노 걸어주면 BoardDAOImpl이라는 클래스를 빈으로 하나 만들어줌. 
//나중에 서비스에서 dao 호출할 때 쓰려고
public class BoardDAOImpl implements BoardDAO {

	@Autowired //나 이거 필요하니까 스프링한테 나 이거줘! 하는거 - 마이바티스 쿼리문을 수행해주는 역할
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override  //1. 전체게시글조회
	public List<BoardVO> selectAll() {
		
		List<BoardVO> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("board.boardDAO.selectAll"); 
		//쿼리 날리는 중! selectAll() 쓸거라고 호출 -> list에 담아!
		
		return list;
	}

	
	@Override  //2. 상세게시글조회
	public BoardVO selectByNo(int boardNo) {
							 //받아'오는' 값
		
		BoardVO board = sqlSessionTemplate.selectOne("board.boardDAO.selectByNo", boardNo);		
		 
		return board;
	}
	
	
	@Override  //3. 새글등록
	public void insertBoard(BoardVO board) {
		
		sqlSessionTemplate.insert("board.boardDAO.insertBoard", board); //board를 줘야해
		
	}
	
	
	//댓글 insert 시 해당 글 조회수 +1 트랜잭션
	@Override
	public void increaseReplyCnt(int boardNo) {
		System.out.println("boardNo"+boardNo);
		
		sqlSessionTemplate.update("board.boardDAO.increaseReplyCnt", boardNo);
	}
}
