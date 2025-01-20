package com.syfe.jan19test3.Service;

import com.syfe.jan19test3.DTO.SavingGoal_ReturnDTO;
import com.syfe.jan19test3.Entity.SavingGoal;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Repository.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavingGoalService {
    @Autowired
    private SavingGoalRepository savingGoalRepository;

    @Autowired
    private UserService userService;

    public List<SavingGoal_ReturnDTO> findAll() throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();

        return savingGoalRepository.findAllByUsername(username).stream()
                .map(goal -> new SavingGoal_ReturnDTO()
                        .builder()
                        .amountdifference(goal.getTargetamount()-currentUser.getWallet())
                        .targetdate(goal.getTargetdate())
                        .creationdate(goal.getCreationdate())
                        .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                        .iscompleted(goal.getTargetamount()-currentUser.getWallet() > 0 ? true : false)
                        .username(goal.getUsername())
                        .build())
                .collect(Collectors.toList());
    }
}
