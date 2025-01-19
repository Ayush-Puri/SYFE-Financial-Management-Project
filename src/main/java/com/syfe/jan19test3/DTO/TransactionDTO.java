package com.syfe.jan19test3.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private String username;
    private String password;
    private Double amount;
    private String category;
    private String decsription;
}
