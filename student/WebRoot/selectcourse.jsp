<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>课程信息添加</title>
</head>

<body bgcolor="CCCFFF">
<center>
<br>
<br>
<br>
<h3>&nbsp;&nbsp;添加课程信息</h3>
<form  name=selectForm"  action="SelectServlet"  method="get">
  <table border="1" width="230">
     <tr>
        <td>课程编号:</td>
        <td><input type="text" name="ccode"></td>
     </tr> 
     <tr>
        <td>课程名称:</td>
        <td><input type="text" name="cname"></td>
     </tr>
     <tr>
       <td>课时：</td>
       <td><input type="text"  name="ctime"></td>
     </tr>
     <tr>
       <td>学分：</td>
       <td><input type="text"  name="credit"></td>
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