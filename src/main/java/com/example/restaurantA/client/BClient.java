package com.example.restaurantA.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class BClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8081";

    public Map<String, Object> getAvailableTables() {
        return restTemplate.getForObject(baseUrl + "/api/available-tables", Map.class);
    }

    public Map<String, Object> estimateWaitTime(int dishes) {
        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", dishes);
        return restTemplate.postForObject(baseUrl + "/api/estimate-wait-time", request, Map.class);
    }
}
