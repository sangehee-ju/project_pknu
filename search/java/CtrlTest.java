package config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CtrlTest {
	
	private SpringDAO springDAO = null;
	
	public SpringDAO getSpringDAO() {
		return springDAO;
	}

	public void setSpringDAO(SpringDAO springDAO) {
		this.springDAO = springDAO;
	}

	@RequestMapping("list.pknu")
	public ModelAndView list() throws Exception{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("view_list");
		mnv.addObject("ls", springDAO.findall());
		return mnv;
	}
	
	@RequestMapping(value="ajax.pknu", method=RequestMethod.GET)
	public void ajax(@RequestParam("keyword") String keyword, HttpServletResponse response) throws Exception{
		
		   System.out.println(keyword); 
		    StringBuffer sb=null;
		    
		    for(SpringVO vo : springDAO.findall()){
		    	String item = vo.getItem();
		    	if(item.indexOf(keyword)!=-1){
		    		if(sb==null){
		    			sb = new StringBuffer();
		    			sb.append("\"").append(Util.encKor(item)).append("\"");
		    		}
		    		else{
		    			sb.append(",");
		    			sb.append("\"").append(Util.encKor(item)).append("\"");
		    		}
		    	}
		    }
		    
		    String list = (sb!=null)?sb.toString() : "";
		    String json = "{\"key\":["+list+"]}";
		    
		    response.getWriter().print(json);
	}
}

