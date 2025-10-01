package com.bartugkaan.controller.impl;

import com.bartugkaan.controller.RestBaseController;
import com.bartugkaan.controller.RootEntity;
import com.bartugkaan.controller.account.IRestAccountController;
import com.bartugkaan.dto.account.DtoAccount;
import com.bartugkaan.dto.account.DtoAccountIU;
import com.bartugkaan.service.account.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU input) {
        return ok(accountService.saveAccount(input));
    }
}
