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
 <body  bgcolor="CCCFFF">
 
 <h2>查询学生信息</h2><br>
<form action="chastudent.jsp"method="post">
<p>请选择查询学生的学号：
<select name="uid">
<%
   Connection conn=DBUtil.getconnectionSQLSERVER();
	String sql="select * from xuesheng";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next()){
		String SNo=rs.getString("uid");
%>	
<option value="<%=SNo%>"><%=SNo%></option>
<% 	
	}
	
%>
   
	</p>
	<p>
	<input type="submit" value="确定">&nbsp;
	<input type="button"value="返回"
	onclick="javascript:history.go(-1)">
	</p>
</select>
      
  <center>
     <br><br><br><br><br>
     学生信息表<br>
     <table border=2 bgcolor="ccceee" align="center">
     <tr>
     <td>学号</td>
     <td>姓名</td>
     <td>密码</td>
     <td>邮件</td>    
     </tr>

   <% 
	
    String sql1 =   "select * from xuesheng" ;

    
 
                  	
    while(rs.next()){
    %>
     <tr>
          <td><%= rs.getString("uid") %></td>
          <td><%= rs.getString("uname")%></td>
           <td><%=rs.getString("password")%></td>  
           <td><%= rs.getString("email")%></td> 			
      </tr>
   <% 
      }
      
      
    %>	
    
  </table>
  </center>
     
</body>
</html>