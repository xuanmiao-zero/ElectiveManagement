/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.11
 * Generated at: 2017-05-07 12:23:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("    <html>\r\n");
      out.write("    <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("    <link href=\"../css/bootstrap-theme.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("    <title>JS框架学习</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body onload=\"loadUserDatas()\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <table class=\"table\" id=\"table\">\r\n");
      out.write("       <caption><h2>迈睿练习一</h2></caption>\r\n");
      out.write("       <caption>\r\n");
      out.write("               <button type=\"button\" class=\"btn btn-info\" id=\"user_add\" data-toggle=\"modal\" \r\n");
      out.write("       data-target=\"#myModal\" onclick=\"optionUserData(this);\">新增</button>\r\n");
      out.write("               <button type=\"button\" class=\"btn btn-info\" id=\"user_delete\" onclick=\"optionUserData(this);\">删除</button>\r\n");
      out.write("               <button type=\"button\" class=\"btn btn-info\" id=\"user_edit\"  data-toggle=\"modal\" \r\n");
      out.write("       data-target=\"#myModal\"  onclick=\"optionUserData(this);\">编辑</button>\r\n");
      out.write("               <button type=\"button\" class=\"btn btn-info\" id=\"user_find\" onclick=\"optionUserData(this);\">查询</button>\r\n");
      out.write("               <input type=\"text\" id=\"s_code\" placeholder=\"按工号查询\" style=\"width: 80px;\">\r\n");
      out.write("               <input type=\"text\" id=\"s_userName\" placeholder=\"按姓名查询\" style=\"width: 80px;\">\r\n");
      out.write("               <input type=\"text\" id=\"s_all\" placeholder=\"全文搜索\" style=\"width: 80px;\">\r\n");
      out.write("       </caption>\r\n");
      out.write("       <thead>\r\n");
      out.write("          <tr>\r\n");
      out.write("               <th>序号</th>\r\n");
      out.write("             <th>工号</th>\r\n");
      out.write("             <th>姓名</th>\r\n");
      out.write("             <th>性别</th>\r\n");
      out.write("             <th>密码</th>\r\n");
      out.write("             <th>年龄</th>\r\n");
      out.write("             <th>出生日期</th>\r\n");
      out.write("          </tr>\r\n");
      out.write("       </thead>\r\n");
      out.write("       <tbody id=\"tbody\">\r\n");
      out.write("       </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    <!-- 模态框（Modal） -->\r\n");
      out.write("    <div class=\"modal hide\" id=\"myModal\"  role=\"dialog\" >\r\n");
      out.write("       <div class=\"modal-dialog\">\r\n");
      out.write("          <div class=\"modal-content\">\r\n");
      out.write("             <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"> \r\n");
      out.write("                      &times;\r\n");
      out.write("                </button>\r\n");
      out.write("                <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("                       新增用户\r\n");
      out.write("                </h4>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"modal-body\" id=\"modal-body\">\r\n");
      out.write("                <label for=\"name\">工号:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_code\" placeholder=\"请输入工号\">\r\n");
      out.write("                  <label for=\"name\">姓名:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_userName\" placeholder=\"请输入姓名\">\r\n");
      out.write("                  <label for=\"name\">性别:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_sex\" placeholder=\"请输入性别\">\r\n");
      out.write("                  <label for=\"name\">密码:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_passWord\" placeholder=\"请输入密码\">\r\n");
      out.write("                 <label for=\"name\">年龄:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_age\" placeholder=\"请输入年龄\">\r\n");
      out.write("                  <label for=\"name\">出生日期:</label>\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"m_birthday\" placeholder=\"请输入出生日期\">\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("                   data-dismiss=\"modal\">保存\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\">提交更改</button>\r\n");
      out.write("             </div>\r\n");
      out.write("          </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../js/jquery.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"index.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("    </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}