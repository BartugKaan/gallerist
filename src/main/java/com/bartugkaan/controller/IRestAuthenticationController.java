package com.bartugkaan.controller;

import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.AuthResponse;
import com.bartugkaan.dto.DtoUser;
import com.bartugkaan.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
