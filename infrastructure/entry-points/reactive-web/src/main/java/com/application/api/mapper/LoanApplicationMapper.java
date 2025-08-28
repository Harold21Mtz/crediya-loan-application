package com.application.api.mapper;

import com.application.api.dto.LoanApplicationRequest;
import com.application.api.dto.LoanApplicationResponse;
import com.application.model.loanapplication.LoanApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanApplicationMapper {

    LoanApplication toModel(LoanApplicationRequest loanApplicationRequest);

    LoanApplicationResponse toResponse(LoanApplication loanApplication);

}
