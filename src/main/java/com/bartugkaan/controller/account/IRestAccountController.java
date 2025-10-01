package com.bartugkaan.controller.account;

import com.bartugkaan.controller.RootEntity;
import com.bartugkaan.dto.account.DtoAccount;
import com.bartugkaan.dto.account.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU input);
}
