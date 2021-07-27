package com.team2.login;

public class Account {

	private String  a_id;
	private String  a_pw;
	private String  a_name;
	private String  a_birth;
	public Account(String a_id, String a_pw, String a_name, String a_birth) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_name = a_name;
		this.a_birth = a_birth;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_pw() {
		return a_pw;
	}
	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_birth() {
		return a_birth;
	}
	public void setA_birth(String a_birth) {
		this.a_birth = a_birth;
	}
	
	
	
}
