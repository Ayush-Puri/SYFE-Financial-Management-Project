package com.syfe.FinancialManagementProject.Entity;

import com.syfe.FinancialManagementProject.DTO.TransactionDTO;
import com.syfe.FinancialManagementProject.DTO.TransactionReturnDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
