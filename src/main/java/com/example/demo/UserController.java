package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public UserResponse[] getAllUsers(){
        UserResponse[] userResponses = new UserResponse[2];
        userResponses[0] = new UserResponse(1,"user1");
        userResponses[1] = new UserResponse(2,"user2");
        return userResponses;
    }
}
