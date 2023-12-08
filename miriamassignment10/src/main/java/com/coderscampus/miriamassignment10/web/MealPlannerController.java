package com.coderscampus.miriamassignment10.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${spoonacular.urls.base}")
	private String baseUrl;
	
	@Value("${spoonacular.apiKey}")
	private String apiKey;
	
	private final RestTemplate restTemplate;
	
	public MealPlannerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam String numCalories, 
			@RequestParam String diet, 
			@RequestParam String exclusions)throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/mealplanner/generate")
									  .queryParam("apiKey", apiKey)
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
		
		URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/mealplanner/generate")
									  .queryParam("apiKey", apiKey)
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
