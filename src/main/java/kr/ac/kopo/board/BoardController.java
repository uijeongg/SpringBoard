package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired //멤버변수로 보드서비스 가지고 있어야지 계속 써야하니까!
	private BoardService boardService;
	
	
	/**
	 * 1. 전체 게시글 조회 핸들러
	 * @param request
	 * @return
	 */
	@RequestMapping("/board") //요청이 왔을 때 거기에 맞는 맵핑을 해줘야함 localhost:8080/springboard/board
	public String allboard(HttpServletRequest request) { //여기서의 데이터를 request로 인자를 전달해주자!
		
		List<BoardVO> boardlist = new ArrayList<>();
		boardlist = boardService.getAllBoard(); //요청 들어왔고 -> 메소드 실행 되면 -> 서비스 구동 되어야지 
												 //-> getAllBoard로 보드리스트 다 가져옴 -> 그걸 boardlist에 저장
		request.setAttribute("boardlist", boardlist); //request에 boardlist를 저장해주자
		
		
		return "board/list"; //board라는 요청이 들어오면 WEB-INF/jsp/board/list.jsp 로 리턴해~
	}
	
	
	
	/**
	 * 2-1. 상세 게시글 조회 핸들러
	 * @param no
	 * @param model
	 * @return
	 */
	//uri로 /board/detail?boardNo=3 이 들어왔을 때 처리해줘
	//@RequestMapping("/board/detail")
	public String detail(@RequestParam("boardNo") int no, Model model) {
						//boardNo를 받으면 니가 알아서 int형의 no로 바꿔줘 -> 얘 덕에 request 필요 x
		 				//공유영역에 저장을 위해 model 사용
		
		//db에 가서 3번 .. 번호에 맞는 게시글 불러오기 - (boardMapper에서) select문 이용

		
		//boardService야 3번 게시글 불러와줘
		BoardVO board = boardService.getOneBoard(no);
		model.addAttribute("board", board); //리퀘스트영역에 board 저장
		
		//WEB-INF/jsp/board/detail.jsp
		return "/board/detail";
	}



	/**
	 * 2-2. 상세 게시글 조회 핸들러
	 * @param no
	 * @param model
	 * @return
	 */
	//uri로 /board/detail/{boardNo}로 들어오게 해보자
	@RequestMapping("/board/detail/{boardNo}")
	public String detail2(@PathVariable("boardNo") int no, Model model) {
				  //"/board/detail/{boardNo}"에서 {boardNo}라고 썼기 때문에 @Pathvariable이 가능한 것
			
		//아래는 다 동일
		
		//boardService야 3번 게시글 불러와줘
		BoardVO board = boardService.getOneBoard(no);
		model.addAttribute("board", board); //리퀘스트영역에 board 저장
			
		//WEB-INF/jsp/board/detail.jsp
		return "/board/detail";
	}


	
	/**
	 * 3-1. 새글 등록 핸들러 - get : write.jsp 페이지를 열어달라!
	 * @return
	 */
	@GetMapping("/board/write")  //http://localhost:8080/springboard/board/write
	public String writeGet() {
				
		return "board/write";
		//@GetMapping 요청uri랑 리턴값이 같으면 void로 해줘도 됨! -> return 없어도 된다는 말
		
	}
	
	
	
	/**
	 * 3-2. 새글 등록 핸들러 - post : write.jsp에서 '새글등록' 버튼을 눌러서 새글을 등록시켜라!
	 * @param board
	 * @return
	 */
	@PostMapping("/board/write")
	public String writePost(BoardVO board) {
							//인자로 객체를 받아오고 싶으면 requestParam없이 그냥 인자를 받아오면 됨
							//write.jsp에서 table 안에 받아온 그거 받아온다는 말임
		
		/*
		 * 여기서 해야할 일
		 * 1. DB에 insert 작업 ----------> boardMapper로 이동!
		 * 2. 완료 후에 list로 redirect
		 * 하러가라!!
		 */
		
		boardService.writeOneBoard(board);
		
		return "redirect:/board"; //새글등록이 성공하면 board list로!
	}

}
