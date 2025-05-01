package com.example.restaurantA.service;

import com.example.restaurantA.model.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final List<MenuItem> menuItems = List.of(
        new MenuItem("กะเพราหมูสับไข่ดาว", 45),
        new MenuItem("หมูกรอบคั่วพริกเกลือ", 50),
        new MenuItem("ไก่ย่าง", 40),
        new MenuItem("ข้าวผัด", 45)
    );

    public List<MenuItem> getMenu() {
        return menuItems;
    }
}
