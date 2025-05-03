// For running Java demo client

package com.example.restaurantA.demo;

import com.example.restaurantA.model.OrderItem;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class RestaurantADemoClient {
    public static void main(String[] args) {
        System.out.println("=== DEMO: Service A calling Service B ===\n");

        RestTemplate restTemplate = new RestTemplate();

        String bTableUrl = "http://localhost:8081/api/available-tables";
        Integer tables = restTemplate.getForObject(bTableUrl, Integer.class);
        System.out.println("[From Service B] Number of available tables:");
        System.out.println("→ " + tables + " tables available\n");

        String waitUrl = "http://localhost:8081/api/estimate-wait-time";

        List<OrderItem> order = List.of(
                new OrderItem("ข้าวผัด", 2),
                new OrderItem("ไก่ย่าง", 1)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<OrderItem>> request = new HttpEntity<>(order, headers);

        Map<String, Object> response = restTemplate.postForObject(waitUrl, request, Map.class);

        System.out.println("[From Service B] Estimated wait time for the order:");
        System.out.println("→ Ordered items:");
        order.forEach(item -> System.out.println("   - " + item.getName() + " x " + item.getQuantity()));
        System.out.println("→ Estimated wait time: " + response.get("waitTime") + " minutes");
    }
}
