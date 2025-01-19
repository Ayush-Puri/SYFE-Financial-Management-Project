package com.syfe.jan19test3.Entity;

import com.syfe.jan19test3.DTO.SavingGoal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private Double wallet;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> category = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<LocalDate, SavingGoal> savinggoals = new HashMap<>();

    @OneToMany
    private List<userTransaction> transactionList;
}
