package servlet;

import java.io.IOException;
import user.Class;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Student;

//@WebServlet("/StudentInfoAdd")
public class ClassInfoAdd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3888646370143708782L;
	public ClassInfoAdd(){
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

		int passWord = Integer.parseInt(request.getParameter("passWord"));
		float class_credit=Float.parseFloat(request.getParameter("class_credit"));
		String calss_intro=request.getParameter("class_intro");
		Class user= new Class();
		try{
			if(user.register(studentId,name,passWord,class_credit,calss_intro)){
				response.getWriter().write(1);
			}else{
				response.getWriter().write(0);
			}

//			System.out.println("CLASSInfoAdd");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
