package com.vanguard.predict.demo.mapper.company;

import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.models.company.CompanyLoginRequest;
import com.vanguard.predict.demo.models.company.CompanyRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company RegisterRequestToEntity(CompanyRegisterRequest model){
        Company company = new Company();
        company.setCompanyCnpj(model.getCompanyCnpj());
        company.setCompanyEmail(model.getCompanyEmail());
        company.setCompanyName(model.getCompanyName());
        company.setCompanyPassword(model.getCompanyPassword());
        return company;
    }
    public Company LoginRequestToEntity(CompanyLoginRequest model){
        Company company = new Company();
        company.setCompanyCnpj(model.getCompanyCnpj());
        company.setCompanyPassword(model.getCompanyPassword());
        return company;
    }
}
