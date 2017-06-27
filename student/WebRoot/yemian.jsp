<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>EasyUI入门——创建EasyUI的Dialog</title>
  <!-- 引入JQuery -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
  <!-- 引入EasyUI -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
  <!-- 引入EasyUI的样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"/>
  <!-- 引入EasyUI的图标样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/icon.css" type="text/css"/>
 
  <script type="text/javascript">
  $('#cc').layout();   

  // 折叠 west panel  

   $('#cc').layout('collapse','west');  
  </script>
  
  </head>
  
  <body class="easyui-layout">
    
    <div region="west" split="true" title="学生界面" style="width:100px;">
       <div id="aa" class="easyui-accordion"  style="width:300px;height:200px;">    
        	<div title="本学期成绩"  style="overflow:auto;padding:10px;"iconCls="icon-tip">     
           	 	<p>本学期成绩</p>    
        	</div>    
        	<div title="选课"  selected="true" style="padding:10px;">    
               	选课
        	</div>    
        	<div title="查看选课结果">    
               	  查看选课结果     
    		</div>    
		</div>    
    </div>  
    <div region="center" title="center title" style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs" fit=true style="width:500px;height:250px;">    
        	<div title="本学期成绩" style="padding:20px;display:none;"style="width:500px;height:250px;">    
        	</div>    
        	<div title="上学期成绩" closable="true" style="overflow:auto;padding:20px;display:none;">    
                                                         上学期成绩
        	</div>        
    	</div>    
    </div> 
    
    
    
    
    
 </body>
</html>