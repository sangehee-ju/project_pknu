package pj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class SpringDAO_Im implements SpringDAO {

	private JdbcTemplate jdbcTemplate = null;
	public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

	@Override
	public List<SpringVO> findAll() throws Exception {
		
		RowMapper<SpringVO> rm = new RowMapper<SpringVO>() {
			
			@Override
			public SpringVO mapRow(ResultSet rs, int idx) throws SQLException {
				return null;
			}
		};
		return null;
	}
	
	// 사용자 등록 메소드
	@Override
	public int register(SpringVO vo, String mode) throws Exception {
		PreparedStatementSetter pss = null;
		String sql = null;
		
		if(mode.equals("customer")) {
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement stmt) throws SQLException {
					// TODO Auto-generated method stub
					stmt.setString(1,vo.getCusid());
					stmt.setString(2, vo.getCuspw());
					stmt.setString(3, Util.change(vo.getCusname()));
					stmt.setString(4, Util.change(vo.getCusaddr()));
					stmt.setInt(5,vo.getCusphone());
					stmt.setString(6,vo.getCusmail());
					stmt.setInt(7,vo.getCusresid());
				}
			};
			sql = "insert into customer_T values (?,?,?,?,?,?,?)";
		}else if(mode.equals("seller")) {
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement stmt) throws SQLException {
					// TODO Auto-generated method stub
					stmt.setString(1,vo.getSelid());
					stmt.setString(2, vo.getSelpw());
					stmt.setString(3, Util.change(vo.getSelname()));
					stmt.setInt(4, vo.getSelnum());
					stmt.setInt(5, vo.getSelphone());
					stmt.setString(6, Util.change(vo.getSeladdr()));
					stmt.setString(7, Util.change(vo.getRepname()));
				}
			};
			sql = "insert into seller_T values (?,?,?,?,?,?,?)";
		}
		
		int uc = jdbcTemplate.update(sql, pss);
		return uc;
	}
	@Override
	public boolean login(SpringVO vo, String mode) throws Exception {
		 String sql = null;
		 String pw = null;
		 boolean res = false;
		 if(mode.equals("cus")) {
			 try {
				 sql = "select cuspw from customer_T where cusid = ?";
				 pw = jdbcTemplate.queryForObject(sql,new Object[] {vo.getCusid()}, String.class);
				 if((pw!=null) && (pw.equals(vo.getCuspw()))) {
					 res = true;
				 }
			 }catch(Exception e) {
				 
			 }
		 }
		 else if(mode.equals("sel")) {
			 try {
				 sql = "select selpw from seller_T where selid=?";
				 pw = jdbcTemplate.queryForObject(sql,new Object[] {vo.getSelid()}, String.class);
				 if((pw!=null) && (pw.equals(vo.getSelpw()))) {
					 res = true;
				 }
			 }
			 catch(Exception e) {
				 
			 } 
		 }
		 
		 return res;
	}
}
