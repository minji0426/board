package domain;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int id ;
	private int views;
	private String delYn;
	String title;
	String content;
	String writer;
	Date inst_date;

	private List<MultipartFile> files;
	private List<Reply> replies;
		
	public void read() {
		views ++;	
	}
	
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getInst_date() {
		return inst_date;
	}

	public void setInst_date(Date inst_date) {
		this.inst_date = inst_date;
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

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", views=" + views + ", delYn=" + delYn + ", title=" + title + ", content=" + content
				+ ", files=" + files + ", replies=" + replies + "]";
	}
	
}
