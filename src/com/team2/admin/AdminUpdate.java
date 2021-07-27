package com.team2.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.AccountDOA;

@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		AccountDOA.getAdao().UserInfoLoad(request);
		request.setAttribute("contentPage", "admin/adUpdate.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		AccountDOA.getAdao().ADUserInfoLoad(request);
		request.setAttribute("contentPage", "admin/adUpdate2.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

}
