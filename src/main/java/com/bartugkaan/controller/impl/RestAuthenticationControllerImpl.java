package com.bartugkaan.controller.impl;

import com.bartugkaan.controller.IRestAuthenticationController;
import com.bartugkaan.controller.RestBaseController;
import com.bartugkaan.controller.RootEntity;
import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.AuthResponse;
import com.bartugkaan.dto.DtoUser;
import com.bartugkaan.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }
}
