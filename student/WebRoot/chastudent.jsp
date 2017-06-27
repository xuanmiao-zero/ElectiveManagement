<%@ page import="java.sql.*"%>
<%@ page import="CONN.*" %>
<%@  page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据处理页面</title>
</heasssd>
<body bgcolor="CCCFFF">
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
     Connection conn=DBUtil.getconnectionSQLSERVER();
	Statement stmt=conn.createStatement();
	String  uid=request.getParameter("uid");
	byte b[]=uid.getBytes("ISO-8859-1");
	uid=new String(b,"UTF-8");
	String sql="select uid,uname,password,email from xuesheng where uid="+uid;
	ResultSet rs=stmt.executeQuery(sql);
   
	

    
 
                  	
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


<center>

<form action="xuexin.jsp"method="post">
<input type="submit"value="返回">
</form>
</center>
</body>
</html>