package com.team2.m4;

import java.util.Date;

public class Review {
	
	private int ub_no;
	private String ub_title;
	private String ub_content;
	private String ub_file;
	private Date ub_date;
	private String ub_id;
	private  int ub_count;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int ub_no, String ub_title, String ub_content, String ub_file, Date ub_date, String ub_id) {
		super();
		this.ub_no = ub_no;
		this.ub_title = ub_title;
		this.ub_content = ub_content;
		this.ub_file = ub_file;
		this.ub_date = ub_date;
		this.ub_id = ub_id;
		
	}

	public int getUb_no() {
		return ub_no;
	}

	
	
	

	public int getUb_count() {
		return ub_count;
	}

	public void setUb_count(int ub_count) {
		this.ub_count = ub_count;
	}

	public void setUb_no(int ub_no) {
		this.ub_no = ub_no;
	}

	public String getUb_title() {
		return ub_title;
	}

	public void setUb_title(String ub_title) {
		this.ub_title = ub_title;
	}

	public String getUb_content() {
		return ub_content;
	}

	public void setUb_content(String ub_content) {
		this.ub_content = ub_content;
	}

	public String getUb_file() {
		return ub_file;
	}

	public void setUb_file(String ub_file) {
		this.ub_file = ub_file;
	}

	public Date getUb_date() {
		return ub_date;
	}

	public void setUb_date(Date ub_date) {
		this.ub_date = ub_date;
	}

	public String getUb_id() {
		return ub_id;
	}

	public void setUb_id(String ub_id) {
		this.ub_id = ub_id;
	}
	
	
	
}
