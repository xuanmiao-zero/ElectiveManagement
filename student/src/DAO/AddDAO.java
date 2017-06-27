package DAO;

import java.sql.*;

import CONN.DBUtil;
public class AddDAO {
	public boolean addStudent(String uid,String uname,String password,String email){
		boolean result1=false;
		try{
			
		    Connection conn=DBUtil.getconnectionSQLSERVER();
			String sql="insert into xuesheng"+"(uid,uname,password,email)"+"values("+"'"+
		     uid+"'"+","+"'"+uname+"'"+","+"'"+password+"'"+","+"'"+email+"'"+")";
			 Statement stmt=conn.createStatement();
			 int row=stmt.executeUpdate(sql);
			 if(row==1){
				 stmt.close();
				 conn.close();
				 return true;
			 }else{
				 stmt.close();
				 conn.close();
				 return false;
			 }
		}catch (Exception e){ 
			e.printStackTrace();
			 System.out.println(e);}
			 return result1;
					 
			
		}
			

		
		
		
	}


