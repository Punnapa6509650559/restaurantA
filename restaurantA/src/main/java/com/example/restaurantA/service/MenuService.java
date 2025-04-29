package com.example.restaurantA.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurantA.model.MenuItem;

@Service
public class MenuService {

    public List<MenuItem> getMenu() {
        return Arrays.asList(
            new MenuItem("กะเพราหมูสับไข่ดาว", 45),
            new MenuItem("หมูกรอบคั่วพริกเกลือ", 50),
            new MenuItem("ไก่ย่าง", 40),
            new MenuItem("ข้าวผัด", 45)
        );
    }
}
