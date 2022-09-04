package kr.ac.kopo.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.BoardDAO;

@Service
public class ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	/**1. 댓글 insert
	 * 하기 전에, 트랜잭션도 실행 -> boardDAO 호출해서 detail.jsp 들어가면 조회수 +1
	 * t_board replyCnt = replyCnt+1;
	 * boardNo 줄테니까 3번 게시글에 replyCnt+1 해줘
	 * 
	 * @Transactional 의 이유: 서비스를 여러개 호출할 때 하나만 성공할 수는 없음. 성공한다면 모든게 성공되도록
	 */
	
	@Transactional
	public void insert(ReplyVO replyVO) {	
		replyDAO.insert(replyVO);
		boardDAO.increaseReplyCnt(replyVO.getBoardNo());
	}
	
	
	//2. 해당 글의 모든 댓글 select
	public List<ReplyVO> selectAllReply(int BoardNo) {
		
		List<ReplyVO> list = replyDAO.selectAll(BoardNo);
		return list;
	}
	
}
