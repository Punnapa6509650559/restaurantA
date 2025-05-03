package com.example.restaurantA.controller;

import com.example.restaurantA.model.MenuItem;
import com.example.restaurantA.model.OrderItem;
import com.example.restaurantA.repository.MenuItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalculatePriceController {

    private final MenuItemRepository repository;

    public CalculatePriceController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/calculate-price")
    public Map<String, Object> calculatePrice(@RequestBody List<OrderItem> order) {
        int total = 0;
        for (OrderItem item : order) {
            MenuItem menuItem = repository.findByName(item.getName());
            if (menuItem != null) {
                total += menuItem.getPrice() * item.getQuantity();
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", total);
        return response;
    }
}
