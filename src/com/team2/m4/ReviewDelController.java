package com.team2.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewDelController")
public class ReviewDelController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	userBoardDAO.getUdao().reviewDel(request);
	CommentDAO.getCDAO().commentDel(request);
	userBoardDAO.getUdao().getAllReviews(request);
	userBoardDAO.getUdao().paging(1, request);
	
	request.setAttribute("contentPage", "m4/userBoard.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
