package com.syfe.FinancialManagementProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionReturnDTO {

        private Long transactionid;

        private Double amount;

        private String username;

        private TransactionType type;

        private LocalDateTime dateTime;

        private String category;

        private String description;
    }

