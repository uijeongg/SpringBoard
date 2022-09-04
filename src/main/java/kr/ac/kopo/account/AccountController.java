package kr.ac.kopo.account;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.member.MemberVO;


@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;


	/**
	 * 0. joinMybank
	 */
	@GetMapping("/joinMybank")
	public String joinMybank() {
	
		return "/account/joinMybank";
	}
	
	
	
	
	
	
	
	/**
	 * 1. 전환 가능한(로그인 회원) 전체 계좌 조회
	 * index에서 accountList.jsp 들어가줘 요청
	 * @param request
	 * @param loginVO
	 * @return
	 */
	@GetMapping("/accountList")
	public String allAccount(HttpServletRequest request, MemberVO loginVO) {
		
		//로그인 한 회원만의 계좌리스트를 뽑아야 함
		HttpSession session = request.getSession(); //session에 저장했던 로그인 정보 MemberVO
		loginVO = (MemberVO)session.getAttribute("loginVO"); //session에 담기면 object형이 되므로 memberVO형으로 형변환
		request.setAttribute("loginVO", loginVO);

		
		
		List<AccountVO> accountList = new ArrayList<>();
		accountList = accountService.getAllAccount(loginVO.getId()); //요청 들어왔고 -> 메소드 실행 되면 -> 서비스 구동 되어야지 
												 //-> getAllAccount로 어카운트리스트 다 가져옴 -> 그걸 accountList에 저장
		//getAllAccount()하러 갈 때 loginVO에 담긴 id를 가지고 가야 로그인 세션에 담긴 회원인지를 알지!!
		
		request.setAttribute("accountList", accountList); //request에 accountList를 저장해주자
		
		
		/*
		 * 로그인 정보를 가지고 넘어갔으니까, accountMapper에서 parameterType을 String(id)로 해줬고, 
		 * 그에 따라서 이에 관련한 service, dao 모두 다 파라미터에 id를 달고 다님!!
		 */
		
		
		return "/account/accountList";
	}
	
	
	

	/**
	 * 2. 전환할 통장 선택 -> 전환하기 버튼 submit
	 * accountList.jsp에서 전환할 통장 선택하고 changing.jsp로 가기
	 */
	  @PostMapping("/changing") 
	  public String changing(HttpServletRequest request) {

		  String checkAccountNo = request.getParameter("checkAccountNo");
		  System.out.println("checkAccountNo : " + checkAccountNo); //라디오버튼으로 받아온 전환할 통장의 계좌번호
		  //이제 where절에 이 계좌번호를 넣어서 거기에 맞는 t_account 정보를 changing.jsp에 출력해주자! mapper.xml 고고
			/* request.setAttribute("checkAccountNo", checkAccountNo); */
		  
	
		  AccountVO accountOne = new AccountVO();
		  accountOne = accountService.getOneAccount(checkAccountNo);
	
		  request.setAttribute("accountOne", accountOne); //request에 accountOne을 저장해주자
			
		  
		  
		  
	  		//전환하기 버튼이면 
	  		return "/myBank/changing";
	  
	  		//돌아가기 버튼이면 
	  		//return "redirect:/"; 
	  }
	  
	
}
