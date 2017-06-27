package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import CONN.DBUtil;

public class AdminDAO {
	public static boolean register2(Admin adm)
	{ 
		
	boolean result2=false;
		try{
	
       Connection conn=DBUtil.getconnectionSQLSERVER(); 
       String username=Admin.getadName();
       String password=Admin.getadPassword();
       Statement stmt=conn.createStatement();
       String str="select * from guanliyuan where  adName ='"+username+"' and adPassword='"+password+"'";
       System.out.println(str);
       ResultSet rs= stmt.executeQuery(str);
       if(rs.next())
       {
    	   result2=true;
    	   System.out.println("ok");
       }
	}catch (Exception e){ System.out.println(e); }
		return result2;
       
}
}
