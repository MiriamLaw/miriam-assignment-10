package com.coderscampus.miriamassignment10.spoonacular.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {

	@JsonProperty("week")
	private Week week;

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public static class Week {
		@JsonProperty("monday")
		private Day monday;

		@JsonProperty("tuesday")
		private Day tuesday;

		@JsonProperty("wednesday")
		private Day wednesday;

		@JsonProperty("thursday")
		private Day thursday;

		@JsonProperty("friday")
		private Day friday;

		@JsonProperty("saturday")
		private Day saturday;

		@JsonProperty("sunday")
		private Day sunday;

		public Day getMonday() {
			return monday;
		}

		public void setMonday(Day monday) {
			this.monday = monday;
		}

		public Day getTuesday() {
			return tuesday;
		}

		public void setTuesday(Day tuesday) {
			this.tuesday = tuesday;
		}

		public Day getWednesday() {
			return wednesday;
		}

		public void setWednesday(Day wednesday) {
			this.wednesday = wednesday;
		}

		public Day getThursday() {
			return thursday;
		}

		public void setThursday(Day thursday) {
			this.thursday = thursday;
		}

		public Day getFriday() {
			return friday;
		}

		public void setFriday(Day friday) {
			this.friday = friday;
		}

		public Day getSaturday() {
			return saturday;
		}

		public void setSaturday(Day saturday) {
			this.saturday = saturday;
		}

		public Day getSunday() {
			return sunday;
		}

		public void setSunday(Day sunday) {
			this.sunday = sunday;
		}

		public static class Day {
			@JsonProperty("meals")
			private List<Meal> meals;

			@JsonProperty("nutrients")
			private Nutrients nutrients;
		}

		public static class Meal {
			@JsonProperty("id")
			private long id;

			@JsonProperty("imageType")
			private String imageType;

			@JsonProperty("title")
			private String title;

			@JsonProperty("readyInMinutes")
			private int readyInMinutes;

			@JsonProperty("servings")
			private int servings;

			@JsonProperty("sourceUrl")
			private String sourceUrl;
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

			public double getCalories() {
				return calories;
			}

			public void setCalories(double calories) {
				this.calories = calories;
			}

			public double getProtein() {
				return protein;
			}

			public void setProtein(double protein) {
				this.protein = protein;
			}

			public double getFat() {
				return fat;
			}

			public void setFat(double fat) {
				this.fat = fat;
			}

			public double getCarbohydrates() {
				return carbohydrates;
			}

			public void setCarbohydrates(double carbohydrates) {
				this.carbohydrates = carbohydrates;
			}
		}
	}
}
