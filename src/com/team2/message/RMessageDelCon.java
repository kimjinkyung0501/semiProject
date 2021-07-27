package com.team2.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RMessageDelCon")
public class RMessageDelCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MessageA.getAdao().MessageDel(request);
		MessageA.getAdao().receivedMessage(request);
		MessageA.getAdao().MessagePageing(1, request);

		
		request.setAttribute("messageContentPage", "receivedMessage.jsp");
		request.getRequestDispatcher("jsp/message.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
