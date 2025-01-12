package com.enviro.assessment.grad001.kganyamaleka;

import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@SpringBootTest
class AssessmentApplicationTests {

	@Autowired
	private CategoryService service;

	@Test
	public void testGetAllCategories() {

	}
}
