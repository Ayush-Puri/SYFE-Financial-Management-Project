package com.syfe.FinancialManagementProject.Controller;

import com.syfe.FinancialManagementProject.DTO.AuthDTO;
import com.syfe.FinancialManagementProject.DTO.UserDTO;
import com.syfe.FinancialManagementProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDTO saveUser(@RequestBody UserDTO userDto){
        userService.saveUserDTO(userDto);
        return userDto;
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
