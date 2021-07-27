package com.team2.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.hc.TokenMaker;


@WebServlet("/CpageController")
public class CpageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userBoardDAO.getUdao().getReview(request);
		TokenMaker.make(request);
		int p = Integer.parseInt(request.getParameter("p"));
		CommentDAO.getCDAO().paging(p, request);
			
		request.setAttribute("contentPage", "m4/userBoard_detail.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
