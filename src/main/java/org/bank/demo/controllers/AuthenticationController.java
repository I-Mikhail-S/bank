package org.bank.demo.controllers;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.request.LoginRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.api.response.LoginResponse;
import org.bank.demo.servises.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public CreateAccountResponse registerUser(@RequestBody CreateAccountRequest request){
        return authenticationService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request){
        return authenticationService.loginUser(request.getEmail(),request.getPassword());
    }
}
