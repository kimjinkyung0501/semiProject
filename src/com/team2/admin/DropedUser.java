package com.team2.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.login.AccountDOA;

@WebServlet("/DropedUser")
public class DropedUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

Admin.getAdao().getDropList(request);

Admin.getAdao().ReasonePageing(1, request);	
	request.setAttribute("contentPage","admin/adDropedUser.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
