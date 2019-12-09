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
		// �Ķ���� ��������
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// DAO�κ��� ���� ��������.
		UserDAO uDAO = new UserDAO();
		UserDTO uDTO = uDAO.select(id);

		//������ �������κ��� �н����� ���ϱ�
		String hPassword = SHA256Util.sha256(password);
		if (uDTO!=null && uDTO.getPassword().equals(hPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			session.setAttribute("userSeq", uDTO.getSeq());
			new BoardListCommand().execute(request, response);
		}
		else {
			request.setAttribute("error", "���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.");
			new LoginViewCommand().execute(request, response);
		}
	}
}
