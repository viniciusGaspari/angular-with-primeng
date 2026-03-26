package com.vanguard.predict.demo.models.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRegisterRequest {

    private Integer companyCnpj;

    private String companyName;

    private String companyEmail;

    private String companyPassword;

}
