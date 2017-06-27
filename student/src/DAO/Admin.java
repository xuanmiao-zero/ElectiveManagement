package DAO;

public class Admin {
	private static String adName;
	private static String adPassword;

	public static String getadName() {
		return adName;
	}

	public void setadName(String adName) {
		this.adName = adName;
	}
	
	public static String getadPassword() {
		return adPassword;
	}

	public void setadPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	
	public Admin(String adName,String adPassword) {
		this.adName = adName;
		this.adPassword = adPassword;
		
	}
		


	
		



}
