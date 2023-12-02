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

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;
import com.coderscampus.miriamassignment10.web.MealPlannerController;

public class mealPlannerControllerTest {
	
	private static final String API_KEY = "0b39434da0644e9f9617f949da1fe6ad";
	
	@Test
	public void testGetWeekMeals() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplateMock = mock(RestTemplate.class);
		
		WeekResponse sampleWeekResponse = new WeekResponse(); //need sample data
		ResponseEntity<WeekResponse> sampleResponseEntity = new ResponseEntity<>(sampleWeekResponse, HttpStatus.OK);	
		
		when(restTemplateMock.getForEntity(any(URI.class), eq(WeekResponse.class))).thenReturn(sampleResponseEntity);
		
		MealPlannerController mealPlannerController = new MealPlannerController();
		
		ReflectionTestUtils.setField(mealPlannerController, "restTemplate", restTemplateMock);
		
		ResponseEntity<WeekResponse> result = mealPlannerController.getWeekMeals("1500", "vegetarian", "dairy");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(sampleWeekResponse, result.getBody());
		
		verify(restTemplateMock, times(1)).getForEntity(eq(new URI("https://api.spoonacular.com/generate?apiKey=" 
		+ API_KEY + "&targetCalories=1500&diet=vegetarian&exclude=dairy")), eq(WeekResponse.class));
	}

}
