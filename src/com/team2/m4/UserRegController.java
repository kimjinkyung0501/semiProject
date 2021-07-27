package com.team2.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.hc.TokenMaker;

@WebServlet("/UserRegController")
public class UserRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "m4/userBoard_reg.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// ��

		TokenMaker.make(request);
	userBoardDAO.getUdao().regReviews(request);
	userBoardDAO.getUdao().getAllReviews(request);

	userBoardDAO.getUdao().paging(1, request);
	// ����ϰ� �����

	request.setAttribute("contentPage", "m4/userBoard.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}
	
	}


