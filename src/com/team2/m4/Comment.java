package com.team2.m4;

import java.util.Date;

public class Comment {
private int co_num;
private int co_board;
private String co_id;
private String co_cotent;
private Date co_date;
private int  co_parent;

public Comment() {
	// TODO Auto-generated constructor stub
}



public Comment(int co_num, int co_board, String co_id, String co_cotent, Date co_date, int co_parent) {
	super();
	this.co_num = co_num;
	this.co_board = co_board;
	this.co_id = co_id;
	this.co_cotent = co_cotent;
	this.co_date = co_date;
	this.co_parent = co_parent;
}



public int getCo_num() {
	return co_num;
}

public void setCo_num(int co_num) {
	this.co_num = co_num;
}

public int getCo_board() {
	return co_board;
}

public void setCo_board(int co_board) {
	this.co_board = co_board;
}

public String getCo_id() {
	return co_id;
}

public void setCo_id(String co_id) {
	this.co_id = co_id;
}

public String getCo_cotent() {
	return co_cotent;
}

public void setCo_cotent(String co_cotent) {
	this.co_cotent = co_cotent;
}

public Date getCo_date() {
	return co_date;
}

public void setCo_date(Date co_date) {
	this.co_date = co_date;
}

public int getCo_parent() {
	return co_parent;
}

public void setCo_parent(int co_parent) {
	this.co_parent = co_parent;
}


}
