package DAO;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String email;
	public User(int  uid, String uname, String password, String email) {
		this.setUid(uid);
		this.setUname(uname);
		this.setPassword(password);
		this.setEmail(email);
		// TODO Auto-generated constructor stub
	}
	public User(String uname,String password)
	{
		this.setUname(uname);
		this.setPassword(password);
	}
	public User(){}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
