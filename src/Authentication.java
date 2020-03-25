import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication {
	
    Connection conn;
	private String inputName;
    private String inputPassword;
    private String	userType;



    public Authentication(Connection conn) {
    	this.conn = conn;
	}

	boolean checkCredentials(String log, String pass, String type) throws SQLException, ClassNotFoundException {

            String sql = "select login, password, type from user_info where login = '"+log+"' ";

            SQLSelect sqlRun = new SQLSelect(conn);
            ResultSet rs = sqlRun.SqlSelectStatement(sql);
            
            while(rs.next()) {
            inputName = rs.getString("login");
            inputPassword = rs.getString("password");
            userType = rs.getString("type");
			}		

            if(userType.equals("admin"))
            {
                if (inputName.equals(log) && inputPassword.equals(pass) && userType.equals(type))
                {
                    return true;
                }
            }
            if(userType.equals("user"))
            {
                if (inputName.equals(log) && inputPassword.equals(pass) && userType.equals(type))
                {
                    return true;
                }
            }

        return false;
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException  {
    	Connection conn = JdbcConnect.connect();
    	Authentication auth = new Authentication(conn);
    	String log = "admin";
    	String pass = "admin";
    	String type = "admin";
    	System.out.println(auth.checkCredentials(log, pass, type));
		

	}
}