package com.syfe.FinancialManagementProject.Entity;

import com.syfe.FinancialManagementProject.DTO.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionid;

    private Double amount;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    private String username;

    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    private LocalDateTime dateTime = LocalDateTime.now();

    private String category;

    private String description;
}
