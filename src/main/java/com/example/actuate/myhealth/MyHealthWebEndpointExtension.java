package com.example.actuate.myhealth;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;

@EndpointWebExtension(endpoint = MyHealthEndpoint.class)
public class MyHealthWebEndpointExtension {

    private final MyHealthEndpoint delegate;

    public MyHealthWebEndpointExtension(MyHealthEndpoint delegate) {
        this.delegate = delegate;
    }

    @ReadOperation
    public WebEndpointResponse<MyHealth> getHealth() {
        MyHealth health = delegate.health();
        return new WebEndpointResponse<>(health, 200);
    }
}
