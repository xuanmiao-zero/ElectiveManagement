package user;

import java.sql.Connection;
import java.sql.SQLException;

import database.DB;

public class Student {
	private String userName;
	private String passWord;
	private int student_id;
	public Student(){}
	public Student(String userName, String passWord, int student_id){
		this.setUserName(userName);
		this.setPassWord(passWord);
		this.setId(student_id);
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassWord() {
		return this.passWord;
	}
	public int getId() {
		return this.student_id;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}
	public void setId(int student_id){
		this.student_id=student_id;
	}
	public Student equal(String userName,String passWord)throws Exception{
		String dbUserName=null;
		String dbPassWord=null;
		int dbid=0;
		DB db=new DB();
		Connection con =db.DBLink();   
	    db.psta=con.prepareStatement("select student_id,name,password from student where name=? and password=?");
//	    System.out.println(userName+"  "+passWord+"");
	    db.psta.setString(1,userName);
	    db.psta.setString(2,passWord);	    
		try{
			db.res=db.psta.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		if(db.res.next()){
			dbUserName=db.res.getString("name");
			dbPassWord=db.res.getString("password");
			dbid=db.res.getInt("student_id");
		}
		db.DBOut();
		if(userName.equals(dbUserName)&&passWord.equals(dbPassWord)){
			Student user = new Student(dbUserName,dbPassWord,dbid);
			return user;
		}else{
			return null;
		}
	}
	public boolean register(String studentId,String userName,String passWord)throws Exception{
		DB db= new DB();
		Connection con = db.DBLink();
		db.psta =con.prepareStatement("insert into student(student_id,name,password) value (?,?,?)");
		db.psta.setString(1,studentId);
		db.psta.setString(2,userName);
		db.psta.setString(3, passWord);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public boolean delete(int student_id) throws Exception{
		DB db = new DB();
		Connection con = db.DBLink();
		db.psta=con.prepareStatement("delete from student where student_id="+student_id);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public boolean modify(String studentId,String userName,String passWord) throws Exception{
		DB db = new DB();
		Connection con = db.DBLink();
		String sql="UPDATE student SET name = '"+ userName +"',password='"+passWord+"' where student_id="+studentId;
//		 +",password = "+ passWord
		db.psta=con.prepareStatement(sql);
		System.out.println(sql);
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
		String sql = "SELECT student_id,name,password FROM student";
		db.psta = con.prepareStatement(sql);
		db.res = db.psta.executeQuery();
		String json ="";
		while(db.res.next()){
			json +="{\"student_id\":\""+db.res.getInt(1)
			+"\",\"name\":\""+db.res.getString(2)
			+"\",\"password\":\""+db.res.getString(3)+"\"},";
		}
		
		json ="[" + json.substring(0,json.length()-1) + "]";
		
		return json;
	}
}
