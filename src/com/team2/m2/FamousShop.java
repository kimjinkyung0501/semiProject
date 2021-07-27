package com.team2.m2;

import java.util.Date;

public class FamousShop {
	private int f_no;
	private String f_name;
	private String f_place;
	private Date date;
	private String f_text;
	private String f_img;
	
	public FamousShop() {
		// TODO Auto-generated constructor stub
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_place() {
		return f_place;
	}

	public void setF_place(String f_place) {
		this.f_place = f_place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getF_text() {
		return f_text;
	}

	public void setF_text(String f_text) {
		this.f_text = f_text;
	}

	public String getF_img() {
		return f_img;
	}

	public void setF_img(String f_img) {
		this.f_img = f_img;
	}

	public FamousShop(int f_no, String f_name, String f_place, Date date, String f_text, String f_img) {
		super();
		this.f_no = f_no;
		this.f_name = f_name;
		this.f_place = f_place;
		this.date = date;
		this.f_text = f_text;
		this.f_img = f_img;
	}
	
	
	
	
	
	
}
