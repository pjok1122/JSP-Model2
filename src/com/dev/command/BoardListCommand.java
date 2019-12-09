package com.dev.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.BoardDAO;
import com.dev.dto.BoardListDTO;
import com.dev.viewCommand.BoardListViewCommand;

public class BoardListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO = new BoardDAO();
		ArrayList<BoardListDTO> list = bDAO.list();
		request.setAttribute("boardList", list);
		new BoardListViewCommand().execute(request, response);
	}
}
