package com.syfe.jan19test3.Service;


import com.syfe.jan19test3.DTO.TransactionDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Entity.userTransaction;
import com.syfe.jan19test3.Repository.TransactionRepository;
import com.syfe.jan19test3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    public String saveTransaction(TransactionDTO transactionDTO) throws Exception {
        // Fetch user by ID
        UserEntity user = userRepository.findByUsername(transactionDTO.getUsername()).orElse(null);
        if (user == null) {
            return "User not found.";
        }

        // Create new transaction
        userTransaction transaction = userTransaction.builder()
                .user(user)
                .amount(transactionDTO.getAmount())
                .category(transactionDTO.getCategory())
                .date(LocalDateTime.now())
                .build();

        // Save transaction
        transactionRepository.save(transaction);

        // Update user's wallet
        double updatedWallet = (user.getWallet() == null ? 0.0 : user.getWallet()) + transactionDTO.getAmount();
        user.setWallet(updatedWallet);
        userRepository.save(user);

        return "Transaction saved successfully.";

    }

}
