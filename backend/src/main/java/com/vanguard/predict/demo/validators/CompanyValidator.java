package com.vanguard.predict.demo.validators;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.repositories.base.BaseRepository;
import com.vanguard.predict.demo.repositories.company.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyValidator {

    private final CompanyRepository companyRepository;
    private final BaseRepository<Company, Integer> baseRepository;

    public String existingCompanyByEmail(String companyEmail) {
        if(this.companyRepository.existsByCompanyEmail(companyEmail)){
            throw new MyRuntimeException("Email já cadastrado", 403);
        }
        return companyEmail;
    }

    public Integer existingCompanyByCnpj(Integer companyCnpj){
        if(this.companyRepository.existsByCompanyCnpj(companyCnpj)){
            throw new MyRuntimeException("CNPJ já cadastrado", 403);
        }
        return companyCnpj;
    }

    public Company findCompanyByCnpj(Integer companyCnpj){
        return this.companyRepository.findByCompanyCnpj(companyCnpj)
                .orElseThrow(() -> new MyRuntimeException("Não existe CNPJ cadastro", 403));
    }

    public Company saveCompany(Company newCompany){
        return this.baseRepository.save(newCompany);
    }

}
