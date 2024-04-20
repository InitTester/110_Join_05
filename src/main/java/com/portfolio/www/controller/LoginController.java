package com.portfolio.www.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.www.dao.JoinDao;
import com.portfolio.www.service.JoinService;
import com.portfolio.www.service.LoginService;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(JoinDao.class);
	/*
	 * 로그인 : login.jsp
	 * 회원가입 : join.jsp 
	 * */
	
	// 로그인 화면으로 전환
	@RequestMapping("/join-page.do")
	public String loginPage() {
		return "login";
	}
	
	// joinservice 사용(필드,생성자,메서드)을 위한 의존성 주입
	@Autowired
	private JoinService joinservice;

	// loginservice 사용(필드,생성자,메서드)을 위한 의존성 주입
	@Autowired
	private LoginService loginService;
	
	
	// 회원가입 화면에서 전송된(input) 데이터를 가지고 처리 및 화면출력(output) 전송	   
	@RequestMapping("/sign-up.do")
	public ModelAndView join(@RequestParam HashMap<String,String> params) {
		
		log.info(params.toString());
		
		// joinservice의 join()메서드를 사용해서 회원가입 여부 확인
		int result = joinservice.join(params);
		
		// 처리된 데이터를 뷰에 전송한다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",result);
		
		String msg = "";
				
		if(result ==1) {
			msg = "회원가입 되었습니다." ;
		}else if(result== -1) {
			msg = "회원ID 6자이상 입력해주세요.";
		}else if(result== -99) {
			msg = "중복된 id 입니다.";
		}
		
		// 결과 값이 1이면,"회원가입 되었습니다.", 아니면 "실패"
		mv.addObject("msg", msg);
		mv.setViewName("login");
		
		return mv;
	}
	
	// 회원가입 화면에서 전송된(input) 데이터를 가지고 처리 및 화면출력(output) 전송	   
	@RequestMapping("/login.do")
	public ModelAndView login(@RequestParam HashMap<String,String> params) {
		
		log.info(params.toString());
		
		// 처리된 데이터를 뷰에 전송한다.
		ModelAndView mv = new ModelAndView();
	
		// loginservice의 login()메서드 사용해서 로그인 
		int result = loginService.login(params);
		
		mv.addObject("result",result);			
		mv.addObject("msg", result >= 1 ? "로그인 되었습니다." :"가입된 정보가 없습니다." );
		mv.setViewName("login");
		
		return mv;
	}	
}
