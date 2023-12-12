package com.coderscampus.miriamassignment10.spoonacular;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.miriamassignment10.config.SpoonacularProperties;
import com.coderscampus.miriamassignment10.spoonacular.dto.DayResponse;
import com.coderscampus.miriamassignment10.spoonacular.dto.WeekResponse;

@Service
public class SpoonacularIntegrationService {

	@Autowired
	private SpoonacularProperties spoonacularProperties;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		URI uri = buildUri("day", numCalories, diet, exclusions);
		return restTemplate.getForEntity(uri, DayResponse.class);
	}

	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		URI uri = buildUri("week", numCalories, diet, exclusions);
		return restTemplate.getForEntity(uri, WeekResponse.class);
	}

	private URI buildUri(String timeFrame, String numCalories, String diet, String exclusions) {
        return UriComponentsBuilder.fromHttpUrl(spoonacularProperties.getBaseUrl() + spoonacularProperties.getMealplan())
                                   .queryParam("apiKey", spoonacularProperties.getKey())
                                   .queryParam("timeFrame", timeFrame)
                                   .queryParam("targetCalories", numCalories)
                                   .queryParam("diet", diet)
                                   .queryParam("exclude", exclusions)
                                   .build()
                                   .toUri();
	}

}
