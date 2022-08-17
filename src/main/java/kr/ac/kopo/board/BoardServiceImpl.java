package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //BoardServiceImpl 얠 나중에 서비스로 써야하니까 service 어노
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	//모든 board를 가지고 오는 메소드를 만든 것
	@Override
	public List<BoardVO> getAllBoard() {
	
		List<BoardVO> list = new ArrayList<>();
		list = boardDAO.selectAll();
		
		return list;
	}
}
