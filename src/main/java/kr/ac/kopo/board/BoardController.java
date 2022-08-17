package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@Autowired //멤버변수로 보드서비스 가지고 있어야지 계속 써야하니까!
	private BoardService boardService;
	
	
	
	@RequestMapping("/board") //요청이 왔을 때 거기에 맞는 맵핑을 해줘야함 localhost:8080/springboard/board
	public String allboard(HttpServletRequest request) { //여기서의 데이터를 request로 인자를 전달해주자!
		
		List<BoardVO> boardlist = new ArrayList<>();
		boardlist = boardService.getAllBoard(); //요청 들어왔고 -> 메소드 실행 되면 -> 서비스 구동 되어야지 
												 //-> getAllBoard로 보드리스트 다 가져옴 -> 그걸 boardlist에 저장
		request.setAttribute("boardlist", boardlist); //request에 boardlist를 저장해주자
		
		
		return "board/list"; //board라는 요청이 들어오면 WEB-INF/jsp/board/list.jsp 로 리턴해~

	}
	
}
