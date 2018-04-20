package csce361.model;

public class Users{

	private String userId;
	private String userName;
	private String password;

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Users(String userName, String password){
		super();
		this.userName = userName;
		this.password = password;
	}

	public Users(){
		super();
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	/**
	 * 注册用户
	 * 
	 * @param aUser
	 */
	public void registerUser(Users aUser){
		DBAccess db = new DBAccess();
		db.connectMeIn();
		db.addSingleUser(aUser);
		db.closeConnection();
	}

	/**
	 * 验证用户名是否已注册
	 * 
	 * @param aUserName
	 * @return
	 */
	public boolean validateUserByUsername(String userName){
		boolean userExists = false;
		DBAccess db = new DBAccess();
		db.connectMeIn();
		System.out.println("1");
		System.out.print(userName);
		userExists = db.findUserByUsername(userName);
		db.closeConnection();
		return userExists;
	}
	
	//
    public boolean validateUserByPassword(String password) {
	    boolean passwordMatches = false;
   	    DBAccess db = new DBAccess();
   	    db.connectMeIn();
   	    passwordMatches = db.findUserByPassword(password);
   	    db.closeConnection();
   	    return passwordMatches;
    }
    
    public Users getUser(String userName) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	Users aUser = db.returnUserByUsername(userName);
	   	db.closeConnection();
	   	
	   	return aUser;
    }

}
