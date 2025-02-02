package com.Financial_Management_System.Controller;

import com.Financial_Management_System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/user/{userId}")
    public String deleteUserEntitybyID(@PathVariable Long userId){
        return userService.deleteUserEntitybyID(userId);
    }
}
