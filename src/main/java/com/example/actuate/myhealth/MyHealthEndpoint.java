package com.example.actuate.myhealth;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "myhealth")
public class MyHealthEndpoint {

    @ReadOperation
    public MyHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("MyStatus", "is happy");
        MyHealth health = new MyHealth();
        health.setDetails(details);

        return health;
    }
}
