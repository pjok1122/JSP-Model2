package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.UserDAO;
import com.dev.dto.UserDTO;
import com.dev.utils.SHA256Util;
import com.dev.viewCommand.BoardListViewCommand;
import com.dev.viewCommand.RegisterViewCommand;

public class RegisterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("re_password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		UserDAO uDAO = new UserDAO();
		
		//�����ϴ� ���̵����� Ȯ���ϴ� �޼��� ���� ����ϱ�.
		if (uDAO.select(id)!=null || id=="") {
			//���� �޽��� �߰��Ͽ� ȸ������ �������� �ٽ� �̵�
			request.setAttribute("id_error", "�̹� �����ϴ� ���̵��̰ų� �Ұ����� ���̵� �Դϴ�..");
			new RegisterViewCommand().execute(request, response);
		}
		else if (password=="" || !password.equals(rePassword)) {
			request.setAttribute("pw_error", "�н����尡 �����̰ų�, �н����尡 ��ġ���� �ʽ��ϴ�.");
			new RegisterViewCommand().execute(request, response);
		}
		else {
			// DAO���� ���� ���� �����ϱ�.
			String hashPassword = SHA256Util.sha256(password);
			int result = 0;
			
			if(name.equals("")) name = null;
			if(gender==null || gender.equals("")) gender ="2";
			if(hashPassword!=null) result = uDAO.registerUser(id, hashPassword, name, Integer.parseInt(gender));
			
			if(result != 0) {
				UserDTO uDTO = uDAO.select(id);
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("userSeq", uDTO.getSeq());
				new BoardListCommand().execute(request,response);
			}
		}
	}
}
