package part06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderInsertController {

	private OrderDao dao;
	
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/orderInsert.htm", method = RequestMethod.GET)
	public String form() {
		return "view/part06/form";  //forward
	}// end form()

	@RequestMapping(value="/orderInsert.htm", method= RequestMethod.POST)
	public String process(OrderDTO dto){
		dao.insertMethod(dto);
		return "redirect:/orderList.htm";  
		
	}
	
}// end class
