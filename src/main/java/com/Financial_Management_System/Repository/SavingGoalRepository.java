package com.Financial_Management_System.Repository;

import com.Financial_Management_System.Entity.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SavingGoalRepository extends JpaRepository<SavingGoal, Integer> {
    List<SavingGoal> findAllByUsername(String username);

    Optional<SavingGoal> findBySavinggoalid(Integer goalId);
}
