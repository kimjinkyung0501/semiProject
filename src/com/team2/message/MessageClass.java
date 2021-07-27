package com.team2.message;

public class MessageClass {
	
	int m_messageNo;
	String m_fromId;
	String m_toId;
	String m_text;
	String m_date;
	public MessageClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageClass(int m_messageNo, String m_fromId, String m_toId, String m_text, String m_date) {
		super();
		this.m_messageNo = m_messageNo;
		this.m_fromId = m_fromId;
		this.m_toId = m_toId;
		this.m_text = m_text;
		this.m_date = m_date;
	}
	public int getM_messageNo() {
		return m_messageNo;
	}
	public void setM_messageNo(int m_messageNo) {
		this.m_messageNo = m_messageNo;
	}
	public String getM_fromId() {
		return m_fromId;
	}
	public void setM_fromId(String m_fromId) {
		this.m_fromId = m_fromId;
	}
	public String getM_toId() {
		return m_toId;
	}
	public void setM_toId(String m_toId) {
		this.m_toId = m_toId;
	}
	public String getM_text() {
		return m_text;
	}
	public void setM_text(String m_text) {
		this.m_text = m_text;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	
	
}
