package com.team2.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import com.team2.hc.DBManager;

public class MessageA {

	private ArrayList<MessageClass> messages;

	private static final MessageA ADAO = new MessageA();

	public static MessageA getAdao() {
		return ADAO;
	}

	public MessageA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void Send(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();

			String sql = "insert into message values (m_messageNo.nextval,?, ?, ?,sysdate)";
			pstmt = con.prepareStatement(sql);

			System.out.println(pstmt);

			String from = request.getParameter("fromId");
			String to = request.getParameter("toId");
			String text = request.getParameter("text");

			System.out.println(from);
			System.out.println(to);
			System.out.println(text);

			pstmt.setString(1, from);
			pstmt.setString(2, to);
			pstmt.setString(3, text);

			MessageClass m = null;
			m = new MessageClass();

			m.setM_fromId(from);
			m.setM_toId(to);
			m.setM_text(text);

			request.setAttribute("message", m);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("rm", "������ ���½��ϴ�");
			} else {
				request.setAttribute("rm", "������ ����-���̵�� ���� ���� Ȯ�����ּ���");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "�������� - ������ �����µ� �����߽��ϴ�");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void receivedMessage(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			request.setCharacterEncoding("UTF-8");
			con = DBManager.connect();
			String sql = "select * from message where m_toId=? order by m_date";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			pstmt.setString(1, id);
			System.out.println("�޽��� �б⿡��(����) : " + id);
			rs = pstmt.executeQuery();
			// ���⼭ ���൵�� �۵�
			MessageClass m = null;

			messages = new ArrayList<MessageClass>();


			while (rs.next()) {

				m = new MessageClass();

				m.setM_messageNo(rs.getInt("m_messageNo"));
				m.setM_fromId(rs.getString("m_fromId"));
				m.setM_toId(rs.getString("m_toId"));
				m.setM_text(rs.getString("m_text"));
				m.setM_date(rs.getString("m_date"));

				messages.add(m);
			}

			request.setAttribute("received", messages);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void sentMessage(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			request.setCharacterEncoding("UTF-8");
			
			con = DBManager.connect();
			String sql = "select * from message where m_fromId=? order by m_date";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			pstmt.setString(1, id);
			System.out.println("�޽��� ���� : " + id);
			rs = pstmt.executeQuery();
			// ���⼭ ���൵�� �۵�
			MessageClass m = null;

			messages = new ArrayList<MessageClass>();

			
			while (rs.next()) {

				m = new MessageClass();

				m.setM_messageNo(rs.getInt("m_messageNo"));
				m.setM_fromId(rs.getString("m_fromId"));
				m.setM_toId(rs.getString("m_toId"));
				m.setM_text(rs.getString("m_text"));
				m.setM_date(rs.getString("m_date"));

				messages.add(m);
			}
			request.setAttribute("sent", messages);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageClass m = null;

		try {
			con = DBManager.connect();

			String way = request.getParameter("searchWay");
			// System.out.println(way);
			request.setAttribute("way", way);

			String searchId = request.getParameter("searchId");
			String myid = request.getParameter("id");

			if (way.equalsIgnoreCase("whoSent")) {
				String sql = "select * from message where m_toId like ? and m_fromId like ?";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", myid + "�� �� ���� ���� �� ���̵�� �˻�");

				pstmt.setString(1, myid);
				pstmt.setString(2, searchId);

			} else {
				String sql = "select * from message where m_toId like ? and m_fromId like ?";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", myid + "�� �� ���� ����  �� ���̵�� �˻�");

				pstmt.setString(1, searchId);
				pstmt.setString(2, myid);

			}

			rs = pstmt.executeQuery();
			// pstmt.executeQuery(); ������ ����� --> rs�� ����

			messages = new ArrayList<MessageClass>();
			int count =0;
			
			while (rs.next()) {
				m = new MessageClass();
				// ��ü�� ����ִ� �׸��� �ؿ��� �ϳ��ϳ� �����ϰ�
				// array����Ʈ�� ���� �ϳ��ϳ�
				m.setM_messageNo(rs.getInt("m_messageNo"));
				m.setM_fromId(rs.getString("m_fromId"));
				m.setM_toId(rs.getString("m_toId"));
				m.setM_text(rs.getString("m_text"));
				m.setM_date(rs.getString("m_date"));
				messages.add(m);
				count++;
			}
			request.setAttribute("messages", messages);
			request.setAttribute("count", count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void MessagePageing(int page, HttpServletRequest request) {

		request.setAttribute("curPageNo", page);

		int cnt = 3;
		int total = messages.size();
		if (total != 0) {
			int pageCount = (int) Math.ceil(total / (double) cnt);
			request.setAttribute("pageCount", pageCount);

			int start = total - (cnt * (page - 1));

			int end = (page == pageCount) ? -1 : start - (cnt + 1);

			ArrayList<MessageClass> items = new ArrayList<MessageClass>();
			for (int i = start - 1; i > end; i--) {

				items.add(messages.get(i));

			}
			request.setAttribute("messages", items);
			request.setAttribute("count", total);
		}
	}

	public void MessageDel(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();
			String sql = "delete message where m_messageNo = ?";
			pstmt = con.prepareStatement(sql);

			int no = Integer.parseInt(request.getParameter("no"));
			

			pstmt.setInt(1, no);

			

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("DR", "���� ���� ����");

			} else {

				request.setAttribute("DR", "���� ���� ����");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("DR", "���� ���� ����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void SearchByDate(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageClass m = null;
		
//		Date d = new Date();
//		Date d2 = new Date();

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// ���� --> Date
		// ��¥ --> ����
		
		String getDate = request.getParameter("fromDate");
		String getDate2 = request.getParameter("endDate");

		// �������� �� sdf�� ������ �ؼ� �ᱹ yyyy-mm-dd�� ����� ��--(new SimpleDateFormat �� ����� �ϳ�)
		request.setAttribute("way", "date");
		try {
//			d = sdf.parse(getDate); 	
//			d2 = sdf.parse(getDate2);
			// getDate �� ���ܵ� DateŸ�Կ� ���� �� �����ϱ� ����Ʈ Ÿ������ �ٲܶ�� sdf.parse��
//			System.out.println(d);
//			System.out.println(d2);

			con = DBManager.connect();
			String sql = "select * from message where m_date between "
					+ "TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') + 0.99999";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, getDate);
			pstmt.setString(2, getDate2);
			rs=pstmt.executeQuery();
			
			messages = new ArrayList<MessageClass>();
			int count =0;
			
			while (rs.next()) {
				m = new MessageClass();
		
				m.setM_messageNo(rs.getInt("m_messageNo"));
				m.setM_fromId(rs.getString("m_fromId"));
				m.setM_toId(rs.getString("m_toId"));
				m.setM_text(rs.getString("m_text"));
				m.setM_date(rs.getString("m_date"));
				messages.add(m);
				count++;
			}
			request.setAttribute("messages", messages);
			request.setAttribute("count", count);
			

		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		
	}

	

}
