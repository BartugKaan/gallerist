package com.bartugkaan.service.impl;


import com.bartugkaan.dto.address.DtoAddress;
import com.bartugkaan.dto.address.DtoAddressIU;
import com.bartugkaan.model.Address;
import com.bartugkaan.repository.address.AddressRepository;
import com.bartugkaan.service.address.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU dtoAddressIU){
        Address address = new Address();
        address.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU input) {
        DtoAddress dtoAddress = new DtoAddress();

        Address savedAddress = addressRepository.save(createAddress(input));
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }
}
