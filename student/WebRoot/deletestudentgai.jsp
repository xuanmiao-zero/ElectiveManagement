<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="CONN.*" %>
<%@  page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据处理页面</title>
</head>
  
  <body  bgcolor="CCCFFF">
   <center>
    <br><br><br>
 
    
  <% 
      response.setCharacterEncoding("UTF-8");
      request.setCharacterEncoding("UTF-8");
      String uid=request.getParameter("uid");
      Connection conn=DBUtil.getconnectionSQLSERVER();
      String sql1 ="select * from xuesheng where uid='"+uid+"'" ;
      
      Statement stmt=conn.createStatement();
      ResultSet rs= stmt.executeQuery(sql1);
      
%>

<%
while(rs.next()){
	
	out.print("");
	out.print("");
	
	out.print("");		
	
	out.print("");

%>

    <h3>确定将学生信息修改吗？</h3>
<form action="deletestudentShow.jsp"method="post"onSubmit="return validate()">
<h4>学号：<input type="text" name="uid" value=" <%=rs.getString("uid")%>"title="学号不能改变"readonly="readonly"></input><br></h4>
<h4>姓名：<input type="text" name="uname"  value=" <%=rs.getString("uname")%>" title="姓名不能为空"></input><br></h4>

<h4>密码：<input type="text" name="password" value="<%=rs.getString("password")%>"title="密码不能为空"></input><br></h4>
<h4>邮件：<input type="text" name="email"  value=" <%=rs.getString("email")%>" title="邮件能为空">        </input><br></h4>
<input type="submit"value="删除">
&nbsp;&nbsp;&nbsp;
<input name="clear" type="reset" value"取消"/>




<%
    }
 %>

    </center>
  

</form>

  </body>
</html>
