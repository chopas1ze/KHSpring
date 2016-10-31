package part02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

	public NoticeController() {
	}

	
	@RequestMapping("/noticeList.do")
	public String process(){
		return "part02/noticeList";
	}
	
	
	
}//end class
