package com.coderscampus.miriamassignment10.spoonacular;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SpoonacularIntegration {
	
	@Value("${spoonacular.urls.base}")
	private String baseUrl;
	
	@Value("${spoonacular.urls.mealplan}")
	private String mealPlan;
	
	@Value("${spoonacular.urls.key}")
	private String key;

	

}
