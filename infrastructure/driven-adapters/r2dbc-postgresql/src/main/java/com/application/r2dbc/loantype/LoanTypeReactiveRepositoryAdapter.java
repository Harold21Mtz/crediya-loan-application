package com.application.r2dbc.loantype;

import com.application.model.loantype.LoanType;
import com.application.model.loantype.gateways.LoanTypeRepository;
import com.application.r2dbc.entity.LoanTypeEntity;
import com.application.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class LoanTypeReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        LoanType,
        LoanTypeEntity,
        Long,
        LoanTypeReactiveRepository
        > implements LoanTypeRepository {
    public LoanTypeReactiveRepositoryAdapter(LoanTypeReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, LoanType.class));
    }

    @Override
    public Mono<LoanType> findLoanTypeById(Long id) {
        return repository.findById(id)
                .map(this::toEntity);
    }

}
