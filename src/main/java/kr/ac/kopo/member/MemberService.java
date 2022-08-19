package kr.ac.kopo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	
	
	public MemberVO login(MemberVO member) {  //가지고 있는 값 여기는 dao와 동일하게
		
		//사용할 dao 호출
		MemberVO authMember =
				memberDAO.selectMember(member);
		
		return authMember;		
	}
	
}



