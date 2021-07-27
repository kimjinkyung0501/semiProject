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
				request.setAttribute("rm", "쪽지를 보냈습니다");
			} else {
				request.setAttribute("rm", "보내기 실패-아이디와 글자 수를 확인해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버오류 - 쪽지를 보내는데 실패했습니다");
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
			System.out.println("메시지 읽기에서(받은) : " + id);
			rs = pstmt.executeQuery();
			// 여기서 실행도구 작동
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
			System.out.println("메시지 보낸 : " + id);
			rs = pstmt.executeQuery();
			// 여기서 실행도구 작동
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
				request.setAttribute("sr", myid + "님 이 받은 쪽지 중 아이디로 검색");

				pstmt.setString(1, myid);
				pstmt.setString(2, searchId);

			} else {
				String sql = "select * from message where m_toId like ? and m_fromId like ?";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", myid + "님 이 보낸 쪽지  중 아이디로 검색");

				pstmt.setString(1, searchId);
				pstmt.setString(2, myid);

			}

			rs = pstmt.executeQuery();
			// pstmt.executeQuery(); 실행한 결과를 --> rs에 담음

			messages = new ArrayList<MessageClass>();
			int count =0;
			
			while (rs.next()) {
				m = new MessageClass();
				// 객체에 들어있는 항목을 밑에서 하나하나 실행하고
				// array리스트에 담음 하나하나
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
				request.setAttribute("DR", "쪽지 삭제 성공");

			} else {

				request.setAttribute("DR", "쪽지 삭제 실페");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("DR", "쪽지 서버 오류");

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
		// 문자 --> Date
		// 날짜 --> 문자
		
		String getDate = request.getParameter("fromDate");
		String getDate2 = request.getParameter("endDate");

		// 현재정보 를 sdf로 포멧팅 해서 결국 yyyy-mm-dd의 모양이 됨--(new SimpleDateFormat 의 기능중 하나)
		request.setAttribute("way", "date");
		try {
//			d = sdf.parse(getDate); 	
//			d2 = sdf.parse(getDate2);
			// getDate 가 문잔데 Date타입에 담을 수 없으니까 데이트 타입으로 바꿀라면 sdf.parse로
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
