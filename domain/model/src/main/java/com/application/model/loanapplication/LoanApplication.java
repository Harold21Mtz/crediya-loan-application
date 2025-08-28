package com.application.model.loanapplication;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LoanApplication {

    private Long loanApplicationId;
    private LocalDate applicationDate;
    private BigDecimal amount;
    private Integer term;
    private String documentNumber;
    private String email;
    private Long statusId;
    private Long loanTypeId;
}
