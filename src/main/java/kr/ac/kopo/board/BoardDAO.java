package kr.ac.kopo.board;

import java.util.List;

public interface BoardDAO {

	//이 인터페이스에는 selectAll() 메소드가 있어야겠지
	List<BoardVO> selectAll();
}
