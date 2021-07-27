package com.team2.paintGame;

import java.util.Date;

public class Print_comment {
	private int c_no;
	private String c_id;
	private Date c_date;
	private String c_txt;
	private String c_ans;
	
	

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public Print_comment(int c_no, String c_id, Date c_date, String c_txt, String c_ans) {
		super();
		this.c_no = c_no;
		this.c_id = c_id;
		this.c_date = c_date;
		this.c_txt = c_txt;
		this.c_ans = c_ans;
	}

	public Print_comment() {
		// TODO Auto-generated constructor stub
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_txt() {
		return c_txt;
	}

	public void setC_txt(String c_txt) {
		this.c_txt = c_txt;
	}

	public String getC_ans() {
		return c_ans;
	}

	public void setC_ans(String c_ans) {
		this.c_ans = c_ans;
	}
	
	
	
}
