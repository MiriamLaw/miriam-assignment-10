package com.coderscampus.miriamassignment10.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api.spoonacular.com")
public class SpoonacularProperties {

	private String baseUrl;
	private String mealplan;
	private String key;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getMealplan() {
		return mealplan;
	}

	public void setMealplan(String mealplan) {
		this.mealplan = mealplan;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
