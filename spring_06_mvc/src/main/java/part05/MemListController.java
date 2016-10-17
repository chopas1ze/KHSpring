package part05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemListController {

	private MemDao dao;
	
	public void setDao(MemDao dao) {
		this.dao = dao;
	}
		
		@RequestMapping("/memList.htm")
		public ModelAndView list(){
			ModelAndView mav = new ModelAndView();
			mav.addObject("aList",dao.listMethod());
			mav.setViewName("view/part05/list");
			return mav;
		}
	
	
		
	
}//end class
