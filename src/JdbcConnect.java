import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {


    public  Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:BusPass.db"; // hard code DB
        Connection conn = null;
        if (conn == null) {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
		return conn;
    }


}