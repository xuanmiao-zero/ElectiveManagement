package CONN;

import java.sql.*;

public class DBUtil {

	public static Connection getconnectionSQLSERVER() throws SQLException {
		// TODO Auto-generated method stub
		final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost;DatabaseName=data12";
		String user="sa"; //输入你开通信里的数据库用户名
		String password="123456";// //输入你开通信里的数据库密码
		Connection conn=null;
		 try{
				Class.forName(DBDRIVER);
			}catch(ClassNotFoundException e){
			}
			try{
				conn = DriverManager.getConnection(url,user,password);
			}catch(SQLException e){	  e.printStackTrace();
			}
		return conn;		
	}

}
