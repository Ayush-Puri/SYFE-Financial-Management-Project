package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.Entity.SavingGoal;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.SavingGoalService;
import com.syfe.jan19test3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savingGoal")
public class SavingGoalController {

    @Autowired
    private SavingGoalService savingGoalService;
    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public List<SavingGoal> findAll() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();

        return savingGoalService.findAll(currentUser.getUsername());
    }
}
