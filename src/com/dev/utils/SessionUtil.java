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

	//세션 아이디와 글의 소유자가 일치하는지를 확인하는 메써드
	public boolean isOwner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userId").equals(request.getParameter("uId"))){
			return true;
		} else {
			return false;
		}
	}
}
