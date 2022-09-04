package kr.ac.kopo.reply;

public class ReplyVO {

	private int no; //reply의 번호
	private int boardNo; //해당 글 (detail)의 번호 (해당 글에 reply가 5개 있다)
	private String content;
	private String writer;
	private String regDate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ReplyVO [no=" + no + ", boardNo=" + boardNo + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	
}
