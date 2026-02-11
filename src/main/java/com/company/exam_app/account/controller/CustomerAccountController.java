package com.company.exam_app.account.controller;


import com.company.exam_app.account.dto.request.CustomerAccountRequestCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseCreateDTO;
import com.company.exam_app.account.dto.response.CustomerAccountResponseViewDTO;
import com.company.exam_app.account.entity.CustomerAccount;
import com.company.exam_app.account.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @PostMapping()
    public ResponseEntity<CustomerAccountResponseCreateDTO> createNewAccount(
            @Valid @RequestBody CustomerAccountRequestCreateDTO customerAccountRequestCreateDTO){

        CustomerAccountResponseCreateDTO result =
                this.customerAccountService.createNewAccount(customerAccountRequestCreateDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);

    }


    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerAccountResponseViewDTO> findCustomerAccountById(@PathVariable Long customerNumber){
        CustomerAccountResponseViewDTO responseOutput = this.customerAccountService.findAccountByCustomerNumber(customerNumber);
       return ResponseEntity
               .status(HttpStatus.FOUND)
               .body(responseOutput);
    }
}
