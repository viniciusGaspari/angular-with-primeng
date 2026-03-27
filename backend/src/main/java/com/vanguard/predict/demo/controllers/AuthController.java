package com.vanguard.predict.demo.controllers;

import com.vanguard.predict.demo.helpers.ResponseCookieBuilder;
import com.vanguard.predict.demo.mapper.company.CompanyMapper;
import com.vanguard.predict.demo.models.company.Company;
import com.vanguard.predict.demo.models.company.CompanyLoginRequest;
import com.vanguard.predict.demo.models.company.CompanyRegisterRequest;
import com.vanguard.predict.demo.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vanguard.predict.demo.helpers.UriLocationBuilder.uriLocationBuilder;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final ResponseCookieBuilder responseCookieBuilder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CompanyLoginRequest login) {
        this.companyService.logIn(this.companyMapper.LoginRequestToEntity(login));

        String cookie = this.responseCookieBuilder
                .responseCookieBuilderWhenLogin(
                        String.valueOf(login.getCompanyCnpj()),
                        login.getRole().getRoleName()
                ).toString();

            return ResponseEntity
                    .status(200)
                    .header(HttpHeaders.SET_COOKIE, cookie)
                    .build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CompanyRegisterRequest register){
        Company newCompany = this.companyService.register(this.companyMapper.RegisterRequestToEntity(register));
        return ResponseEntity
                .created(uriLocationBuilder(newCompany.getId()))
                .build();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity
                .noContent()
                .header(HttpHeaders.SET_COOKIE, this.responseCookieBuilder.responseCookieBuilderWhenLogout().toString()).build();
    }

}
