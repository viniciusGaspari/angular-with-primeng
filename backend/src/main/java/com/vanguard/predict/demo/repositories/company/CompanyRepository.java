package com.vanguard.predict.demo.repositories.company;

import com.vanguard.predict.demo.models.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Boolean existsByCompanyEmail(String companyName);
    Boolean existsByCompanyCnpj(Integer companyCnpj);

    Optional<Company> findByCompanyCnpj(Integer companyCnpj);
    Optional<Company> getByCompanyCnpj(Integer companyCnpj);
}
