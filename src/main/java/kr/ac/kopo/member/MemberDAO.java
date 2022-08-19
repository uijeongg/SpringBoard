package kr.ac.kopo.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  //spring이 만들어줘야 하므로 Repository
public class MemberDAO {

	@Autowired  //SqlSessionTemplate는 마이바티스를 불러와주는 애
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public MemberVO selectMember(MemberVO member) { //받아오는값 (가지고 있는 값)
		
		MemberVO authMember = 
				sqlSessionTemplate.selectOne("member.memberDAO.selectMember", member); //주는값
		
		
		return authMember;
	}
	
}


/*
 * 스프링에서 빈 인스턴스가 생성된 이후 
 * @Autowired를 설정한 메서드가 자동으로 호출되고, 인스턴스가 자동으로 주입된다.
 * 즉, 해당 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념
 * @Autowired 는 변수, Setter메서드, 생성자, 일반 메서드에 적용이 가능하며 
 * <property>, <constructor-arg>태그와 동일한 역할을 합니다. 
 */
