import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BusMaster {



	
public ArrayList<String> BusesInRoute(String route) throws SQLException
{
	String sql = "select distinct bus_id from bus_table where route =  '"+route+"' ";
	ArrayList<String> al = new ArrayList<String>();
	
	SQLSelect sqlRun = new SQLSelect();
	ResultSet rs = sqlRun.SqlSelectStatement(sql);
	while (rs.next())
            {
            	al.add(rs.getString("bus_id"));
            }  
	rs.close();
    return al;
}


public void AddBusInRoute(String route) throws SQLException
{			//JdbcConnect jbc = new JdbcConnect();
	ArrayList<String> al = new ArrayList<String>();
	
	al = this.BusesInRoute(route);
 
    System.out.println("In "+ route+ " route there are total "+al.size()+" buses. Bus number: "+al );

    if(al.size() <3)        	
    {
    	String sql2 = "select distinct category_id, count(distinct bus_id) as num from bus_table where route is null group by 1";
    	ArrayList<Integer> number = new ArrayList<Integer>();
    	ArrayList<String> typeBus = new ArrayList<String>();
    	
    	SQLSelect sqlRun = new SQLSelect();
    	ResultSet rs2 = sqlRun.SqlSelectStatement(sql2);
    	                   	
    		while (rs2.next())
    		{
    			number.add(rs2.getInt("num"));
    			typeBus.add(rs2.getString("category_id"));
    		}   

    		int sum = 0;
    		for(int i = 0; i < number.size(); i++)
    			sum = sum + number.get(i);
    		
	   
		   System.out.println();
		   System.out.println("Total available buses are: "+sum);
		   System.out.println();
		   
		   for(int i = 0; i < number.size(); i++)
			   System.out.println("category: "+typeBus.get(i)+"-seaters"+" total of "+number.get(i)+" vehicle available.");
   
		   System.out.println();
		   System.out.println("Enter the category number from above available category to assign the bus.");
		   
		   boolean flag = true;
		   
		   Scanner input = new Scanner(System.in);
		   
		   while(flag) {
		       String categoryAllocate = input.nextLine();
		       String busNum=null;
		
		       if(typeBus.contains(categoryAllocate)){
		        	
		       String sql3 = "select bus_id from bus_table where route is null and category_id = '"+categoryAllocate+"'";
		       
		       SQLSelect sqlRun2 = new SQLSelect();
		       ResultSet rs3 = sqlRun2.SqlSelectStatement(sql3);
		       busNum = rs3.getString("bus_id");
		       rs3.close();
		       
		       SQLUpdate su = new SQLUpdate();
		       HashMap<String, String> colValues = new HashMap<String, String>();
		       HashMap<String, String> where = new HashMap<String, String>();
		       String tableName = "bus_table";
		       colValues.put("route", route);
		       where.put("bus_id", busNum);
		       su.ExecuteUpdate(tableName, colValues, where);
		       
		       System.out.println("Bus: "+busNum+" is allocated to the route: "+route);

		       
		       flag = false;
		       }
		       
		       else {
		    	   System.out.println("Please enter the valid category from above ");
		    	   	}
		       }
		   }    	
   else
	   {
	   System.out.println("Sorry, you can't allocate bus to this route as it already has three buses.");
	   }
   System.out.println();
   
}
        
public static void main(String[] args) throws SQLException {
		BusMaster bm = new BusMaster();
		bm.AddBusInRoute("R2");
		

	}

}
