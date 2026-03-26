package com.vanguard.predict.demo.validators;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.repositories.company.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyValidator {

    private final CompanyRepository companyRepository;

    public String existingCompanyByName(String companyEmail) {
        if(this.companyRepository.findByCompanyEmail(companyEmail)){
            throw new MyRuntimeException("Email já cadastrado", 403);
        }
        return companyEmail;
    }

    public Integer existingCompanyByCnpj(Integer companyCnpj){
        if(this.companyRepository.findByCompanyCnpj(companyCnpj)){
            throw new MyRuntimeException("CNPJ já cadastrado", 403);
        }
        return companyCnpj;
    }

}
