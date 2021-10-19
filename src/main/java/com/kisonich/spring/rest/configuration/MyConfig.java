package com.kisonich.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.kisonich.spring.rest")
public class MyConfig {

     @Bean
    public RestTemplate restTemplate() { // Совершение HTTP запрос из рестклиента


         return new RestTemplate();
     }
}
