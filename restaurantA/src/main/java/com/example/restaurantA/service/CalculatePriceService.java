package com.example.restaurantA.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CalculatePriceService {

    private final Map<String, Integer> menuPriceMap = new HashMap<>();

    public CalculatePriceService() {
     
        menuPriceMap.put("กะเพราหมูสับไข่ดาว", 45);
        menuPriceMap.put("หมูกรอบคั่วพริกเกลือ", 50);
        menuPriceMap.put("ไก่ย่าง", 40);
        menuPriceMap.put("ข้าวผัด", 45);
    }

    public Map<String, Object> calculatePrice(List<String> dishes) {
        int totalPrice = 0;

        for (String dish : dishes) {
            Integer price = menuPriceMap.get(dish);
            if (price != null) {
                totalPrice += price;
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return response;
    }
}
