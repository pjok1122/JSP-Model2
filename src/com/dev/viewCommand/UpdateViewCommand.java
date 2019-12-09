package com.dev.viewCommand;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.command.BoardListCommand;
import com.dev.command.Command;

public class UpdateViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		HttpSession session = request.getSession();
		
		int seq = Integer.parseInt(request.getParameter("bSeq"));
		String uId = request.getParameter("uId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(session.getAttribute("userId").equals(uId)) {
			url ="update.jsp";
		} else {
			url = "main.do";
		}
		
		request.setAttribute("bSeq", seq);
		request.setAttribute("uId", uId);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
