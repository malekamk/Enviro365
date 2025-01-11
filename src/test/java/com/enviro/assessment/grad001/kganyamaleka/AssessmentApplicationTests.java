package com.enviro.assessment.grad001.kganyamaleka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AssessmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
		private CategoryService service;

	@Test
	public void testGetAllCategories() {
		List<WasteCategory> categories = service.getAllCategories();
		assertNotNull(categories);
	}

	@Test
	public void testAllCategories() {
		List<WasteCategory> categories = service.getAllCategories();
		assertNotNull(categories);
	}



}
