package com.example.restaurantA.controller;

import com.example.restaurantA.model.OrderItem;
import com.example.restaurantA.service.CalculatePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalculatePriceController {

    @Autowired
    private CalculatePriceService calculatePriceService;

    @PostMapping("/calculate-price")
    public Map<String, Object> calculatePrice(@RequestBody Map<String, List<OrderItem>> payload) {
        List<OrderItem> order = payload.get("order");
        int total = calculatePriceService.calculateTotalPrice(order);

        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", total);
        return response;
    }
}
