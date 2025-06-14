package com.enviro.assessment.grad001.kganyamaleka.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/nelson")
public class WebhookContoller {

    @PostMapping
    public Map<String, List<String>> handleWebhook(@RequestBody Map<String, String> payload) {
        String input = payload.get("data");

        // Convert to char array, sort, and collect back as list of strings
        List<String> sortedChars = input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .toList();

        // Return as JSON
        Map<String, List<String>> response = new HashMap<>();
        response.put("word", sortedChars);
        return response;
    }
}
