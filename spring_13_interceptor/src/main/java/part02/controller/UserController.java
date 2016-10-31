package part02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import part02.dto.personDTO;

@Controller
public class UserController {

	public UserController() {}
	
	
	@RequestMapping("/login.do")
	public String loginProcess(){
		return "part02/loginForm";
	}//end loginProcess()
	
	@RequestMapping("/logpro.do")
	public String logCheckProcess(personDTO dto, HttpSession session,HttpServletRequest req){
		
		if(dto.getId().equals("kim") && dto.getPass().equals("1234")){
			session.setAttribute("chk", dto.getId());
			String url = req.getParameter("returnUrl");
			if(url!=null){
				return "redirect:/"+url;
			}
			else{
				return "redirect:/index.do";
			}
		}
			return "redirect:/login.do";
	}//end logCheckProcess()
	
	@RequestMapping("/logout.do")
	public String logoutProcess(HttpSession session){
		session.removeAttribute("chk");
		return "redirect:/index.do";
	}
	
	
}//end class
