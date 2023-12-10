package com.coderscampus.miriamassignment10.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.miriamassignment10.config.SpoonacularProperties;
import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;

@RestController
@RequestMapping("/mealplanner")
public class MealPlannerController {
	
	@Autowired
	private SpoonacularProperties spoonacularProperties;
	
	private final RestTemplate restTemplate;
	
	public MealPlannerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam String numCalories, 
			@RequestParam String diet, 
			@RequestParam String exclusions)throws URISyntaxException{
		
		URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularProperties.getBaseUrl() + spoonacularProperties.getMealplan())
									  .queryParam("apiKey", spoonacularProperties.getKey())
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclusions)
									  .build()
									  .toUri();
		System.out.println("Generated URI: " + uri);
		
		ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
				return response;
	}
	
	@GetMapping("/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value = "targetCalories", required = false) String numCalories, 
			@RequestParam(required = false) String diet, 
			@RequestParam(value = "exclude", required = false) String exclusions) throws URISyntaxException{
		
		URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularProperties.getBaseUrl() + spoonacularProperties.getMealplan())
									  .queryParam("apiKey", spoonacularProperties.getKey())
									  .queryParam("timeFrame", "day")
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclusions)
									  .build()
									  .toUri();
		ResponseEntity<DayResponse> response = restTemplate.getForEntity(uri, DayResponse.class);						  
				return response;
	}

	
	

}
