package DAO;

import java.sql.*;

import CONN.DBUtil;

public class Select2DAO {
	public boolean selectstudent(String ccode,String cname,String ctime,String credit){
		boolean result1=false;
		try{
			  Connection conn=DBUtil.getconnectionSQLSERVER();
			  String sql="insert into coures"+"(ccode,cname,ctime,credit)"+"values("+"'"+
					     ccode+"'"+","+"'"+cname+"'"+","+"'"+ctime+"'"+","+"'"+credit+"'"+")";
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
	


