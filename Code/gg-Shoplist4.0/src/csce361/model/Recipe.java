package csce361.model;

import java.util.ArrayList;

public class Recipe{
	private String recipeId;
	private String recipeName;
	private String description;
	private String instruction;
	private String image;
	private Integer prepTime;
	private Integer cookTime;
	private ArrayList<RecipeIngredient> ingredientName;
	private String amount;

	public Recipe(){
		super();
	}

	public Recipe(String recipeId, String recipeName, String description, String instruction, String image, Integer prepTime, Integer cookTime, ArrayList<RecipeIngredient> ingredientName, String amount){
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.description = description;
		this.instruction = instruction;
		this.image = image;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.ingredientName = ingredientName;
		this.amount = amount;
	}

	public String getRecipeId(){
		return recipeId;
	}

	public void setRecipeId(String recipeId){
		this.recipeId = recipeId;
	}

	public String getRecipeName(){
		return recipeName;
	}

	public void setRecipeName(String recipeName){
		this.recipeName = recipeName;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getInstruction(){
		return instruction;
	}

	public void setInstruction(String instruction){
		this.instruction = instruction;
	}

	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image = image;
	}

	public Integer getPrepTime(){
		return prepTime;
	}

	public void setPrepTime(Integer prepTime){
		this.prepTime = prepTime;
	}

	public Integer getCookTime(){
		return cookTime;
	}

	public void setCookTime(Integer cookTime){
		this.cookTime = cookTime;
	}

	public ArrayList<RecipeIngredient> getIngredientName(){
		return ingredientName;
	}

	public void setIngredientName(ArrayList<RecipeIngredient> ingredientName){
		this.ingredientName = ingredientName;
	}

	public String getAmount(){
		return amount;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}

}
