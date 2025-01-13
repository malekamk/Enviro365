package com.enviro.assessment.grad001.kganyamaleka.controllersTest;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.controllers.WasteCategoryController;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.services.WasteCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for the WasteCategoryController class.
 * Verifies the behavior of the controller endpoints for managing waste categories.
 */
class WasteCategoryControllerTests {

    private MockMvc mockMvc;

    @Mock
    private WasteCategoryService categoryService;

    @InjectMocks
    private WasteCategoryController wasteCategoryController;

    private WasteCategoryDTO plasticDTO;
    private WasteCategoryDTO metalDTO;

    /**
     * Set up test environment and sample data before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wasteCategoryController).build();

        plasticDTO = new WasteCategoryDTO(new WasteCategory());
        plasticDTO.setName("Plastic");
        plasticDTO.setDescription("Plastic materials");

        metalDTO = new WasteCategoryDTO(new WasteCategory());
        metalDTO.setName("Metal");
        metalDTO.setDescription("Metallic waste");
    }

    /**
     * Test for retrieving all waste categories.
     */
    @Test
    void testGetCategories() throws Exception {
        List<WasteCategoryDTO> categories = Arrays.asList(plasticDTO, metalDTO);

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/waste/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Plastic"))
                .andExpect(jsonPath("$[1].name").value("Metal"));

        verify(categoryService, times(1)).getAllCategories();
    }

    /**
     * Test for adding a new waste category.
     */
    @Test
    void testSaveCategory() throws Exception {
        WasteCategoryDTO newCategoryDTO = new WasteCategoryDTO(new WasteCategory());
        newCategoryDTO.setName("Glass");
        newCategoryDTO.setDescription("Glass waste");

        when(categoryService.addCategory(any(WasteCategory.class))).thenReturn(newCategoryDTO);

        mockMvc.perform(post("/api/waste/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Glass\", \"description\": \"Glass waste\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Glass"))
                .andExpect(jsonPath("$.description").value("Glass waste"));

        verify(categoryService, times(1)).addCategory(any(WasteCategory.class));
    }

    /**
     * Test for deleting a waste category by ID.
     */
    @Test
    void testDeleteCategory() throws Exception {
        Long categoryId = 1L;

        when(categoryService.getById(categoryId)).thenReturn(plasticDTO);

        // Mock the deleteCategoryByID method to do nothing
        doNothing().when(categoryService).deleteCategoryByID(categoryId);

        // Perform DELETE request
        mockMvc.perform(delete("/api/waste/categories/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()); // Expect 204 No Content

        // Verify that the service methods were called correctly
        verify(categoryService, times(1)).getById(categoryId);
        verify(categoryService, times(1)).deleteCategoryByID(categoryId);
    }
    @Test
    void testSaveCategoryInvalidInput() throws Exception {
        // Missing required fields (e.g., "name")
        String invalidPayload = "{\"description\": \"Missing name field\"}";

        mockMvc.perform(post("/api/waste/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPayload))
                .andExpect(status().isBadRequest()); // Expect 400 Bad Request
    }

}
