package com.vanguard.predict.demo.helpers;

import com.vanguard.predict.demo.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class ResponseCookieBuilder {

    private final JwtService jwtService;

     public ResponseCookie responseCookieBuilderWhenLogin(String subject, String roleName){
        String token = jwtService.generateToken(subject, roleName);

        return ResponseCookie.from("accessToken", token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(3600)
                .sameSite("Lax")
                .build();
    }


    public ResponseCookie responseCookieBuilderWhenLogout() {
        return ResponseCookie.from("accessToken", "")
                .httpOnly(true)
                .path("/")
                .maxAge(0)
                .sameSite("Lax")
                .build();
    }

}
