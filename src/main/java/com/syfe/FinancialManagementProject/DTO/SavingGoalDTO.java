package com.syfe.FinancialManagementProject.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    @Min(value = 0, message = "Can Not set negative Saving Goal")
    private Double targetamount;

    private String targetdate;
}

