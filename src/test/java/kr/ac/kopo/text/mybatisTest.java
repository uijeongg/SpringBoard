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

@RunWith(SpringJUnit4ClassRunner.class) //이건 테스트용이다! 여기까지 해주면 junit 돌리기 가능
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class mybatisTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void mybatisT() {
		assertNotNull(sqlSessionTemplate);
	}
	
	@Test
	public void boardSelectAll() {
      List<BoardVO> boardList = sqlSessionTemplate.selectList("board.boardDAO.selectAll");
      	for(BoardVO board : boardList) {
	         System.out.println(board);
	      }
	   }
	
}
