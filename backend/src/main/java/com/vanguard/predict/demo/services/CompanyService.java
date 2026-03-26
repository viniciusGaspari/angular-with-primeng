package com.vanguard.predict.demo.services;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.repositories.company.CompanyRepository;
import com.vanguard.predict.demo.validators.CompanyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyValidator companyValidator;
    private final BCryptPasswordEncoder bCrypt;

    public Company register(Company request) {
        request.setCompanyPassword(bCrypt.encode(request.getCompanyPassword()));
        request.setCompanyEmail(this.companyValidator.existingCompanyByName(request.getCompanyEmail()));
        request.setCompanyCnpj(this.companyValidator.existingCompanyByCnpj(request.getCompanyCnpj()));
        return this.companyRepository.save(request);
    }

    public void logIn(Company request){
        Company companyFound = this.companyRepository.getByCompanyCnpj(request.getCompanyCnpj())
                .orElseThrow(() -> new MyRuntimeException("Empresa não encontrada", 401));
        if(!bCrypt.matches(request.getCompanyPassword(), companyFound.getCompanyPassword())){
            throw new MyRuntimeException("Senha incorreta", 401);
        }
    }

}
