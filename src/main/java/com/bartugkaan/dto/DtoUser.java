package com.bartugkaan.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser extends DtoBase{

    private String username;

    @JsonIgnore
    private String password;
}
