package org.bank.demo.servise;

import org.bank.demo.entites.Account;
import org.bank.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
       return accountRepository.save(account);
    }

    public Account getInfoAccount (Long id) {
        return accountRepository.getReferenceById(id);
    }
}
