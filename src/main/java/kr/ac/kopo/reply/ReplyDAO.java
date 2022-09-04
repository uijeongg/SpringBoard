package kr.ac.kopo.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//1. 댓글 입력 - 입력만 하고 가져와서 보여줄건 없으니까 void
	public void insert(ReplyVO replyVO) {
		sqlSessionTemplate.insert("reply.ReplyDAO.insert", replyVO);
		
	}
	
	
	//2. (해당글) 댓글 보기
	public List<ReplyVO> selectAll(int boardNo) {
		
		List<ReplyVO> list =
				sqlSessionTemplate.selectList("reply.ReplyDAO.selectAll", boardNo);
		
		return list;
	}
	
	 
}
