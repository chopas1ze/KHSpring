package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@RequestMapping("/chat.do")
	public String Chat(HttpSession session) {
		String id = (String) session.getAttribute("memid");
		session.setAttribute("memid", "aaa");
		return "chat";
	}
}
