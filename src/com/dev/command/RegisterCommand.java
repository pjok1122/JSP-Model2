package com.dev.command;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dev.dao.UserDAO;
import com.dev.dto.UserDTO;
import com.dev.encrypt.SHA256Util;

public class RegisterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 추출
		 
        // 2. 유효성 체크
         
        // 3. VO 객체에 데이터 바인딩
         
        // 4. Service 객체의 데이터 바인딩
         
        // 5. Output View 페이지로 이동
		
		if (request.getMethod().equals("POST")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("re_password");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			UserDAO uDAO = new UserDAO();
			//존재하는 아이디인지 확인하는 메서드 만들어서 사용하기.
			if (uDAO.select(id)==null) {
				//에러 메시지 추가하여 회원가입 페이지로 다시 이동
			}
			
			if (id!="" && password!="" && password.equals(rePassword)) {
				try {
					// DAO에게 계정 생성 질의하기.
					String hashPassword = SHA256Util.sha256(password);
					if(name.equals("")) name = null;
					if(gender==null || gender.equals("")) gender ="2";
					
					boolean result = uDAO.registerUser(id, hashPassword, name, Integer.parseInt(gender));
					if(result) {
						HttpSession session = request.getSession();
						session.setAttribute("userId", id);
					}
					
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
