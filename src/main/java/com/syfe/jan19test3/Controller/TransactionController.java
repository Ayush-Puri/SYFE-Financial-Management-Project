package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.Entity.userTransaction;
import com.syfe.jan19test3.DTO.TransactionDTO;
import com.syfe.jan19test3.Entity.UserEntity;
import com.syfe.jan19test3.Service.TransactionService;
import com.syfe.jan19test3.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/commit")
    public String commitTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return transactionService.saveTransaction(transactionDTO, username);
    }

    @GetMapping("/viewAllM2")
    public List<userTransaction> findAllTransactionsByUser() throws Exception {
        return transactionService.findAllTransactionsByUser();
    }

    @GetMapping("/viewAll")
    public List<userTransaction> findAllCategoriesOfUser(HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity currentUser = userService.findUserEntityByUsername(username).get();

        return currentUser.getTransactionList();
    }
}
