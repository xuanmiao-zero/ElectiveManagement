package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Student;

//@WebServlet("/StudentInfoAdd")
public class StudentInfoDelete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3888646370143708782L;
	public StudentInfoDelete(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int studentId =Integer.parseInt(request.getParameter("studentId"));
		Student user= new Student();
		try{
			System.out.println("StudentInfoDelete");
			if(user.delete(studentId)){
				response.getWriter().write(1);
			}else{
				response.getWriter().write(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
