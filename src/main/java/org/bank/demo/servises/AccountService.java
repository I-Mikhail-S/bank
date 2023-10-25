package org.bank.demo.servises;


import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository  cardRepository;

    public Account createAccount(Account account){

        Card card = new Card(account);
        account.setCard(card);

        return accountRepository.save(account);
    }

    public Optional<Account> getInfoAccount (Long id) {

        return accountRepository.findById(id);
    }
}
