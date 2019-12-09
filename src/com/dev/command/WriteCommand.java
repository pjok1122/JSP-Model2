package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.BoardDAO;
import com.dev.utils.SessionUtil;
import com.dev.viewCommand.WriteViewCommand;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtil util = new SessionUtil();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(!util.isLogined(request, response))
			return;
		
		if(title==null || content==null || title.equals("") || content.equals("")) {
			request.setAttribute("error", "제목과 내용을 작성하세요.");
			new WriteViewCommand().execute(request, response);
			return;
		}
		
		BoardDAO bDAO = new BoardDAO();
		HttpSession session = request.getSession();
		bDAO.write((Integer) session.getAttribute("userSeq"), title, content);
		new BoardListCommand().execute(request, response);
	}
}
