package com.Financial_Management_System.Controller;

import com.Financial_Management_System.DTO.TransactionReturnDTO;
import com.Financial_Management_System.DTO.TransactionDTO;
import com.Financial_Management_System.Service.TransactionService;
import com.Financial_Management_System.Service.UserService;
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

    @GetMapping("/viewAll")
    public List<TransactionReturnDTO> findAllTransactionsByUser() throws Exception {
        return transactionService.findAllTransactionsByUser();
    }

    @PutMapping("/commit/{transactionId}")
    public TransactionReturnDTO updateTreansaction(@RequestBody TransactionDTO transactionDTO, @PathVariable Integer transactionId) throws Exception {
        return transactionService.updateTransaction(transactionDTO, transactionId);
    }

}
