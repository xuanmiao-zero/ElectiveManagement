package KDAO;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class Select2Servlet extends HttpServlet{
	protected void doGet (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String ccode=request.getParameter("ccode");
		  String cname=request.getParameter("cname");  
		  String ctime=request.getParameter("ctime");
		 // String ctime1=request.getParameter("ctime");
		  String credit=request.getParameter("credit");
		  
		  Select2DAO sel=new Select2DAO();
		  if(sel.selectstudent(ccode,cname,ctime,credit)){
			  response.sendRedirect("message3.jsp");
		  }else{
			  System.out.println("Ñ¡¿ÎÊ§°Ü");
			  response.sendRedirect("xuanke.html");
		  }
	}

}
