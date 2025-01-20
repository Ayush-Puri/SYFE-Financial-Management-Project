package com.syfe.jan19test3.Service;

import com.syfe.jan19test3.Entity.SavingGoal;
import com.syfe.jan19test3.Repository.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingGoalService {
    @Autowired
    private SavingGoalRepository savingGoalRepository;

    @Autowired
    private UserService userService;

    public List<SavingGoal> findAll(String username){
        return savingGoalRepository.findAllByUsername(username);
    }
}
