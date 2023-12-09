package com.coderscampus.miriamassignment10.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(prefix = "spoonacular.api", classes = SpoonacularProperties.class)
public class SpoonacularProperties {
	
	private String baseUrl;
	private String mealplan;
	private String key;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

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
