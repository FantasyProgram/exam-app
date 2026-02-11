package com.company.exam_app.account.service;


import com.company.exam_app.account.dto.request.CustomerAccountRequestCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseViewDTO;

public interface CustomerAccountService {
    CustomerAccountResponseCreateDTO createNewAccount(CustomerAccountRequestCreateDTO customerAccountRequestCreateDTO);
    CustomerAccountResponseViewDTO findAccountByCustomerNumber(Long customerNumber);
}
