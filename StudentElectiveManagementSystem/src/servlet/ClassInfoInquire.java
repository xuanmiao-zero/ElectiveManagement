package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Student;
import user.Class;
//@WebServlet("/StudentInfoAdd")
public class ClassInfoInquire extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3888646370143708782L;
	public ClassInfoInquire(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Class user= new Class();
			System.out.println("CLASSInfoInquire");
	        PrintWriter writer = null;
	        try{
	        	response.setContentType("text/html");
	            writer = response.getWriter();
	            try {
					writer.print(user.inquireAll());
//					System.out.println(user.inquireAll());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }finally{
	            if(writer != null){
	                writer.close();
	            }
	        }
	}
}
