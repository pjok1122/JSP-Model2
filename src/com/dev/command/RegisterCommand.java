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
        // 1. �Ķ���� ����
		 
        // 2. ��ȿ�� üũ
         
        // 3. VO ��ü�� ������ ���ε�
         
        // 4. Service ��ü�� ������ ���ε�
         
        // 5. Output View �������� �̵�
		
		if (request.getMethod().equals("POST")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("re_password");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			UserDAO uDAO = new UserDAO();
			//�����ϴ� ���̵����� Ȯ���ϴ� �޼��� ���� ����ϱ�.
			if (uDAO.select(id)==null) {
				//���� �޽��� �߰��Ͽ� ȸ������ �������� �ٽ� �̵�
			}
			
			if (id!="" && password!="" && password.equals(rePassword)) {
				try {
					// DAO���� ���� ���� �����ϱ�.
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
