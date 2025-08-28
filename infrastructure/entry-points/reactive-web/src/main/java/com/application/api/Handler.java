package com.application.api;

import com.application.api.dto.LoanApplicationRequest;
import com.application.api.mapper.LoanApplicationMapper;
import com.application.api.utils.ValidateDtos;
import com.application.usecase.loanapplication.LoanApplicationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final LoanApplicationUseCase loanApplicationUseCase;
    private final LoanApplicationMapper loanApplicationMapper;
    private final ValidateDtos validateDtos;

    public Mono<ServerResponse> createLoanApplication(ServerRequest request) {
        return validateDtos.validate(request, LoanApplicationRequest.class)
                .flatMap(loanApplicationRequest -> loanApplicationUseCase.createLoanApplication(loanApplicationMapper.toModel(loanApplicationRequest))
                        .then(ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue("{\"message\": \"Solicitud creada con exito\"}")));
    }
}
