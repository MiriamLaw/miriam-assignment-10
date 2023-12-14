package com.coderscampus.miriamassignment10.spoonacular.dto;

public class Nutrients {

	private Integer calories;
	private Integer protein;
	private Integer fat;
	private Integer carbohydrates;

	public Nutrients() {

	}

	public Nutrients(Integer calories, Integer protein, Integer fat, Integer carbohydrates) {
		super();
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getProtein() {
		return protein;
	}

	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	public Integer getFat() {
		return fat;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	public Integer getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Integer carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

}
