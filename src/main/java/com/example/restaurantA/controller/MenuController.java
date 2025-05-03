package com.example.restaurantA.controller;

import com.example.restaurantA.model.MenuItem;
import com.example.restaurantA.repository.MenuItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private final MenuItemRepository repository;

    public MenuController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return repository.findAll();
    }
}
