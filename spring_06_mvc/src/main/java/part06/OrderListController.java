package part06;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderListController {
	private OrderDao dao;
	
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/orderList.htm")
	public ModelAndView process(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList",dao.selectMethod());
		mav.setViewName("view/part06/list");
		return mav;
	}
	
}
