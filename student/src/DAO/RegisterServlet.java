package DAO;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;




public class RegisterServlet extends HttpServlet{
  
  public void doPost (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    //ServletContext context=getServletContext();
    //Counter counter=(Counter)context.getAttribute("counter");
	  String target = "/denglu.htm";
     int userid=Integer.parseInt(request.getParameter("userid"));
     String username=request.getParameter("username");
     String password=request.getParameter("password");
     String email=request.getParameter("email");
     User user=new User(userid,username,password,email);
     boolean result=UserDAO.register( user);
     response.setContentType("text/html;charset=utf-8");

     PrintWriter out = response.getWriter();
     out.print("<html><head></head>");
     out.print("<body>");
     //out.print("<h1>+��ӭ���ٱ�վ�����ǵ�" +counter.getCounter()+"λ�����ߡ�</h1>");
     
    
     if(result)
     {
    	 out.println("���ʳɹ�");
    	    ServletContext context = getServletContext();
    	    RequestDispatcher dispatcher =context.getRequestDispatcher(target);
    	    dispatcher.forward(request, response);
     }
     else
     {
    	 out.println("����ʧ��");
    	
     }
         out.print("</body></html>");
	 out.close();
    
  }
}




