package com.coderscampus.miriamassignment10.spoonacular.dto;

import java.util.List;

public class DayResponse {

	private List<Meals.Meal> meals;
	private Nutrients nutrients;

	public DayResponse() {

	}

	public DayResponse(List<Meals.Meal> meals, Nutrients nutrients) {
		super();
		this.meals = meals;
		this.nutrients = nutrients;
	}

	public List<Meals.Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meals.Meal> meals) {
		this.meals = meals;
	}

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}
}
