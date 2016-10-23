package part05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemInsertController {
	private MemDao dao;
	
	public void setDao(MemDao dao) {
		this.dao = dao;
	}
	
	
	
	@RequestMapping(value="/memInsert.htm", method=RequestMethod.GET)
	public String form(){
		return "view/part05/memForm";  //forward
	}


	@RequestMapping(value="/memInsert.htm", method=RequestMethod.POST)
	public String process(MemDTO dto){
		dao.insertMethod(dto);
		return "redirect:/memList.htm";  //redirect
	}
	
	
	
}//end class
