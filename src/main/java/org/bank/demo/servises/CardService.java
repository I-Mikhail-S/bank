package org.bank.demo.servises;

import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Optional<Card> createCard(Card card) {
        Account account = accountRepository.getReferenceById(card.getAccount().getId());
        if (account != null) {
            card.setAccount(account);
            accountRepository.save(account);
            return cardRepository.save(card);
        }
        return Optional.empty();
    }
}
