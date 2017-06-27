package DAO;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class SelectServlet extends HttpServlet{
	protected void doGet (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String ccode=request.getParameter("ccode");
		  String cname=request.getParameter("cname");  
		  String ctime=request.getParameter("ctime");
		 // String ctime1=request.getParameter("ctime");
		  String credit=request.getParameter("credit");
		  
		  SelectDAO sel=new SelectDAO();
		  if(sel.selectstudent(ccode,cname,ctime,credit)){
			  response.sendRedirect("message2.jsp");
		  }else{
			  System.out.println("ÃÌº” ß∞‹");
			  response.sendRedirect("selectcourse.jsp");
		  }
	}

}
