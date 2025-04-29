package com.example.restaurantA.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${service.b.base-url}")
    private String baseUrl;

    public Map<String, Object> getAvailableTables() {
        String url = baseUrl + "/api/available-tables";
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> estimateWaitTime(int dishes) {
        String url = baseUrl + "/api/estimate-wait-time";
        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", dishes);
        return restTemplate.postForObject(url, request, Map.class);
    }
}
