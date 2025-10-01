package com.bartugkaan.service.address;

import com.bartugkaan.dto.address.DtoAddress;
import com.bartugkaan.dto.address.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU input);
}
