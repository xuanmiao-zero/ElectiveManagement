//package database;
//
//import java.sql.*;
//
//public class DB {
//	//定义数据库的驱动程序
//	private static final String DBDRIVER="com.mysql.jdbc.Driver";
//	//定义mysql数据库的链接地址
//	private	static final String DBURL="jdbc:mysql://localhost:3306/javaweb_user";
//	//定义mysql数据库的链接用户名
//	private static final String DBUSER="root";
//	//定义mysql数据库的链接密码
//	private static final String DBPASS="root";
//	public Connection con =null;
//	public PreparedStatement psta=null;
//	public Statement sta =null;
//	public ResultSet res=null;
//	
//	public DB(){}
//	public Connection DBLink()throws Exception{
//		try{
//			Class.forName(DBDRIVER).newInstance();//Class.forName(“”)返回的是类。Class.forName(“”).newInstance()返回的是object
//			System.out.println("数据库驱动加载完成");
//		}catch(java.lang.ClassNotFoundException e){
//			System.out.print("Class.forName or DriverManager.registerDriver Exception:"+e.getMessage());
//		}
//		try{
//			con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
//			System.out.println("数据库连接完成");
//		}catch(SQLException e){
//			System.out.print("SQL DriverManager or Statement Exception:"+e.getMessage());
//		}
//		return con;
//	}
//	public void DBout(){
//		try{
//			if(res!=null){
//				res.close();
//				res=null;
//			}
//			psta.close();
//			psta=null;
//			con.close();
//			con=null;
//			System.out.println("数据库关闭");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
//}
package database;

import java.sql.*;

 public class DB{
		private static final String DBURL="jdbc:mysql://localhost:3306/elective_management";
		private static final String DBDRIVER="com.mysql.jdbc.Driver";
		private static final String DBUSER="root";
		private static final String DBPASS="root";
	    public Connection con = null;
	    public PreparedStatement psta=null;
	    public Statement sta=null;
	    public ResultSet res = null;
	    
		public DB(){}
		
		public Connection DBLink()throws Exception{
			
		    try{
		        Class.forName(DBDRIVER).newInstance();
		        System.out.println("数据库驱动加载完成");
		    }
		    catch(java.lang.ClassNotFoundException e){
		        System.out.print("Class.forName or DriverManager.registerDriver Exception:"+e.getMessage());
		    }

		    try{
		        con=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		        System.out.println("数据库连接完成");
		    }
		    catch(SQLException e){
		        System.out.print("SQL DriverManager or Statement Exception:"+e.getMessage());
		    }
		    return con;
		}
		
		public void DBOut(){
			try{
				if(res!=null){
					res.close();
					res=null;
				}
				psta.close();
				psta=null;
				con.close();
				con=null;
				System.out.println("数据库关闭");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
}
