package com.bartugkaan.service;

import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.AuthResponse;
import com.bartugkaan.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);
}
