package com.bartugkaan.controller;

import com.bartugkaan.dto.address.DtoAddress;
import com.bartugkaan.dto.address.DtoAddressIU;

public interface IRestAddressController {
    public  RootEntity<DtoAddress> saveAddress(DtoAddressIU input);
}
