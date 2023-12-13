package com.coderscampus.miriamassignment10.spoonacular.dto;

import java.util.List;

import com.coderscampus.miriamassignment10.spoonacular.dto.Meals.Meal;

public class DayResponse {

	public static class Day {
//		@JsonProperty("meals")
		private List<Meal> meals;

//		@JsonProperty("nutrients")
		private Nutrients nutrients;

		public Day() {

		}

		public Day(List<Meal> meals, Nutrients nutrients) {
			super();
			this.meals = meals;
			this.nutrients = nutrients;
		}

		public List<Meal> getMeals() {
			return meals;
		}

		public void setMeals(List<Meal> meals) {
			this.meals = meals;
		}

		public Nutrients getNutrients() {
			return nutrients;
		}

		public void setNutrients(Nutrients nutrients) {
			this.nutrients = nutrients;
		}
	}
}
