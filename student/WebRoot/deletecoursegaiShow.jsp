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
	String ccode=request.getParameter("ccode");
	String cname=request.getParameter("cname");

	String ctime=request.getParameter("ctime");
		
	String credit=request.getParameter("credit");
    Connection conn=DBUtil.getconnectionSQLSERVER();
    Statement stmt=conn.createStatement();
	
	String sql="delete from coures where ccode="+ccode;
	 stmt.executeUpdate(sql);

	         
 %>	

<center>

<br><br><br>
  <br><br><br>
<h3>删除成功！</h3>


 <form name="gaiiform" method="POST" action="deletecourse.jsp">
       <input type="submit" value="确定" >
     </form>
</center>
</body>
</html>