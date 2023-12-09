package com.coderscampus.miriamassignment10.spoonacular.dto;

import com.coderscampus.miriamassignment10.domain.Week;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {

	@JsonProperty("week")
	private Week week;
	
	public WeekResponse (Week week) {
		super();
		this.week = week;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

//	public static class Week {
//		@JsonProperty("monday")
//		private Day monday;
//
//		@JsonProperty("tuesday")
//		private Day tuesday;
//
//		@JsonProperty("wednesday")
//		private Day wednesday;
//
//		@JsonProperty("thursday")
//		private Day thursday;
//
//		@JsonProperty("friday")
//		private Day friday;
//
//		@JsonProperty("saturday")
//		private Day saturday;
//
//		@JsonProperty("sunday")
//		private Day sunday;
//
//		public Day getMonday() {
//			return monday;
//		}
//
//		public void setMonday(Day monday) {
//			this.monday = monday;
//		}
//
//		public Day getTuesday() {
//			return tuesday;
//		}
//
//		public void setTuesday(Day tuesday) {
//			this.tuesday = tuesday;
//		}
//
//		public Day getWednesday() {
//			return wednesday;
//		}
//
//		public void setWednesday(Day wednesday) {
//			this.wednesday = wednesday;
//		}
//
//		public Day getThursday() {
//			return thursday;
//		}
//
//		public void setThursday(Day thursday) {
//			this.thursday = thursday;
//		}
//
//		public Day getFriday() {
//			return friday;
//		}
//
//		public void setFriday(Day friday) {
//			this.friday = friday;
//		}
//
//		public Day getSaturday() {
//			return saturday;
//		}
//
//		public void setSaturday(Day saturday) {
//			this.saturday = saturday;
//		}
//
//		public Day getSunday() {
//			return sunday;
//		}
//
//		public void setSunday(Day sunday) {
//			this.sunday = sunday;
//		}
//
//		public static class Day {
//			@JsonProperty("meals")
//			private List<Meal> meals;
//
//			@JsonProperty("nutrients")
//			private Nutrients nutrients;
//
//			public List<Meal> getMeals() {
//				return meals;
//			}
//
//			public void setMeals(List<Meal> meals) {
//				this.meals = meals;
//			}
//
//			public Nutrients getNutrients() {
//				return nutrients;
//			}
//
//			public void setNutrients(Nutrients nutrients) {
//				this.nutrients = nutrients;
//			}
//		}
//
//		public static class Meal {
//			@JsonProperty("id")
//			private long id;
//
//			@JsonProperty("imageType")
//			private String imageType;
//
//			@JsonProperty("title")
//			private String title;
//
//			@JsonProperty("readyInMinutes")
//			private int readyInMinutes;
//
//			@JsonProperty("servings")
//			private int servings;
//
//			@JsonProperty("sourceUrl")
//			private String sourceUrl;
//
//			public long getId() {
//				return id;
//			}
//
//			public void setId(long id) {
//				this.id = id;
//			}
//
//			public String getImageType() {
//				return imageType;
//			}
//
//			public void setImageType(String imageType) {
//				this.imageType = imageType;
//			}
//
//			public String getTitle() {
//				return title;
//			}
//
//			public void setTitle(String title) {
//				this.title = title;
//			}
//
//			public int getReadyInMinutes() {
//				return readyInMinutes;
//			}
//
//			public void setReadyInMinutes(int readyInMinutes) {
//				this.readyInMinutes = readyInMinutes;
//			}
//
//			public int getServings() {
//				return servings;
//			}
//
//			public void setServings(int servings) {
//				this.servings = servings;
//			}
//
//			public String getSourceUrl() {
//				return sourceUrl;
//			}
//
//			public void setSourceUrl(String sourceUrl) {
//				this.sourceUrl = sourceUrl;
//			}
//		}
//
//		public static class Nutrients {
//			@JsonProperty("calories")
//			private double calories;
//
//			@JsonProperty("protein")
//			private double protein;
//
//			@JsonProperty("fat")
//			private double fat;
//
//			@JsonProperty("carbohydrates")
//			private double carbohydrates;
//
//			public double getCalories() {
//				return calories;
//			}
//
//			public void setCalories(double calories) {
//				this.calories = calories;
//			}
//
//			public double getProtein() {
//				return protein;
//			}
//
//			public void setProtein(double protein) {
//				this.protein = protein;
//			}
//
//			public double getFat() {
//				return fat;
//			}
//
//			public void setFat(double fat) {
//				this.fat = fat;
//			}
//
//			public double getCarbohydrates() {
//				return carbohydrates;
//			}
//
//			public void setCarbohydrates(double carbohydrates) {
//				this.carbohydrates = carbohydrates;
//			}
//		}
//	}
}
