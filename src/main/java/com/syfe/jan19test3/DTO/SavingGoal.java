package com.syfe.jan19test3.DTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingGoal {
    private Double targetamount;
    private LocalDate targetdate;
    private Boolean iscompleted;
    private LocalDate creationdate = LocalDate.now();
    private Period daysremaining = Period.between(targetdate, LocalDate.now());

}
