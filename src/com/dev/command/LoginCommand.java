package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.UserDAO;
import com.dev.dto.UserDTO;
import com.dev.utils.SHA256Util;
import com.dev.viewCommand.LoginViewCommand;
import com.dev.viewCommand.BoardListViewCommand;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 가져오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// DAO로부터 계정 가져오기.
		UserDAO uDAO = new UserDAO();
		UserDTO uDTO = uDAO.select(id);

		//가져온 계정으로부터 패스워드 비교하기
		String hPassword = SHA256Util.sha256(password);
		if (uDTO!=null && uDTO.getPassword().equals(hPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			session.setAttribute("userSeq", uDTO.getSeq());
			new BoardListCommand().execute(request, response);
		}
		else {
			request.setAttribute("error", "아이디 또는 패스워드가 일치하지 않습니다.");
			new LoginViewCommand().execute(request, response);
		}
	}
}
