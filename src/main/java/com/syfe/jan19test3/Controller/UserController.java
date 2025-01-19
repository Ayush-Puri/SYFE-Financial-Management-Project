package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.DTO.AuthDTO;
import com.syfe.jan19test3.DTO.UserDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findme")
    public UserEntity findByUsername(@RequestBody AuthDTO authDTO) throws Exception {
        return userService.findUserEntity(authDTO.getUsername(), authDTO.getPassword());
    }



}