package com.coderscampus.miriamassignment10.spoonacular;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.miriamassignment10.config.SpoonacularProperties;

@Service
public class SpoonacularIntegrationService {

	private SpoonacularProperties spoonacularProperties;
	private RestTemplate restTemplate;
	
	@Autowired
	public SpoonacularIntegrationService(SpoonacularProperties spoonacularProperties, RestTemplate restTemplate) {
		super();
		this.spoonacularProperties = spoonacularProperties;
		this.restTemplate = restTemplate;
	}

//	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
	public ResponseEntity<String> getDayMeals(String numCalories, String diet, String exclusions) {
		System.out.println("Base URL: " + spoonacularProperties.getBaseUrl());
	    System.out.println("Meal Plan Endpoint: " + spoonacularProperties.getMealplan());
	    System.out.println("API Key: " + spoonacularProperties.getKey());
		URI uri = buildUri("day", numCalories, diet, exclusions);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		System.out.println("Raw JSON Response: " + response.getBody());
//		return restTemplate.getForEntity(uri, DayResponse.class);
		return response;
	}

//	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
	public ResponseEntity<String> getWeekMeals(String numCalories, String diet, String exclusions) {

		URI uri = buildUri("week", numCalories, diet, exclusions);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		System.out.println("Raw JSON response: " + response.getBody());
//		return restTemplate.getForEntity(uri, WeekResponse.class);
		return response;
	}

	private URI buildUri(String timeFrame, String numCalories, String diet, String exclusions) {
         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(spoonacularProperties.getBaseUrl() + spoonacularProperties.getMealplan())
                                   .queryParam("apiKey", spoonacularProperties.getKey())
                                   .queryParam("timeFrame", timeFrame);
         if (numCalories != null && !numCalories.isEmpty()) {
        	 builder.queryParam("targetCalories", numCalories);
        	 
         }
         
         if (diet != null && !diet.isEmpty()) {
        	 builder.queryParam("diet", diet);
        	 
         }
         
         if (exclusions != null && !exclusions.isEmpty()) {
        	 builder.queryParam("exclude", exclusions);
        	 
         }
                                   
        URI uri = builder.build().toUri();                           
        System.out.println("Constructed URI: " + uri.toString());
        return uri;
	}

}
