package DAO;



import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class AddReportServlet extends HttpServlet{
	protected void doGet (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String uid=request.getParameter("uid");
		  String ccode=request.getParameter("ccode");  
		  String report=request.getParameter("report");
	
		 
		  AddDAO2 add=new AddDAO2();
		  if(add.addReport(uid,ccode,report)){
			  response.sendRedirect("message1.jsp");
		  }else{
			  System.out.println("ÃÌº” ß∞‹");
			  response.sendRedirect("addReport.jsp");
		  }
}


protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doGet(request,response);
}
}

