<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>学生成绩添加</title>
</head>

<body bgcolor="CCCFFF">
<center>
<br>
<br>
<br>
<h3>&nbsp;&nbsp;添加学生成绩</h3>
<form  name=addForm"  action="AddReportServlet" method="get">
  <table border="1" width="230">
     <tr>
        <td>学号:</td>
        <td><input type="text" name="uid"></td>
     </tr> 
     <tr>
        <td>课程号:</td>
        <td><input type="text" name="ccode"></td>
     </tr>
     <tr>
       <td>成绩：</td>
       <td><input type="text"  name="report"></td>
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