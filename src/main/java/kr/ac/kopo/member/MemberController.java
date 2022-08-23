package kr.ac.kopo.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"loginVO", "loginmsg"}) //모델아 loginVO 세션에 등록해줘
@Controller
public class MemberController {

	@Autowired //controller는 service를 호출해서 사용하니까
	private MemberService memberService;
	
	
	
	/**
	 * 1-1. 로그인 - get
	 * memberController에서 get으로 login이 들어오면 뭘 해야하는가
	 * 로그인 페이지로 가줘! -> 갈 때 로그인폼에 입력값이 어떤 값인지 알고 가야한다
	 */
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		
		//spring form tag에서 사용할 memberVO를 공유영역에 등록시켜주는 작업 필요
		request.setAttribute("memberVO", new MemberVO());
		
		return "/member/login";  //WEB-INF/jsp/member/login.jsp
		
	}
	
	
	
	/**
	 * 1-2. 로그인 - post
	 * 로그인버튼을 눌렀을 때 실행될 핸들러
	 * 로그인 입력값을 입력하면 -> 그걸 db작업 -> id/pw가 유효하니? -> yes : board list로
	 * 												   -> no : 다시 login.jsp
	 */
	@PostMapping("/login")
	public String login(@Valid MemberVO member, BindingResult result, Model model, HttpSession session) {
							  //요청으로 member를 받고, result로 null 체크
			
		
//		System.out.println(result); //null이 있나요
//		System.out.println(member);		
		
		/*
		 * 1.MemberVO의 member가 null값이 아닌 valid한 값이 들어왔는가 확인
		 * -> BindingResult를 가지고 확인
		 * 2-1. null값을 가진 error값이 들어온 경우 forward member/login.jsp ㄱㄱ    -> hasError
		 * 2-2. 정상값이 들어온 경우, id/ pw가 유효한지 select문으로 체크				 -> else
		 * 	2-2-1) 유효한 id/pw - db존재하는 애
		 * 		-> "welcome! ***님 반갑습니다" 띄워주고
		 *         session에 해당 유효한 memberVO를 등록
		 * 		     
		 *  2-2-2) 유효하지 않을 때 - db존재하지 않는 애
		 *  	-> 사용자에게 메시지로 id/pw가 유효하지 않으니 다시 입력하세요 라고 보여주고, 
		 *  	   다시 로그인창으로 가야함 -> forward member/login.jsp
		 *  
		 * 3. interceptor (에다가 로그인했는지 확인해봐!)
		 */
		

		
		//null이 있으면 true 없으면 false
		if(result.hasErrors()) {
			//null o -> 다시 입력하세요
			
			return "member/login";
			
		} else {
			//null x -> 로그인 성공 -> db작업. id/pw 유효한 사용자인지 확인
//			System.out.println("테스트" + member);
			
			MemberVO authMember = 
							memberService.login(member);
			
			System.out.println("로그인 성공 정보 : " + authMember );
			
			
				if(authMember == null) {
					//id, pw가 유효하지 않은 경우 -> 다시 입력
					
					model.addAttribute("loginmsg", "로그인 정보가 올바르지 않습니다");
					//Model model은 spring form 태그랑 짝궁이라고 생각해
					
					//session.setAttribute("loginmsg", "로그인 정보가 올바르지 않습니다");
					
					return "member/login";
					
				} else {
					//id, pw가 유효한 경우 -> 로그인 성공 -> 세션에 로그인정보 저장해야지
					
					//세션등록 방법 1
					session.setAttribute("loginVO", authMember);
					
					//세션등록 방법2
					//이건 사용하려면 controller에 @SessionAttributes("loginVO")붙여줘야함
					//model.addAttribute("loginVO", authMember);
					
				
					
					//return "redirect:/board";
					//dest를 세션에 저장해놨으니까 이거 말고 이렇게도 가능
					String dest = (String)session.getAttribute("dest");
				
					
					
					
					//로그인 한 한 상태로 새글등록 이런거 눌러서 로그인으로 넘어가게 하는거 말고
					//처음부터 정직하게 로그인 한 사람들까지도 싹 다 페이지가 막히는 함정 풀어주기
					if(dest==null) {
						return "redirect:/";
					} else {
						return "redirect:" + dest;
					}
					
				}
			
				}
		}

	
	
	
	
	
	
	/**
	 * 2. 로그아웃
	 */
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
 // public String logout(HttpSession session) {
				  //로그인 세션 정보를 '가지고 있고', 그걸 지우는게 목적
		
		
		//session.invalidate();
		//원랜 이건데 이거 말고 SessionStatus 써보자
		
		sessionStatus.setComplete();  //invalidate()랑 같은 기능!!
		
		System.out.println("로그아웃 성공");
		return "redirect:/";
	}
	
	
	
	
}


