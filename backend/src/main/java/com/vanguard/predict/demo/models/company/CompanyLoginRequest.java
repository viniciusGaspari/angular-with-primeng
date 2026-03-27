package com.vanguard.predict.demo.models.company;

import com.vanguard.predict.demo.models.roles.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyLoginRequest {

    private Integer companyCnpj;
    private String companyPassword;
    private Role role;

}
