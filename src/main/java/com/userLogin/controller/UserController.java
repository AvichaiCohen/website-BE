package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.service.UserOrderService;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUser customUser){
        try{
           userService.createUser(customUser);
           return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @GetMapping(value = "/get")
    @CrossOrigin
    public CustomUser getUserById(@RequestParam String username) throws Exception {
        return userService.findUserByUsername(username);
    }

    @PutMapping(value = "/update")
    @CrossOrigin
    public void updateUserByUsername(@RequestParam String username,
                               @RequestBody CustomUser user) throws Exception {
        userService.updateUserDetailsByAuth(user,username);
    }

    @DeleteMapping(value = "/delete")
    @CrossOrigin
    public void deleteUserById(@RequestParam String username) throws Exception {
        userService.deleteUserDetailsByAuth(username);
    }
}



