package view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import dao.BoardDaoImp;


//다운로드 창을 띄우기 위한 뷰페이지
public class BoardDownLoadView extends AbstractView{
		private BoardDaoImp dao;
	
	public BoardDownLoadView() {
	}
	
	public void setDao(BoardDaoImp dao) {
		this.dao = dao;
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
						
		int num=Integer.parseInt(request.getParameter("rno"));
		/*System.out.println(num);
		request나 model으로 받으나 같은값
		System.out.println(model.get("num"));*/
		
		
		String root=request.getSession().getServletContext().getRealPath("/");
		//root+"temp/"
		/*C:\study\workspace_spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring_07_board\temp */
		String saveDirectory = root+"temp"+File.separator;
		
		String upload=dao.replyUploadMethod(num);
		String fileName=upload.substring(upload.indexOf("_")+1);
		
		//파일명이 한글일때 인코딩 작업을 한다.(다운로드창에 깨져나옴. 브라우저에 따라 다르기때문에 판단해야함)
		String str=URLEncoder.encode(fileName,"UTF-8");
		//원본파일명에서 공백이 있을 때 +로 표시가 되므로 공백으로 처리해줌
		str=str.replaceAll("\\+","%20");
		
		//컨텐트 타입
		response.setContentType("application/octet-stream");
		
		//다운로드창에 보여줄 파일명을 지정한다.
		response.setHeader("Content-Disposition", "attachment;filename="+str+";");
		
		
		//서버에서 저장된 파일을 읽어와 클라이언트에 출력해 준다
		FileCopyUtils.copy(new FileInputStream(new File(saveDirectory,upload)), response.getOutputStream());
		
		
		//파일 크기제한은 jsp에서 스크립트로 처리.
		
	}//end renderMergedOutoutModel()
	
	

}//end class
