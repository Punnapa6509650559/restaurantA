package com.example.restaurantA.demo;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestaurantADemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://192.168.1.52:8081"; 

        String tablesUrl = baseUrl + "/api/available-tables";
        Map<String, Object> tables = restTemplate.getForObject(tablesUrl, Map.class);
        System.out.println("ผลลัพธ์จาก B (/available-tables): " + tables);


        String waitTimeUrl = baseUrl + "/api/estimate-wait-time";
        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", 3);

        Map<String, Object> waitTime = restTemplate.postForObject(waitTimeUrl, request, Map.class);
        System.out.println("ผลลัพธ์จาก B (/estimate-wait-time): " + waitTime);
    }
}
