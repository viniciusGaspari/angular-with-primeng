package com.vanguard.predict.demo.models.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyLoginRequest {

    private Integer companyCnpj;
    private String companyPassword;

}
