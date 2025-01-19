package com.syfe.jan19test3.Service;


import com.syfe.jan19test3.DTO.TransactionDTO;
import com.syfe.jan19test3.DTO.TransactionType;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Entity.userTransaction;
import com.syfe.jan19test3.Repository.TransactionRepository;
import com.syfe.jan19test3.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    public String saveTransaction(TransactionDTO transactionDTO, String username) throws Exception {
        // Fetch user by ID
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return "User not found.";
        }
        // Create new transaction
        userTransaction transaction = userTransaction.builder()
                .user(user.get())
                .amount(transactionDTO.getAmount())
                .category(transactionDTO.getCategory())
                .type(transactionDTO.getType())
                .date(LocalDateTime.now())
                .description(transactionDTO.getDescription())
                .build();

        // Save transaction
        transactionRepository.save(transaction);

        if(!user.get().getCategory().contains(transactionDTO.getCategory())){

            Set<String> newCategoryList = user.get().getCategory();
            newCategoryList.add(transactionDTO.getCategory());
            user.get().setCategory(newCategoryList);
        }

        // Update user's wallet
        double updatedWallet = (user.get().getWallet() == null ? 0.0 : user.get().getWallet()) + transactionDTO.getAmount();
        user.get().setWallet(updatedWallet);

        return "Transaction saved successfully.";
    }

    public List<userTransaction> findAllTransactionsByUser(Long userId){
        return transactionRepository.findAllById(List.of(userId));
    }

}
