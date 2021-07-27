package com.team2.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.AccountDOA;

@WebServlet("/AdminPageController")
public class AdminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = Integer.parseInt(request.getParameter("page"));
		
	AccountDOA.getAdao().getAllUser(request);
	AccountDOA.getAdao().AccountPageing(page, request);
	
	request.setAttribute("contentPage", "admin/admin.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
