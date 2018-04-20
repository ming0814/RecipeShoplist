package csce361.model;

public class Ingredient {
	private int ingreId;
	private String ingreName;
	public int getIngreId() {
		return ingreId;
	}
	public void setIngreId(int ingreId) {
		this.ingreId = ingreId;
	}
	public String getIngreName() {
		return ingreName;
	}
	public void setIngreName(String ingreName) {
		this.ingreName = ingreName;
	}
	//super
	public Ingredient() {
		super();
	}
	public Ingredient(int ingreId, String ingreName) {
		super();
		this.ingreId = ingreId;
		this.ingreName = ingreName;
	}
}
