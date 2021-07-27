package com.team2.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DropedUserPageController")
public class DropedUserPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		Admin.getAdao().getDropList(request);
		Admin.getAdao().ReasonePageing(page, request);	

			request.setAttribute("contentPage","admin/adDropedUser.jsp");
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
