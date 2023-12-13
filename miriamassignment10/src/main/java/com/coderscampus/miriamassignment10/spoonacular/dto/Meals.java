package com.coderscampus.miriamassignment10.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meals {

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
		
		public Meal() {
			
		}

		public Meal(long id, String imageType, String title, int readyInMinutes, int servings, String sourceUrl) {
			super();
			this.id = id;
			this.imageType = imageType;
			this.title = title;
			this.readyInMinutes = readyInMinutes;
			this.servings = servings;
			this.sourceUrl = sourceUrl;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getReadyInMinutes() {
			return readyInMinutes;
		}

		public void setReadyInMinutes(int readyInMinutes) {
			this.readyInMinutes = readyInMinutes;
		}

		public int getServings() {
			return servings;
		}

		public void setServings(int servings) {
			this.servings = servings;
		}

		public String getSourceUrl() {
			return sourceUrl;
		}

		public void setSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}
	}
}