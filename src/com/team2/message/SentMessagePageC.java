package com.team2.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SentMessagePageC")
public class SentMessagePageC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MessageA.getAdao().sentMessage(request);
		
		int p = Integer.parseInt(request.getParameter("p"));
		MessageA.getAdao().MessagePageing(p, request);
		
		
		request.setAttribute("messageContentPage", "sentMessage.jsp");
		request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
