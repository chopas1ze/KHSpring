package service;

import java.util.List;

import dto.BoardDTO;
import dto.ReplyDTO;

public interface BoardService {
	
	public List<BoardDTO> boardListProcess();	
	public BoardDTO boardViewProcess(int bno);
	public List<ReplyDTO> replyListProcess(ReplyDTO rdto);
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto);
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto);

}//end interface
