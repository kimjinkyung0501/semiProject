package com.team2.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentUpdateController")
public class CommentUpdateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO.getCDAO().getComment(request);
		userBoardDAO.getUdao().getReview(request);
		
		userBoardDAO.getUdao().paging(1, request);

		request.setAttribute("contentPage", "m4/comment_update.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CommentDAO.getCDAO().updatecomment(request);
		userBoardDAO.getUdao().getReview(request);
		CommentDAO.getCDAO().getAllComment(request);

		userBoardDAO.getUdao().paging(1, request);
			
		request.setAttribute("contentPage", "m4/userBoard_detail.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	
	}

}
