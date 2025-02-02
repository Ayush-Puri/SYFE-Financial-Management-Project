package com.Financial_Management_System.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavingGoalDTO {

    @Min(value = 0, message = "Can Not set negative Saving Goal")
    private Double targetamount;

    private String targetdate;
}

