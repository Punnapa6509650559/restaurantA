package com.example.restaurantA.controller;

import com.example.restaurantA.model.MenuItem;
import com.example.restaurantA.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return menuService.getMenu();
    }
}
