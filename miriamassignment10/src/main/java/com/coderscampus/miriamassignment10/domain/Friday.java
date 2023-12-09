package com.coderscampus.miriamassignment10.domain;

import java.util.List;

public class Friday {
	private List <Meals> meals;
	private Nutrients nutrients;
	public List<Meals> getMeals() {
		return meals;
	}
	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}
	public Nutrients getNutrients() {
		return nutrients;
	}
	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}

}
