package DAO;



import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class AddStudentServlet extends HttpServlet{
	protected void doGet (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String uid=request.getParameter("uid");
		  String uname=request.getParameter("uname");  
		  String password=request.getParameter("password");
	      String email=request.getParameter("email");
		 
		  AddDAO add=new AddDAO();
		  if(add.addStudent(uid,uname,password,email)){
			  response.sendRedirect("message1.jsp");
		  }else{
			  System.out.println("ÃÌº” ß∞‹");
			  response.sendRedirect("addStudent.jsp");
		  }
}


protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doGet(request,response);
}
}

