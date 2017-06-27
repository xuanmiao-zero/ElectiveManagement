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
 <h2>查询选课信息</h2><br>
<form action="chacoures.jsp"method="post">
<p>请选择查询课程的课程号：
<select name="ccode">
<%
   Connection conn=DBUtil.getconnectionSQLSERVER();
	String sql="select * from coures";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next()){
		String SNo=rs.getString("ccode");
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
     课程信息表<br>
     <table border=2 bgcolor="ccceee" align="center">
      <tr>
     <td>课程编号</td>
     <td>课程名</td>
     <td>课时</td>
     <td>学分</td>    
     </tr>

   <% 
	
    String sql1 =   "select * from coures" ;


                  	
    while(rs.next()){
     %>
    
     <tr>
          <td><%= rs.getString("ccode") %></td>
          <td><%= rs.getString("cname")%></td>
           <td><%=rs.getString("ctime")%></td>  
           <td><%= rs.getString("credit")%></td>     			
      </tr>
<% 
      }
            
    %>	
 
    
      </table>
  </center>
     
</body>
</html>