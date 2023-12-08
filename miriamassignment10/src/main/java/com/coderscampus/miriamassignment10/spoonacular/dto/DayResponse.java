package com.coderscampus.miriamassignment10.spoonacular.dto;

import java.util.List;

import com.coderscampus.miriamassignment10.dto.Nutrients;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse.Week.Meal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DayResponse {

	@JsonProperty("day")
	private Day day;

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

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

	public static class Meal {
		@JsonProperty("id")
		private long id;
		@JsonProperty("title")
		private String title;
		@JsonProperty("imageType")
		private String imageType;
		@JsonProperty("readyInMinutes")
		private String readyInMinutes;
		@JsonProperty("servings")
		private Integer servings;
		@JsonProperty("sourceUrl")
		private String sourceUrl;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		public String getReadyInMinutes() {
			return readyInMinutes;
		}

		public void setReadyInMinutes(String readyInMinutes) {
			this.readyInMinutes = readyInMinutes;
		}

		public Integer getServings() {
			return servings;
		}

		public void setServings(Integer servings) {
			this.servings = servings;
		}

		public String getSourceUrl() {
			return sourceUrl;
		}

		public void setSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}
	}

	public static class Nutrients {
		@JsonProperty("calories")
		private double calories;
		@JsonProperty("protein")
		private double protein;
		@JsonProperty("fat")
		private double fat;
		@JsonProperty("carbohydrates")
		private double carbohydrates;
	}
}
