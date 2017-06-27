package DAO;



import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

	public class AdengluServlet extends HttpServlet{
	  
	  public void doPost (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  Admin adm=new Admin(username,password);
		  boolean result2=AdminDAO.register2(adm);	  
		  response.setContentType("text/html;charset=utf-8");

		     PrintWriter out = response.getWriter();
		     out.print("<html><head>");
		     out.print( "<meta charset=utf-8>");
		     out.print( "</head>");
		     out.print("<body>");
		  
		//  PrintWriter out = response.getWriter();
		    System.out.println(result2);
	       if(result2)
	       {
	    	   response.sendRedirect("ye.html"); 
	       }
	       else
	       {
	    	   out.println("µÇÂ½Ê§°Ü");
	       }
		  
	         out.print("</body></html>");
	  	 out.close();
			
		

}
}