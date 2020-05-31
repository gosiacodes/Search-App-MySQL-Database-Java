package searchPackage;

public class DatabaseLoginMySQLJava {
	private static String userName = "root";
	private static String userPass = "";
	
	public static String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		DatabaseLoginMySQLJava.userName = userName;
	}

	public static String getuserPass() {
		return userPass;
	}

	public void setuserPass(String userPass) {
		DatabaseLoginMySQLJava.userPass = userPass;
	}
	
}
