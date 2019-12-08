package com.dev.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 가져오기
		String name = (String) request.getAttribute("name");
		String password = (String) request.getAttribute("password");
		
		// DAO에게 질의하기.
	}

}
