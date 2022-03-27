package com.example.paymentmicroservice.paymentmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaymentMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMicroserviceApplication.class, args);
    }

}
