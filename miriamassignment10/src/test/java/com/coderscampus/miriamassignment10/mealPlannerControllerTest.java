package com.coderscampus.miriamassignment10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coderscampus.miriamassignment10.spoonacular.SpoonacularIntegrationService;
import com.coderscampus.miriamassignment10.web.MealPlannerController;

@SpringBootTest
public class mealPlannerControllerTest {

	@Test
	public void testGetWeekMeals() {

		SpoonacularIntegrationService serviceMock = mock(SpoonacularIntegrationService.class);

		String sampleResponse = "{\"week\": {\"monday\": {\"meals\": [{\"id\": 1100990, \"imageType\": \"jpg\", \"title\": \"Blueberry, Chocolate & Cocao Superfood Pancakes - Gluten-Free/Paleo/Vegan\", \"readyInMinutes\": 30, \"servings\": 2, \"sourceUrl\": \"https://spoonacular.com/blueberry-chocolate-cocao-superfood-pancakes-gluten-free-paleo-vegan-1100990\"}]}}}";

		when(serviceMock.getWeekMeals("1500", "vegetarian", "dairy"))
				.thenReturn(new ResponseEntity<>(sampleResponse, HttpStatus.OK));

		MealPlannerController mealPlannerController = new MealPlannerController(serviceMock);

		ResponseEntity<String> result = mealPlannerController.getWeekMeals("1500", "vegetarian", "dairy");

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(sampleResponse, result.getBody());
	}

	@Test
	public void testGetDayMeals() {

		SpoonacularIntegrationService serviceMock = mock(SpoonacularIntegrationService.class);

		String sampleResponse = "{\"meals\":[{\"id\":1100990,\"imageType\":\"jpg\",\"title\":\"Blueberry, Chocolate & Cocao Superfood Pancakes - Gluten-Free/Paleo/Vegan\",\"readyInMinutes\":30,\"servings\":2,\"sourceUrl\":\"https://spoonacular.com/blueberry-chocolate-cocao-superfood-pancakes-gluten-free-paleo-vegan-1100990\"}]}";

		when(serviceMock.getDayMeals("1500", "vegetarian", "dairy"))
				.thenReturn(new ResponseEntity<>(sampleResponse, HttpStatus.OK));

		MealPlannerController mealPlannerController = new MealPlannerController(serviceMock);

		ResponseEntity<String> result = mealPlannerController.getDayMeals("1500", "vegetarian", "dairy");

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(sampleResponse, result.getBody());

	}
}
