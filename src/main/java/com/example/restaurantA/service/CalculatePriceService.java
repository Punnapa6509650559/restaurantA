package com.example.restaurantA.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatePriceService {

    private final Map<String, Integer> priceMap = Map.of(
        "กะเพราหมูสับไข่ดาว", 45,
        "หมูกรอบคั่วพริกเกลือ", 50,
        "ไก่ย่าง", 40,
        "ข้าวผัด", 45
    );

    public Map<String, Object> calculatePrice(List<String> dishes) {
        int totalPrice = 0;
        for (String name : dishes) {
            totalPrice += priceMap.getOrDefault(name, 0);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("totalPrice", totalPrice);
        return result;
    }
}
