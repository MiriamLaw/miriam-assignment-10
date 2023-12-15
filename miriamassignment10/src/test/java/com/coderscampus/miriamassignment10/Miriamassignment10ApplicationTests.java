package com.coderscampus.miriamassignment10;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.coderscampus.miriamassignment10.config.SpoonacularProperties;
import com.coderscampus.miriamassignment10.spoonacular.SpoonacularIntegrationService;

@SpringBootTest
class Miriamassignment10ApplicationTests {
	
	@Autowired
	private SpoonacularIntegrationService spoonacularIntegrationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SpoonacularProperties spoonacularProperties;

	@Test
	void contextLoads() {
	}
	
	@Test
    public void spoonacularIntegrationServiceBeanLoaded() {
        assertNotNull(spoonacularIntegrationService, "SpoonacularIntegrationService bean should be loaded");
    }

    @Test
    public void restTemplateBeanLoaded() {
        assertNotNull(restTemplate, "RestTemplate bean should be loaded");
    }

    @Test
    public void spoonacularPropertiesBeanLoaded() {
        assertNotNull(spoonacularProperties, "SpoonacularProperties bean should be loaded");
    }
	

}
