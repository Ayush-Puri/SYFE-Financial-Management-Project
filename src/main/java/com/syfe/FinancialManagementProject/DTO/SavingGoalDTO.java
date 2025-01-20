package com.syfe.FinancialManagementProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavingGoalDTO {
    private Double targetamount;
    private LocalDate targetdate;
}
