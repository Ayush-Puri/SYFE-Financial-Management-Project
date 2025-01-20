package com.syfe.FinancialManagementProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer savinggoalid;

    @ManyToOne
    @JoinColumn(name = "user_userid")
    private UserEntity user;

    private String username;

    private Double targetamount;
    private LocalDate targetdate;
    private Boolean iscompleted;
    private LocalDate creationdate;
    private Period daysremaining;
    private Double amountdifference;

}
