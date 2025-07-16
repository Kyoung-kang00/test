package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.common.UserDTO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.biz.user.impl.UserService;

@Controller
public class LogController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login.do" , method = RequestMethod.GET)
	public String login() {
		
		return "board/login";  //  /WEB-INF/views/+board/login+.jsp
	}
	//로그인으로
	@RequestMapping(value = "/login.do" , method = RequestMethod.POST)
	public String login(UserDTO vo, HttpSession session) throws Exception {
		
		System.out.println("로그인 인증처리");
		
		/*
		 * // 1. ID입력여부 체크 if (vo.getId() == null || vo.getId() == "") {
		 * 
		 * throw new IllegalAccessException("아이디는 반드시 입력하셔야 합니다");
		 * 
		 * }
		 * 
		 * // 2. 0으로 나눠보자 int num1 = 100; int num2 = 0; int sum = num1 / num2; if (sum >
		 * 0) {
		 * 
		 * throw new IllegalAccessException("0으로 나눌 수 없습니다");
		 * 
		 * }
		 */
		
		if(userService.getUser(vo) != null) {
			session.setAttribute("user", userService.getUser(vo));
			
			return "redirect:getBoardList.do";
		}else {
			return "login";
		}
		
	}
	
	//로그아웃
	//@RequestMapping("/logout.do")
}
