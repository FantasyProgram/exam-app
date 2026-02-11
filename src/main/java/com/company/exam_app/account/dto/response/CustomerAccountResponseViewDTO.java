package com.company.exam_app.account.dto.response;

import com.company.exam_app.account.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CustomerAccountResponseViewDTO {
    CustomerAccount customerAccount;
    String transactionStatusCode = "";
    String transactionStatusDescription = "";

}
