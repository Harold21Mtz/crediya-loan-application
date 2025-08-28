package com.application.model.loanapplication.gateways;

import com.application.model.loanapplication.LoanApplication;
import reactor.core.publisher.Mono;

public interface LoanApplicationRepository {

    Mono<Void> saveLoanApplication(LoanApplication loanApplication);
}
