package com.bartugkaan.dto.address;

import com.bartugkaan.dto.DtoBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddress extends DtoBase {
    private String city;

    private String district;

    private String neighborhood;

    private String street;
}
