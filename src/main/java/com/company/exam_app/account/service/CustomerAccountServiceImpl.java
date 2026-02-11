package com.company.exam_app.account.service;

import com.company.exam_app.account.dto.response.CustomerAccountResponseViewDTO;
import com.company.exam_app.account.enums.AccountType;
import com.company.exam_app.account.mapper.CustomerAccountMapper;
import com.company.exam_app.account.repository.CustomerAccountRepository;
import com.company.exam_app.account.dto.request.CustomerAccountRequestCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseCreateDTO;
import com.company.exam_app.account.entity.BankAccount;
import com.company.exam_app.account.entity.CustomerAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Primary
@RequiredArgsConstructor
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerAccountMapper customerAccountMapper;

    @Transactional
    @Override
    public CustomerAccountResponseCreateDTO createNewAccount(
            CustomerAccountRequestCreateDTO customerAccountRequestCreateDTO)
    {
        CustomerAccount customerAccount = this.customerAccountMapper.dtoToEntity(
                (customerAccountRequestCreateDTO));

        //Bank Account
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType(AccountType.valueOf(customerAccountRequestCreateDTO.getAccountType()));
        bankAccount.setCustomerAccount(customerAccount);

        customerAccount.getSavings().add(bankAccount);
        CustomerAccount savedResult = customerAccountRepository.save(customerAccount);

        return this.customerAccountMapper.generateCreateEntityResponseDTO(
                savedResult.getCustomerNumber(),
                ((Integer)(HttpStatus.CREATED.value())).toString(),
                "Customer Account Created"
        );
    }

    @Override
    public CustomerAccountResponseViewDTO findAccountByCustomerNumber(Long customerNumber) {

        CustomerAccount result = this.customerAccountRepository
                .findById(customerNumber)
                .orElseThrow(()-> new EntityNotFoundException("Customer not found"));

        return this.customerAccountMapper.generateViewEntityResponseDTO(result,
                ((Integer)(HttpStatus.FOUND.value())).toString(),
                "Customer Account found"
        );

    }

}
