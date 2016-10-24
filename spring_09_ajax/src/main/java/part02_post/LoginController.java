package part02_post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping("/loginForm.do")
	public String form(){
		return "part02_post/start";
	}
	
	@RequestMapping("/loginPro.do")
	public ModelAndView process(String id, String pass){
			ModelAndView mav = new ModelAndView();
			String chk="";
			if(id.equals("kim") && pass.equals("1234"))
				chk=id+"님 로그아웃";
			else
				chk=id+"님 비회원";

			mav.addObject("chk",chk);
			mav.setViewName("part02_post/result");
			return mav;
	}//end process()
}//end class
