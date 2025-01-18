package com.syfe.jan19test3.DTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingGoal {
    private Double targetamount;
    private LocalDateTime date;
}
