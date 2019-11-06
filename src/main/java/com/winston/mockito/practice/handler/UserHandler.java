package com.winston.mockito.practice.handler;

import com.winston.mockito.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserHandler {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public long saveUser(String userName){
        return userService.saveUser(userName);
    }

}
