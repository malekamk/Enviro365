package com.enviro.assessment.grad001.kganyamaleka;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.kganyamaleka.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.kganyamaleka.services.WasteCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WasteCategoryServiceTests {

	@Mock
	private WasteCategoryRepository repository;

	@InjectMocks
	private WasteCategoryService wasteCategoryService;

	private WasteCategory plasticCategory;
	private WasteCategoryDTO plasticDTO;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		// Sample data
		plasticCategory = new WasteCategory();
		plasticCategory.setId(1L);
		plasticCategory.setName("Plastic");
		plasticCategory.setDescription("Plastic materials");

		plasticDTO = new WasteCategoryDTO(plasticCategory);
	}

	@Test
	void testGetAllCategories() {
		WasteCategory metalCategory = new WasteCategory();
		metalCategory.setId(2L);
		metalCategory.setName("Metal");
		metalCategory.setDescription("Metallic waste");

		when(repository.findAll()).thenReturn(Arrays.asList(plasticCategory, metalCategory));

		List<WasteCategoryDTO> categories = wasteCategoryService.getAllCategories();

		assertEquals(2, categories.size());
		assertEquals("Plastic", categories.get(0).getName());
		assertEquals("Metal", categories.get(1).getName());

		verify(repository, times(1)).findAll();
	}

	@Test
	void testGetByIdValid() {
		when(repository.findById(1L)).thenReturn(Optional.of(plasticCategory));

		WasteCategoryDTO result = wasteCategoryService.getById(1L);

		assertNotNull(result);
		assertEquals("Plastic", result.getName());
		verify(repository, times(1)).findById(1L);
	}

	@Test
	void testGetByIdNotFound() {
		when(repository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> wasteCategoryService.getById(1L));

		verify(repository, times(1)).findById(1L);
	}

	@Test
	void testAddCategory() {
		WasteCategory newCategory = new WasteCategory();
		newCategory.setName("Glass");
		newCategory.setDescription("Glass waste");

		WasteCategory savedCategory = new WasteCategory();
		savedCategory.setId(3L);
		savedCategory.setName("Glass");
		savedCategory.setDescription("Glass waste");

		when(repository.save(newCategory)).thenReturn(savedCategory);

		WasteCategoryDTO result = wasteCategoryService.addCategory(newCategory);

		assertNotNull(result);
		assertEquals("Glass", result.getName());
		assertEquals("Glass waste", result.getDescription());

		verify(repository, times(1)).save(newCategory);
	}

	@Test
	void testNumberOfCategories() {
		when(repository.count()).thenReturn(3L);

		Long count = wasteCategoryService.numberOfCategories();

		assertEquals(3L, count);
		verify(repository, times(1)).count();
	}

	@Test
	void testDeleteCategoryByIDValid() {
		when(repository.existsById(1L)).thenReturn(true);

		doNothing().when(repository).deleteById(1L);

		wasteCategoryService.deleteCategoryByID(1L);

		verify(repository, times(1)).existsById(1L);
		verify(repository, times(1)).deleteById(1L);
	}

	@Test
	void testDeleteCategoryByIDNotFound() {
		when(repository.existsById(1L)).thenReturn(false);

		assertThrows(ResourceNotFoundException.class, () -> wasteCategoryService.deleteCategoryByID(1L));

		verify(repository, times(1)).existsById(1L);
		verify(repository, never()).deleteById(anyLong());
	}
}
