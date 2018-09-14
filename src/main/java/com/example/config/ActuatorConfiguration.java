package com.example.config;

import com.example.actuate.myhealth.MyHealthEndpoint;
import com.example.actuate.myhealth.MyHealthWebEndpointExtension;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public MyHealthEndpoint myHealthEndpoint() {
        return new MyHealthEndpoint();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    @ConditionalOnBean({MyHealthEndpoint.class})
    public MyHealthWebEndpointExtension myHealthWebEndpointExtension(MyHealthEndpoint delegate) {
        return new MyHealthWebEndpointExtension(delegate);
    }

    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(final GracefulShutdown gracefulShutdown) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(gracefulShutdown);
        return factory;
    }


}
