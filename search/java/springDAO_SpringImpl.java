package config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class springDAO_SpringImpl implements SpringDAO{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<SpringVO> findall() throws Exception {
		
		RowMapper<SpringVO> rm = new RowMapper<SpringVO>() {
			@Override
			public SpringVO mapRow(ResultSet rs, int idx) throws SQLException {
				SpringVO vo = new SpringVO();
				vo.setNo(rs.getInt("no"));
				vo.setItem(rs.getString("item"));
				return vo;
			}
		};
		
		
		List<SpringVO> l = jdbcTemplate.query("select * from item",rm);
		if(l!=null) {
			System.out.println("Complete!");
		}
		return l;
	}

}
