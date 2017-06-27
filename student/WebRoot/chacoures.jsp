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
     课程信息表<br>
     <table border=2 bgcolor="ccceee" align="center">
     <tr>
     <td>课程编号</td>
     <td>课程名称</td>
     <td>课时</td>
     <td>学分</td>    
     </tr>

 <% 
    Connection conn=DBUtil.getconnectionSQLSERVER();
	Statement stmt=conn.createStatement();
	String  ccode=request.getParameter("ccode");
	byte b[]=ccode.getBytes("ISO-8859-1");
	ccode=new String(b,"UTF-8");
	String sql1="select ccode,cname,ctime,credit from coures where [ccode]="+ccode;
	ResultSet rs=stmt.executeQuery(sql1);
   
	

                  	
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


<center>

<form action="kecheng.jsp"method="post">
<input type="submit"value="返回">
</form>
</center>
</body>
</html>