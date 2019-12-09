package com.dev.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	public boolean isLogined(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null) {
			return true;
		}else {
			return false;
		}
	}

	//���� ���̵�� ���� �����ڰ� ��ġ�ϴ����� Ȯ���ϴ� �޽��
	public boolean isOwner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userId").equals(request.getParameter("uId"))){
			return true;
		} else {
			return false;
		}
	}
}
