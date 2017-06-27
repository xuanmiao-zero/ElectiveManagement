<%@ page import="java.sql.*"%>
<%@  page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="CONN.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body bgcolor="CCCFFF">
<% 
	 request.setCharacterEncoding("UTF-8");
	String uid=request.getParameter("uid");
	String uname=request.getParameter("uname");

	String password=request.getParameter("password");
		
	String email=request.getParameter("email");
    Connection conn=DBUtil.getconnectionSQLSERVER();
    Statement stmt=conn.createStatement();
	
	String sql="update xuesheng set uid='"+uid+"',uname='"+uname+"',password='"+password+"',email='"+email+"' where uid='"+uid+"'";
	stmt.executeUpdate(sql);

	ResultSet rs=stmt.executeQuery("select * from coures where uid="+uid+"");      
 %>	

<center>
<br><br><br>
  <br><br><br>
<h3>修改成功！</h3>


 <form name="gaiform" method="POST" action="UpdateStudent.jsp">
       <input type="submit" value="确定" >
     </form>
</center>
</body>
</html>