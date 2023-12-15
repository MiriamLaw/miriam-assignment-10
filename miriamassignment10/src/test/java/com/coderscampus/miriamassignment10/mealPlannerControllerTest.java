package com.coderscampus.miriamassignment10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coderscampus.miriamassignment10.spoonacular.SpoonacularIntegrationService;
import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.Meals;
import com.coderscampus.miriamassignment10.spoonacular.dto.Week;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;
import com.coderscampus.miriamassignment10.web.MealPlannerController;

@SpringBootTest
public class mealPlannerControllerTest {

	@Autowired
	private MealPlannerController mealPlannerController;

	@MockBean
	private SpoonacularIntegrationService serviceMock;

	@Test
	public void testGetWeekMeals() {

		WeekResponse mockResponse = createMockWeekResponse();
		when(serviceMock.getWeekMeals("1500", "vegetarian", "dairy"))
				.thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

		ResponseEntity<WeekResponse> result = mealPlannerController.getWeekMeals("1500", "vegetarian", "dairy");

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(mockResponse, result.getBody());
	}

	private WeekResponse createMockWeekResponse() {
		WeekResponse weekResponse = new WeekResponse();
		Week week = new Week();
		DayResponse mondayResponse = new DayResponse();

		List<Meals.Meal> mondayMeals = new ArrayList<>();
		Meals.Meal mondayMeal1 = new Meals.Meal();
		mondayMeals.add(mondayMeal1);
		mondayResponse.setMeals(mondayMeals);

		week.setMonday(mondayResponse);
		weekResponse.setWeek(week);

		return weekResponse;
	}

	@Test
	public void testGetDayMeals() {

		DayResponse mockResponse = createMockDayResponse();

		when(serviceMock.getDayMeals("1500", "vegetarian", "dairy"))
				.thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

		MealPlannerController mealPlannerController = new MealPlannerController(serviceMock);

		ResponseEntity<DayResponse> result = mealPlannerController.getDayMeals("1500", "vegetarian", "dairy");

		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(mockResponse, result.getBody());

	}

	private DayResponse createMockDayResponse() {
		DayResponse dayResponse = new DayResponse();
		DayResponse day = new DayResponse();
		List<Meals.Meal> meals = new ArrayList<>();

		Meals.Meal meal1 = new Meals.Meal();
		meal1.setId(639726);
		meal1.setImageType("jpg");
		meal1.setTitle("Coconut Banana Nut Bread");
		meal1.setReadyInMinutes(45);
		meal1.setServings(12);
		meal1.setSourceUrl("https://spoonacular.com/coconut-banana-nut-bread-639726");
		meals.add(meal1);
		day.setMeals(meals);

		return dayResponse;
	}
}
