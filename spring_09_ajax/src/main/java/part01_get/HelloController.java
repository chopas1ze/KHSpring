package part01_get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String form(){
		return "part01_get/start";
	}
	
	@RequestMapping("/customer.do")
	public ModelAndView process(String name){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("part01_get/result");
		return mav;
	}//end process()

}//end class
