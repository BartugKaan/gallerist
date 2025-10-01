package com.bartugkaan.controller;

import com.bartugkaan.dto.DtoAddress;
import com.bartugkaan.dto.DtoAddressIU;

public interface IRestAddressController {
    public  RootEntity<DtoAddress> saveAddress(DtoAddressIU input);
}
