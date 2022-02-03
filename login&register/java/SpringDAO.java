package pj;

import java.util.*;

import org.springframework.web.servlet.ModelAndView;

public interface SpringDAO {

	public List<SpringVO> findAll() throws Exception; 
	public int register(SpringVO vo, String mode) throws Exception;
	public boolean login(SpringVO vo, String mode) throws Exception;
}
