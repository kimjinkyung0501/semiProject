package com.team2.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReceivedMessagePageC")
public class ReceivedMessagePageC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("p"));
		
		MessageA.getAdao().receivedMessage(request);
		MessageA.getAdao().MessagePageing(page, request);

		request.setAttribute("messageContentPage", "receivedMessage.jsp");
		request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
