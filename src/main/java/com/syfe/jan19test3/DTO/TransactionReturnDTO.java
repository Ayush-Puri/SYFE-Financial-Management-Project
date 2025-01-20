package com.syfe.jan19test3.DTO;

import com.syfe.jan19test3.Entity.UserEntity;
import jakarta.persistence.*;
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

        private LocalDateTime created_date;

        private String category;

        private String description;
    }

