package com.syfe.FinancialManagementProject.Service;

import com.syfe.FinancialManagementProject.DTO.SavingGoalDTO;
import com.syfe.FinancialManagementProject.DTO.SavingGoal_ReturnDTO;
import com.syfe.FinancialManagementProject.Entity.SavingGoal;
import com.syfe.FinancialManagementProject.Entity.UserEntity;
import com.syfe.FinancialManagementProject.Repository.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
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
                .map(goal -> SavingGoal_ReturnDTO
                        .builder()
                        .savinggoalid(goal.getSavinggoalid())
                        .amountdifference(goal.getTargetamount()-currentUser.getWallet())
                        .targetamount(goal.getTargetamount())
                        .targetdate(goal.getTargetdate())
                        .creationdate(goal.getCreationdate())
                        .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                        .iscompleted(goal.getTargetamount() - currentUser.getWallet() < 0)
                        .username(goal.getUsername())
                        .build())
                .collect(Collectors.toList());
    }

    public SavingGoal_ReturnDTO saveNewGoal(SavingGoalDTO goal) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();

        savingGoalRepository.save(SavingGoal.builder()
                        .user(currentUser)
                        .targetamount(goal.getTargetamount())
                        .targetdate(goal.getTargetdate())
                        .amountdifference(goal.getTargetamount()-currentUser.getWallet())
                        .iscompleted(goal.getTargetamount()-currentUser.getWallet() < 0)
                        .username(currentUser.getUsername())
                        .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                        .creationdate(LocalDate.now())
                .build());

        return SavingGoal_ReturnDTO.builder()
                .savinggoalid(0)
                .amountdifference(goal.getTargetamount()-currentUser.getWallet())
                .targetdate(goal.getTargetdate())
                .creationdate(LocalDate.now())
                .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                .iscompleted(goal.getTargetamount()-currentUser.getWallet() < 0)
                .username(currentUser.getUsername())
                .targetamount(goal.getTargetamount())
                .build();
    }

    public SavingGoal_ReturnDTO updateGoal(SavingGoalDTO goal, Integer goalId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();
        Optional<SavingGoal> savedgoal = savingGoalRepository.findBySavinggoalid(goalId);
        if(savedgoal.isEmpty()){
            throw new Exception("Goal Not Found");
        }
        if(!savedgoal.get().getUsername().equals(currentUser.getUsername())){
            throw new Exception("Saving Goal is not Your to Edit!");
        }
        savedgoal.get().setTargetamount(goal.getTargetamount());
        savedgoal.get().setTargetdate(goal.getTargetdate());
        savingGoalRepository.save(savedgoal.get());

        return SavingGoal_ReturnDTO.builder()
                .savinggoalid(savedgoal.get().getSavinggoalid())
                .amountdifference(goal.getTargetamount()-currentUser.getWallet())
                .targetdate(goal.getTargetdate())
                .creationdate(savedgoal.get().getCreationdate())
                .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                .iscompleted(goal.getTargetamount()-currentUser.getWallet() < 0)
                .username(currentUser.getUsername())
                .targetamount(goal.getTargetamount())
                .build();
    }

    public String removeGoal(Integer goalId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();
        Optional<SavingGoal> savedgoal = savingGoalRepository.findBySavinggoalid(goalId);
        if(savedgoal.isEmpty()){
            throw new Exception("Goal Not Found");
        }
        if(!savedgoal.get().getUsername().equals(currentUser.getUsername())){
            throw new Exception("Saving Goal is not Your to Edit!");
        }
        savingGoalRepository.delete(savedgoal.get());
        return "Deletion Successful";
    }
}
