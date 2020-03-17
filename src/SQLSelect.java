import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSelect {
	JdbcConnect jbc = new JdbcConnect();
	
	public ResultSet SqlSelectStatement(String sql) throws SQLException	{
		
		ResultSet rs = null;
		if(jbc.connect() != null)
			
	    {
	        String sqlToRun = sql;
	        
	        try
	        {Statement stmt = jbc.connect().createStatement();
	         rs = stmt.executeQuery(sqlToRun);
	         jbc.connect().close();
	         return rs;
	            }
	        
	        catch (SQLException e) 
	        {
	        	System.out.println(e.getMessage());}
	        }
		jbc.connect().close();
		return rs;
	        
	        
	        }
}
