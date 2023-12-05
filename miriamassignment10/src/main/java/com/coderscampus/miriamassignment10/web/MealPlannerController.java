package com.coderscampus.miriamassignment10.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;

@RestController
@RequestMapping("/mealplanner")
public class MealPlannerController {
	private static final String API_KEY = "0b39434da0644e9f9617f949da1fe6ad";
	private final RestTemplate restTemplate;
	
	public MealPlannerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam String numCalories, 
			@RequestParam String diet, 
			@RequestParam String exclusions)throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", getApiKey())
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclusions)
									  .build()
									  .toUri();
		ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
				return response;
	}
	
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value = "targetCalories", required = false) String numCalories, 
			@RequestParam(required = false) String diet, 
			@RequestParam(value = "exclude", required = false) String exclusions) throws URISyntaxException{
		
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", getApiKey())
									  .queryParam("timeFrame", "day")
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclusions)
									  .build()
									  .toUri();
		ResponseEntity<DayResponse> response = restTemplate.getForEntity(uri, DayResponse.class);						  
				return response;
	}

	public static String getApiKey() {
		return API_KEY;
	}
	

}
