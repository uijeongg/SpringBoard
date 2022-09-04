package kr.ac.kopo.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	
	/**
	 * 1. 댓글 입력
	 * db에 insert
	 */
	@ResponseBody
	@PostMapping("/reply")
	public void insert(ReplyVO replyVO) { //insert라는 핸들러에 replyVO받아오고
		System.out.println("들어와?");
		System.out.println(replyVO + "들어왔나요!!");
		replyService.insert(replyVO); 
	}
	
	
	
	/**
	 * 2. reply/{boardNo}이라는 요청이 get으로 들어왔을 때
	 * 에이젝스 단에서 넘겨준 해당글번호인 {boardNo}를 받아서 그 글에 해당하는 댓글만 getAll 
	 */
	@ResponseBody //리턴값인 replylist를 json형태로 
	@GetMapping("/reply/{boardNo}") 
	public List<ReplyVO> getAllReply(@PathVariable("boardNo") int boardNo) {
			//댓글이 여러개 있을거니까 list형
			//int로 boardNo를 받고 싶다 -> @PathVariable로 받아오기 (URL 경로에 변수를 넣어주는거)
		
		List<ReplyVO> replylist = 
				replyService.selectAllReply(boardNo);
		
		//db작업 ㄱㄱ
		
		return replylist;
	}
	
	
	
}
