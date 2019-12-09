package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.BoardDAO;
import com.dev.utils.SessionUtil;
import com.dev.viewCommand.UpdateViewCommand;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("bSeq"));
		String uId = request.getParameter("uId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(!new SessionUtil().isOwner(request, response))
			return;
		
		if(title==null || content==null || title.equals("") || content.equals("")) {
			request.setAttribute("error", "제목과 내용을 작성하세요.");
			new UpdateViewCommand().execute(request, response);
			return;
		}
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.update(seq, uId, title, content);
		new BoardListCommand().execute(request, response);			
		
	}
}
