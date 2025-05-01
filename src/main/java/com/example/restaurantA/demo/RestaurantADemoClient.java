package com.example.restaurantA.demo;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestaurantADemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8081";

        System.out.println("[A → B] Checking available tables...");

        Map<String, Object> tables = restTemplate.getForObject(baseUrl + "/api/available-tables", Map.class);
        System.out.println("Available tables from B: " + tables.get("availableTables"));

        System.out.println("\n[A → B] Estimating wait time for 3 dishes...");

        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", 3);
        Map<String, Object> waitTime = restTemplate.postForObject(baseUrl + "/api/estimate-wait-time", request, Map.class);
        System.out.println("Estimated wait time from B: " + waitTime.get("waitTime") + " minutes");
    }
}
