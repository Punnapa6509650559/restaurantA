package com.example.restaurantA.service;

import com.example.restaurantA.model.MenuItem;
import com.example.restaurantA.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuItemRepository repository;

    public MenuService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getMenu() {
        return repository.findAll(); 
    }
}
