package com.Financial_Management_System.Controller;

import com.Financial_Management_System.DTO.AuthDTO;
import com.Financial_Management_System.DTO.UserDTO;
import com.Financial_Management_System.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@Valid @RequestBody(required = false) UserDTO userDto){
        return userService.saveUserDTO(userDto);
    }

    @PostMapping("/verify")
    public String verifyUser(@RequestBody AuthDTO authDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String Result_part1 = userService.verifyUser(authDTO);
        String Result = username+Result_part1;

        return Result;
    }


}
