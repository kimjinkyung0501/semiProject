package com.team2.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogJoin")
public class LogJoin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		
		request.setAttribute("contentPage", "login/logJoin.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		AccountDOA.getAdao().accountJoin(request);
	
		request.setAttribute("contentPage", "login/join2.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	
	
	}


