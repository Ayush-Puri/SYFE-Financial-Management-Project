package com.syfe.jan19test3.Service;

import com.syfe.jan19test3.DTO.AuthDTO;
import com.syfe.jan19test3.DTO.SavingGoal_ReturnDTO;
import com.syfe.jan19test3.DTO.UserDTO;
import com.syfe.jan19test3.DTO.UserReadDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Entity.userTransaction;
import com.syfe.jan19test3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;

    public List<UserReadDTO> findAllUserDTO(){

        List<UserEntity> list_of_All_Users =   userRepository.findAll();
        return list_of_All_Users.stream()
                .map(userFound -> UserReadDTO.builder()
                        .username(userFound.getUsername())
                        .category(userFound.getCategory())
                        .transactionList(userFound.getTransactionList())
                        .savinggoals(userFound.getSavinggoals().stream()
                                .map(
                                        goal -> new SavingGoal_ReturnDTO().builder()
                                                .amountdifference(goal.getTargetamount()-userFound.getWallet())
                                                .targetdate(goal.getTargetdate())
                                                .creationdate(goal.getCreationdate())
                                                .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                                                .iscompleted(goal.getTargetamount()-userFound.getWallet() > 0 ? true : false)
                                                .username(goal.getUsername())
                                                .build())
                                .collect(Collectors.toSet())
                        )
                        .wallet(userFound.getWallet())
                        .build())
                .collect(Collectors.toList());
    }

    public UserReadDTO findUserDTO() throws Exception{

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity userFound = findUserEntityByUsername(username).get();

            return UserReadDTO.builder()
                    .username(userFound.getUsername())
                    .category(userFound.getCategory())
                    .transactionList(userFound.getTransactionList())
                    .savinggoals(userFound.getSavinggoals().stream()
                            .map(
                                    goal -> new SavingGoal_ReturnDTO().builder()
                                            .amountdifference(goal.getTargetamount()-userFound.getWallet())
                                            .targetdate(goal.getTargetdate())
                                            .creationdate(goal.getCreationdate())
                                            .daysremaining(Period.between(LocalDate.now(), goal.getTargetdate()))
                                            .iscompleted(goal.getTargetamount()-userFound.getWallet() > 0 ? true : false)
                                            .username(goal.getUsername())
                                            .build())
                                    .collect(Collectors.toSet())
                            )
                    .wallet(userFound.getWallet())
                    .build();
    }


    public Optional<UserEntity> findUserEntityByUsername(String username) throws Exception{
        Optional<UserEntity> userFound = userRepository.findByUsername(username);
        if(userFound.isPresent()){
            return userFound;
        }
        else throw new Exception("User Not Found in database");
    }

    public String saveUserDTO(UserDTO user){
        Set<String> category = new HashSet<>();
        category.add("food");
        category.add("rent");
        category.add("entertainment");

        UserEntity newUser = UserEntity.builder()
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .email(user.getEmail())
                .category(category)
                .savinggoals(new HashSet<>())
                .transactionList(new ArrayList<>())
                .build();
        userRepository.save(newUser);
        return "User Successfully Saved!";
    }

    public String deleteUserEntity(String username) throws Exception {
    Optional<UserEntity> toBeDeletedUser = findUserEntityByUsername(username);
    if(toBeDeletedUser.isPresent()) {
        userRepository.delete(toBeDeletedUser.get());
        return "Deletion Successful";
    }else return "Deletion Insuccessful";
    }

    public List<UserEntity> findAllUserEntity(){
        return userRepository.findAll();
    }

    public String verifyUser(AuthDTO authDTO){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDTO.getUsername(), authDTO.getPassword()));

        if(authentication.isAuthenticated())
            return "Authenicated";

        return "Authentication Failed";
    }

    public boolean isUserPresentinDatabase(Long userId){
        return userRepository.findById(userId).isPresent();
    }

    public String deleteUserEntitybyID(Long userId){
        if(isUserPresentinDatabase(userId)){
            userRepository.deleteById(userId);
            return "Deletion Successful";
        }
        return "Deletion Unsuccessful";
    }


}
