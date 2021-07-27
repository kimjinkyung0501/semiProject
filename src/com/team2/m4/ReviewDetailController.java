package com.team2.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.hc.TokenMaker;

@WebServlet("/ReviewDetailController")
public class ReviewDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// ��
	userBoardDAO.getUdao().getReview(request);
	TokenMaker.make(request);
	userBoardDAO.getUdao().count(request);
	CommentDAO.getCDAO().getAllComment(request);
	CommentDAO.getCDAO().paging(1, request);
	request.setAttribute("contentPage","m4/userBoard_detail.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userBoardDAO.getUdao().getReview(request);
		TokenMaker.make(request);
		CommentDAO.getCDAO().regComent(request);
		CommentDAO.getCDAO().getAllComment(request);
		CommentDAO.getCDAO().paging(1, request);
		
		request.setAttribute("contentPage","m4/userBoard_detail.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
