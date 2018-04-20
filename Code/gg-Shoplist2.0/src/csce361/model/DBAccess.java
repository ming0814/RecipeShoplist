package csce361.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import csce361.util.CommonUtil;

public class DBAccess{
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	boolean connected = false;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// static final String DB_URL = "jdbc:mysql://localhost/MVCApp";
	//final String DB_URL = "jdbc:mysql://localhost:3306/private_9";
	 final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/mkracl";

	// Database credentials
	//static final String USER = "root"; // Replace with your CSE_LOGIN
	//static final String PASS = "root"; // Replace with your CSE MySQL_PASSWORD
	 static final String USER = "mkracl"; // Replace with your CSE_LOGIN
     static final String PASS = "8uG:sm"; // Replace with your CSE MySQL_PASSWORD

	/**
	 * 注册用户
	 * 
	 * @param aUser
	 */
	public void addSingleUser(Users aUser){
		if(connected == false){
			connectMeIn();
		}
		try{
			String userName = aUser.getUserName();
			String password = aUser.getPassword();
			//String sql = "INSERT INTO users VALUES ('" + CommonUtil.getUUID() + "','" + userName + "', '" + password + "')";
			String sql = "INSERT INTO users (userName, password)" +
			          "VALUES ('" + userName + 
					  "', '" + password + "')";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param aUserName
	 * @return
	 */
	public boolean findUserByUsername(String aUserName){
		if(connected == false){
			connectMeIn();
		}
		boolean userExists = false;
		String SQL = "SELECT * from users";
		Statement stat;
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				if(aUserName.equals(rs.getString(2))){
					userExists = true;
					System.out.print(aUserName);
				}
			}
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return userExists;
	}

	public boolean findUserByPassword(String password){
		if(connected == false){
			connectMeIn();
		}
		boolean passwordMatches = false;
		String SQL = "SELECT * from users";
		Statement stat;
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				if(password.equals(rs.getString(3))){
					passwordMatches = true;
				}
			}

			stat.close();

		}catch(SQLException e){
			e.printStackTrace();
		}

		return passwordMatches;
	}

	/**
	 * 登录验证
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public Users login(String userName, String password){
		if(connected == false){
			connectMeIn();
		}
		Users user = null;
		String SQL = "SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + password + "'";
		Statement stat;
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				if(userName.equals(rs.getString(2))){
					user = new Users(userName, password);
					user.setUserId(rs.getString(1));
				}
			}
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return user;
	}
	
	public ArrayList<String> ingredientList(){
		if(connected == false){
			connectMeIn();
		}
		String SQL = "SELECT * FROM Ingredient";
		Statement stat;
		ArrayList<String> ingredientList=new ArrayList<String>();
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				ingredientList.add(rs.getString(2));
			}
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return ingredientList;
	}

	public String addUserIngredient(String userIngredient,Users aUser){
		if(connected == false){
			connectMeIn();
		}
		ArrayList<String> ingredientList=new ArrayList<String>();

		ArrayList<String> userIngredientList=getUserIngredient(aUser);
		System.out.println(userIngredient);
		if(userIngredientList.contains(userIngredient)) {
			return "Already exists!";
		}
		String SQL = "SELECT * FROM Ingredient where ingredientName='"+userIngredient+"'";
		Statement stat;
		int ingredientId = 0;
		System.out.println(1111);
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				ingredientId=rs.getInt(1);
			}
			System.out.println(ingredientId+userIngredient);
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(2222);
		
		
		try{
			String userId = aUser.getUserId();
			//String sql = "INSERT INTO users VALUES ('" + CommonUtil.getUUID() + "','" + userName + "', '" + password + "')";
			String sql = "INSERT INTO UserIngredient (userId, ingredientId)" +
			          "VALUES ('" + userId + 
					  "', '" + ingredientId + "')";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println(userId);
		}catch(SQLException e){
			e.printStackTrace();
		}

		System.out.println(3333);
		return "Success";
	}
	
	
	public ArrayList<String> getUserIngredient(Users aUser){
		if(connected == false){
			connectMeIn();
		}
		ArrayList<String> ingredientList=new ArrayList<String>();

		Statement stat;
		String SQL = "SELECT ingredientName FROM Ingredient INNER JOIN UserIngredient on Ingredient.ingredientId=UserIngredient.ingredientId"
				+ " where UserIngredient.userId='"+aUser.getUserId()+"'";
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				ingredientList.add(rs.getString(1));
			}
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ingredientList;
	}
	
	public Users returnUserByUsername(String aUserName){
		if(connected == false){
			connectMeIn();
		}
		String SQL = "SELECT * from users";
		Statement stat;

		Users aUser = new Users();
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while(rs.next()){
				if(aUserName.equals(rs.getString(2))){
					aUser.setUserId(rs.getString(1));
					aUser.setUserName(rs.getString(2));
					aUser.setPassword(rs.getString(3));
				}
			}

			stat.close();

		}catch(SQLException e){
			e.printStackTrace();
		}

		return aUser;
	}

	public void displayAllUsers(){
		if(connected == false){
			connectMeIn();
		}
		String SQL = "SELECT * from users";
		Statement stat;
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while(rs.next()){
				System.out.println(rs.getString(1) + rs.getString(2) + " " + rs.getString(3));
			}

			stat.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void connectMeIn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		try{
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(SQLException e){
			e.printStackTrace();
		}
		connected = true;
	}

	public void closeConnection(){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Recipe getRecipe(String recipeName){
		if(connected == false){
			connectMeIn();
		}
		StringBuffer SQL = new StringBuffer();
		SQL.append(" select r.recipeId, r.recipeName, r.description, r.instruction, r.image, r.prepTime, r.cookTime, t.amount, i.ingredientName from Recipe r ");
		SQL.append(" inner join RecipeIngredient t on t.recipeId = r.recipeId ");
		SQL.append(" inner join Ingredient i on i.ingredientId = t.ingredientId ");
		SQL.append(" where r.recipeName = '" + recipeName + "' ");

		Recipe recipe = null;

		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL.toString());

			recipe = new Recipe();
			ArrayList<RecipeIngredient> riList = new ArrayList();
			while(rs.next()){
				recipe.setRecipeId(rs.getString(1));
				recipe.setRecipeName(rs.getString(2));
				recipe.setDescription(rs.getString(3));
				recipe.setInstruction(rs.getString(4));
				recipe.setImage(rs.getString(5));
				recipe.setPrepTime(rs.getInt(6));
				recipe.setCookTime(rs.getInt(7));
				RecipeIngredient ri = new RecipeIngredient();
				ri.setIngAmount(rs.getString(8));
				ri.setIngName(rs.getString(9));
				riList.add(ri);
			}
			recipe.setIngredientName(riList);
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return recipe;
	}

	public Ingredient addIngre(String userIngreName) {
		if(connected == false){
			connectMeIn();
		}
		String SQL = "SELECT * from ....";
		Statement stat;

		Ingredient ingre = new Ingredient();
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while(rs.next()){
			}

			stat.close();

		}catch(SQLException e){
			e.printStackTrace();
		}

		return ingre;
	}

	public ArrayList<Recipe> getRecipes(Users aUser){
		if(connected == false){
			connectMeIn();       
		}
//		String SQL="select re.`recipeName`, re.`image` from RecipeIngredient as r "
//				+ "inner join UserIngredient as u on u.`ingredientId`=r.`ingredientId` "
//				+ "inner join Recipe as re on re.`recipeId`=r.`recipeId`"
//				+ "where u.`userId`="+aUser.getUserId()+" group by r.recipeId "
//						+ "having count(r.recipeId)=(select count(*) from UserIngredient where userId="+aUser.getUserId()+")";
		String SQL="select re.`recipeName`, re.`image`,r.`recipeId`,u.`ingredientId`,count(*) as counted,s.recipeCount from RecipeIngredient as r "
				+"inner join UserIngredient as u on u.`ingredientId`=r.`ingredientId` "
			    +"inner join Recipe as re on re.`recipeId`=r.`recipeId` "
			    +"inner join (select count(*)  as recipeCount, recipeId from RecipeIngredient group by recipeId) s on r.`recipeId`=s.`recipeId` "
			    +"where u.`userId`="+aUser.getUserId()+" group by r.recipeId "
			    +"having s.recipeCount=(select count(*) from `UserIngredient` where `userId` = "+aUser.getUserId()+" ) and counted=(select count(*) from `UserIngredient` where `userId` = "+aUser.getUserId()+" )";
		Statement stat;
		ArrayList<Recipe> recipelist=new ArrayList<Recipe>();
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL.toString());
			while(rs.next()) {
				Recipe r = new Recipe();
				r.setRecipeName(rs.getString(1));
				r.setImage(rs.getString(2));
				recipelist.add(r);
			}
			stat.close();
			return recipelist;
		}catch(SQLException e){
			e.printStackTrace();
			return recipelist;
		}
	}

	public ArrayList<Recipe> getRecipes(String ingredientName){
		if(connected == false){
			connectMeIn();
		}
		String SQL="select re.`recipeName`, re.`image`  from RecipeIngredient as r " + 
				"inner join `Ingredient` as i on i.`ingredientId`=r.`ingredientId`" + 
				"inner join Recipe as re on re.`recipeId`=r.`recipeId`" + 
				"where i.`ingredientName`='"+ingredientName+"'";
		Statement stat;
		ArrayList<Recipe> recipelist=new ArrayList<Recipe>();
		try{
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL.toString());
			while(rs.next()) {
				Recipe r = new Recipe();
				r.setRecipeName(rs.getString(1));
				r.setImage(rs.getString(2));
				recipelist.add(r);
			}
			stat.close();
			return recipelist;
		}catch(SQLException e){
			e.printStackTrace();
			return recipelist;
		}
	}
	public String deleteUserIngredient(String userIngredient, Users aUser) {
		// TODO Auto-generated method stub
		if(connected == false){
			connectMeIn();
		}
		String SQL = "DELETE u FROM UserIngredient as u INNER JOIN Ingredient as i on u.ingredientId=i.ingredientId "
				+ "WHERE u.userId="+aUser.getUserId()+" AND i.ingredientName='"+userIngredient+"'";
		Statement stat;
		try{
			stat = conn.createStatement();
			stat.executeUpdate(SQL);
			stat.close();
			return "Success";
		}catch(SQLException e){
			e.printStackTrace();
			return "Fail";
		}
	}
}
