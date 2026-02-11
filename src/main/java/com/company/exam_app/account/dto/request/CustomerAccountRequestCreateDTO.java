package com.company.exam_app.account.dto.request;

import com.company.exam_app.account.enums.AccountType;
import com.company.exam_app.validation.ValidEnum;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountRequestCreateDTO {

    @NotBlank(message = "Customer name is a required field")
    @Size(max=50 ,message = "Maximum length of 50 is reached")
    private String customerName;

    @NotBlank(message = "Customer mobile is a required field")
    @Size(max=20 , message = "Maximum length of 20 is reached")
    private String customerMobile;

    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Invalid email pattern"
    )
    @NotBlank(message = "Email is required")
    @Size(max=50 , message = "Maximum length of 50 is reached")
    private String  customerEmail;

    @NotBlank(message = "Address 1 is a required field")
    @Size(max=100 , message = "Maximum length of 100 is reached")
    private String address1;

    @Size(max=100 , message = "Maximum length of 100 is reached")
    private String address2;

    @NotNull(message = "Account Type is a required field")
    @ValidEnum(enumClass= AccountType.class , message = "Account Type value is incorrect")
    private String accountType;



}
