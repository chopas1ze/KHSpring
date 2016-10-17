package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloModelViewController {

	@RequestMapping("/helloModelView.htm")
	public ModelAndView search(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","kim");
		mav.addObject("age",30);
		mav.setViewName("view/part03/helloModelView");
		return mav;
	}//end search()
	
}//end class
