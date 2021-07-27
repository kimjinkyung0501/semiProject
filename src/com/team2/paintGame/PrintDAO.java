package com.team2.paintGame;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.hc.DBManager;

public class PrintDAO {

	private ArrayList<Print> prints;
	private ArrayList<Print_comment> comments;

	private PrintDAO() {
		// TODO Auto-generated constructor stub
	}

	public static final PrintDAO PDAO = new PrintDAO();

	public static PrintDAO getPdao() {
		return PDAO;
	}

	public void showAllPrint(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select * from print order by p_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			prints = new ArrayList<Print>();
			Print p = null;
			while (rs.next()) {
				p = new Print();
				p.setP_no(rs.getInt("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_id(rs.getString("p_id"));
				p.setP_ans(rs.getString("p_ans"));
				p.setP_hint(rs.getString("p_hint"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_img(rs.getString("p_img"));
				prints.add(p);
			}

			request.setAttribute("prints", prints);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void paging(int page, HttpServletRequest request) {

		request.setAttribute("curPageNo", page);

		// ��ü ������ ���
		int cnt = 5; // ���������� ������ ����
		int total = prints.size(); // �� ������ ����

		int pageCount = (int) Math.ceil((total / (double) cnt)); // ���� �ݿø�

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Print> items = new ArrayList<Print>();
		for (int i = start - 1; i > end; i--) {
			items.add(prints.get(i));
		}
		request.setAttribute("prints", items);

	}

	public void regPrint(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String path = request.getSession().getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			con = DBManager.connect();
			String sql = "insert into print values(print_seq.nextval, ?, ?, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);

			String title = mr.getParameter("title");
			String u_id = mr.getParameter("u_id");
			String ans = mr.getParameter("ans");
			String hint = mr.getParameter("hint");
			String img = mr.getFilesystemName("img");
			

			pstmt.setString(1, title);
			pstmt.setString(2, u_id);
			pstmt.setString(3, ans);
			pstmt.setString(4, hint);
			pstmt.setString(5, img);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "성공");
			} else {
				request.setAttribute("result", "실패");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "db");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void showPrint(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select * from print where p_no = ?";
			String p_no = request.getParameter("p_no");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_no);
			rs = pstmt.executeQuery();

			Print p = null;
			if (rs.next()) {
				p = new Print();
				p.setP_no(rs.getInt("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_id(rs.getString("p_id"));
				p.setP_ans(rs.getString("p_ans"));
				p.setP_hint(rs.getString("p_hint"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_img(rs.getString("p_img"));

			}

			request.setAttribute("p", p);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void showComment(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "select * from print_comment " + "where c_no = ?" + "order by c_date";
			pstmt = con.prepareStatement(sql);
			String paint_no = request.getParameter("p_no");
			pstmt.setString(1, paint_no);

			rs = pstmt.executeQuery();

			comments = new ArrayList<Print_comment>();
			Print_comment c = null;
			while (rs.next()) {
				c = new Print_comment();
				c.setC_id(rs.getString("c_id"));
				c.setC_date(rs.getDate("c_date"));
				c.setC_txt(rs.getString("c_txt"));
				c.setC_ans(rs.getString("c_ans"));
				comments.add(c);

			}
			request.setAttribute("comments", comments);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void comment_paging(int page, HttpServletRequest request) {
		// TODO Auto-generated method stub

		request.setAttribute("curPageNo", page);

		// ��ü ������ ���

		int cnt = 3; // ���������� ������ ����
		int total = comments.size(); // �� ������ ����

		if (total != 0) {
			int pageCount = (int) Math.ceil((total / (double) cnt)); // ���� �ݿø�
			request.setAttribute("pageCount", pageCount);

			int start = total - (cnt * (page - 1));
			int end = (page == pageCount) ? -1 : start - (cnt + 1);

			ArrayList<Print_comment> items = new ArrayList<Print_comment>();
			for (int i = start - 1; i > end; i--) {
				items.add(comments.get(i));
			}
			request.setAttribute("comments", items);
		}

	}

	public void regComment(HttpServletRequest request) throws UnsupportedEncodingException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();
			String sql = "insert into print_comment values(?, ?, sysdate, ?, ?)";
			pstmt = con.prepareStatement(sql);

			int c_no = Integer.parseInt(request.getParameter("p_no"));
			String u_id = request.getParameter("u_id");
			String comment = request.getParameter("comment");
			String answer = request.getParameter("answer");

			pstmt.setInt(1, c_no);
			pstmt.setString(2, u_id);
			pstmt.setString(3, comment);
			pstmt.setString(4, answer);

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void showComment_post(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "select * from print_comment " + "where c_no = ?" + "order by c_date";
			pstmt = con.prepareStatement(sql);
			int p_no = Integer.parseInt(request.getParameter("p_no"));
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();

			comments = new ArrayList<Print_comment>();
			Print_comment c = null;
			while (rs.next()) {
				c = new Print_comment();
				c.setC_id(rs.getString("c_id"));
				c.setC_date(rs.getDate("c_date"));
				c.setC_txt(rs.getString("c_txt"));
				c.setC_ans(rs.getString("c_ans"));
				comments.add(c);
			}

			request.setAttribute("comments", comments);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void calc(HttpServletRequest request) {
		
		try {
			
		Print p = (Print) request.getAttribute("p");
		String p_ans = p.getP_ans();
		ArrayList<Print_comment> comment = (ArrayList<Print_comment>) request.getAttribute("comments");
		
		for (Print_comment pp : comment) {
			if (p_ans.equals(pp.getC_ans())) {
				String result = "yes";
				request.setAttribute("result", result);
			}
			else {
				String result = "no";
				request.setAttribute("result", result);
			}
		
		}
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

	public void deleteGame(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete from print where p_no = ?";
			pstmt = con.prepareStatement(sql);
			int p_no = Integer.parseInt(request.getParameter("p_no"));
			pstmt.setInt(1, p_no);
			
			pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "db");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	public void deleteComments(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();
			String sql = "delete from print_comment where c_no = ?";
			pstmt = con.prepareStatement(sql);
			int c_no = Integer.parseInt(request.getParameter("p_no"));
			pstmt.setInt(1, c_no);
			
			pstmt.executeUpdate();



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "db");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
