package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<UserResponse> getAllUsers(@RequestParam(required = false) int page, int itemPerPage){
        List<UserResponse> userResponses = new ArrayList<>();
        userResponses.add(new UserResponse(1,"user1"));
        userResponses.add(new UserResponse(2,"user2"));
        return userResponses;
    }
    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id){
        return new UserResponse(id, "User " + id);
    }

}
