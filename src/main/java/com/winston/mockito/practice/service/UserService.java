package com.winston.mockito.practice.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public long saveUser(String userName) {
        System.out.println("userName is:" + userName);
        return 100L;
    }

}
