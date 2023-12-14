package com.coderscampus.miriamassignment10.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.miriamassignment10.spoonacular.SpoonacularIntegrationService;

@RestController
@RequestMapping("/mealplanner")
public class MealPlannerController {
	
	private SpoonacularIntegrationService spoonacularIntegrationService;

	public MealPlannerController(SpoonacularIntegrationService spoonacularIntegrationService) {
		super();
		this.spoonacularIntegrationService = spoonacularIntegrationService;
	}

	@GetMapping("/week")
//	public ResponseEntity<WeekResponse> getWeekMeals(
	public ResponseEntity<String> getWeekMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required=false) String diet, 
			@RequestParam(value = "exclusions", required = false) String exclusions){
		return spoonacularIntegrationService.getWeekMeals(numCalories, diet, exclusions);
	}
	
	@GetMapping("/day")
//	public ResponseEntity<DayResponse> getDayMeals(
	public ResponseEntity<String> getDayMeals(

			@RequestParam(value = "targetCalories", required = false) String numCalories, 
			@RequestParam(required = false) String diet, 
			@RequestParam(value = "exclude", required = false) String exclusions) {
		return spoonacularIntegrationService.getDayMeals(numCalories, diet, exclusions);
	}

	
	

}
