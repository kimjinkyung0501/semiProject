package com.team2.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.hc.DBManager;
import com.team2.hc.TokenMaker;
import com.team2.m1.Board;


public class userBoardDAO {
	
	private ArrayList<Review> reviews;

	private static final userBoardDAO UDAO = new userBoardDAO();
	
	private userBoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static userBoardDAO getUdao() {
		return UDAO;
	}


	public void getAllReviews(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
		
			
			con = DBManager.connect();
			
			String sql = "select * from userboard order by ub_date";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			reviews = new ArrayList<Review>();
			
			Review r = null;
			
			
			while (rs.next()) {
				r = new Review();
				
				r.setUb_no(rs.getInt("ub_no"));
				r.setUb_title(rs.getString("ub_title"));
				r.setUb_content(rs.getString("ub_content"));
				r.setUb_file(rs.getString("ub_file"));
				r.setUb_date(rs.getDate("ub_date"));
				r.setUb_id(rs.getString("ub_id"));
				r.setUb_count(rs.getInt("ub_count"));
				reviews.add(r);
			}
			
				request.setAttribute("reviews", reviews);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
	}

	
	public void regReviews(HttpServletRequest request) {
		
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
			
			String sql = "insert into userboard values (userboard_seq.nextval, ?, ?, ?, sysdate, ?,0)";
			
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8", new DefaultFileRenamePolicy());
			
			
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
		
			String file = mr.getFilesystemName("file");
			
			String id = mr.getParameter("id");
			
			
			// ���� �� �ް� ���� �װ� �Ʒ� ����ǥ ä�� �� ���� ��.
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, file);			
			pstmt.setString(4, id);
			
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "성공!");
			} else {
				request.setAttribute("r", "실패!!!");
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		 	}
	}
	public void count(HttpServletRequest request) {
		Connection con = null;
	      PreparedStatement pstmt = null; 
	      String bbb  =(String)request.getAttribute("token");
		    Date dd = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ss");
		 	String aaa = sdf.format(dd);
		 	System.out.println(aaa);
		 	if (bbb.equals(aaa)) {
	      try {
			con=DBManager.connect();
			String sql = "update userboard set ub_count=ub_count+1 where ub_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(con, pstmt, null);
		}
		 	}
	}

	public void getReview(HttpServletRequest request) {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Review dt = null;
	    
	    try {
	         con = DBManager.connect();
	         
	         String sql = "select * from userboard where ub_no=?";
	      
	         pstmt = con.prepareStatement(sql);
	    
	         
	         int no = Integer.parseInt(request.getParameter("no"));
	         pstmt.setInt(1, no);
	         
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            dt = new Review();
	        	
	            dt.setUb_no(rs.getInt("ub_no"));
	            dt.setUb_title(rs.getString("ub_title"));
	            dt.setUb_content(rs.getString("ub_content"));
	            dt.setUb_file(rs.getString("ub_file"));
	            dt.setUb_date(rs.getDate("ub_date"));
	            dt.setUb_id(rs.getString("ub_id"));
	            dt.setUb_count(rs.getInt("ub_count"));
	            
	         }
	         
	         //�����
	         request.setAttribute("dt", dt);
			
	} catch (Exception e) {
		request.setAttribute("r", "DB실패");
		e.printStackTrace();
	} finally {
		DBManager.close(con, pstmt, null);
	}
		
		
	}


	public void reviewDel(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete userboard where ub_no = ?";
			pstmt = con.prepareStatement(sql);
			
			
			 String no = request.getParameter("no");
	         pstmt.setString(1, no);
			
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공");
			} else {
				request.setAttribute("r", "삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	public void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String type = request.getParameter("type");
			String txt = request.getParameter("txt");

			if (type.equals("all")) {

				String sql = "select * from userboard where ub_title like '%' || ? || '%' or ub_content like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);
				pstmt.setString(2, txt);

			} else if (type.equals("title")) {

				String sql = "select * from userboard where ub_title like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);

			} else if (type.equals("text")) {

				String sql = "select * from userboard where ub_content like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, txt);

			}

			rs = pstmt.executeQuery();

			reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				// 占쏙옙체 Bean 占십울옙.
				r = new Review();

				r.setUb_no(rs.getInt("ub_no"));
				r.setUb_title(rs.getString("ub_title"));
				r.setUb_content(rs.getString("ub_content"));
				r.setUb_file(rs.getString("ub_file"));
				r.setUb_date(rs.getDate("ub_date"));
				r.setUb_id(rs.getString("ub_id"));
				r.setUb_count(rs.getInt("ub_count"));
				reviews.add(r);
			}
			request.setAttribute("reviews", reviews);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}
	}

	
	
	
	
	
	
	
	
	
	public void update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
	      PreparedStatement pstmt = null;
	     
	      try {
	         con = DBManager.connect();

	         String sql = "update userboard set ub_title=?, ub_content=?,ub_file=?, ub_date=sysdate where ub_no=?";
	         pstmt = con.prepareStatement(sql);

	         String saveDirectory = request.getServletContext().getRealPath("img");
	         System.out.println(saveDirectory);

	         MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
	               new DefaultFileRenamePolicy());

	         
	         String title = mr.getParameter("title");
	         String content = mr.getParameter("content");
	         String file = mr.getFilesystemName("file");
	         String fName22 = mr.getParameter("file22");
	         int no = Integer.parseInt(mr.getParameter("no"));

	        System.out.println(title);
	        System.out.println(content);
	        System.out.println(file);
	        System.out.println(fName22);
	        System.out.println(no);

	         pstmt.setString(1, title);
	         pstmt.setString(2, content);
	         
	         if (file != null) {
	        	 pstmt.setString(3, file);
	         }  else if (file == null) {
	        	 pstmt.setString(3, fName22);
			}
	         pstmt.setInt(4, no);

	         if (pstmt.executeUpdate() == 1) {
	            request.setAttribute("r", "수정!");
	         } else {
	            request.setAttribute("r", "실패!!!");
	         }

	      } catch (Exception e) {
	         request.setAttribute("r", "DB");
	         e.printStackTrace();
	      } finally {
	         DBManager.close(con, pstmt, null);
	      }
		
		 	
	}
	public void paging(int page, HttpServletRequest request) {

		request.setAttribute("curPageNO", page);

		int cnt = 10; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		int total = reviews.size(); // 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		if (total != 0) {
		int pageCount = (int) Math.ceil(total / (double) cnt);

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Review> items = new ArrayList<Review>();
		for (int i = start - 1; i > end; i--) {
			items.add(reviews.get(i));
		}

		request.setAttribute("reviews", items);
		}
	
	}
	
	public void best(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
			con = DBManager.connect();
			
			String sql = "select * from userboard order by ub_count desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			reviews = new ArrayList<Review>();
			
			Review r = null;
			
			
			while (rs.next()) {
				r = new Review();
				
				r.setUb_no(rs.getInt("ub_no"));
				r.setUb_title(rs.getString("ub_title"));
				r.setUb_content(rs.getString("ub_content"));
				r.setUb_file(rs.getString("ub_file"));
				r.setUb_date(rs.getDate("ub_date"));
				r.setUb_id(rs.getString("ub_id"));
				r.setUb_count(rs.getInt("ub_count"));
				reviews.add(r);
			}
			
				request.setAttribute("reviews2", reviews);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
	}
	
}
