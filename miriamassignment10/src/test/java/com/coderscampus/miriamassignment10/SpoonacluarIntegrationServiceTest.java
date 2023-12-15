package com.coderscampus.miriamassignment10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.coderscampus.miriamassignment10.config.SpoonacularProperties;
import com.coderscampus.miriamassignment10.spoonacular.SpoonacularIntegrationService;
import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;

public class SpoonacluarIntegrationServiceTest {

	private SpoonacularIntegrationService service;
	private RestTemplate restTemplateMock;
	private SpoonacularProperties propertiesMock;

	@BeforeEach
	public void setup() {
		restTemplateMock = mock(RestTemplate.class);
		propertiesMock = mock(SpoonacularProperties.class);

		service = new SpoonacularIntegrationService(propertiesMock, restTemplateMock);

		when(propertiesMock.getBaseUrl()).thenReturn("https://api.spoonacular.com");
		when(propertiesMock.getMealplan()).thenReturn("/mealplanner/generate");
		when(propertiesMock.getKey()).thenReturn("0b39434da0644e9f9617f949da1fe6ad");
	}

	@Test
	public void getDayMealsTest() {
		DayResponse expectedResponse = new DayResponse(); // populate with test data as needed
		when(restTemplateMock.getForEntity(any(URI.class), eq(DayResponse.class)))
				.thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

		ResponseEntity<DayResponse> actualResponse = service.getDayMeals("2000", "vegan", "nuts");

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(expectedResponse, actualResponse.getBody());
	}

	@Test
	public void getWeekMealsTest() {
		WeekResponse expectedResponse = new WeekResponse(); // Populate with test data as needed
		when(restTemplateMock.getForEntity(any(URI.class), eq(WeekResponse.class)))
				.thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
		
        ResponseEntity<WeekResponse> actualResponse = service.getWeekMeals("2000", "vegan", "nuts");
        
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedResponse, actualResponse.getBody());

        
	}
}
