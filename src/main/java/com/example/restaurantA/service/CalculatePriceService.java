package com.example.restaurantA.service;

import com.example.restaurantA.model.MenuItem;
import com.example.restaurantA.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculatePriceService {

    private final List<MenuItem> menu = List.of(
            new MenuItem("กะเพราหมูสับไข่ดาว", 45),
            new MenuItem("หมูกรอบคั่วพริกเกลือ", 50),
            new MenuItem("ไก่ย่าง", 40),
            new MenuItem("ข้าวผัด", 45)
    );

    public int calculateTotalPrice(List<OrderItem> order) {
   
        Map<String, Integer> priceMap = menu.stream()
                .collect(Collectors.toMap(MenuItem::getName, MenuItem::getPrice));

        return order.stream()
                .mapToInt(item -> priceMap.getOrDefault(item.getName(), 0) * item.getQuantity())
                .sum();
    }
}
