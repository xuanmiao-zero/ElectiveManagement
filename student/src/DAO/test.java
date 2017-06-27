package DAO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      test();
	}
	public static void test()
	{
	User user=new User(1993,"tom","123456","123456");
	UserDAO userdao=new UserDAO();
	boolean result=userdao.register(user);
	System.out.println("注册结果"+result);
	User user1=new User(1992,"tom1","123456","456978");
	result=userdao.register(user1);
	System.out.println("注册结果"+result);
	}

}
