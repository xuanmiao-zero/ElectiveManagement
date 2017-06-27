package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Class;
import user.Student;

//@WebServlet("/StudentInfoAdd")
public class ClassInfoModify extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3888646370143708782L;
	public ClassInfoModify(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		int passWord = Integer.parseInt(request.getParameter("passWord"));
		float class_credit=Float.parseFloat(request.getParameter("class_credit"));
		String calss_intro=request.getParameter("class_intro");
		Class user= new Class();
		try{
			System.out.println("StudentInfoModify");
			if(user.modify(name, passWord, class_credit,calss_intro)){
				response.getWriter().write(1);
			}else{
				response.getWriter().write(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
