package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService{
	private BoardDAO dao;
	
	public BoardServiceImp() {
	}
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
			
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
			dao.save(dto);
	}

	@Override
	public BoardDTO contentProcess(int num) {
		dao.readCount(num);
		return dao.content(num);
	}

	@Override
	public void reStepProcess(BoardDTO dto) {
		dao.reStepCount(dto);
		dto.setRe_step(dto.getRe_step()+1);
		dto.setRe_level(dto.getRe_level()+1);
		dao.save(dto);
	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		return dao.updateNum(num);
	}

	@Override
	public void updateProcess(BoardDTO dto, HttpServletRequest request) {
		String filename = dao.getFile(dto.getNum());
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		
		MultipartFile file = dto.getFilename();
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
			dto.setUpload(random + "_" + fileName);
			
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
		
		dto.setIp(request.getRemoteAddr());
		
		
		dao.update(dto);
		
	}//end updateProcess

	@Override
	public void deleteProcess(int num, HttpServletRequest request) {
		//첨부파일 삭제
		String upload = dao.getFile(num);
		if(upload != null){
			String root = request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			File fe = new File(saveDirectory, upload);
			fe.delete();
		}
		
		dao.delete(num);
		
	}//end deleteProcess()
	
	
	
}//end class
