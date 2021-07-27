package com.team2.m1;

import java.util.Date;

public class Board {
private int b_num;
private String b_subject;
private String b_content;
private String b_file;
private Date b_date;
private String b_id;


public Board() {
	
}

public Board(int b_num, String b_subject, String b_content, String b_file, Date b_date, String b_id) {
	super();
	this.b_num = b_num;
	this.b_subject = b_subject;
	this.b_content = b_content;
	this.b_file = b_file;
	this.b_date = b_date;
	this.b_id = b_id;
}





public int getB_num() {
	return b_num;
}

public void setB_num(int b_num) {
	this.b_num = b_num;
}

public String getB_subject() {
	return b_subject;
}

public void setB_subject(String b_subject) {
	this.b_subject = b_subject;
}

public String getB_content() {
	return b_content;
}

public void setB_content(String b_content) {
	this.b_content = b_content;
}

public String getB_file() {
	return b_file;
}

public void setB_file(String b_file) {
	this.b_file = b_file;
}

public Date getB_date() {
	return b_date;
}

public void setB_date(Date b_date) {
	this.b_date = b_date;
}

public String getB_id() {
	return b_id;
}

public void setB_id(String b_id) {
	this.b_id = b_id;
}



}
