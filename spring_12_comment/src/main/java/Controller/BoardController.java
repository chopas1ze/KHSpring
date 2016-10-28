package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.ReplyDTO;
import service.BoardService;

@Controller
public class BoardController {
	
	private BoardService service;
	
	public BoardController() {
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping("/boardlist.do")
	public ModelAndView boardListPage(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",service.boardListProcess());
		mav.setViewName("boardList");
		return mav;
	}//end boardListPage()
	
	@RequestMapping("/boardView.do")
	public ModelAndView boardViewPage(int bno){
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", service.boardViewProcess(bno));
		//mav.setViewName("boardView");
		mav.setViewName("boardView2");
		return mav;
	}//end readPage()
	
	@RequestMapping("/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto, HttpServletRequest req){
		if(rdto.getFilename()!=null){
		
		MultipartFile file = rdto.getFilename();
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			UUID random=UUID.randomUUID();
			String root=req.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			
			/*C:\study\workspace_spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring_07_board\temp */
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
			
			rdto.setRupload(random+"_"+fileName);
			
		}
		}
		
		return service.replyListProcess(rdto);
	}//end replyListPage()
	
	@RequestMapping("/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto,HttpServletRequest request){
		System.out.println(rdto.getRupload());
		
		return service.replyDeleteProcess(rdto,request);
	}//end replyDeleteListPage()
	
	@RequestMapping("/replyUpdate.do")
	public @ResponseBody List<ReplyDTO> replyUpdateListPage(ReplyDTO rdto){
		return service.replyUpdateProcess(rdto);
	}//end replyUpdateListPage()
	
	
	@RequestMapping("/contentdownload.do")
	public ModelAndView downMethod(ReplyDTO rdto){
		ModelAndView mav = new ModelAndView();
		mav.addObject("rno",rdto.getRno());
		mav.setViewName("download");
		return mav;
	}
		//하나의 뷰에 하나의 값은 생성자를 통해서 가능
							//       뷰		  모델명 모델값
		//return new ModelAndView("download","num",num);
	
	
}//end class
