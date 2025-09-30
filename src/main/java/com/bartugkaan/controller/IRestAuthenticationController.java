package com.bartugkaan.controller;

import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.DtoUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);
}
