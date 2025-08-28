package com.application.model.loantype.gateways;

import com.application.model.loantype.LoanType;
import reactor.core.publisher.Mono;

public interface LoanTypeRepository {

    Mono<LoanType> findLoanTypeById(Long id);
}
