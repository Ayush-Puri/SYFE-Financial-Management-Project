package com.syfe.jan19test3.Repository;

import com.syfe.jan19test3.Entity.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SavingGoalRepository extends JpaRepository<SavingGoal, Integer> {
    List<SavingGoal> findAllByUsername(String username);

    Optional<SavingGoal> findBySavinggoalid(Integer goalId);
}
