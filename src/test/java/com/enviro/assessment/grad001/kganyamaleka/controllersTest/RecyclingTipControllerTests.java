package com.enviro.assessment.grad001.kganyamaleka.controllersTest;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.controllers.RecyclingTipController;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.services.RecyclingTipService;
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

class RecyclingTipControllerTests {

    private MockMvc mockMvc;

    @Mock
    private RecyclingTipService recyclingTipService;

    @InjectMocks
    private RecyclingTipController recyclingTipController;

    private RecyclingTipDTO tip1;
    private RecyclingTipDTO tip2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(recyclingTipController).build();

        tip1 = new RecyclingTipDTO(new RecyclingTip());
        tip1.setRecyclingTip("Recycle plastic bottles into planters.");

        tip2 = new RecyclingTipDTO(new RecyclingTip());
        tip2.setRecyclingTip("Reuse glass jars as storage containers.");
    }

    /**
     * Test for retrieving all recycling tips.
     */
    @Test
    void testGetAllTips() throws Exception {
        List<RecyclingTipDTO> tips = Arrays.asList(tip1, tip2);

        when(recyclingTipService.getAllTips()).thenReturn(tips);

        mockMvc.perform(get("/api/tips")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].recyclingTip").value("Recycle plastic bottles into planters."))
                .andExpect(jsonPath("$[1].recyclingTip").value("Reuse glass jars as storage containers."));

        verify(recyclingTipService, times(1)).getAllTips();
    }

    /**
     * Test for retrieving recycling tips by category ID.
     */
    @Test
    void testGetByCategoryId() throws Exception {
        Long categoryId = 101L;
        List<RecyclingTipDTO> tips = List.of(tip1);

        when(recyclingTipService.getTipByCategoryId(categoryId)).thenReturn(tips);

        mockMvc.perform(get("/api/tips/category/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].recyclingTip").value("Recycle plastic bottles into planters."));

        verify(recyclingTipService, times(1)).getTipByCategoryId(categoryId);
    }

    /**
     * Test for adding a new recycling tip.
     */
    @Test
    void testAddTip() throws Exception {
        RecyclingTip newTip = new RecyclingTip();
        newTip.setRecyclingTip("Compost organic waste to create fertilizer.");

        RecyclingTipDTO savedTip = new RecyclingTipDTO(new RecyclingTip());
        savedTip.setRecyclingTip("Compost organic waste to create fertilizer.");

        when(recyclingTipService.addTip(any(RecyclingTip.class))).thenReturn(savedTip);

        mockMvc.perform(post("/api/tips")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"recyclingTip\": \"Compost organic waste to create fertilizer.\", \"id\": 103}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.recyclingTip").value("Compost organic waste to create fertilizer."));

        verify(recyclingTipService, times(1)).addTip(any(RecyclingTip.class));
    }

    /**
     * Test for invalid input when adding a recycling tip.
     */
    @Test
    void testAddTipInvalidInput() throws Exception {
        // Missing required fields (e.g., "tip")
        String invalidPayload = "{\"categoryId\": 103}";

        mockMvc.perform(post("/api/tips")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPayload))
                .andExpect(status().isBadRequest());
    }
}
