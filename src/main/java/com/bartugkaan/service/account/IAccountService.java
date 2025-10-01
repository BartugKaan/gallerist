package com.bartugkaan.service.account;

import com.bartugkaan.dto.account.DtoAccount;
import com.bartugkaan.dto.account.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU input);
}
