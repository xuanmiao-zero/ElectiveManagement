package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Student;

//@WebServlet("/StudentInfoAdd")
public class StudentInfoModify extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3888646370143708782L;
	public StudentInfoModify(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String studentId =request.getParameter("studentId");
		String name=request.getParameter("name");
		String passWord=request.getParameter("passWord");
		Student user= new Student();
		try{
			System.out.println("StudentInfoModify");
			if(user.modify(studentId, name, passWord)){
				response.getWriter().write(1);
			}else{
				response.getWriter().write(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
