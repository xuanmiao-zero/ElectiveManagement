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
 <body bgcolor="CCCFFF" >
   
  <center>
     <br><br><br><br><br>
     学生成绩表<br>
     <table border=2 bgcolor="ccceee" align="center">
     <tr>
     <td>学号</td>
     <td>课程编号</td>
     <td>分数</td>    
     </tr>
   <% 
	Connection conn=DBUtil.getconnectionSQLSERVER();
    String sql1 =   "select * from xuanke" ;

    Statement stmt=conn.createStatement();
    ResultSet rs= stmt.executeQuery(sql1);
    
                  	
    while(rs.next()){
    %>
     <tr>
          <td><%= rs.getString("uid") %></td>
          <td><%= rs.getString("ccode")%></td>
           <td><%=rs.getString("report")%></td>    			
      </tr>
                 			
     <% 
      }
    %>	
    
      </table>
  </center>
     
</body>
</html>