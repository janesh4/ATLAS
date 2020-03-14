
public class User {
	private String userName;
//	private String userPassword;
//	private String	userType;
	
	
	public User(String userName) {
		this.userName = userName;

	}


	public void viewRoute() {
		Authentication auth = new Authentication();
		if(auth.checkCredentials("admin","admin","admin")) {
			RouteMaster rm = new RouteMaster();
			rm.viewAllRoutes();
		}
		
	}

}
