package com.vanguard.predict.demo.validators;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BcryptValidator {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void isPasswordMatches(String rawPassword, String passwordSaved){
        if(!bCryptPasswordEncoder.matches(rawPassword, passwordSaved)){
            throw new MyRuntimeException("Senha incorreta", 401);
        }
    }

    public String encodePassword(String newPassword){
        return this.bCryptPasswordEncoder.encode(newPassword);
    }

}
