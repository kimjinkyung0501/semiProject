package com.team2.paintGame;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrintPageController")
public class PrintPageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p = Integer.parseInt(request.getParameter("p"));
		
		PrintDAO.getPdao().showAllPrint(request);
		PrintDAO.getPdao().paging(p, request);
		
		request.setAttribute("contentPage", "paintGame/paintGroup.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
