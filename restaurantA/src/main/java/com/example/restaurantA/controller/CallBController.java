package com.example.restaurantA.controller;

import com.example.restaurantA.client.BClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CallBController {

    private final BClient bClient;

    public CallBController(BClient bClient) {
        this.bClient = bClient;
    }

    @GetMapping("/call-b/available-tables")
    public Map<String, Object> callAvailableTablesFromB() {
        return bClient.getAvailableTables();
    }

    @PostMapping("/call-b/estimate-wait-time")
    public Map<String, Object> callEstimateWaitTimeFromB(@RequestBody Map<String, Integer> request) {
        return bClient.estimateWaitTime(request.getOrDefault("dishes", 1));
    }
}
