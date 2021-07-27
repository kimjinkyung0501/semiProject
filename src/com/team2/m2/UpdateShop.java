package com.team2.m2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.login.Account;

@WebServlet("/UpdateShop")
public class UpdateShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FamousDAO.getFdao().shopDetail(request);
		
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");
		request.setAttribute("accountInfo", a);
		
		request.setAttribute("contentPage", "famous_shop/updatePage.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FamousDAO.getFdao().update(request);
		FamousDAO.getFdao().Search(request);
		
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");
		request.setAttribute("accountInfo", a);
		
		request.setAttribute("contentPage", "famous_shop/famousShop_index.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
