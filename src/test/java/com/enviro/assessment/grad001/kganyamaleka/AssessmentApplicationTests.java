package com.enviro.assessment.grad001.kganyamaleka;

import com.enviro.assessment.grad001.kganyamaleka.services.WasteCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@SpringBootTest
class AssessmentApplicationTests {

	@Autowired
	private WasteCategoryService service;

	@Test
	public void testGetAllCategories() {

	}
}
