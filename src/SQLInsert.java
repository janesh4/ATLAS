import java.util.HashMap;
import java.util.Map;

public class SQLInsert {
	

	public static String insertSQL(String tableName, Map<String, String> columnValueMappingForInsert) {
	    StringBuilder insertSQLBuilder = new StringBuilder();
	 
	    /**
	     * Removing column that holds NULL value or Blank value...
	     */
	    if (!columnValueMappingForInsert.isEmpty()) {
	        for (Map.Entry<String, String> entry : columnValueMappingForInsert.entrySet()) {
	            if(entry.getValue() == null || entry.getValue().equals("")) {
	                columnValueMappingForInsert.remove(entry.getKey());
	            }
	        }
	    }
	 
	    /* Making the INSERT Query... */
	    insertSQLBuilder.append("INSERT INTO");
	    insertSQLBuilder.append(" ").append(tableName);
	    insertSQLBuilder.append("(");
	 
	    if (!columnValueMappingForInsert.isEmpty()) {
	        for (Map.Entry<String, String> entry : columnValueMappingForInsert.entrySet()) {
	            insertSQLBuilder.append(entry.getKey());
	            insertSQLBuilder.append(",");
	        }
	    }
	 
	    insertSQLBuilder = new StringBuilder(insertSQLBuilder.subSequence(0, insertSQLBuilder.length() - 1));
	    insertSQLBuilder.append(")");
	    insertSQLBuilder.append(" VALUES");
	    insertSQLBuilder.append("(");
	 
	    if (!columnValueMappingForInsert.isEmpty()) {
	        for (Map.Entry<String, String> entry : columnValueMappingForInsert.entrySet()) {
	            insertSQLBuilder.append("'").append(entry.getValue()).append("'");
	            insertSQLBuilder.append(",");
	        }
	    }
	 
	    insertSQLBuilder = new StringBuilder(insertSQLBuilder.subSequence(0, insertSQLBuilder.length() - 1));
	    insertSQLBuilder.append(")");
	 
	    // Returning the generated INSERT SQL Query as a String...
	    return insertSQLBuilder.toString();
	}
	
	
	public static void main(String[] args) {
		SQLInsert sqlIns = new SQLInsert();
		HashMap<String, String> colValues = new HashMap<String, String>();
		HashMap<String, String> where = new HashMap<String, String>();
		String table = "bus_table";
		colValues.put("user_id", "122");
		colValues.put("dd", "122");
		where.put("name", "rahul");
		
		String s = sqlIns.insertSQL(table, colValues );
		System.out.println(s);
	}

}
