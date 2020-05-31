package searchPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {

	static Connection connectSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception ex){
			ex.printStackTrace();
			System.out.print("Exception Driver: " + ex);
		}
		
		Connection connectionSQL = null;
		try {
			connectionSQL = DriverManager.getConnection("jdbc:mysql://localhost:3308/slutprojekt?serverTimezone=UTC",
					DatabaseLoginMySQLJava.getuserName(), DatabaseLoginMySQLJava.getuserPass());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		System.out.println("**********Database connected**********");
		return connectionSQL;	
	}
	
}
