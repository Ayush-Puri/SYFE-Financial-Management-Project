package com.syfe.jan19test3.DTO;

import com.syfe.jan19test3.Entity.SavingGoal;
import com.syfe.jan19test3.Entity.userTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReadDTO {
    private String username;
    private Double wallet;
    private Set<String> category = new HashSet<>();
    private Set<SavingGoal_ReturnDTO> savinggoals = new HashSet<>();
    private List<userTransaction> transactionList;
}
