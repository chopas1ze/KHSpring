package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String process(){
		//tiles.xml 에서 definition 으로 지정한 index를 불러온다.
		return "index";
	}
	
	
}//end class
