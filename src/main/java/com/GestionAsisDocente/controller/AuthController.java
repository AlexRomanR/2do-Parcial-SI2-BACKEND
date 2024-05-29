package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.ReqRes;
import com.GestionAsisDocente.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/token")
    public ResponseEntity<String> token(@RequestBody ReqRes signInRequest){
        ReqRes response = authService.signIn(signInRequest);
        return ResponseEntity.ok(response.getToken());
    }

    @PostMapping("/invalidate")
    public ResponseEntity<ReqRes> invalidateToken(@RequestBody ReqRes tokenRequest) {
        authService.invalidateToken(tokenRequest.getToken());
        ReqRes response = new ReqRes();
        response.setStatusCode(200);
        response.setMessage("Token invalidated successfully");
        return ResponseEntity.ok(response);
    }



}