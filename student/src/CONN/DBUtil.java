package CONN;

import java.sql.*;

public class DBUtil {

	public static Connection getconnectionSQLSERVER() throws SQLException {
		// TODO Auto-generated method stub
		final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost;DatabaseName=data12";
		String user="sa"; //�����㿪ͨ��������ݿ��û���
		String password="123456";// //�����㿪ͨ��������ݿ�����
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
