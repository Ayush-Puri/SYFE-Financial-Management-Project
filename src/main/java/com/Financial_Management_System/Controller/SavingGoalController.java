package com.Financial_Management_System.Controller;

import com.Financial_Management_System.DTO.SavingGoalDTO;
import com.Financial_Management_System.DTO.SavingGoal_ReturnDTO;
import com.Financial_Management_System.Service.SavingGoalService;
import com.Financial_Management_System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
