package com.bartugkaan.service;

import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);
}
