package DAO;



import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

	public class dengluServlet extends HttpServlet{
	  
	  public void doPost (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String username=request.getParameter("username").toString();
		  String password=request.getParameter("password");
		  User user1=new User(username,password);
		  boolean result1=UserDAO1.register1(user1);
		  
		   response.setContentType("text/html;charset=utf-8");

		     PrintWriter out = response.getWriter();
		     out.print("<html><head>");
		     out.print( "<meta charset=utf-8>");
		     out.print( "</head>");
		     out.print("<body>");
		  
		//  PrintWriter out = response.getWriter();
		    System.out.println(result1);
	       if(result1)
	       {
	    	   response.sendRedirect("xueye.html"); 
	       }
	       else
	       {
	    	   out.println("µÇÂ½Ê§°Ü");
	       }
		  
	         out.print("</body></html>");
	  	 out.close();
			
		

}
}