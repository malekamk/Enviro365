package com.enviro.assessment.grad001.kganyamaleka.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nelson")
public class WebhookContoller {

    @PostMapping
    public Map<String, List<String>> handleWebhook(@RequestBody Map<String, String> payload) {
        System.out.println("Payload received: " + payload);
        String input = payload.get("data");
        if (input == null) {
            throw new IllegalArgumentException("Payload missing 'data' field");
        }

        List<String> sortedChars = input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.toList());

        Map<String, List<String>> response = new HashMap<>();
        response.put("word", sortedChars);
        return response;
    }

}
