package com.bartugkaan.controller.impl;

import com.bartugkaan.controller.IRestAddressController;
import com.bartugkaan.controller.RestBaseController;
import com.bartugkaan.controller.RootEntity;
import com.bartugkaan.dto.DtoAddress;
import com.bartugkaan.dto.DtoAddressIU;
import com.bartugkaan.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    @Autowired
    private IAddressService addressService;


    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU input) {
        return ok(addressService.saveAddress(input));
    }
}
