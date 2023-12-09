package org.bank.demo.servises;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.exception.NotFoundAccountException;
import org.bank.demo.mapper.AccountMapper;
import org.bank.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public CreateAccountResponse createAccount(CreateAccountRequest request){
        Account account = accountMapper.toEntity(request);
        accountRepository.save(account);
        //Card card = new Card(account);
        //account.setCard(card);

        return accountMapper.toResponse(account);
    }

    public Optional<CreateAccountResponse> getInfoAccount (Long id) {
        Optional<Account> createAccountResponse = Optional.ofNullable(accountRepository.findById(id).orElseThrow(
                () -> new NotFoundAccountException("Нет такого аккаунта!")
        ));
        return Optional.ofNullable(accountMapper.toResponse(createAccountResponse.get()));
    }

    public List<Account> getInfoAccountAll() {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty())
            throw new NotFoundAccountException("Не существует ни одного аккаунта.");
        return accounts;
    }

    public void deleteAccount(Long id){
        if (!accountRepository.existsById(id))
            throw new NotFoundAccountException("Нет аккаунта с таким ID!");
        accountRepository.deleteById(id);
    }

}
