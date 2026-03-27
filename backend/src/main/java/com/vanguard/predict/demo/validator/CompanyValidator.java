package com.vanguard.predict.demo.validator;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.repositories.company.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyValidator {

    private final CompanyRepository companyRepository;


    public void existingCompanyByEmail(String companyEmail) {
        companyRepository.existsByCompanyEmail(companyEmail)
                .orElseThrow(() -> new MyRuntimeException("Email já cadastrado", 403));
    }

    public void existingCompanyByCnpj(Integer companyCnpj){
        this.companyRepository.existsByCompanyCnpj(companyCnpj)
                .orElseThrow(() -> new MyRuntimeException("CNPJ já cadastrado", 403));
    }


}
