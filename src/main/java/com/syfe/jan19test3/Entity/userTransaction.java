package com.syfe.jan19test3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userTransaction {

    @Id
    @GeneratedValue
    private Long transactionid;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    private Double amount;

    private LocalDateTime date = LocalDateTime.now();

    private String category;

    private String description;
}
