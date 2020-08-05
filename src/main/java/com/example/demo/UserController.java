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
    public PagingResponse getAllUsers(@RequestParam(required = false,defaultValue = "2") int page,
                                      @RequestParam(defaultValue = "15") int itemPerPage){
        PagingResponse pagingResponse = new PagingResponse();
        List<UserResponse> userResponseList = new ArrayList<>();
        userResponseList.add(new UserResponse(1,"bomb"));
        userResponseList.add(new UserResponse(2,"dang"));
        pagingResponse.setUserResponseList(userResponseList);
        pagingResponse.setItemPerPage(15);
        pagingResponse.setPage(2);
        return pagingResponse;
    }
    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id){
        return new UserResponse(id, "User " + id);
    }

}
