package com.team2.paintGame;

import java.util.Date;

public class Print {
	private int p_no;
	private String p_title;
	private String p_id;
	private String p_ans;
	private String p_hint;
	private Date p_date;
	private String p_img;
	
	public Print() {
		// TODO Auto-generated constructor stub
	}

	public Print(int p_no, String p_title, String p_id, String p_ans, String p_hint, Date p_date, String p_img) {
		super();
		this.p_no = p_no;
		this.p_title = p_title;
		this.p_id = p_id;
		this.p_ans = p_ans;
		this.p_hint = p_hint;
		this.p_date = p_date;
		this.p_img = p_img;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_ans() {
		return p_ans;
	}

	public void setP_ans(String p_ans) {
		this.p_ans = p_ans;
	}

	public String getP_hint() {
		return p_hint;
	}

	public void setP_hint(String p_hint) {
		this.p_hint = p_hint;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	
	
	
	
}