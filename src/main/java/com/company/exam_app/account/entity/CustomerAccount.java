package com.company.exam_app.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer_accounts")
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;

    @Column(length =50 , nullable = false)
    private String customerName;

    @Column(length = 20 , nullable = false)
    private String customerMobile;

    @Column(length=50, nullable = false)
    private String  customerEmail;

    @Column(length = 100 , nullable = false)
    private String address1;

    @Column(length = 100)
    private String address2;

    @OneToMany(mappedBy = "customerAccount", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<BankAccount> savings = new LinkedHashSet<>();




}
