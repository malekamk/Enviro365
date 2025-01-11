package com.enviro.assessment.grad001.kganyamaleka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AssessmentApplicationTests {

	@Autowired
	private CategoryService service;

	@Test
	public void testGetAllCategories() {
		List<WasteCategory> categories = service.getAllCategories();
		assertNotNull(categories);
	}
}
