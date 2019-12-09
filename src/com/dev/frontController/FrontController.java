package com.dev.frontController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.command.*;
import com.dev.viewCommand.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Command> commandMap = null;
    HashMap<String, String> viewPages = null;
	@Override
	public void init() throws ServletException {
		// 서브컨트롤러와 뷰 페이지 객체 생성
		commandMap = new HashMap<String, Command>();
		
		// 서브 컨트롤러 전부 등록
		commandMap.put("/main.do", new BoardListCommand());
		commandMap.put("/loginAuth.do", new LoginCommand());
		commandMap.put("/register.do", new RegisterCommand());
		commandMap.put("/logout.do", new LogoutCommand());
		commandMap.put("/login.do", new LoginCommand());
		commandMap.put("/write.do", new WriteCommand());
		commandMap.put("/content.do", new ContentCommand());
		commandMap.put("/update.do", new UpdateCommand());
		commandMap.put("/delete.do", new DeleteCommand());
		// 뷰 페이지 전부 등록..
		commandMap.put("/login_view.do", new LoginViewCommand());
		commandMap.put("/register_view.do", new RegisterViewCommand());
		commandMap.put("/write_view.do", new WriteViewCommand());
		commandMap.put("/update_view.do", new UpdateViewCommand());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");
		
		Command command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		
		command = commandMap.get(path); //HashMap에 없는 값을 찾으면 무슨 예외가 발생하지?
		if(command!=null)
			command.execute(request,response);
		else {
			response.sendRedirect("main.do");
		}
	}

}
