package com.grabmoney.eurekaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaconfigApplication.class, args);
    }

}
