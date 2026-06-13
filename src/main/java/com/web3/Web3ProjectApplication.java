package com.web3;

import com.web3.infra.properties.CoingeckoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(CoingeckoProperties.class)
@EnableFeignClients
public class Web3ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Web3ProjectApplication.class, args);
    }

}
