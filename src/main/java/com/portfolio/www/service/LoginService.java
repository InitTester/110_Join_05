package com.portfolio.www.service;

import java.util.HashMap;

import com.portfolio.www.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	/* 로그인 체크 */
	public int login(HashMap<String,String> params) {
		return loginDao.idCheck(params.get("name"));		
	}
}
