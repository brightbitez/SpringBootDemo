package com.example.demo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"page","itemPerPage","users"})
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

    @PostMapping("/users")
    public UserResponse createNewUser(NewUserRequest request){
        return new UserResponse(0,request.getName() + request.getAge());
    }
}
