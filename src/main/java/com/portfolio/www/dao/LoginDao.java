package com.portfolio.www.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDao extends JdbcTemplate {
	
	public LoginDao() {}
	
	public LoginDao(DataSource ds) {
		super(ds);
	}
	
	public int idCheck(String username) {		
		String sql = "select count(*) from member where name = ?";		
		return queryForObject(sql, Integer.class, username);
	}

}
