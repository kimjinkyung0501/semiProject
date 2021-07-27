package com.team2.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.hc.TokenMaker;

@WebServlet("/NoticeUploadController")
public class NoticeUploadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("contentPage", "m1/upload.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		TokenMaker.make(request);
		BoardDAO.getBdao().upload(request);
		
		
		
		BoardDAO.getBdao().list(request);
		BoardDAO.getBdao().paging(1, request);

		request.setAttribute("contentPage", "m1/list.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request,response);
	
	}

}
