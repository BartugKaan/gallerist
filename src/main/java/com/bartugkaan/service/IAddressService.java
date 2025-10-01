package com.bartugkaan.service;

import com.bartugkaan.dto.DtoAddress;
import com.bartugkaan.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU input);
}
