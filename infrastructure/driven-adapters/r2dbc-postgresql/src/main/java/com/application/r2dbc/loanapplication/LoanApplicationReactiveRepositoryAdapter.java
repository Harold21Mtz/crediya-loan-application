package com.application.r2dbc.loanapplication;

import com.application.model.loanapplication.LoanApplication;
import com.application.model.loanapplication.gateways.LoanApplicationRepository;
import com.application.r2dbc.entity.LoanApplicationEntity;
import com.application.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class LoanApplicationReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        LoanApplication,
        LoanApplicationEntity,
        Long,
        LoanApplicationReactiveRepository
        > implements LoanApplicationRepository {
    public LoanApplicationReactiveRepositoryAdapter(LoanApplicationReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, LoanApplication.class));
    }

    @Override
    public Mono<Void> saveLoanApplication(LoanApplication loanApplication) {
        return repository.save(this.toData(loanApplication))
                .then();
    }
}
