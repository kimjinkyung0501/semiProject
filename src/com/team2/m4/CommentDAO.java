package com.team2.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import com.team2.hc.DBManager;

public class CommentDAO {
	private ArrayList<Comment> comments;

	private static final CommentDAO CDAO = new CommentDAO();
	
	private CommentDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CommentDAO getCDAO() {
		return CDAO;
	}


	public void getAllComment(HttpServletRequest request) {
		
		request.getCharacterEncoding();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
		
			con = DBManager.connect();
			
			String sql = "select * from board_comment where co_board = ? order by co_num";
			pstmt = con.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("no"));
	         pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			comments = new ArrayList<Comment>();
			
			Comment c = null;
			

			
			while (rs.next()) {
				c = new Comment();
				
				c.setCo_num(rs.getInt("co_num"));
				c.setCo_board(rs.getInt("co_board"));
				c.setCo_id(rs.getString("co_id"));
				c.setCo_cotent(rs.getString("co_content"));
				c.setCo_date(rs.getDate("co_date"));
				comments.add(c);
			}
			
				request.setAttribute("comments", comments);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
	}

	
	public void regComent(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		 
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into board_comment values (board_comment_seq.nextval, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
		
			
			
		
			
			// ���� �� �ް� ���� �װ� �Ʒ� ����ǥ ä�� �� ���� ��.
		
			pstmt.setInt(1, Integer.parseInt(request.getParameter("co_board")));
			pstmt.setString(2, request.getParameter("co_id"));			
			pstmt.setString(3, request.getParameter("co_content"));
			
			
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
	public void paging(int page, HttpServletRequest request) {

		request.setAttribute("curPageNO", page);
		int cnt = 3; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		int total = comments.size(); // 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		if (total != 0) {

		int pageCount = (int) Math.ceil(total / (double) cnt);

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Comment> items = new ArrayList<Comment>();
		for (int i = start - 1; i > end; i--) {
			items.add(comments.get(i));
		}

		request.setAttribute("comments", items);
		}
	
	}
	public void commentDel(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete board_comment where co_board = ?";
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
public void delComent2(HttpServletRequest request) {
		
		// 댓글 하나 삭제하는 기능
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete board_comment where co_num = ?";
			pstmt = con.prepareStatement(sql);
			
			int num = Integer.parseInt(request.getParameter("num"));
			pstmt.setInt(1, num);
			
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
public void updatecomment(HttpServletRequest request) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
 
  try {
     con = DBManager.connect();

     String sql = "update board_comment set co_content=? where co_num=?";
     pstmt = con.prepareStatement(sql);

     

     String co_content = request.getParameter("co_content");
     int num = Integer.parseInt(request.getParameter("num"));
     
     pstmt.setString(1, co_content);
     pstmt.setInt(2, num);
     

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
public void getComment(HttpServletRequest request) {
	
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    Comment com = null;
    
    try {
         con = DBManager.connect();
         
         String sql = "select * from board_comment where co_num=? and co_board=?";
      
         pstmt = con.prepareStatement(sql);
    
         int num = Integer.parseInt(request.getParameter("num"));
         int no = Integer.parseInt(request.getParameter("no"));
         
         pstmt.setInt(1, num);
         pstmt.setInt(2, no);

         
         rs = pstmt.executeQuery();
         
         if (rs.next()) {
            com = new Comment();
        	
            com.setCo_num(rs.getInt("co_num"));
			com.setCo_board(rs.getInt("co_board"));
			com.setCo_id(rs.getString("co_id"));
			com.setCo_cotent(rs.getString("co_content"));
			com.setCo_date(rs.getDate("co_date"));
             
         }
         
         request.setAttribute("com", com);
		
} catch (Exception e) {
	request.setAttribute("r", "DB실패");
	e.printStackTrace();
} finally {
	DBManager.close(con, pstmt, null);
}
	
}
	
	}

