package service;

import java.util.List;

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
	
	
}//end class
