package com.Financial_Management_System.Entity;

import com.Financial_Management_System.DTO.TransactionReturnDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReportEntity {

    private String username;
    private LocalDate fromDate;
    private LocalDate uptoDate;
    private Double Income;
    private Double Expense;
    private Double Saving;
    private Hashtable<String, Double> categoryWiseSpending;
    private List<TransactionReturnDTO> transactionList;

}
