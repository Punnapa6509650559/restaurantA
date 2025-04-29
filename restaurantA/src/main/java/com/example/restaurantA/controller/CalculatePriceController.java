package com.example.restaurantA.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantA.service.CalculatePriceService;

@RestController
public class CalculatePriceController {

    private final CalculatePriceService calculatePriceService;

    public CalculatePriceController(CalculatePriceService calculatePriceService) {
        this.calculatePriceService = calculatePriceService;
    }

    @PostMapping("/calculate-price")
    public Map<String, Object> calculatePrice(@RequestBody Map<String, List<String>> request) {
        List<String> dishes = request.get("dishes");
        return calculatePriceService.calculatePrice(dishes);
    }
}
