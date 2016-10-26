package dto;

import java.util.Date;
import java.util.List;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private List<ReplyDTO> replyList;
	
	public BoardDTO() {
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public List<ReplyDTO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyDTO> replyList) {
		this.replyList = replyList;
	}
	
	
	
	

}//end class
