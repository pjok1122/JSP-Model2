package com.dev.frontController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.command.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Command> controllerMap = null;
    HashMap<String, String> viewPages = null;
	@Override
	public void init() throws ServletException {
		// 서브컨트롤러와 뷰 페이지 객체 생성
		controllerMap = new HashMap<String, Command>();
		viewPages = new HashMap<String, String>();
		
		// 서브 컨트롤러 전부 등록
		controllerMap.put("/loginAuth.do", new LoginCommand());
		controllerMap.put("/register.do", new RegisterCommand());
		
		// 뷰 페이지 전부 등록..
		viewPages.put("/login.do", "login.jsp");
		viewPages.put("/register.do", "register.jsp");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = null;
		Command subController = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		
		subController = controllerMap.get(path); //HashMap에 없는 값을 찾으면 무슨 예외가 발생하지?
		viewPage = viewPages.get(path);
		if (subController!= null)
			subController.execute(request,response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}
//	public static void main(String[] args) {
//		HashMap<String, String> map = new HashMap<String,String>();
//		String val = map.get("key");
//		System.out.println(val);
//	}

}
