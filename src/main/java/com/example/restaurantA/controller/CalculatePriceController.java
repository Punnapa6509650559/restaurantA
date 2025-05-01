package com.example.restaurantA.controller;

import com.example.restaurantA.service.CalculatePriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CalculatePriceController {

    private final CalculatePriceService service;

    public CalculatePriceController(CalculatePriceService service) {
        this.service = service;
    }

    @PostMapping("/calculate-price")
    public Map<String, Object> calculate(@RequestBody Map<String, List<String>> body) {
        return service.calculatePrice(body.get("dishes"));
    }
}
