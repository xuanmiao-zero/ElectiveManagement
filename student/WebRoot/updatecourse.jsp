<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="CONN.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>score Page</title>
</head>
 <body bgcolor="CCCFFF">
   
  <center>
     <br><br><br><br><br>
     课程信息表<br>
     <table border=2 bgcolor="ccceee" align="center">
     <tr>
     <td>课程编号</td>
     <td>课程名</td>
     <td>课时</td>
     <td>学分</td>    
     </tr>

   <%
    
    response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	String ccode=request.getParameter("ccode");
	String cname=request.getParameter("cname");
	
	String ctime=request.getParameter("ctime");
			
	String credit=request.getParameter("credit");
	Connection conn=DBUtil.getconnectionSQLSERVER();
  
    Statement stmt=conn.createStatement();
    
    String sql1 =  "select * from coures" ;
    
    ResultSet rs= stmt.executeQuery(sql1);
    %>
   
   <%          	
    while(rs.next()){
     %>
    
     <tr>
          <td><%= rs.getString("ccode") %></td>
          <td><%= rs.getString("cname")%></td>
           <td><%=rs.getString("ctime")%></td>  
           <td><%= rs.getString("credit")%></td>    
           <td><a href="updatecoursegai.jsp?ccode=<%=rs.getString("ccode") %>">修改</a></td> 			
      </tr>
<% 
      }
            
    %>	
  
    
      </table>
  </center>
     
</body>
</html>