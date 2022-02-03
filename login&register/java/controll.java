package pj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pj.SpringVO;

@Controller
public class controll {
	
	private JdbcTemplate jdbcTemplate = null;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
	public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	
	// 오류 발생으로 변경
	private SpringDAO_Im springDao = null;
	public SpringDAO_Im getSpringDao() {
		return springDao;
	}
	public void setSpringDao(SpringDAO_Im springDao) {
		this.springDao = springDao;
	}
	
	//==================== return type : ModelAndView ==================== 
	@RequestMapping( "/~.pj" )
	public ModelAndView list() throws Exception {
		
		ModelAndView mnv = new ModelAndView();
		
		mnv.setViewName( "~.jsp" );
		mnv.addObject( "list", springDao.findAll() );
		
		return mnv;
	}
	
	// 사용자 등록하는 메소드
	@RequestMapping("/register.pj")
	public ModelAndView register() throws Exception{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("account");
		return mnv;
	}
	
	@RequestMapping("/login.pj")
	public ModelAndView login() throws Exception{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login");
		return mnv;
	}
	
	@RequestMapping("/main.pj")
	public ModelAndView main() throws Exception{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("main");
		return mnv;
	}
	
	//======================================= 기능 수행 redirect =======================================
	//사용자 등록
	// 소비자
	@RequestMapping("/cusaccount.pj")
	public String cusaccount(final @ModelAttribute SpringVO vo, HttpSession session) throws Exception{
		springDao.register(vo, "customer");
		return "redirect:login.pj";
	}
	
	//판매자
	@RequestMapping("/selaccount.pj")
	public String selaccount(final @ModelAttribute SpringVO vo, HttpSession session) throws Exception{
		springDao.register(vo, "seller");
		return "redirect:login.pj";
	}
	
	//로그인 기능 수행
	// 사용자 로그인
	@RequestMapping("/cuslogin.pj")
	public String cusLogin(@ModelAttribute SpringVO vo, HttpSession session) throws Exception{
		boolean res = springDao.login(vo, "cus");
		if(res) {
			session.setAttribute("userid", vo.getCusid());
			return "redirect:main.pj";
		}
		else {
			return "redirect:login.pj?e_code=fail_to_login";
		}
	}
	
	//판매자 로그인
	@RequestMapping("/sellogin.pj")
	public String selLogin(@ModelAttribute SpringVO vo, HttpSession session) throws Exception{
		boolean res = springDao.login(vo, "sel");
		if(res) {
			return "redirect:main.pj";
		}
		else {
			return "redirect:login.pj?e_code=fail_to_login";
		}
	}
}
