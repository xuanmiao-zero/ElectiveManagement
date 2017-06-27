package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Student;

@WebServlet("/StudentRegisterCheck")
public class StudentRegisterCheck extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6154988921044034920L;
	public StudentRegisterCheck(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String studentId =request.getParameter("R_Student_ID");
		String userName = request.getParameter("R_UserName");
		String passWord = request.getParameter("R_PassWord");
		Student user = new Student();
		try{
			if(user.register(studentId,userName, passWord)){
				response.sendRedirect("logininandup.html");
			}else{
				response.sendRedirect("registerfail.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
