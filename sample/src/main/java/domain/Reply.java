package domain;

import java.util.Date;

public class Reply {
	private int replyId;
	private int parentReplyId;
	private int id;
	private String delYn;
	String writer;
	String content;
	Date inst_date;
	
	
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getParentReplyId() {
		return parentReplyId;
	}
	public void setParentReplyId(int parentReplyId) {
		this.parentReplyId = parentReplyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInst_date() {
		return inst_date;
	}
	public void setInst_date(Date inst_date) {
		this.inst_date = inst_date;
	}
}
