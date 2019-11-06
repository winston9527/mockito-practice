package com.winston.mockito.practice.support;

import com.winston.mockito.practice.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class MockBeansConfig {

    @Bean
    @Primary
    public UserService mockitoUserService() {
        return mock(UserService.class);
    }


}