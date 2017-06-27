package user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DB;

public class Manager {
	private String userName;
	private String passWord;
	private int id;
	public Manager(){}
	public Manager(String userName, String passWord, int id){
		this.setUserName(userName);
		this.setPassWord(passWord);
		this.setId(id);
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassWord() {
		return this.passWord;
	}
	public int getId() {
		return this.id;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}
	public void setId(int id){
		this.id=id;
	}
	public Manager isValued(String userName,String passWord)throws Exception{
		String dbUserName=null;
		String dbPassWord=null;
		int dbid=0;
		DB db=new DB();
		Connection con =db.DBLink();   
	    db.psta=con.prepareStatement("select id,name,password from manager where name=? and password=?");
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
			dbid=db.res.getInt("id");
		}
		db.DBOut();
		if(userName.equals(dbUserName)&&passWord.equals(dbPassWord)){
			Manager user = new Manager(dbUserName,dbPassWord,dbid);
			return user;
		}else{
			return null;
		}
	}
	public boolean register(String userName,String passWord)throws Exception{
		DB db= new DB();
		Connection con = db.DBLink();
		db.psta =con.prepareStatement("insert into manager(name,password) value (?,?)");
		db.psta.setString(1,userName);
		db.psta.setString(2, passWord);
		try{
			System.out.println("ע��ɹ���");
			db.psta.executeUpdate();
		}catch(SQLException e){
			System.out.println("ע��ʧ��");
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public boolean delete(String userName) throws Exception{
		DB db = new DB();
		Connection con = db.DBLink();
		db.psta=con.prepareStatement("delete from manager where name="+userName);
		try{
			db.psta.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		db.DBOut();
		return true;
	}
	public List<Manager> showAllUser()throws Exception{
		List<Manager> list = new ArrayList<Manager>();
		DB db = new DB();
		Connection con = db.DBLink();
		db.psta = con.prepareStatement("select name,password from manager");
		db.res = db.psta.executeQuery();
		while(db.res.next()){
			Manager user = new Manager();
			user.setId(db.res.getInt(1));
			user.setPassWord(db.res.getString(2));
			list.add(user);
		}
		return list;
	}
}
