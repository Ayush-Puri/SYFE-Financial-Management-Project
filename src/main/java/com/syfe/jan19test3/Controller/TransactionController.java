package com.syfe.jan19test3.Controller;

import com.syfe.jan19test3.DTO.TransactionDTO;
import com.syfe.jan19test3.Service.TransactionService;
import com.syfe.jan19test3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/commit")
    public String commitTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        return transactionService.saveTransaction(transactionDTO);
    }
}
