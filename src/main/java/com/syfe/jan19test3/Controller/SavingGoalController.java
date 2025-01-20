package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.DTO.SavingGoalDTO;
import com.syfe.jan19test3.DTO.SavingGoal_ReturnDTO;
import com.syfe.jan19test3.Entity.SavingGoal;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.SavingGoalService;
import com.syfe.jan19test3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/savingGoal")
public class SavingGoalController {

    @Autowired
    private SavingGoalService savingGoalService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<SavingGoal_ReturnDTO> findAll() throws Exception {
        return savingGoalService.findAll();
    }

    @PostMapping()
    public SavingGoal_ReturnDTO saveSavingGoal(@RequestBody SavingGoalDTO goal) throws Exception {
        return savingGoalService.saveNewGoal(goal);
    }

    @PutMapping("/{goalId}")
    public SavingGoal_ReturnDTO updateSavingGoal(@RequestBody SavingGoalDTO goal, @PathVariable Integer goalId) throws Exception {
        return savingGoalService.updateGoal(goal, goalId);
    }

    @DeleteMapping("/{goalId}")
    public String deleteGoal(@PathVariable Integer goalId) throws Exception {
        return savingGoalService.removeGoal(goalId);
    }

}
