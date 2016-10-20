package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
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

	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num){
		ModelAndView mav = new ModelAndView();
		BoardDTO dto = service.contentProcess(num);
		mav.addObject("dto",dto);
		//view.jsp에서 currentPage값을 넘겨준다. 답변 삭제 수정 목록 으로 갈때 필요.
		mav.addObject("currentPage",currentPage);
		mav.setViewName("board/view");
		return mav;
	}//end viewMethod()
	
	@RequestMapping(value = "/write.sb", method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv,BoardDTO dto){ //currentpage와 num,ref,re_step,re_level 값 받아온다.
		ModelAndView mav = new ModelAndView();
		if(dto.getRef()!=0){
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto",dto);
		}
		mav.setViewName("board/write");
		return mav;
	}
	
	@RequestMapping(value = "/write.sb", method = RequestMethod.POST)
	public String writeProMethod(BoardDTO dto, PageDTO pv, HttpServletRequest req){ //리퀘스트 객체가 필요하면 매개변수에 선언하면된다. 스프링에서 제공.
												
							//업로드파일 객체값이 저장되어 있다.
		MultipartFile file = dto.getFilename();
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			//중복 파일명을 처리하기 위해 난수 발생 
			UUID random=UUID.randomUUID();
			String root=req.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			
			/*C:\study\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webdemo\*/
			String saveDirectory = root+"temp"+File.separator;  //File.separator 는 "/" 이다.
			
			//디렉토리 생성 용도
			File fe = new File(saveDirectory);
			if(!fe.exists())
				fe.mkdir();
			
			
			File ff = new File(saveDirectory,random+"_"+fileName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			dto.setUpload(random+"_"+fileName);
		}
		//클라이언트 ip주소 넣기
		dto.setIp(req.getRemoteAddr());

		if(dto.getRe_level()!=0){
			
			service.reStepProcess(dto);
			dto.setRef(dto.getRef());
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}
		
		
		service.insertProcess(dto);
		
		return "redirect:/list.sb";
	}//end writeProMethod()
}//end class
