package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.BoardDAO;
import com.dev.dto.BoardDTO;
import com.dev.viewCommand.BoardListViewCommand;
import com.dev.viewCommand.WriteViewCommand;

public class HitUpCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("bSeq"));
		
		BoardDAO dao = new BoardDAO();
		dao.hitUp(seq);
		
	}
}
