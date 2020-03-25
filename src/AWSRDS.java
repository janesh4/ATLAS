import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AWSRDS {
//	private static Connection getRemoteConnection() throws SQLException {
////	    if (System.getenv("RDS_HOSTNAME") != null) {
////	      Object logger;
//		try {
//	      Class.forName("com.mysql.cj.jdbc.Driver");
//	      String dbName = "h7-bus-pass";
//	      String userName = "admin";
//	      String password = "atlas1234";
//	      String hostname = "h7-bus-pass.cshwoihh6dqb.us-east-1.rds.amazonaws.com";
//	      String port = "3306";
//	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//	      //((Object) logger).trace("Getting remote connection with connection string from environment variables.");
//	      System.out.println(jdbcUrl);
//	      Connection con = DriverManager.getConnection(jdbcUrl);
//	      //((Object) logger).info("Remote connection successful.");
//	      return con;
//	    }
//	    catch (ClassNotFoundException e) { }
//	    //catch (SQLException e) { logger.wait(e.toString());}
//		return null;
//	    }
////	    return null;
////	  }
	
	public static void connectJDBCToAWSEC2() {

	    System.out.println("----MySQL JDBC Connection Testing -------");
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	        return;
	    }

	    System.out.println("MySQL JDBC Driver Registered!");
	    Connection connection = null;

	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://" + "h7-bus-pass-atlas.cshwoihh6dqb.us-east-1.rds.amazonaws.com" + ":" + "3306" + "/" + "H7", "admin", "atlas1234");
	    } catch (SQLException e) {
	        System.out.println("Connection Failed!:\n" + e.getMessage());
	    }

	    if (connection != null) {
	        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
	    } else {
	        System.out.println("FAILURE! Failed to make connection!");
	    }
	}

	public static void main(String[] args) throws SQLException {
		AWSRDS db = new AWSRDS();
//	    vr.PendingBusPassRequests();
//		System.out.println("jdbc:mysql://h7-bus-pass-atlas.cshwoihh6dqb.us-east-1.rds.amazonaws.com:3036/H7,admin,atlas1234");
		db.connectJDBCToAWSEC2();
		



	}

}
