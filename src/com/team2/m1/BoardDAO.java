package com.team2.m1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.hc.DBManager;
import com.team2.hc.TokenMaker;

public class BoardDAO {

	private ArrayList<Board> boards;

	private static final BoardDAO BDAO = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getBdao() {
		return BDAO;
	}

	// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Ã¼ ï¿½ï¿½ï¿½ï¿½Æ® ï¿½ï¿½ï¿½ï¿½
	public void list(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();

			String sql = "select * from board order by b_date";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			boards = new ArrayList<Board>();
			Board b = null;

			while (rs.next()) {
				b = new Board();

				b.setB_num(rs.getInt("b_num"));
				b.setB_subject(rs.getString("b_subject"));
				b.setB_date(rs.getDate("b_date"));
				b.setB_id(rs.getString("b_id"));
				boards.add(b);
			}

			request.setAttribute("boards", boards);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}

	}

// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Îµï¿½ï¿½Ï±ï¿½
	public void upload(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String bbb  =(String)request.getAttribute("token");
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		String aaa = sdf.format(dd);
		System.out.println(aaa);
	 	if (bbb.equals(aaa)) {
	 	
		try {
		
				
		
			con = DBManager.connect();

			String sql = "insert into board values (Board_seq.nextval,?,?,?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
					new DefaultFileRenamePolicy());

			String subject = mr.getParameter("subject");
			String content = mr.getParameter("content");
			String file = mr.getFilesystemName("file");
			String id = mr.getParameter("id");
			
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, file);
			pstmt.setString(4, id);
		
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "¾÷·Îµå");
			} else {
				request.setAttribute("r", "½ÇÆÐ");
			}

		} catch (Exception e) {
			request.setAttribute("r", "DB");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	 	}
	}

	// ï¿½ï¿½ï¿½ï¿½

	public void del(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "delete Board where b_num = ?";
			pstmt = con.prepareStatement(sql);

			int num = Integer.parseInt(request.getParameter("num"));

			pstmt.setInt(1, num);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "»èÁ¦");
			} else {
				request.setAttribute("r", "»èÁ¦");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	// ï¿½ï¿½ï¿½ï¿½

	public void edit(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "update board set b_subject=?, b_content=?, b_file=?, b_date=sysdate where b_num=?";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
					new DefaultFileRenamePolicy());
				System.out.println("----------------");
			String subject = mr.getParameter("subject");
			String content = mr.getParameter("content");
			String file = mr.getFilesystemName("file");
			String file2 = mr.getParameter("file2");
//			if (file == null) {
//				String file22 = mr.getParameter("file22");
//			}
			int num = Integer.parseInt(mr.getParameter("num"));

			System.out.println(subject);
			System.out.println(content);
			System.out.println(file);
			System.out.println(num);
			request.setCharacterEncoding("utf-8");
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
		if (file!=null) {
			pstmt.setString(3, file);
			
		}else if (file==null) {
			pstmt.setString(3, file2);			
		}	
			pstmt.setInt(4, num);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ó¼¼³ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

	public void view(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Board b = null;
		try {
			con = DBManager.connect();

			String sql = "select * from board where b_num=?";
			pstmt = con.prepareStatement(sql);

			String num = request.getParameter("num");
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new Board();
				b.setB_date(rs.getDate("b_date"));
				b.setB_id(rs.getString("b_id"));
				b.setB_num(rs.getInt("b_num"));
				b.setB_subject(rs.getString("b_subject"));
				b.setB_content(rs.getString("b_content"));
				b.setB_file(rs.getString("b_file"));

			}

			request.setAttribute("boards", b);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}

	}

	// ï¿½Ë»ï¿½

	public void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String type = request.getParameter("type");
			String txt = request.getParameter("txt");

			if (type.equals("all")) {

				String sql = "select * from Board where b_subject like '%' || ? || '%' or b_content like '%' || ? || '%' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);
				pstmt.setString(2, txt);

			} else if (type.equals("title")) {

				String sql = "select * from Board where b_subject like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);

			} else if (type.equals("text")) {

				String sql = "select * from Board where b_content like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);

			}

			rs = pstmt.executeQuery();

			boards = new ArrayList<Board>();
			Board b = null;

			while (rs.next()) {
				// ï¿½ï¿½Ã¼ Bean ï¿½Ê¿ï¿½.
				b = new Board();

				b.setB_num(rs.getInt("b_num"));
				b.setB_subject(rs.getString("b_subject"));
				b.setB_content("b_content");
				b.setB_date(rs.getDate("b_date"));
				b.setB_id(rs.getString("b_id"));

				boards.add(b);
			}
			request.setAttribute("boards", boards);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}
	}

	// ï¿½ï¿½ï¿½ï¿½Â¡Ã³ï¿½ï¿½

	public void paging(int page, HttpServletRequest request) {

		request.setAttribute("curPageNO", page);

		int cnt = 10; // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int total = boards.size(); // ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		if (total != 0) {
		int pageCount = (int) Math.ceil(total / (double) cnt);

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Board> items = new ArrayList<Board>();
		for (int i = start - 1; i > end; i--) {
	
			items.add(boards.get(i));
		}

		request.setAttribute("boards", items);
		}
	}
	
	
	public void latest(HttpServletRequest request) {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();

			String sql = "select * from board order by b_date desc";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			boards = new ArrayList<Board>();
			Board b = null;

			while (rs.next()) {
				b = new Board();

				b.setB_num(rs.getInt("b_num"));
				b.setB_subject(rs.getString("b_subject"));
				b.setB_date(rs.getDate("b_date"));
				b.setB_id(rs.getString("b_id"));
				boards.add(b);
			}

			request.setAttribute("boards2", boards);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}

	}
	

}
