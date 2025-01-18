package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.DTO.UserDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserDTO> findAllUsers(){
        return userService.findAllUserDTO();
    }

    @GetMapping("/user/{userId}")
    public UserDTO findUser(@PathVariable Long userId) throws Exception {
        return userService.findUserDTO(userId);
    }

    @GetMapping("/allusers")
    public List<UserEntity> findAllUserEntity(){
        return userService.findAllUserEntity();
    }



}