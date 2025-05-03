package com.example.restaurantA.demo;

import com.example.restaurantA.model.OrderItem;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestaurantADemoClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Call B: Check available tables
        String bUrl = "http://localhost:8081/available-tables";
        Integer tables = restTemplate.getForObject(bUrl, Integer.class);
        System.out.println("[B] Available tables: " + tables);

        // Call B: Estimate wait time
        String waitUrl = "http://localhost:8081/estimate-wait-time";

        List<OrderItem> order = List.of(
                new OrderItem("ข้าวผัด", 2),
                new OrderItem("ไก่ย่าง", 1)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<OrderItem>> request = new HttpEntity<>(order, headers);

        Integer waitTime = restTemplate.postForObject(waitUrl, request, Integer.class);
        System.out.println("[B] Estimated wait time: " + waitTime + " minutes");
    }
}
