package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.BoardDAO;
import com.dev.utils.SessionUtil;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 확인
		if(!new SessionUtil().isOwner(request, response))
			return;
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.delete(Integer.parseInt(request.getParameter("bSeq")));
		new BoardListCommand().execute(request, response);
	}
}
