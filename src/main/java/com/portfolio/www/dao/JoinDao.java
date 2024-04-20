package com.portfolio.www.dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.slf4j.*;

public class JoinDao extends JdbcTemplate {
	private static final Logger log = LoggerFactory.getLogger(JoinDao.class);
	
	/* 회원가입 쿼리 처리 */
	public JoinDao() {}
	
	public JoinDao(DataSource ds) {
		super(ds);		
		log.info("\n\n ds : "+ds+"\n\n");		
	}
	
	public int idCheck(String username) {		
		String sql = "select count(*) from member where name = ?";		
		return queryForObject(sql, Integer.class, username);
	}
	
	// 회원가입 데이터 등록 
	public int join(HashMap<String,String> params) {
		
		// HashMap으로 전송된 데이터를 추출해서 sql을 완성하자!
		
		// 회원 이름
		String name = params.get("name") ;
		// 회원 비밀번호
		String passwd = params.get("passwd") ;		
		// 회원 이메일
		String email = params.get("email") ;
		
		// insert 구문
		String sql = "INSERT INTO forum.`member` " +
		         "(member_id, passwd, member_nm, email, auth_yn, pwd_chng_dtm, join_dtm, name) " +
		         "VALUES ('', ?, '', ?, '', '', DATE_FORMAT(now(),'%Y%m%d%H%i%s'),?)";
		
//		log.info("\n\n sql : "+sql+"\n\n");
		
		/* JdbcTemplate의 update 메서드 중 아래의 오버라이딩(PreparedStatement)된 메서드를 이용해서 쿼리 실행한다.
		 * 	@Override
			public int update(String sql, @Nullable Object... args) throws DataAccessException {
				return update(sql, newArgPreparedStatementSetter(args));
			}
			해당 메서드의 사용으로 성능과 보안을 좀더 신경썼다
		 * */
		return update(sql, passwd, email, name);
	}
}
