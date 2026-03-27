package com.vanguard.predict.demo.helpers;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BcryptHelper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public String encodeNewPassword(String newPassword){
        return this.bCryptPasswordEncoder.encode(newPassword);
    }

}
