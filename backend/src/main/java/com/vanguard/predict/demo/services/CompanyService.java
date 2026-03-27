package com.vanguard.predict.demo.services;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.repositories.base.BaseRepository;
import com.vanguard.predict.demo.validators.BcryptValidator;
import com.vanguard.predict.demo.validators.CompanyValidator;
import com.vanguard.predict.demo.validators.RoleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyValidator companyValidator;
    private final RoleValidator roleValidator;
    private final BcryptValidator bcryptValidator;

    public Company register(Company request) {
        request.setRole(this.roleValidator.getRoleById(request.getRole().getRoleId()));
        request.setCompanyPassword(this.bcryptValidator.encodePassword(request.getCompanyPassword()));
        request.setCompanyEmail(this.companyValidator.existingCompanyByEmail(request.getCompanyEmail()));
        request.setCompanyCnpj(this.companyValidator.existingCompanyByCnpj(request.getCompanyCnpj()));
        return this.companyValidator.saveCompany(request);
    }

    public void logIn(Company request){
        this.bcryptValidator
                .isPasswordMatches(
                        request.getCompanyPassword(),
                        this.companyValidator.findCompanyByCnpj(request.getCompanyCnpj()).getCompanyPassword()
                );
    }

}
