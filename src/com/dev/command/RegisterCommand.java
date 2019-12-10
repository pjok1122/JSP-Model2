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
		
		//존재하는 아이디인지 확인하는 메서드 만들어서 사용하기.
		if (uDAO.select(id)!=null || id=="") {
			//에러 메시지 추가하여 회원가입 페이지로 다시 이동
			request.setAttribute("id_error", "이미 존재하는 아이디이거나 불가능한 아이디 입니다..");
			new RegisterViewCommand().execute(request, response);
		}
		else if (password=="" || !password.equals(rePassword)) {
			request.setAttribute("pw_error", "패스워드가 공란이거나, 패스워드가 일치하지 않습니다.");
			new RegisterViewCommand().execute(request, response);
		}
		else {
			// DAO에게 계정 생성 질의하기.
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
