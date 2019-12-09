package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.BoardDAO;
import com.dev.dto.BoardListDTO;
import com.dev.viewCommand.ContentViewCommand;

public class ContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bSeq = Integer.parseInt(request.getParameter("bSeq"));
		BoardDAO bDAO = new BoardDAO();
		BoardListDTO article = bDAO.select(bSeq);
		request.setAttribute("article", article);
		
		new HitUpCommand().execute(request, response);
		new ContentViewCommand().execute(request, response);
	}

}
