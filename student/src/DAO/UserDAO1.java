package DAO;

import java.sql.*;

import CONN.DBUtil;

public class UserDAO1 {
	public static boolean register1(User user)
	{ 
		
	boolean result1=false;
		try{
	
       Connection conn=DBUtil.getconnectionSQLSERVER(); 
       String username=user.getUname();
       String password=user.getPassword();
      // String email=user.getEmail();
       Statement stmt=conn.createStatement();
       String str="select * from xuesheng where uname='"+username+"' and password='"+password+"'";
       System.out.println(str);
       ResultSet rs= stmt.executeQuery(str);
       if(rs.next())
       {
    	   result1=true;
    	   System.out.println("ok");
       }
	}catch (Exception e){ System.out.println(e); }
		return result1;
       
}
}
