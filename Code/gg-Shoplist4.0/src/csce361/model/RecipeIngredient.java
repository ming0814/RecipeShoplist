package csce361.model;

public class RecipeIngredient {
	public RecipeIngredient(){
		super();
	}
	private String ingName;
	private String ingAmount;
	public RecipeIngredient(String ingName, String ingAmount){
		this.ingName = ingName;
		this.ingAmount = ingAmount;
	}
	public String getIngName() {
		return ingName;
	}
	public void setIngName(String ingName) {
		this.ingName = ingName;
	}
	public String getIngAmount() {
		return ingAmount;
	}
	public void setIngAmount(String ingAmount) {
		this.ingAmount = ingAmount;
	}
}
