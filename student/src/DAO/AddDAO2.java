package DAO;

import java.sql.*;

import CONN.DBUtil;
public class AddDAO2 {
	public boolean addReport(String uid,String ccode ,String report){
		boolean result1=false;
		try{
			
		    Connection conn=DBUtil.getconnectionSQLSERVER();
			String sql="insert into xuanke"+"(uid,ccode,report)"+"values("+"'"+
		     uid+"'"+","+"'"+ccode+"'"+","+"'"+report+"'"+")";
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


