package dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReplyDTO {

	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private String rupload;
	private MultipartFile filename;
	
	public String getRupload() {
		return rupload;
	}

	public void setRupload(String rupload) {
		this.rupload = rupload;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public ReplyDTO() {
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}//end class
