package DAO;

import java.sql.*;

import CONN.DBUtil;

public class UserDAO {
	public static boolean register(User user)
	{ 
		
	boolean result=false;
		try{
	
       Connection conn=DBUtil.getconnectionSQLSERVER();
       int userid=user.getUid();
       String username=user.getUname();
       String password=user.getPassword();
       String strl="select * from xuesheng where uid='"+userid+"'and uname='"+username+"'";      
       Statement stmt=conn.createStatement();
       ResultSet rs= stmt.executeQuery(strl);
      // ResultSet res= stmt.executeQuery(str3);
      
       if(rs.next())
       {
    	   
          System.out.println("无法注册，用户存在");
    	  //查询重名无法注册
          
       }else
       {
    	   System.out.println("可以注册，用户不存在");
    	   //将用户的信息输入数据库
    	   String str2="insert into xuesheng (uid,uname,password,email) values(?,?,?,?)";
    	   PreparedStatement pstmt=conn.prepareStatement(str2);
    	   pstmt.setInt(1,userid);
    	   pstmt.setString(2,username);
    	   pstmt.setString(3,password);
    	   String email = null;
		   pstmt.setString(4,email);
    	   pstmt.executeUpdate();
    	   result=true;
       }
       
	}catch (Exception e)
	{ 
		System.out.println(e); 
	}
		
		return result;
       
}
}
