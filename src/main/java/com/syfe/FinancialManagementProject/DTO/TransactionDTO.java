package com.syfe.FinancialManagementProject.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Double amount;
    private TransactionType type;
    private String category;
    private String description;

}
