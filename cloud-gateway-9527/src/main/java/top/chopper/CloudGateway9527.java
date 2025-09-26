package top.chopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway9527.class,args);
    }
}