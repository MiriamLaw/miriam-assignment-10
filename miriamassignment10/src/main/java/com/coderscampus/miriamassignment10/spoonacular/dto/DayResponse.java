package com.coderscampus.miriamassignment10.spoonacular.dto;

import java.util.List;

import com.coderscampus.miriamassignment10.domain.Meals.Meal;
import com.coderscampus.miriamassignment10.domain.Nutrients;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DayResponse {

	public static class Day {
		@JsonProperty("meals")
		private List<Meal> meals;

		@JsonProperty("nutrients")
		private Nutrients nutrients;

		public List<Meal> getMeals() {
			return meals;
		}

		public Nutrients getNutrients() {
			return nutrients;
		}

		public void setNutrients(Nutrients nutrients) {
			this.nutrients = nutrients;
		}

		public void setMeals(List<Meal> meals) {
			this.meals = meals;
		}
	}

}
