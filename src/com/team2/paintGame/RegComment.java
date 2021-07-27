package com.team2.paintGame;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.login.Account;
@WebServlet("/RegComment")
public class RegComment extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int p = Integer.parseInt(request.getParameter("p"));
		
		PrintDAO.getPdao().regComment(request);
		
		PrintDAO.getPdao().showPrint(request);
		PrintDAO.getPdao().showComment_post(request);
		
		PrintDAO.getPdao().calc(request);
		PrintDAO.getPdao().comment_paging(p, request);
		
		
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");
		request.setAttribute("user_session", a);
		
		request.setAttribute("contentPage", "paintGame/paintDetail.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

}
