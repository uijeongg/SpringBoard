package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.MemberVO;

public class LoginInterceptor implements HandlerInterceptor{
							  //interceptor 쓰려면 HandlerInterceptor 상속 받아야함!
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		/*
		 * System.out.println("preHandle 동작");
		 * System.out.println("handler : " + handler);
		 * return true;
		 * return true는 요청 받아서 handler에게 넘겨주는 것. 
		 * return false는 작동하지(보이지) 않음. prehandle이 요청을 가지고 있어서 (몽땅 다 막고 있어서)
		 */
		
		
		//로그인 정보는 request가 아니까 리퀘스트가 가진 정보 찍어보기
		System.out.println("contextPath : " + request.getContextPath());
		System.out.println("uri : " + request.getRequestURI());
		System.out.println("queryString : " + request.getQueryString());
		
		//uri 너무 기니까 contextPath 잘라내고 뒷부분만 uri로 쓰자
		String dest = request.getRequestURI(); //springboard/board/write/3
		dest = dest.substring(request.getContextPath().length()); //board/write/3
		
		//dest (board/write/3) 얘를 세션에 등록
		HttpSession session = request.getSession();
		session.setAttribute("dest", dest);
		
		
		///////////////////////////////////////////////////////////////////////
		
		
		//로그인 한 회원만 다른 페이지 접근 가능하도록 만들기 -> jsp 들어갈 때 로그인 안했으면 로그인 페이지가 뜸 
		//로그인 한 사용자인지 확인을 위해 세션 받아오기
//		HttpSession session = request.getSession();
		
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO"); //야 세션아 너 loginVO ㅇㅆ냐
		
		if(loginVO == null) {
			//login X -> login 하러 리다이렉트
			response.sendRedirect(request.getContextPath() + "/login");
			return false; //잡고 있지
			
		} else {
			//login 되어 있음 -> 그럼 전체게시글, 상세게시글 다 접근 가능
			return true;
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	//	System.out.println("postHandle 동작");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	//	System.out.println("afterCompletion 동작");
	}
	
	
							  

	
}
