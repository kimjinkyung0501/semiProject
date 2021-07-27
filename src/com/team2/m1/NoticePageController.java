package com.team2.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/NoticePageController")


public class NoticePageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int p = Integer.parseInt(request.getParameter("p"));
		
		BoardDAO.getBdao().paging(p, request);
		
		request.setAttribute("contentPage", "m1/list.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
