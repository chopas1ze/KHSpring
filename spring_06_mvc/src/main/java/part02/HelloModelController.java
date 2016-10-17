package part02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/springmvc/view/part02/HelloModel.htm
@Controller
public class HelloModelController {
//이방법은 사용하진 않으니 잊길바람
	@RequestMapping("/view/part02/HelloModel.htm")
	public Model search(){
		Model model = new ExtendedModelMap();
		model.addAttribute("id","korea");
		return model;
	}
	
}//end class
