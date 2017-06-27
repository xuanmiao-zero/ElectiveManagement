<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息添加</title>
</head>

<body bgcolor="CCCFFF">
<center>
<br>
<br>
<br>
<h3>&nbsp;&nbsp;添加学生信息</h3>
<form  name=addForm"  action="AddStudentServlet" method="get">
  <table border="1" width="230">
     <tr>
        <td>学号:</td>
        <td><input type="text" name="uid"></td>
     </tr> 
     <tr>
        <td>姓名:</td>
        <td><input type="text" name="uname"></td>
     </tr>
     <tr>
       <td>密码：</td>
       <td><input type="text"  name="password"></td>
     </tr>
     <tr>
       <td>邮件：</td>
       <td><input type="text"  name="email"></td>
     </tr>
     <tr align="center">
       <td colspan="2">
       <input name="sure" type="submit" value="提交"/>
       &nbsp;&nbsp;&nbsp;&nbsp;
       <input name="clear" type="reset" value="取消"/>
       </td>
       
      </tr>
      </table>
      </form>
     </center>

  </body>
</html>