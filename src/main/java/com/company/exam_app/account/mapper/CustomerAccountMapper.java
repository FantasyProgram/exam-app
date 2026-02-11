package com.company.exam_app.account.mapper;

import com.company.exam_app.account.dto.request.CustomerAccountRequestCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseViewDTO;
import com.company.exam_app.account.entity.CustomerAccount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerAccountMapper {

    public CustomerAccount dtoToEntity(CustomerAccountRequestCreateDTO customerAccountRequestCreateDTO);

    public CustomerAccountResponseCreateDTO generateCreateEntityResponseDTO (
            Long customerNumber,
            String transactionStatusCode,
            String transactionStatusDescription
    );

    public CustomerAccountResponseViewDTO generateViewEntityResponseDTO (
            CustomerAccount customerAccount,
            String transactionStatusCode,
            String transactionStatusDescription
    );
}
