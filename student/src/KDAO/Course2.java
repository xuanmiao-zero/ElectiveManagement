package KDAO;


public class Course2 {
	private String ccode;
	private String cname;
	private String ctime ;
	private int credit;
	public Course2(String ccode, String cname, String ctime, int credit) {
		this.setCcode(ccode);
		this.setCname(cname);
		this.setCtime(ctime);
		this.setCredit(credit);
	}
	public Course2(){}
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
