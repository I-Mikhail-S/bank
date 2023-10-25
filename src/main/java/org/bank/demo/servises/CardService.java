package org.bank.demo.servises;

import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountService accountService;

    public boolean createCard(Card card, Long id) {
        Optional<Account> account = accountService.getInfoAccount(id);
        if (account.isEmpty()) {
            card.setAccount(account.get());

            cardRepository.save(card);
            return true;
        }
        return false;
    }
}
