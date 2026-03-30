package com.vanguard.predict.demo.helpers;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.repositories.company.CompanyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyHelper {

    private final CompanyRepository companyRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public Company findCompanyByCnpj(Integer companyCnpj){
        return this.companyRepository.findByCompanyCnpj(companyCnpj)
                .orElseThrow(() -> new MyRuntimeException("Não existe CNPJ cadastro", 404));
    }

    @Transactional
    public Company saveCompany(Company newCompany){
        entityManager.flush();
        entityManager.refresh(newCompany);
        return this.companyRepository.save(newCompany);
    }

}
