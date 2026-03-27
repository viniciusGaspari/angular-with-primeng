package com.vanguard.predict.demo.validator;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BcryptValidator {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void isPasswordMatches(String rawPassword, String hashedPassword){
        if(!bCryptPasswordEncoder.matches(rawPassword, hashedPassword)){
            throw new MyRuntimeException("Senha incorreta", 401);
        }
    }

}
