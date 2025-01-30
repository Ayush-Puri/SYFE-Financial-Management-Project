package com.syfe.FinancialManagementProject.Controller;

import com.syfe.FinancialManagementProject.DTO.UserDTO;
import com.syfe.FinancialManagementProject.DTO.UserReadDTO;
import com.syfe.FinancialManagementProject.Entity.UserEntity;
import com.syfe.FinancialManagementProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Allusers")
    public String findAllUsers(Model model){

        List<UserReadDTO> list = userService.findAll();
        model.addAttribute("UserReadDTO", list);

        return "User_Pages/all-users";
    }

    @GetMapping("/user")
    public UserReadDTO findUser(Model model) throws Exception {
        return userService.findUser();
    }

    @GetMapping("/allusers")
    public List<UserReadDTO> findAllUserEntity(Model model){
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

    @PutMapping("/user")
    public UserReadDTO updateUser(@RequestBody UserDTO user) throws Exception {
        return userService.updateUser(user);
    }

}