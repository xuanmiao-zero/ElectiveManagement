package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.Student;

@WebServlet("/StudentLoginCheck")
public class StudentLoginCheck extends HttpServlet {
	private static final long serialVersionUID = -3888646370143708782L;
	public StudentLoginCheck(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String userName =request.getParameter("L_UserName");
		String passWord=request.getParameter("L_PassWord");
		
		Student user= new Student();
		
		try{
			if(user.equal(userName, passWord)!=null){
				
				user = user.equal(userName, passWord);
				HttpSession session = request.getSession();
				session.setAttribute("userName", user.getUserName());
				System.out.println(session.getAttribute("userName").toString());
				session.setAttribute("id", user.getId());
				response.sendRedirect("administratormanagement.html");
			
			}else{
				response.sendRedirect("loginfail.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
