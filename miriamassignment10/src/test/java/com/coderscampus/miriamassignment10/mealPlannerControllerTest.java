package com.coderscampus.miriamassignment10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;
import com.coderscampus.miriamassignment10.web.MealPlannerController;

@SpringBootTest
public class mealPlannerControllerTest {
	
	private static final String API_KEY = "0b39434da0644e9f9617f949da1fe6ad";
	
	@Test
	public void testGetWeekMeals() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplateMock = mock(RestTemplate.class);
		
		WeekResponse sampleWeekResponse = createSampleWeekResponse();
		ResponseEntity<WeekResponse> sampleResponseEntity = new ResponseEntity<>(sampleWeekResponse, HttpStatus.OK);	
		
		when(restTemplateMock.getForEntity(any(URI.class), eq(WeekResponse.class))).thenReturn(sampleResponseEntity);
		
		MealPlannerController mealPlannerController = new MealPlannerController(restTemplateMock);
		
		ResponseEntity<WeekResponse> result = mealPlannerController.getWeekMeals("1500", "vegetarian", "dairy");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(sampleWeekResponse, result.getBody());
		
		verify(restTemplateMock, times(1)).getForEntity(new URI("https://api.spoonacular.com/mealplanner/generate?apiKey=" 
		+ API_KEY + "&targetCalories=1500&diet=vegetarian&exclude=dairy"), WeekResponse.class);
		
		System.out.println("Expected: " + sampleWeekResponse);
		System.out.println("Actual: " + result.getBody());

	}
	
	private WeekResponse createSampleWeekResponse() {
		WeekResponse weekResponse = new WeekResponse();
		
		WeekResponse.Week week = new WeekResponse.Week();
		WeekResponse.Week.Day monday = new WeekResponse.Week.Day();
		List<WeekResponse.Week.Meal> mondayMeals = new ArrayList<>();
		
		WeekResponse.Week.Meal meal1 = new WeekResponse.Week.Meal();
		meal1.setId(655786);
		meal1.setImageType("jpg");
		meal1.setTitle("Persimmons Pumpkin Orange Smoothie With Chia Seeds");
		meal1.setReadyInMinutes(45);
		meal1.setServings(3);
		meal1.setSourceUrl("https://spoonacular.com/persimmons-pumpkin-orange-smoothie-with-chia-seeds-655786");
		
		mondayMeals.add(meal1);
		
		monday.setMeals(mondayMeals);
		monday.setNutrients(new WeekResponse.Week.Nutrients());
		
		week.setMonday(monday);
		
		weekResponse.setWeek(week);
		
		return weekResponse;
	}

}
