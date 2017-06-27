<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="CONN.*" %>
<%@  page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据处理页面</title>
<script type="text/javascript">
	function validate()
	{
		var ccode=document.forms[0].ccode.value;
		var cname=document.forms[0].cname.value;
		
		var ctime=document.forms[0].ctime.value;
		var credit=document.forms[0].credit.value;
		if(ccode<=0)
			{
				alter("课程号不能为空，请输入课程号!");
				return false;
			}
		else if(cname.length<=0){
			alter("课程名不能为空，请输入课程名!");
			return false;
		}
		
		else if(ctime<=0){
			alter("学时不能为空,请输入课时!");
			return false;
		}
		else if(credit<=0){
			alter("学分不能为空,请输入课时");
			return false;
		}
	}
</script>
</head>
  
  <body  bgcolor="CCCFFF">
   <center>
    <br><br><br>
      
  <% 
      
       response.setCharacterEncoding("UTF-8");
      request.setCharacterEncoding("UTF-8");
      String ccode=request.getParameter("ccode");
      Connection conn=DBUtil.getconnectionSQLSERVER();
      Statement stmt=conn.createStatement();
      String sql1 =   "select * from coures where ccode='"+ccode+"'" ;
      ResultSet rs= stmt.executeQuery(sql1);
      
%>

<%
while(rs.next()){
	
	out.print("");
	out.print("");
	
	out.print("");		
	
	out.print("");

%>
    <h3>确定将课程信息删除吗？</h3>
<form action="deletecoursegaiShow.jsp"method="post"onSubmit="return validate()">
<h4>课程号：<input type="text" name="ccode" value=" <%=rs.getString("ccode")%>"title="课程号不能改变"readonly="readonly"></input><br></h4>
<h4>课程名：<input type="text" name="cname" value=" <%=rs.getString("cname")%>"   title="课程名不能为空"></input><br></h4>

<h4>课时：<input type="text" name="ctime"  value="<%=rs.getString("ctime")%>"title="课时不能为空"></input><br></h4>
<h4>学分：<input type="text" name="credit"  value="<%=rs.getString("credit")%>"title="学分不能为空"></input><br></h4>
<input type="submit"value="修改">
&nbsp;&nbsp;&nbsp;
<input name="clear" type="reset" value"取消"/>
 </td>
<br>


<%
    }
 %>

    </center>
    

</form>
  </body>
</html>
