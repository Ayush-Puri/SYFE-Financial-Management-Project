package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.DTO.UserDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @DeleteMapping("/user")
    public String deleteUserEntity() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();
        return userService.deleteUserEntity(currentUser.getUsername());
    }

    @GetMapping("/MyCategories")
    public Set<String> findAllCategoriesOfUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();

        return currentUser.getCategory();
    }

}