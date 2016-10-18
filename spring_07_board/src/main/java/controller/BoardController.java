package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.PageDTO;
import service.BoardService;

@Controller
public class BoardController {
	private BoardService service;
	private int currentPage;
	private PageDTO pdto; 
	
	public BoardController() {
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/list.sb")
	public ModelAndView listMethod(PageDTO pv){
		//객체로 받으면 첫 접속일떄 null값이어도 오류가 없다. 내부에서 0으로 처리
		//객체로 받지 않으면  null 오류가 떠서 if를 사용하여 page초기값을 지정해야 한다.
		ModelAndView mav = new ModelAndView();
		
		int totalRecord = service.countProcess();
		if(totalRecord >=1 ){
			if(pv.getCurrentPage()==0)
				currentPage=1;
			else
				currentPage=pv.getCurrentPage();
				
			pdto = new PageDTO(currentPage,totalRecord);
			
			//list.jsp에서 페이지번호를 사용하기위해 pdto를 넘겨준다.	
			mav.addObject("pv",pdto);
			mav.addObject("aList",service.listProcess(pdto));	
		}
		mav.setViewName("board/list");
		return mav;
	}//end listMethod()

}//end class
