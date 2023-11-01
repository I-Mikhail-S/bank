package org.bank.demo.servises;

import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountRepository accountRepository;

    /*@Transactional
    public Optional<Card> createCard(Card card) {
        Account account = accountRepository.getReferenceById(card.getAccount().getId());
        if (account != null) {
            card.setAccount(account);
            accountRepository.save(account);
            return Optional.of(cardRepository.save(card));
        }
        return Optional.empty();
    }*/

    @Transactional
    public Card createCard(Long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();// Извлекаем значение из Optional
            Card card = new Card(account);
            accountRepository.save(account); // Сохраняем аккаунт
            return cardRepository.save(card); // Сохраняем карту
        }
        return null;
    }
}
