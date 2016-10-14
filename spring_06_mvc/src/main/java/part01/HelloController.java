package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://127.0.0.1:8090/springmvc/hello.htm

//서블릿 상속받지않고 Controller만 설정하면 끝.
@Controller
public class HelloController {
	
		@RequestMapping("/hello.htm")
		public String search(){
			
			return "view/part01/hello";
		}//end search()
		
}//end class

// src/main/webapp 에는 정적페이지에 저장. html,css,js등
// src/main/web-inf에는 jsp는  클라이언트가 url을 통해 직접 jsp을 호출하지 못하게 하기위해(보안) web-inf에 저장한다.