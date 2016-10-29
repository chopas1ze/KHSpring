package dao;

import java.util.List;

import dto.BoardDTO;
import dto.ReplyDTO;

public interface BoardDao {
	public List<BoardDTO> boardListMethod();	
	public BoardDTO boardViewMethod(int bno);
	public void replyInsertMethod(ReplyDTO rdto);
	public List<ReplyDTO> replyListMethod(int bno);
	public void replyDeleteMethod(int rno);
	public void replyUpdateMethod(ReplyDTO rdto);
	public String replyUploadMethod(int rno);
	
	
	/////////////////////////////////수정본///////////////////////////
	
	public void boardDeleteMethod(int bno);
	public void boardCntMethod(int bno);
	public void boardUptMethod(BoardDTO bdto);
	public BoardDTO boardMethod(int bno);
	public void boardInsertMethod(BoardDTO bdto);
}// end class
