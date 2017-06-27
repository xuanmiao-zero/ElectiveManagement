package DAO;


public class Course {
	private String ccode;
	private String cname;
	private String ctime ;
	private int credit;
	public Course(String ccode, String cname, String ctime, int credit) {
		this.setCcode(ccode);
		this.setCname(cname);
		this.setCtime(ctime);
		this.setCredit(credit);
	}
	public Course(){}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
		
	
	
	

}
