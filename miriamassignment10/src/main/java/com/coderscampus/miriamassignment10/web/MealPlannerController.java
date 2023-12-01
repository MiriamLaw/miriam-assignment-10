package com.coderscampus.miriamassignment10.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;

@RestController
@RequestMapping("/mealplanner")
public class MealPlannerController {
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam String numCalories, 
			@RequestParam String diet, 
			@RequestParam String exclusions) {
				return null;
		//implement logic to fetch week meals from spoonacular
	}
	
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam String numCalories, 
			@RequestParam String diet, 
			@RequestParam String exclusions) {
				return null;
		//implement logic to fetch day meals from spoonacular
	}

}
