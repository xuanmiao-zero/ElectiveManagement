package user;

import java.sql.Connection;
import java.sql.SQLException;

import database.DB;

public class Class {
	private String class_id;
	private String 	class_name;
	private int class_hours;
	private float class_credit;
	private String 	class_intro;
	public Class(){}
	public Class(String class_id,String class_name,int class_hours,float class_credit,String class_intro){
		this.class_id = class_id;
		this.class_name = class_name;
		this.class_hours = class_hours;
		this.class_credit = class_credit;
		this.class_intro = class_intro;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getClass_hours() {
		return class_hours;
	}
	public void setClass_hours(int class_hours) {
		this.class_hours = class_hours;
	}
	public float getClass_credit() {
		return class_credit;
	}
	public void setClass_credit(float class_credit) {
		this.class_credit = class_credit;
	}
	public String getClass_intro() {
		return class_intro;
	}
	public void setClass_intro(String class_intro) {
		this.class_intro = class_intro;
	}
//	public Class equal(String class_id)throws Exception{
//		String classId=null;
//		DB db=new DB();
//		Connection con =db.DBLink();   
//	    db.psta=con.prepareStatement("select class_id,class_name,class_hours,class_credit,class_intro from student where class_id=? ");
//	    db.psta.setString(1,classId);  
//		try{
//			db.res=db.psta.executeQuery();
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		
//		if(db.res.next()){
//			dbUserName=db.res.getString("name");
//			dbPassWord=db.res.getString("password");
//			dbid=db.res.getInt("student_id");
//		}
//		db.DBOut();
//		if(userName.equals(dbUserName)&&passWord.equals(dbPassWord)){
//			Class user = new Class(dbUserName,dbPassWord,dbid);
//			return user;
//		}else{
//			return null;
//		}
//	}
	public boolean register(String class_id,String class_name,int class_hours,float class_credit,String class_intro)throws Exception{
		DB db= new DB();
		Connection con = db.DBLink();
		db.psta =con.prepareStatement("insert into class(class_id,class_name,class_hours,class_credit,class_intro) value (?,?,?,?,?)");
		db.psta.setString(1,class_id);
		db.psta.setString(2,class_name);
		db.psta.setInt(3, class_hours);
		db.psta.setFloat(4, class_credit);
		db.psta.setString(5, class_intro);
		System.out.println(class_intro);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public boolean delete(int class_id) throws Exception{
		DB db = new DB();
		Connection con = db.DBLink();
		db.psta=con.prepareStatement("delete from student where class_id="+class_id);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public boolean modify(String class_name,int class_hours,float class_credit,String class_intro) throws Exception{
		DB db = new DB();
		Connection con = db.DBLink();
		String sql="UPDATE student SET class_name = '"+ class_name +"',class_hours='"+class_hours+"',class_credit='"+class_credit+"',class_intro='"+class_intro+"' where student_id="+class_id;
		db.psta=con.prepareStatement(sql);
//		System.out.println(sql);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public String inquireAll() throws Exception {
		DB db = new DB();
		Connection con = db.DBLink();
		String sql = "SELECT class_id,class_name,class_hours,class_credit,class_intro FROM class";
		db.psta = con.prepareStatement(sql);
		db.res = db.psta.executeQuery();
		String json ="";
		while(db.res.next()){
			json +="{\"class_id\":\""+db.res.getInt(1)
			+"\",\"class_name\":\""+db.res.getString(2)
			+"\",\"class_hours\":\""+db.res.getString(3)
			+"\",\"class_credit\":\""+db.res.getString(4)
			+"\",\"class_intro\":\""+db.res.getString(5)
			+"\"},";
		}
		
		json ="[" + json.substring(0,json.length()-1) + "]";
		
		return json;
	}
}
