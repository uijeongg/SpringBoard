package kr.ac.kopo.text;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.BoardVO;
import kr.ac.kopo.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class) //이건 테스트용이다! 여기까지 해주면 junit 돌리기 가능
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class mybatisTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Test
	public void mybatisT() {
		assertNotNull(sqlSessionTemplate);
	}
	
	
	
	@Test  //전체게시글조회
	public void boardSelectAllTest() {
      List<BoardVO> boardList = sqlSessionTemplate.selectList("board.boardDAO.selectAll");
      	for(BoardVO board : boardList) {
	         //System.out.println(board);
	      }
	   }
	
	
	@Test  //상세게시글조회
	public void boardSelectByNoTest() {
		BoardVO board = sqlSessionTemplate.selectOne("board.boardDAO.selectByNo", 3);
		
		//System.out.println(board);
	}
	
	
	@Test  //새글등록
	public void boardInsertTest() {
		BoardVO board = new BoardVO();
		
		//가짜 데이터 insert 해줘보는게 test
		//board.setNo(1);
		board.setTitle("제목2");
		board.setWriter("작성자2");
		board.setContent("내용2");
		
		//board를 가지고 쿼리문을 날린다!
		sqlSessionTemplate.insert("board.boardDAO.insertBoard", board);
		
		//파라미터가 필요한 애들은 , 뒤로 넘겨줌
	}
	
	
	
	@Test  //로그인
	public void selectMemberTest() {
		
		MemberVO member = new MemberVO();
		member.setId("user");
		member.setPassword("user");
		
		//여기 밑에 ,member를 하나 만들어준것 근데 얘가 디비에 잇어야지 애초에 
		MemberVO authMember = sqlSessionTemplate.selectOne("member.memberDAO.selectMember", member);
		
		System.out.println(authMember);
		
	}
}
