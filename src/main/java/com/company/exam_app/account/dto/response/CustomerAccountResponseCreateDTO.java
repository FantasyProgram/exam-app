package com.company.exam_app.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class CustomerAccountResponseCreateDTO {
    private Long customerNumber;
    private String transactionStatusCode;
    private String transactionStatusDescription;
}
