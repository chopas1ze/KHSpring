package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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
			   dao.boardCntMethod(bno);
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
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto,HttpServletRequest request) {
		if(rdto.getFilename()!=null){
			
		//기존 첨부파일명
		String filename = dao.replyUploadMethod(rdto.getRno());
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		
		MultipartFile file = rdto.getFilename();
		//수정할 첨부파일이 있으면
		if(!file.isEmpty()){
			// 중복파일명을 처리하기 위해서 난수발생
			UUID random = UUID.randomUUID();
			
			//기존 첨부파일이 있으면...
			if(filename!=null){
				File fe = new File(saveDirectory, filename);
				fe.delete();
			}
			
			String fileName = file.getOriginalFilename();
			rdto.setRupload(random + "_" + fileName);
			
			File ff = new File(saveDirectory, random+"_"+fileName);
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
			   dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	};	
	
	/////////////////////////////수정본///////////////////////////////
	
	@Override
	public void doubleDeleteProcess(ReplyDTO rdto, HttpServletRequest request) {
		//리플이 있으면...
		if(rdto.getBno()!=0){
			List<ReplyDTO> rnoList = dao.replyListMethod(rdto.getBno());
			//리플 리스트
			for(int i=0;i<rnoList.size();i++){
				//첨부파일이 있으면..
				if(rnoList.get(i).getRupload()!=null){
					
					String filename = dao.replyUploadMethod(rnoList.get(i).getRno());
					String root = request.getSession().getServletContext().getRealPath("/");
					String saveDirectory = root + "temp" + File.separator;
					MultipartFile file = rnoList.get(i).getFilename();
					
					File fe = new File(saveDirectory, filename);
					fe.delete();
				}//end if
				
				//리플 삭제
				dao.replyDeleteMethod(rnoList.get(i).getRno());
				
			}//end for
			
			//제목글삭제
			dao.boardDeleteMethod(rdto.getBno());
			
		}//end if
			
	};//end doubleDeleteProcess()
	
	
	@Override
	public BoardDTO boardUpdateProcess(BoardDTO bdto) {
			dao.boardUptMethod(bdto);
		return dao.boardViewMethod(bdto.getBno());
	};

	@Override
	public void boardInsertProcess(BoardDTO bdto) {
			dao.boardInsertMethod(bdto);
	}
	
}//end class
