package com.team2.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NoticeEditController")
public class NoticeEditController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO.getBdao().view(request);
		request.setAttribute("contentPage", "m1/edit.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO.getBdao().edit(request);
		BoardDAO.getBdao().view(request);
		request.setAttribute("contentPage", "m1/board_view.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
