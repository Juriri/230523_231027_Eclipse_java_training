package model;

import java.sql.Date;

public class Board {
	private int num;
	private String writer;
	private String w_date;
	private String title;
	private String content;

	public Board() {
	}

	public Board(int num, String writer, String w_date, String title, String content) {
		this.num = num;
		this.writer = writer;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getW_date() {
		return w_date;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
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

	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", w_date=" + w_date + ", title=" + title + ", content="
				+ content + "]";
	}

}
