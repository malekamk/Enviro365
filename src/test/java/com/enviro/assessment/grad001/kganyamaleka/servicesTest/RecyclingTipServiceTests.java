package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.repository.RecyclingTipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecyclingTipServiceTests {

    @Mock
    private RecyclingTipRepository repository;

    @InjectMocks
    private RecyclingTipService recyclingTipService;

    private RecyclingTip plasticTip;
    private RecyclingTip metalTip;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        plasticTip = new RecyclingTip();
        plasticTip.setId(1L);
        plasticTip.setRecyclingTip("Reuse plastic bottles as planters.");

        metalTip = new RecyclingTip();
        metalTip.setId(2L);
        metalTip.setRecyclingTip("Recycle aluminum cans at your local recycling center.");
    }

    @Test
    void testGetAllTips() {
        List<RecyclingTip> tips = Arrays.asList(plasticTip, metalTip);
        when(repository.findAll()).thenReturn(tips);

        List<RecyclingTipDTO> result = recyclingTipService.getAllTips();

        assertEquals(2, result.size());
        assertEquals("Reuse plastic bottles as planters.", result.get(0).getRecyclingTip());
        assertEquals("Recycle aluminum cans at your local recycling center.", result.get(1).getRecyclingTip());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testAddTip() {
        when(repository.save(any(RecyclingTip.class))).thenReturn(plasticTip);

        RecyclingTipDTO result = recyclingTipService.addTip(plasticTip);

        assertEquals("Reuse plastic bottles as planters.", result.getRecyclingTip());
        verify(repository, times(1)).save(plasticTip);
    }

    @Test
    void testGetTipByCategoryId() {
        List<RecyclingTip> tips = Arrays.asList(plasticTip);
        when(repository.findByCategoryId(101L)).thenReturn(tips);

        List<RecyclingTipDTO> result = recyclingTipService.getTipByCategoryId(101L);

        assertEquals(1, result.size());
        assertEquals("Reuse plastic bottles as planters.", result.get(0).getRecyclingTip());
        verify(repository, times(1)).findByCategoryId(101L);
    }
}
