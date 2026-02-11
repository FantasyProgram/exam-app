package com.company.exam_app.account.entity;

import com.company.exam_app.account.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long accountNumber;
    @Column()

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(precision = 19, scale = 4)
    private BigDecimal availableBalance = BigDecimal.ZERO;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CustomerAccount.class)
    @JoinColumn(name="customer_account")
    private CustomerAccount customerAccount;
}
