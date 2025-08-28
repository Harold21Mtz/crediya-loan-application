package com.application.r2dbc.status;

import com.application.model.status.Status;
import com.application.model.status.gateways.StatusRepository;
import com.application.r2dbc.entity.StatusEntity;
import com.application.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StatusReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Status,
        StatusEntity,
        Long,
        StatusReactiveRepository
        > implements StatusRepository {
    public StatusReactiveRepositoryAdapter(StatusReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Status.class));
    }

}
