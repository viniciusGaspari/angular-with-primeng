package com.vanguard.predict.demo.services.company;

import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.helpers.BcryptHelper;
import com.vanguard.predict.demo.helpers.CompanyHelper;
import com.vanguard.predict.demo.helpers.RoleHelper;
import com.vanguard.predict.demo.validator.BcryptValidator;
import com.vanguard.predict.demo.validator.CompanyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyHelper companyHelper;
    private final CompanyValidator companyValidator;
    private final BcryptValidator bcryptValidator;

    private final RoleHelper roleHelper;
    private final BcryptHelper bcryptHelper;

    public Company register(Company companyRequest) {
        this.companyValidator.existingCompanyByCnpj(companyRequest.getCompanyCnpj());
        this.companyValidator.existingCompanyByEmail(companyRequest.getCompanyEmail());

        companyRequest.setRole(this.roleHelper.getRoleById(companyRequest.getRole().getRoleId()));
        companyRequest.setCompanyPassword(this.bcryptHelper.encodeNewPassword(companyRequest.getCompanyPassword()));

        return this.companyHelper.saveCompany(companyRequest);
    }

    public void logIn(Company companyRequest){
        this.companyValidator.existingCompanyByCnpj(companyRequest.getCompanyCnpj());
        this.bcryptValidator
                .isPasswordMatches(
                        companyRequest.getCompanyPassword(),
                        this.companyHelper.findCompanyByCnpj(companyRequest.getCompanyCnpj()).getCompanyPassword()
                );
    }

}
