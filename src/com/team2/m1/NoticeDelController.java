package com.team2.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NoticeDelController")
public class NoticeDelController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BoardDAO.getBdao().del(request);
		BoardDAO.getBdao().list(request);
		BoardDAO.getBdao().paging(1, request);

		request.setAttribute("contentPage", "m1/list.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
