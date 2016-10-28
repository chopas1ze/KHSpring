package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.support.TransactionTemplate;

import dao.BoardDao;
import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardServiceImp implements BoardService {
	private BoardDao dao;
	
	public BoardServiceImp() {
	}
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BoardDTO> boardListProcess() {
		
		return dao.boardListMethod();
	}

	@Override
	public BoardDTO boardViewProcess(int bno) {
		return dao.boardViewMethod(bno);
	}

	@Override
	public List<ReplyDTO> replyListProcess(ReplyDTO rdto) {
		dao.replyInsertMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}
	
	@Override
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto,HttpServletRequest request) {
		String upload = dao.replyUploadMethod(rdto.getRno());
		System.out.println(upload);
		if(upload != null){
			String root = request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			File fe = new File(saveDirectory, upload);
			fe.delete();
		}
		
			dao.replyDeleteMethod(rdto.getRno());
		return dao.replyListMethod(rdto.getBno()); 
	}
	
	@Override
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto) {
			  dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}
	
}//end class
