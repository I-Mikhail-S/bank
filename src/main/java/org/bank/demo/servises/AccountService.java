package org.bank.demo.servises;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.mapper.AccountMapper;
import org.bank.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }


//    public CreateAccountResponse createAccount(CreateAccountRequest request){
//        Account account = accountMapper.toEntity(request);
//        accountRepository.save(account);
//        //Card card = new Card(account);
//        //account.setCard(card);
//
//        return accountMapper.toResponse(account);
//    }

    public Optional<Account> getInfoAccount (Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

}
