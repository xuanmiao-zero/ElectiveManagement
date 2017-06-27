//package database;
//
//import java.sql.*;
//
//public class DB {
//	//�������ݿ����������
//	private static final String DBDRIVER="com.mysql.jdbc.Driver";
//	//����mysql���ݿ�����ӵ�ַ
//	private	static final String DBURL="jdbc:mysql://localhost:3306/javaweb_user";
//	//����mysql���ݿ�������û���
//	private static final String DBUSER="root";
//	//����mysql���ݿ����������
//	private static final String DBPASS="root";
//	public Connection con =null;
//	public PreparedStatement psta=null;
//	public Statement sta =null;
//	public ResultSet res=null;
//	
//	public DB(){}
//	public Connection DBLink()throws Exception{
//		try{
//			Class.forName(DBDRIVER).newInstance();//Class.forName(����)���ص����ࡣClass.forName(����).newInstance()���ص���object
//			System.out.println("���ݿ������������");
//		}catch(java.lang.ClassNotFoundException e){
//			System.out.print("Class.forName or DriverManager.registerDriver Exception:"+e.getMessage());
//		}
//		try{
//			con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
//			System.out.println("���ݿ��������");
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
//			System.out.println("���ݿ�ر�");
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
		        System.out.println("���ݿ������������");
		    }
		    catch(java.lang.ClassNotFoundException e){
		        System.out.print("Class.forName or DriverManager.registerDriver Exception:"+e.getMessage());
		    }

		    try{
		        con=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		        System.out.println("���ݿ��������");
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
				System.out.println("���ݿ�ر�");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
}
