package com.example.restaurantA.demo;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestaurantADemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8081";

        Map<String, Object> tables = restTemplate.getForObject(baseUrl + "/api/available-tables", Map.class);
        System.out.println("โต๊ะว่างจาก B: " + tables);

        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", 3);
        Map<String, Object> waitTime = restTemplate.postForObject(baseUrl + "/api/estimate-wait-time", request, Map.class);
        System.out.println("เวลารอจาก B: " + waitTime);
    }
}
