package com.syfe.jan19test3.Service;

import com.syfe.jan19test3.DTO.UserDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<UserDTO> findAllUserDTO(){

        List<UserEntity> list_of_All_Users =   userRepo.findAll();
        return list_of_All_Users.stream()
                .map(user -> UserDTO.builder()
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .collect(Collectors.toList());
    }

    public UserDTO findUserDTO(Long Id) throws Exception{
        Optional<UserEntity> userFound = userRepo.findById(Id);
        if(userFound.isPresent()){
            return UserDTO.builder()
                    .email(userFound.get().getEmail())
                    .username(userFound.get().getUsername())
                    .password(userFound.get().getPassword())
                    .build();
        }
        throw new Exception("User Not Found");
    }

    public UserDTO findUserDTO(String username, String password) throws Exception{
        Optional<UserEntity> userFound = userRepo.findByUsername(username);
        if(userFound.isPresent() && userFound.get().getPassword().equalsIgnoreCase(password)){
            return UserDTO.builder()
                    .email(userFound.get().getEmail())
                    .username(userFound.get().getUsername())
                    .password(userFound.get().getPassword())
                    .build();
        }
        throw new Exception("User Not Found");
    }

    public Long findUserID(String username, String password) throws Exception{
        Optional<UserEntity> userFound = userRepo.findByUsername(username);
        if(userFound.isPresent() && userFound.get().getPassword().equalsIgnoreCase(password)){
            return userFound.get().getUserid();
        }
        throw new Exception("User Not Found");
    }

    public UserEntity findUserEntity(String username, String password) throws Exception{
        Optional<UserEntity> userFound = userRepo.findByUsername(username);
        if(userFound.isPresent() && userFound.get().getPassword().equalsIgnoreCase(password)){
            return userFound.get();
        }
        throw new Exception("User Not Found");
    }

    public String saveUserDTO(UserDTO user){
        UserEntity newUser = UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .transactionList(new ArrayList<>())
                .build();
        userRepo.save(newUser);
        return "User Successfully Saved!";
    }

    public void deleteUserEntity(Long id){
        userRepo.deleteById(id);
    }

    public List<UserEntity> findAllUserEntity(){
        return userRepo.findAll();
    }

}
