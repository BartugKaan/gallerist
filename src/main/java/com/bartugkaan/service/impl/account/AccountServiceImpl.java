package com.bartugkaan.service.impl.account;

import com.bartugkaan.dto.account.DtoAccount;
import com.bartugkaan.dto.account.DtoAccountIU;
import com.bartugkaan.model.Account;
import com.bartugkaan.repository.account.AccountRepository;
import com.bartugkaan.service.account.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU input) {
        Account account = new Account();
        account.setCreateTime(new Date());

        BeanUtils.copyProperties(input, account);

        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU input) {
        DtoAccount dtoAccount = new DtoAccount();

        Account savedAccount = accountRepository.save(createAccount(input));
        BeanUtils.copyProperties(savedAccount, dtoAccount);

        return dtoAccount;
    }
}
