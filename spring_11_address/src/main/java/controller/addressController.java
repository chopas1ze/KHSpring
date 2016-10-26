package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addressController {

	@RequestMapping("/address.do")
	public String process(){
		
		return "view/address";
	}
}//end class
